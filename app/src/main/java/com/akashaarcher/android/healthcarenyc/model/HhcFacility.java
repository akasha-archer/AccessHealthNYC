package com.akashaarcher.android.healthcarenyc.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akashaarcher on 4/5/18.
 */

public class HhcFacility {

    @SerializedName("borough")
    @Expose
    private String borough;
    @SerializedName("facility_name")
    @Expose
    private String facilityName;
    @SerializedName("facility_type")
    @Expose
    private String facilityType;
    @SerializedName("location_1_city")
    @Expose
    private String location1City;
    @SerializedName("location_1_location")
    @Expose
    private String location1Location;
    @SerializedName("location_1_state")
    @Expose
    private String location1State;
    @SerializedName("location_1_zip")
    @Expose
    private String location1Zip;
    @SerializedName("phone")
    @Expose
    private String phone;

    public HhcFacility() {
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getLocation1City() {
        return location1City;
    }

    public void setLocation1City(String location1City) {
        this.location1City = location1City;
    }

    public String getLocation1Location() {
        return location1Location;
    }

    public void setLocation1Location(String location1Location) {
        this.location1Location = location1Location;
    }

    public String getLocation1State() {
        return location1State;
    }

    public void setLocation1State(String location1State) {
        this.location1State = location1State;
    }

    public String getLocation1Zip() {
        return location1Zip;
    }

    public void setLocation1Zip(String location1Zip) {
        this.location1Zip = location1Zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}
