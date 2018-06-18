package com.akashaarcher.android.healthcarenyc.data.network;


import com.akashaarcher.android.healthcarenyc.model.HhcFacility;
import com.akashaarcher.android.healthcarenyc.model.HhcFeeLevelCosts;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by akashaarcher on 4/5/18.
 */

public interface HhcService {

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

    //Costs for services based on fee levels
    @GET("resource/ujy7-x749.json")
    Call<List<HhcFeeLevelCosts>> getServiceCosts();

}

