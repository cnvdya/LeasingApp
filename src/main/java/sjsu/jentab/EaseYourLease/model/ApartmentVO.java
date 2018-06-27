package sjsu.jentab.EaseYourLease.model;

public class ApartmentVO {



        private Integer id;

        private String apartmentName;
        private String adressLine1;
        private String adressLine2;
        private String city;
        private String state;
        private String country;
        private String code;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getApartmentName() {
            return apartmentName;
        }
        public void setApartmentName(String apartmentName) {
            this.apartmentName = apartmentName;
        }

        public String getAdressLine1() {
            return adressLine1;
        }
        public void setAdressLine1(String addressLine1) {
            this.adressLine1 = addressLine1;
        }

        public String getAdressLine2() {
            return adressLine2;
        }
        public void setAdressLine2(String addressLine2) {
            this.adressLine2 = addressLine2;
        }

        public String getCity() {
            return city;
        }
        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }
        public void setState(String state) {
            this.state = state;
        }

        public String getCountry() {
            return country;
        }
        public void setCountry(String country) {
            this.country = country;
        }

        public String getCode() {
            return code;
        }
        public void setCode(String code) {
            this.code = code;
        }
    }


