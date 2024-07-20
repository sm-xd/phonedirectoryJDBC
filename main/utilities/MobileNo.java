package main.utilities;

public class MobileNo {
    private String fname;
    private String mname;
    private String lname;
    private String city;
    private String mobileNo;

    public MobileNo() {
    }

    public MobileNo(String fname, String mname, String lname, String city, String mobileNo) {
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.city = city;
        this.mobileNo = mobileNo;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    @Override
    public String toString() {
        return "MobileNo{" +
                "Name= " + fname + mname + '\'' +lname + '\'' +
                ", city= " + city + '\'' +
                ", mobileNo= " + mobileNo + '\'' +
                '}';
    }
}
