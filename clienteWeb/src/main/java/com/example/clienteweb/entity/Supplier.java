package com.example.clienteweb.entity;

public class Supplier {

    private Integer idSupplier;
    private String supplierName;
//    private String contactName;
//    private String contactTitle;
    private String address;
//    private String city;
//    private String region;
//    private String postalCode;
//    private String country;
//    private String phone;
//    private String fax;
//    private String homePage;

    //Get and Set


    public Integer getIdSupplier() {
        return idSupplier;
    }
    public void setIdSupplier(Integer idSupplier) {
        this.idSupplier = idSupplier;
    }

    public String getSupplierName() {
        return supplierName;
    }
    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
