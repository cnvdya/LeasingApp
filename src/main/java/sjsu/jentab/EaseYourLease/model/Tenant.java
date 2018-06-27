package sjsu.jentab.EaseYourLease.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Tenant")
public class Tenant {

		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;

		private String firstName;
		private String lastName;
		private Date rentDate;
		private String contact;




	private Integer flatid;

	public Integer getFlatid() {
		return flatid;
	}

	public void setFlatid(Integer flatid) {
		this.flatid = flatid;
	}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Date getRentDate() { return rentDate; }
		public void setRentDate(Date rentDate) { this.rentDate = rentDate; }

		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}



}

