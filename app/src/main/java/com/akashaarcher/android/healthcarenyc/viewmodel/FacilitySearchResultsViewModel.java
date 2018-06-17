package com.akashaarcher.android.healthcarenyc.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.akashaarcher.android.healthcarenyc.R;
import com.akashaarcher.android.healthcarenyc.data.network.HhcClient;
import com.akashaarcher.android.healthcarenyc.model.HhcFacility;
import com.akashaarcher.android.healthcarenyc.model.WomensHealthFacility;

import java.util.ArrayList;
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


    public List<WomensHealthFacility> getWomensHealthFacilities() {
        List<WomensHealthFacility> allWomensFacilities = new ArrayList<>();
        allWomensFacilities.add(new WomensHealthFacility("Planned Parenthood - Bronx", R.string.planned_parenthood_bronx, R.string.ppnyc_website, R.string.planned_parenthood_phone)
                );
        allWomensFacilities.add(new WomensHealthFacility("Planned Parenthood - Manhattan", R.string.planned_parenthood_manhattan, R.string.ppnyc_website, R.string.planned_parenthood_phone)
                );
        allWomensFacilities.add(new WomensHealthFacility("Planned Parenthood - Queens", R.string.planned_parenthood_queens, R.string.ppnyc_website, R.string.planned_parenthood_phone)
                );
        allWomensFacilities.add(new WomensHealthFacility("Planned Parenthood - Brooklyn", R.string.planned_parenthood_brooklyn, R.string.ppnyc_website, R.string.planned_parenthood_phone)
                );
        allWomensFacilities.add(new WomensHealthFacility("Planned Parenthood - Staten Island", R.string.planned_parenthood_staten_island, R.string.ppnyc_website, R.string.planned_parenthood_phone)
                );
        allWomensFacilities.add(new WomensHealthFacility("Eastside Gynecology", R.string.eastside_gynecology, R.string.ppnyc_website, R.string.eastside_gynecology_phone)
                );
        allWomensFacilities.add(new WomensHealthFacility("Charles B. Wang Health Center - Chinatown", R.string.charles_wang_clinic_address_chtwn, R.string.charles_wang_web, R.string.charles_wang_gyn_canal_phone)
                );
        allWomensFacilities.add(new WomensHealthFacility("Charles B. Wang Health Center - Flushing", R.string.charles_wang_clinic_address_flushing, R.string.charles_wang_web, R.string.charles_wang_gyn_flushing1_phone)
                );
        allWomensFacilities.add(new WomensHealthFacility("Charles B. Wang Health Center - Flushing", R.string.charles_wang_clinic_address_flushing_second, R.string.charles_wang_web, R.string.charles_wang_gyn_flushing2_phone)
        );
        return allWomensFacilities;
    }
}
