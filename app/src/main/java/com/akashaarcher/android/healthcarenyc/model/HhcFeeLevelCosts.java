package com.akashaarcher.android.healthcarenyc.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HhcFeeLevelCosts {


    private String fee;

    @SerializedName("hhc_options_reduced_fee_level")
    @Expose
    private String hhcOptionsReducedFeeLevel;

    private String service;

    public HhcFeeLevelCosts() {
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getHhcOptionsReducedFeeLevel() {
        return hhcOptionsReducedFeeLevel;
    }

    public void setHhcOptionsReducedFeeLevel(String hhcOptionsReducedFeeLevel) {
        this.hhcOptionsReducedFeeLevel = hhcOptionsReducedFeeLevel;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
