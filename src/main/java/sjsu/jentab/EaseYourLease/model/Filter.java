package sjsu.jentab.EaseYourLease.model;

public class Filter {
    private String name ;
    private String type ;
    private String price;
    private String amenity;

    public Filter(){

    }

    public Filter(String name, String type, String price, String amenity){
    this.name=name;
    this.type=type;
    this.price=price;
    this.amenity=amenity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmenity() {
        return amenity;
    }

    public void setAmenity(String amenity) {
        this.amenity = amenity;
    }



}
