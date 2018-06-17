package com.akashaarcher.android.healthcarenyc.model;

/**
 * Created by akashaarcher on 4/5/18.
 */

public class HealthFacility {

    private String healthFacilityName;
    private Integer healthFacilityAddress;
    private String healthFacilityWebsite;
    private String healthFacilityPhone;


    public HealthFacility(String name, Integer address, String website, String phone) {
        this.healthFacilityName = name;
        this.healthFacilityAddress = address;
        this.healthFacilityWebsite = website;
        this.healthFacilityPhone = phone;
    }

    public String getHealthFacilityName() {
        return healthFacilityName;
    }

    public void setHealthFacilityName(String healthFacilityName) {
        this.healthFacilityName = healthFacilityName;
    }

    public Integer getHealthFacilityAddress() {
        return healthFacilityAddress;
    }

    public void setHealthFacilityAddress(Integer healthFacilityAddress) {
        this.healthFacilityAddress = healthFacilityAddress;
    }

    public String getHealthFacilityWebsite() {
        return healthFacilityWebsite;
    }

    public void setHealthFacilityWebsite(String healthFacilityWebsite) {
        this.healthFacilityWebsite = healthFacilityWebsite;
    }

    public String getHealthFacilityPhone() {
        return healthFacilityPhone;
    }

    public void setHealthFacilityPhone(String healthFacilityPhone) {
        this.healthFacilityPhone = healthFacilityPhone;
    }
}
