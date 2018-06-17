package com.akashaarcher.android.healthcarenyc.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.akashaarcher.android.healthcarenyc.R;
import com.akashaarcher.android.healthcarenyc.data.network.HhcClient;
import com.akashaarcher.android.healthcarenyc.model.HhcFacility;
import com.akashaarcher.android.healthcarenyc.view.adapter.HhcFacilityAdapter;
import com.akashaarcher.android.healthcarenyc.view.adapter.StdTestCenterAdapter;
import com.akashaarcher.android.healthcarenyc.view.adapter.WomensHealthCenterAdapter;
import com.akashaarcher.android.healthcarenyc.viewmodel.FacilitySearchResultsViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
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
    private final String WOMEN_HEALTH = "Women's Health";

    @BindView(R.id.search_results_rv)
    RecyclerView facilityResultsRv;

    private HhcClient hhcClient;

    private FacilitySearchResultsViewModel facilitySearchResultsViewModel;
    private HhcFacilityAdapter adapter = new HhcFacilityAdapter();
    private static final String TAG = FacilitySearchResultsActivity.class.getSimpleName();

    private List<HhcFacility> hhcFacilities = new ArrayList<>();

    private CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facility_search_results);

        ButterKnife.bind(this);
        facilitySearchResultsViewModel = new FacilitySearchResultsViewModel(HhcClient.getInstance());

        facilityResultsRv.setLayoutManager(new LinearLayoutManager(this));

        String service = getIntent().getStringExtra(FindServiceFragment.SERVICE_KEY);
        switch (service) {
            case GENERAL_HOSPITAL:
                getFacilities();
                break;
            case HEALTH_CENTER:
                // load
                break;
            case CHILD_HEALTH:
                // load
                break;
            case NURSING_HOME:
                // load
                break;
            case STD_TESTING:
                facilityResultsRv.setAdapter(new StdTestCenterAdapter());
                break;
            case WOMEN_HEALTH:
                facilityResultsRv.setAdapter(new WomensHealthCenterAdapter());
                break;
        }

    }

    private void getFacilities() {

        facilitySearchResultsViewModel = new FacilitySearchResultsViewModel(HhcClient.getInstance());
        Call<List<HhcFacility>> call = facilitySearchResultsViewModel.getHhcAcuteHospitals();
        call.enqueue(new Callback<List<HhcFacility>>() {
            @Override
            public void onResponse(Call<List<HhcFacility>> listResults, Response<List<HhcFacility>> response) {
                List<HhcFacility> hhcFacilities = response.body();
                adapter.setData(hhcFacilities);
                facilityResultsRv.setAdapter(adapter);
                Log.d(TAG, "In onResponse, list size: " + hhcFacilities.size());
            }

            @Override
            public void onFailure(Call<List<HhcFacility>> listResults, Throwable t) {
                Log.d(TAG, "There was a failure" + t.getMessage());

            }
        });
    }


//    private void getFacilities() {
//        disposables.add(
//                facilitySearchResultsViewModel.getHhcAcuteHospitals()
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Consumer<List<HhcFacility>>() {
//                            @Override
//                            public void accept(List<HhcFacility> listResults) throws Exception {
//                                adapter.setData(listResults);
//                                Log.d(TAG, "In onSuccess, list size: " + listResults.size());
//                            }
//                        }, new Consumer<Throwable>() {
//                            @Override
//                            public void accept(Throwable throwable) throws Exception {
//                                throwable.printStackTrace();
//                                Log.d(TAG, "In onError " + throwable.getMessage());
//                            }
//                        }));
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.clear();
    }


}
