package com.akashaarcher.android.healthcarenyc.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.akashaarcher.android.healthcarenyc.R;
import com.akashaarcher.android.healthcarenyc.data.network.HhcClient;
import com.akashaarcher.android.healthcarenyc.model.HealthFacility;
import com.akashaarcher.android.healthcarenyc.model.HhcFacility;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;


public class FacilitySearchResultsViewModel extends ViewModel {

    private HhcClient client;

    public FacilitySearchResultsViewModel(HhcClient client) {
        this.client = client;
    }

    public Call<List<HhcFacility>> getHhcAcuteHospitals() {
        return client.getHhcService().getHhcAcuteLocations();
    }

    public Call<List<HhcFacility>> getHhcChildCareHospitals() {
        return client.getHhcService().getHhcChildCareLocations();
    }

    public Call<List<HhcFacility>> getHhcNursingHomes() {
        return client.getHhcService().getHhcNursingHomeLocations();
    }

    public Call<List<HhcFacility>> getHhcHealthCenters() {
        return client.getHhcService().getHhcHealthCenterLocations();
    }


    public List<HealthFacility> getWomensHealthFacilities() {
        List<HealthFacility> allWomensFacilities = new ArrayList<>();
        allWomensFacilities.add(new HealthFacility("Planned Parenthood - Bronx", R.string.planned_parenthood_bronx, R.string.ppnyc_website, R.string.planned_parenthood_phone)
                );
        allWomensFacilities.add(new HealthFacility("Planned Parenthood - Manhattan", R.string.planned_parenthood_manhattan, R.string.ppnyc_website, R.string.planned_parenthood_phone)
                );
        allWomensFacilities.add(new HealthFacility("Planned Parenthood - Queens", R.string.planned_parenthood_queens, R.string.ppnyc_website, R.string.planned_parenthood_phone)
                );
        allWomensFacilities.add(new HealthFacility("Planned Parenthood - Brooklyn", R.string.planned_parenthood_brooklyn, R.string.ppnyc_website, R.string.planned_parenthood_phone)
                );
        allWomensFacilities.add(new HealthFacility("Planned Parenthood - Staten Island", R.string.planned_parenthood_staten_island, R.string.ppnyc_website, R.string.planned_parenthood_phone)
                );
        allWomensFacilities.add(new HealthFacility("Eastside Gynecology", R.string.eastside_gynecology, R.string.ppnyc_website, R.string.eastside_gynecology_phone)
                );
        allWomensFacilities.add(new HealthFacility("Charles B. Wang Health Center - Chinatown", R.string.charles_wang_clinic_address_chtwn, R.string.charles_wang_web, R.string.charles_wang_gyn_canal_phone)
                );
        allWomensFacilities.add(new HealthFacility("Charles B. Wang Health Center - Flushing", R.string.charles_wang_clinic_address_flushing, R.string.charles_wang_web, R.string.charles_wang_gyn_flushing1_phone)
                );
        allWomensFacilities.add(new HealthFacility("Charles B. Wang Health Center - Flushing", R.string.charles_wang_clinic_address_flushing_second, R.string.charles_wang_web, R.string.charles_wang_gyn_flushing2_phone)
        );
        return allWomensFacilities;
    }

    public List<HealthFacility> getStdTestingFacilities() {
        List<HealthFacility> allStdTestingFacilities = new ArrayList<>();
        allStdTestingFacilities.add(new HealthFacility("Sexual Health Clinic: Central Harlem", R.string.health_dept_sexual_harlem, R.string.health_dept_sexual_website, R.string.health_dept_sexual_phone));
        allStdTestingFacilities.add(new HealthFacility("Sexual Health Clinic: Riverside", R.string.health_dept_sexual_riverside, R.string.health_dept_sexual_website, R.string.health_dept_sexual_phone));
        allStdTestingFacilities.add(new HealthFacility("Sexual Health Clinic: Chelsea", R.string.health_dept_sexual_chelsea, R.string.health_dept_sexual_website, R.string.health_dept_sexual_phone));
        allStdTestingFacilities.add(new HealthFacility("Sexual Health Clinic: Bronx", R.string.health_dept_sexual_morrisania, R.string.health_dept_sexual_website, R.string.health_dept_sexual_phone));
        allStdTestingFacilities.add(new HealthFacility("Sexual Health Clinic: Fort Greene", R.string.health_dept_sexual_fort_greene, R.string.health_dept_sexual_website, R.string.health_dept_sexual_phone));
        allStdTestingFacilities.add(new HealthFacility("Sexual Health Clinic: Corona", R.string.health_dept_sexual_corona, R.string.health_dept_sexual_website, R.string.health_dept_sexual_phone));
        allStdTestingFacilities.add(new HealthFacility("Sexual Health Clinic: Jamaica", R.string.health_dept_sexual_jamaica, R.string.health_dept_sexual_website, R.string.health_dept_sexual_phone));

        return allStdTestingFacilities;
    }

}
