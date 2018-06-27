
package sjsu.jentab.EaseYourLease.security;



import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;

public class AWSCredentialsKeys{
	

	
	
	private static final String AWS_ACCESS_KEY = "xxxxxx";
	private static final String AWS_SECRET_ACCESS_KEY = "xxxxxxxxxxxx";
	public static final String S3_URL = "xx";
	public static final String S3_BUCKET_NAME = "xx";
	
	
	public static AWSCredentials getAccessKeyCredentials() {
		AWSCredentials credentials;
		try {

			credentials = new BasicAWSCredentials(AWS_ACCESS_KEY, AWS_SECRET_ACCESS_KEY);

		} catch (Exception e) {
			throw new AmazonClientException("Cannot load the credentials from the credential profiles file. "
					+ "Please make sure that your credentials file is at the correct "
					+ "location (/Users/userid/.aws/credentials), and is in a valid format.", e);
		}

		return credentials;
	}
}