package sjsu.jentab.EaseYourLease.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class FlatVO {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
		private Integer id;



		private Apartment apartment;

		private String flatName;
		private String details;
		private List<MultipartFile> images;

		private String type;
		private String price;
		private String availability;
//	private Integer apartmentId;
//
//
//	public Integer getApartmentId() {
//		return apartmentId;
//	}
//
//	public void setApartmentId(Integer apartmentId) {
//		this.apartmentId = apartmentId;
//	}


		public Apartment getApartment() { return apartment; }
		

		public List<MultipartFile> getImages() {
			return images;
		}

		public void setImages(List<MultipartFile> images) {
			this.images = images;
		}

		public void setApartment(Apartment apartment) { this.apartment = apartment; }

		public String getFlatName() {
			return flatName;
		}
		public void setFlatName(String flatName) {
			this.flatName = flatName;
		}

		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}

		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}

		public String getAvailability() {
			return availability;
		}
		public void setAvailability(String availability) {
			this.availability = availability;
		}

		public String getDetails() {
			return details;
		}
		
		public void setDetails(String details) {
			this.details = details;
		}
}
