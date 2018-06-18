package com.akashaarcher.android.healthcarenyc.view;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.akashaarcher.android.healthcarenyc.R;
import com.akashaarcher.android.healthcarenyc.data.network.HhcClient;
import com.akashaarcher.android.healthcarenyc.model.HhcFacility;
import com.akashaarcher.android.healthcarenyc.model.HhcFeeLevelCosts;
import com.akashaarcher.android.healthcarenyc.viewmodel.FacilitySearchResultsViewModel;
import com.akashaarcher.android.healthcarenyc.viewmodel.MedicalServicesCostViewModel;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MedicalServicesCostActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @BindView(R.id.spn_select_service)
    Spinner spinnerSelectService;

    @BindView(R.id.tv_cost_of_service)
    TextView tvCostOfService;

    private List<HhcFeeLevelCosts> hhcCosts;
    private List<String> spinnerArray;
    private List<String> costArray;

    private MedicalServicesCostViewModel medicalServicesCostViewModel;

    ArrayAdapter spinnerArrayAdapter;

    private int feeLevel;
    private String TAG = "MedicalServicesCostActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_services_cost);
        ButterKnife.bind(this);

        medicalServicesCostViewModel = new MedicalServicesCostViewModel(HhcClient.getInstance());
        feeLevel = getIntent().getIntExtra(CalculateCostFragment.FEE_KEY, 1);
        spinnerSelectService.setOnItemSelectedListener(this);

        hideCostView();
        displayHhcServiceCosts();
    }


    private void displayHhcServiceCosts() {
        Call<List<HhcFeeLevelCosts>> call = medicalServicesCostViewModel.getHhcServicesCost();
        call.enqueue(new Callback<List<HhcFeeLevelCosts>>() {
            @Override
            public void onResponse(Call<List<HhcFeeLevelCosts>> call, Response<List<HhcFeeLevelCosts>> response) {
                hhcCosts = response.body();
                Log.d(TAG, "onResponse: " + hhcCosts.size());
                populateArray();
            }

            @Override
            public void onFailure(Call<List<HhcFeeLevelCosts>> call, Throwable t) {
                Log.d(TAG, "There was a failure " + t.getMessage());
            }
        });

    }

    private void populateArray() {
        spinnerArray = new ArrayList<>();
        costArray = new ArrayList<>();

        for (int i = 0; i < hhcCosts.size(); i++) {
            if (Integer.valueOf(hhcCosts.get(i).getHhcOptionsReducedFeeLevel()) == feeLevel) {
                spinnerArray.add(hhcCosts.get(i).getService());
                if (hhcCosts.get(i).getFee() == null || hhcCosts.get(i).getFee().equals("")) {
                    costArray.add("Full Cost");
                } else {
                    costArray.add(hhcCosts.get(i).getFee());
                }
            }
        }

        spinnerArrayAdapter = new ArrayAdapter(
                this,
                R.layout.spinner_item_multiline,
                spinnerArray);
        spinnerArrayAdapter.notifyDataSetChanged();
        spinnerSelectService.setAdapter(spinnerArrayAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                getCost(0);
                break;
            case 1:
                getCost(1);
                break;
            case 2:
                getCost(2);
                break;
            case 3:
                getCost(3);
                break;
            case 4:
                getCost(4);
                break;
            case 5:
                getCost(5);
                break;
            case 6:
                getCost(6);
                break;
            case 7:
                getCost(7);
                break;
            default:
                getCost(7);
                break;
        }
    }

    private void getCost(int position) {
        String cost = costArray.get(position);

        if (cost.matches("[0-9]+")) {
            String formattedCost = NumberFormat.
                    getCurrencyInstance().
                    format(Long.valueOf(cost));
            tvCostOfService.setText(formattedCost);
            tvCostOfService.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
        } else {
            tvCostOfService.setTextColor(Color.RED);
            tvCostOfService.setText("Ineligible");
            tvCostOfService.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));

        }
        showCostView();
    }

    private void showCostView() {
        tvCostOfService.setEnabled(true);
        tvCostOfService.setVisibility(View.VISIBLE);
    }

    private void hideCostView() {
        tvCostOfService.setEnabled(false);
        tvCostOfService.setVisibility(View.GONE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Do Nothing
    }


}


