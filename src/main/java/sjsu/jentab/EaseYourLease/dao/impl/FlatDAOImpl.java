package sjsu.jentab.EaseYourLease.dao.impl;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.*;
import com.amazonaws.services.rekognition.model.S3Object;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sjsu.jentab.EaseYourLease.dao.FlatDAO;
import sjsu.jentab.EaseYourLease.dao.ImageLabelsDAO;
import sjsu.jentab.EaseYourLease.model.Flat;
import sjsu.jentab.EaseYourLease.model.ImageLabels;
import sjsu.jentab.EaseYourLease.security.AWSCredentialsKeys;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component

public class FlatDAOImpl {

    @Autowired
    private FlatDAO flatDAO;
    
    @Autowired
    private ImageLabelsDAO imageLabelsDAO;

    public List<Flat> flatslist(Integer apartmentId){
        return (List<Flat>)flatDAO.findByApartmentId(apartmentId);

    }

    public Flat getFlatbyid(Integer id){
        return (Flat)flatDAO.findOne(id);
    }

    public String addorUpdateFlat(Flat flat,List<MultipartFile> imageFileNames){
        String status,statusS3;
        try{
            System.out.println("Flat Dao "+ flatDAO);
            flat.setAvailability("true");
            flatDAO.save(flat);

			List<String> s3ImageNameList = uploadToS3DAO(flat.getId(),imageFileNames);

			AmazonS3 s3Connection = makeConnectionToS3(Regions.US_EAST_1);
			ObjectListing s3Objects = getListOfObjectFromS3ForFlat(s3Connection,AWSCredentialsKeys.S3_BUCKET_NAME,flat.getId());
			AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.standard().withRegion(Regions.US_EAST_1)
					.withCredentials(new AWSStaticCredentialsProvider(AWSCredentialsKeys.getAccessKeyCredentials()))
					.build();

			System.out.println("save flat details"+s3Objects.getObjectSummaries());

			for(S3ObjectSummary s3SummaryOfFiles : s3Objects.getObjectSummaries()){
				List<Label> labelForOneFlat = detectLabels(rekognitionClient,s3SummaryOfFiles);
				for(Label label : labelForOneFlat) {
					ImageLabels imageLabels = new ImageLabels();
					imageLabels.setFlatId(String.valueOf(flat.getId()));
					imageLabels.setImageName(s3SummaryOfFiles.getKey());
					imageLabels.setLabels(label.getName());
					imageLabelsDAO.save(imageLabels);
				}

			}

//			List<Label> labelForOneFlat = detectLabels(rekognitionClient,s3Objects);

//			for(String s3ImageName : s3ImageNameList) {
//				for(Label label : labelForOneFlat) {
//				ImageLabels imageLabels = new ImageLabels();
//				imageLabels.setFlatId(String.valueOf(flat.getId()));
//				imageLabels.setImageName(s3ImageName);
//				imageLabels.setLabels(label.getName());
//				imageLabelsDAO.save(imageLabels);
//				}
//			}

            status="SUCCESS";
        }
        catch (Exception e){
            System.out.println(e);
            status="FAILED";
        }
        return status;
    }


	public String updateAvailibility(Integer flatid){
        System.out.println(flatid);
        System.out.println("Flat Dao "+ flatDAO);

        Flat flat=(Flat)getFlatbyid(flatid);

        System.out.println("Flat "+ flat);

        flat.setAvailability("false");

        System.out.println("testing"+flat.getId());
        System.out.println("---"+flat.getFlatName());
        System.out.println("---"+flat.getAvailability());
        System.out.println("---"+flat.getType());
        addorUpdateFlat(flat,null);
        return "availibility updated";
    }
    
//    public String uploadToS3(Flat flat){
//    	
//    	flat.getImagePath();
//    	
//    }
    
