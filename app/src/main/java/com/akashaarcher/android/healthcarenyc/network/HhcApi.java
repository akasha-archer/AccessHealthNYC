package com.akashaarcher.android.healthcarenyc.network;

import com.akashaarcher.android.healthcarenyc.model.HhcFacility;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by akashaarcher on 4/5/18.
 */

public interface HhcApi {

//    GET("resource/ujy7-x749.json")
//    Call<List<HhcData>> getDataSet();

    // General hospitals
    @GET("resource/w7a6-9xrz.json?facility_type=Acute%20Care%20Hospital")
    Call<List<HhcFacility>> getHhcAcuteLocations();

    //ChildCare facilities
    @GET("resource/w7a6-9xrz.json?facility_type=Child%20Health%20Center")
    Call<List<HhcFacility>> getHhcChildCareLocations();

    //Nursing Home facilities
    @GET("resource/w7a6-9xrz.json?facility_type=Nursing%20Home")
    Call<List<HhcFacility>> getHhcNursingHomeLocations();

    //Neighborhood Health Center facilities  >> use %26 for '&'
    @GET("resource/w7a6-9xrz.json?facility_type=Diagnostic%20%26%20Treatment%20Center")
    Call<List<HhcFacility>> getHhcHealthCenterLocations();

}
