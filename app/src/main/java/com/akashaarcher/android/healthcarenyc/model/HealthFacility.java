package com.akashaarcher.android.healthcarenyc.model;

/**
 * Created by akashaarcher on 4/5/18.
 */

public class HealthFacility {

    private String name;
    private Integer address;
    private String website;
    private String phone;


    public HealthFacility(String name, Integer address, String website, String phone) {
        this.name = name;
        this.address = address;
        this.website = website;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
