package com.akashaarcher.android.healthcarenyc.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.akashaarcher.android.healthcarenyc.R;

import java.util.List;

/**
 * Created by akashaarcher on 4/5/18.
 */

@Entity
public class WomensHealthFacility {
    @PrimaryKey
    private int id;
    private String womenHealthFacilityName;
    private Integer womenHealthFacilityAddress;
    private Integer womenHealthFacilityWebsite;
    private Integer womenHealthFacilityPhone;


    public WomensHealthFacility(String womenHealthFacilityName, Integer womenHealthFacilityAddress, Integer womenHealthFacilityWebsite, Integer womenHealthFacilityPhone) {
        this.womenHealthFacilityName = womenHealthFacilityName;
        this.womenHealthFacilityAddress = womenHealthFacilityAddress;
        this.womenHealthFacilityWebsite = womenHealthFacilityWebsite;
        this.womenHealthFacilityPhone = womenHealthFacilityPhone;
    }

    public WomensHealthFacility() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWomenHealthFacilityName() {
        return womenHealthFacilityName;
    }

    public void setWomenHealthFacilityName(String womenHealthFacilityName) {
        this.womenHealthFacilityName = womenHealthFacilityName;
    }

    public Integer getWomenHealthFacilityAddress() {
        return womenHealthFacilityAddress;
    }

    public void setWomenHealthFacilityAddress(Integer womenHealthFacilityAddress) {
        this.womenHealthFacilityAddress = womenHealthFacilityAddress;
    }

    public Integer getWomenHealthFacilityWebsite() {
        return womenHealthFacilityWebsite;
    }

    public void setWomenHealthFacilityWebsite(Integer womenHealthFacilityWebsite) {
        this.womenHealthFacilityWebsite = womenHealthFacilityWebsite;
    }

    public Integer getWomenHealthFacilityPhone() {
        return womenHealthFacilityPhone;
    }

    public void setWomenHealthFacilityPhone(Integer womenHealthFacilityPhone) {
        this.womenHealthFacilityPhone = womenHealthFacilityPhone;
    }

    // Data prepared ahead of time for database. To be displayed in RV when user selects Women's Health Facility option
    public static WomensHealthFacility[] populateDataBase() {

        return new WomensHealthFacility[]{
                new WomensHealthFacility("Planned Parenthood - Bronx", R.string.planned_parenthood_bronx, R.string.ppnyc_website, R.string.planned_parenthood_phone),
                new WomensHealthFacility("Planned Parenthood - Manhattan", R.string.planned_parenthood_manhattan, R.string.ppnyc_website, R.string.planned_parenthood_phone),
                new WomensHealthFacility("Planned Parenthood - Queens", R.string.planned_parenthood_queens, R.string.ppnyc_website, R.string.planned_parenthood_phone),
                new WomensHealthFacility("Planned Parenthood - Brooklyn", R.string.planned_parenthood_brooklyn, R.string.ppnyc_website, R.string.planned_parenthood_phone),
                new WomensHealthFacility("Planned Parenthood - Staten Island", R.string.planned_parenthood_staten_island, R.string.ppnyc_website, R.string.planned_parenthood_phone),

                new WomensHealthFacility("Eastside Gynecology", R.string.eastside_gynecology, R.string.ppnyc_website, R.string.eastside_gynecology_phone),
                new WomensHealthFacility("Charles B. Wang Health Center - Chinatown", R.string.charles_wang_clinic_address_chtwn, R.string.charles_wang_web, R.string.charles_wang_gyn_canal_phone),
                new WomensHealthFacility("Charles B. Wang Health Center - Flushing", R.string.charles_wang_clinic_address_flushing, R.string.charles_wang_web, R.string.charles_wang_gyn_flushing1_phone),
                new WomensHealthFacility("Charles B. Wang Health Center - Flushing", R.string.charles_wang_clinic_address_flushing_second, R.string.charles_wang_web, R.string.charles_wang_gyn_flushing2_phone)
        };

    }

}
