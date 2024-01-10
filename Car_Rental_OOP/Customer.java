package Projects.Car_Rental_OOP;

public class Customer {
    private String name;
    private String licenceNo;
    private String mobileNo;

    public Customer(String name, String licenceNo, String mobileNo) {
        this.name = name;
        this.licenceNo = licenceNo;
        this.mobileNo = mobileNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
