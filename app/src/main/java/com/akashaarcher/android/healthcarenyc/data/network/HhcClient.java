package com.akashaarcher.android.healthcarenyc.data.network;

import android.support.annotation.NonNull;

import com.akashaarcher.android.healthcarenyc.model.HhcFacility;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HhcClient {

    private static final String BASE_URL = "https://data.cityofnewyork.us";

    private static HhcClient instance;
    private HhcService hhcService;

    public static HhcClient getInstance() {
        if (instance == null) {
            instance = new HhcClient();
        }
        return instance;
    }

    private HhcClient () {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        hhcService = retrofit.create(HhcService.class);
    }

    public HhcService getService() {
        return hhcService;
    }

//    public Observable<List<HhcFacility>> getHhcAcuteHospitals() {
//        return hhcService.getHhcAcuteLocations();
//    }
//
//    public Observable<List<HhcFacility>> getHhcChildCareHospitals() {
//        return hhcService.getHhcChildCareLocations();
//    }
//
//    public Observable<List<HhcFacility>> getHhcNursingHomes() {
//        return hhcService.getHhcNursingHomeLocations();
//    }
//
//    public Observable<List<HhcFacility>> getHhcHealthCenters() {
//        return hhcService.getHhcHealthCenterLocations();
//    }


}
