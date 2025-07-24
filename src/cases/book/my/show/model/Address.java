package cases.book.my.show.model;

public class Address {
    private int pincode;
    private String city;
    private String state;
    private String country;
    private String landmark;
    private String addressLine1;

    //constructor
    public Address(int pincode, String city, String state, String country, String landmark, String addressLine1) {
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.landmark = landmark;
        this.addressLine1 = addressLine1;
    }

    //getters and setters
    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
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

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
}
