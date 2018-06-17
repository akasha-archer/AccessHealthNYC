package com.akashaarcher.android.healthcarenyc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.akashaarcher.android.healthcarenyc.R;

import java.util.List;

/**
 * Created by akashaarcher on 4/5/18.
 */


public class HealthFacility {
    private String healthFacilityName;
    private Integer healthFacilityAddress;
    private Integer healthFacilityWebsite;
    private Integer healthFacilityPhone;


    public HealthFacility(String healthFacilityName, Integer healthFacilityAddress, Integer healthFacilityWebsite, Integer healthFacilityPhone) {
        this.healthFacilityName = healthFacilityName;
        this.healthFacilityAddress = healthFacilityAddress;
        this.healthFacilityWebsite = healthFacilityWebsite;
        this.healthFacilityPhone = healthFacilityPhone;
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

    public Integer getHealthFacilityWebsite() {
        return healthFacilityWebsite;
    }

    public void setHealthFacilityWebsite(Integer healthFacilityWebsite) {
        this.healthFacilityWebsite = healthFacilityWebsite;
    }

    public Integer getHealthFacilityPhone() {
        return healthFacilityPhone;
    }

    public void setHealthFacilityPhone(Integer healthFacilityPhone) {
        this.healthFacilityPhone = healthFacilityPhone;
    }
}
