package sjsu.jentab.EaseYourLease.model;

import javax.persistence.*;

@Entity
@Table(name = "Flat")
public class Flat {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;



	@ManyToOne
		@JoinColumn(name = "apartmentId")
		private Apartment apartment;

		private String flatName;
		private String details;
		

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
