package org.dhanush.domain;

public class User {
    private String organization="default";
    private String userName="cb_admin";
    private String password = "password";
    private String NameFirst = "c";
    private String NameLast = "tom";
    private String mobileNum="9884765326";
    private String DoB = "01/08/1998";
    private String street ="No: 2, Nehru Street";
    private String addressLine1 = "Medavakkam";
    private String district = "Chennai";

    private String state = "Tamil Nadu";
    private String activationDate = "13 June 2022";
    public String getActivationDate() {
        return activationDate;
    }

    public String getState() {
        return state;
    }

    public String getStreet() {
        return street;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getDoB(){
        return DoB;
    }
    public String getNameFirst() {
        return NameFirst;
    }

    public String getNameLast() {
        return NameLast;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public String getOrganization() {
        return organization;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
    public String getDistrict() {
        return district;
    }
}
