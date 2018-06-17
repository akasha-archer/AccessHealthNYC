package com.akashaarcher.android.healthcarenyc.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.akashaarcher.android.healthcarenyc.data.network.HhcClient;
import com.akashaarcher.android.healthcarenyc.model.HhcFacility;

import java.util.List;
import io.reactivex.Single;
import retrofit2.Call;


public class FacilitySearchResultsViewModel extends ViewModel {

    private HhcClient client;

    public FacilitySearchResultsViewModel(HhcClient client) {
        this.client = client;
    }


    public Call<List<HhcFacility>> getHhcAcuteHospitals() {
        return client.getService().getHhcAcuteLocations();
    }

    public Call<List<HhcFacility>> getHhcChildCareHospitals() {
        return client.getService().getHhcChildCareLocations();
    }

    public Call<List<HhcFacility>> getHhcNursingHomes() {
        return client.getService().getHhcNursingHomeLocations();
    }

    public Call<List<HhcFacility>> getHhcHealthCenters() {
        return client.getService().getHhcHealthCenterLocations();
    }

   /* public Single<List<HhcFacility>> getHhcAcuteHospitals() {
        return client.getService().getHhcAcuteLocations();
    }

    public Single<List<HhcFacility>> getHhcChildCareHospitals() {
        return client.getService().getHhcChildCareLocations();
    }

    public Single<List<HhcFacility>> getHhcNursingHomes() {
        return client.getService().getHhcNursingHomeLocations();
    }

    public Single<List<HhcFacility>> getHhcHealthCenters() {
        return client.getService().getHhcHealthCenterLocations();
    }*/

}