    public List<String> uploadToS3DAO(Integer flatId,List<MultipartFile> imageFileNames){
    	
    	AmazonS3 clientConnection = new AmazonS3Client(AWSCredentialsKeys.getAccessKeyCredentials());
    	String s3_Bucket_Name = AWSCredentialsKeys.S3_BUCKET_NAME;
    	clientConnection.createBucket(s3_Bucket_Name);
    	List<String> finalImageNameList = new ArrayList<String>();
		try {

			if (null != imageFileNames && imageFileNames.size() > 0) {
				for (MultipartFile multipartFile : imageFileNames) {
					String imagePath = multipartFile.getOriginalFilename();
					
					String[] imagePathSplit = imagePath.split("\\.(?=[^\\.]+$)");
					String imagePathFileNameBase = imagePathSplit[0];
					String imagePathFileNameExt = imagePathSplit[1];
					String finalImageName = imagePathFileNameBase + "_" + flatId  + "." + imagePathFileNameExt;
					InputStream fileContent = multipartFile.getInputStream();
					clientConnection.putObject(new PutObjectRequest(s3_Bucket_Name, flatId.toString()+"/"+finalImageName, fileContent, new ObjectMetadata())
							.withCannedAcl(CannedAccessControlList.PublicRead));

					finalImageNameList.add(finalImageName);
					
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return finalImageNameList;
    }
    
	public Set<String> searchLabelsDAO(String labels) {

	Set<String> imagesSet = new HashSet<String>();
		 /**********************
		  * Label should be stored at the time of flat saving,
		  * this method should only returns the lable
		  **********************/

		 /*AmazonRekognition rekognitionClient = AmazonRekognitionClientBuilder.standard().withRegion(Regions.US_EAST_1)
					.withCredentials(new AWSStaticCredentialsProvider(AWSCredentialsKeys.getAccessKeyCredentials()))
					.build();
			AmazonS3 s3Connection = new AmazonS3Client(AWSCredentialsKeys.getAccessKeyCredentials());
			final ListObjectsV2Request req = new ListObjectsV2Request().withBucketName(AWSCredentialsKeys.S3_BUCKET_NAME);
			ListObjectsV2Result s3Objects;
			s3Objects = s3Connection.listObjectsV2(req);
			for (S3ObjectSummary s3SummaryOfFiles : s3Objects.getObjectSummaries()) {

				DetectLabelsRequest requestLabel = new DetectLabelsRequest()
						.withImage(new Image().withS3Object(new S3Object().withName(s3SummaryOfFiles.getKey()).withBucket(AWSCredentialsKeys.S3_BUCKET_NAME)))
						.withMaxLabels(10).withMinConfidence(75F);

				DetectLabelsResult result = rekognitionClient.detectLabels(requestLabel);

				List<Label> labels = result.getLabels();
				for (Label label : labels) {
					System.out.println(label.getName() + ": " + label.getConfidence().toString());
					ImageLabels imageLabel = new ImageLabels();
					String[] imagePathSplit = s3SummaryOfFiles.getKey().split("_");
					String[] imagePathFileName = imagePathSplit[1].split("\\.(?=[^\\.]+$)");
					imageLabel.setFlatId(imagePathFileName[0]);
					imageLabel.setImageName(imagePathSplit[0]+".jpg");
					imageLabel.setLabels(label.getName());
					imageLabelsDAO.save(imageLabel);

				}
			}*/
			
//				if (labelName.equalsIgnoreCase(label.getName())) {
//					String[] imagePathSplit = s3SummaryOfFiles.getKey().split("_");
//					String[] imagePathFileName = imagePathSplit[1].split("\\.(?=[^\\.]+$)");
//					imagesList.add(AWSCredentialsKeys.S3_URL + s3SummaryOfFiles.getKey());
//				}

		List<ImageLabels> imageLabelsList = (List<ImageLabels>)imageLabelsDAO.findByLabels(labels);
		for(ImageLabels imageLabels : imageLabelsList){
			imagesSet.add(AWSCredentialsKeys.S3_URL +imageLabels.getFlatId()+"/"+imageLabels.getImageName());
			System.out.println( "Lable found " +imageLabels.getLabels()+" for image name " + AWSCredentialsKeys.S3_URL+imageLabels.getImageName());

		}
		return imagesSet;
	}
	
	public Set<String> viewImages(String flatId) {
		/*AmazonS3 s3Connection = new AmazonS3Client(AWSCredentialsKeys.getAccessKeyCredentials());
		final ListObjectsV2Request req = new ListObjectsV2Request().withBucketName(AWSCredentialsKeys.S3_BUCKET_NAME);
		List<String> images = new ArrayList<String>();
		ListObjectsV2Result s3Objects;
		s3Objects = s3Connection.listObjectsV2(req);
		for (S3ObjectSummary s3SummaryOfFiles : s3Objects.getObjectSummaries()) {
			System.out.println(" - " + s3SummaryOfFiles.getKey() + " - " + s3SummaryOfFiles.getLastModified() + " - "
					+ s3SummaryOfFiles.getETag() + " - " + s3SummaryOfFiles.getKey() + " - "
					+ s3SummaryOfFiles.getClass() + " - " + s3SummaryOfFiles.getOwner() + "  " + "(size = "
					+ s3SummaryOfFiles.getSize() + ")");
			String[] imagePathSplit = s3SummaryOfFiles.getKey().split("_");
			String[] imagePathFileName = imagePathSplit[1].split("\\.(?=[^\\.]+$)");
			if (imagePathFileName[0].equalsIgnoreCase(flatName)) {
				images.add(AWSCredentialsKeys.S3_URL + s3SummaryOfFiles.getKey());
			}

		}
		return images;*/

		Set<String> imagesSet = new HashSet<String>();
		List<ImageLabels> imageLabelsList = (List<ImageLabels>)imageLabelsDAO.findByFlatId(flatId) ;
		for(ImageLabels imageLabels : imageLabelsList){
			imagesSet.add(AWSCredentialsKeys.S3_URL+imageLabels.getImageName());
			System.out.println( "Lable found " +imageLabels.getLabels()+" for image name " + AWSCredentialsKeys.S3_URL+flatId.toString()+"/"+imageLabels.getImageName());

		}

		return imagesSet;
	}

	private AmazonS3 makeConnectionToS3(Regions region) {
		AmazonS3 s3Connection = new AmazonS3Client(AWSCredentialsKeys.getAccessKeyCredentials());
		return s3Connection;
	}

	private ObjectListing getListOfObjectFromS3ForFlat(AmazonS3 s3Connection,String bucketName,Integer flatId ) {
		ObjectListing listing  = s3Connection.listObjects(bucketName,flatId.toString()+"/");
		return listing;
	}

	private List<Label> detectLabels(AmazonRekognition rekognitionClient,S3ObjectSummary s3SummaryOfFiles) {
		List<Label> labels = new ArrayList<Label>();
		//for (S3ObjectSummary s3SummaryOfFiles : s3Objects.getObjectSummaries()) {
			DetectLabelsRequest requestLabel = new DetectLabelsRequest()
					.withImage(new Image().withS3Object(new S3Object().withName(s3SummaryOfFiles.getKey()).withBucket(AWSCredentialsKeys.S3_BUCKET_NAME)))
					.withMaxLabels(10).withMinConfidence(75F);

			System.out.println("detect labels details"+s3SummaryOfFiles.getKey());

			DetectLabelsResult result = rekognitionClient.detectLabels(requestLabel);

			labels = result.getLabels();
		//}
		return labels;
	}


}
