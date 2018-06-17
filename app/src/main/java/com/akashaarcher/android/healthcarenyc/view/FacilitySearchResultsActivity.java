package com.akashaarcher.android.healthcarenyc.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.akashaarcher.android.healthcarenyc.R;
import com.akashaarcher.android.healthcarenyc.data.network.HhcClient;
import com.akashaarcher.android.healthcarenyc.model.HhcFacility;
import com.akashaarcher.android.healthcarenyc.model.WomensHealthFacility;
import com.akashaarcher.android.healthcarenyc.view.adapter.HhcFacilityAdapter;
import com.akashaarcher.android.healthcarenyc.view.adapter.StdTestCenterAdapter;
import com.akashaarcher.android.healthcarenyc.view.adapter.WomensHealthCenterAdapter;
import com.akashaarcher.android.healthcarenyc.viewmodel.FacilitySearchResultsViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by akashaarcher on 4/5/18.
 */

public class FacilitySearchResultsActivity extends AppCompatActivity {

    private final String GENERAL_HOSPITAL = "General Hospital";
    private final String HEALTH_CENTER = "Health Center";
    private final String CHILD_HEALTH = "Child Health Center";
    private final String NURSING_HOME = "Nursing Home";
    private final String STD_TESTING = "STD Testing";
    private final String WOMEN_HEALTH = "Women";

    @BindView(R.id.search_results_rv)
    RecyclerView facilityResultsRv;

    private FacilitySearchResultsViewModel facilitySearchResultsViewModel;

    private HhcFacilityAdapter hhcAdapter = new HhcFacilityAdapter();
    private WomensHealthCenterAdapter womensHealthAdapter = new WomensHealthCenterAdapter();

    private static final String TAG = FacilitySearchResultsActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_search_results);

        Toast.makeText(this, "women's health: On create", Toast.LENGTH_LONG).show();

        ButterKnife.bind(this);
        facilitySearchResultsViewModel = new FacilitySearchResultsViewModel(HhcClient.getInstance());

        String service = getIntent().getStringExtra(FindServiceFragment.SERVICE_KEY);
        Log.d(TAG, "Service selected is: " + service);

        facilityResultsRv.setLayoutManager(new LinearLayoutManager(this));

        switch (service) {
            case GENERAL_HOSPITAL:
                getAcuteFacilities();
                break;
            case HEALTH_CENTER:
                getHealthCenterFacilities();
                break;
            case CHILD_HEALTH:
                getChildHealthFacilities();
                break;
            case NURSING_HOME:
                getNursingHomeFacilities();
                break;
            case STD_TESTING:
                // facilityResultsRv.setAdapter(new StdTestCenterAdapter());
                break;
            case WOMEN_HEALTH:
                List<WomensHealthFacility> womensHealthFacilities = facilitySearchResultsViewModel.getWomensHealthFacilities();
                womensHealthAdapter.setData(womensHealthFacilities);
                facilityResultsRv.setAdapter(womensHealthAdapter);
                Log.d(TAG, "Women's Health selected: List size = " + womensHealthFacilities.size());
                Toast.makeText(this, "women's health", Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void getAcuteFacilities() {
        Call<List<HhcFacility>> call = facilitySearchResultsViewModel.getHhcAcuteHospitals();
        call.enqueue(new Callback<List<HhcFacility>>() {
            @Override
            public void onResponse(Call<List<HhcFacility>> listResults, Response<List<HhcFacility>> response) {
                List<HhcFacility> hhcFacilities = response.body();
                hhcAdapter.setData(hhcFacilities);
                facilityResultsRv.setAdapter(hhcAdapter);
                Log.d(TAG, "In onResponse, list size: " + hhcFacilities.size());
            }

            @Override
            public void onFailure(Call<List<HhcFacility>> listResults, Throwable t) {
                Log.d(TAG, "There was a failure" + t.getMessage());
            }
        });
    }

    private void getHealthCenterFacilities() {
        Call<List<HhcFacility>> call = facilitySearchResultsViewModel.getHhcHealthCenters();
        call.enqueue(new Callback<List<HhcFacility>>() {
            @Override
            public void onResponse(Call<List<HhcFacility>> listResults, Response<List<HhcFacility>> response) {
                List<HhcFacility> hhcFacilities = response.body();
                hhcAdapter.setData(hhcFacilities);
                facilityResultsRv.setAdapter(hhcAdapter);
                Log.d(TAG, "In onResponse, list size: " + hhcFacilities.size());
            }

            @Override
            public void onFailure(Call<List<HhcFacility>> listResults, Throwable t) {
                Log.d(TAG, "There was a failure" + t.getMessage());
            }
        });
    }

    private void getChildHealthFacilities() {
        Call<List<HhcFacility>> call = facilitySearchResultsViewModel.getHhcChildCareHospitals();
        call.enqueue(new Callback<List<HhcFacility>>() {
            @Override
            public void onResponse(Call<List<HhcFacility>> listResults, Response<List<HhcFacility>> response) {
                List<HhcFacility> hhcFacilities = response.body();
                hhcAdapter.setData(hhcFacilities);
                facilityResultsRv.setAdapter(hhcAdapter);
                Log.d(TAG, "In onResponse, list size: " + hhcFacilities.size());
            }

            @Override
            public void onFailure(Call<List<HhcFacility>> listResults, Throwable t) {
                Log.d(TAG, "There was a failure" + t.getMessage());
            }
        });
    }

    private void getNursingHomeFacilities() {
        Call<List<HhcFacility>> call = facilitySearchResultsViewModel.getHhcNursingHomes();
        call.enqueue(new Callback<List<HhcFacility>>() {
            @Override
            public void onResponse(Call<List<HhcFacility>> listResults, Response<List<HhcFacility>> response) {
                List<HhcFacility> hhcFacilities = response.body();
                hhcAdapter.setData(hhcFacilities);
                facilityResultsRv.setAdapter(hhcAdapter);
                Log.d(TAG, "In onResponse, list size: " + hhcFacilities.size());
            }

            @Override
            public void onFailure(Call<List<HhcFacility>> listResults, Throwable t) {
                Log.d(TAG, "There was a failure" + t.getMessage());
            }
        });
    }


}
