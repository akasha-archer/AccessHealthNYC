package com.akashaarcher.android.healthcarenyc.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.akashaarcher.android.healthcarenyc.R;
import com.akashaarcher.android.healthcarenyc.data.database.UserEntity;
import com.akashaarcher.android.healthcarenyc.viewmodel.FindServiceViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by akashaarcher on 4/7/18.
 */

public class FindServiceFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.user_greeting)
    TextView userGreetingTv;

    @BindView(R.id.services_spinner)
    Spinner servicesSpinner;

    @BindView(R.id.location_input)
    EditText locationInputEt;

    @BindView(R.id.current_location_btn)
    ImageView currLocationIv;

    @BindView(R.id.find_service_btn)
    Button findServicesBtn;

    private String serviceSpinnerValue = "";
    public static String SERVICE_KEY = "Service Key";
    
    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_service, container, false);
        unbinder = ButterKnife.bind(this, view);

        ArrayAdapter<CharSequence> serviceAdapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.medical_services, android.R.layout.simple_spinner_item);
        serviceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        servicesSpinner.setAdapter(serviceAdapter);

        servicesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                serviceSpinnerValue = servicesSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(getActivity(), "Please select a service to continue", Toast.LENGTH_SHORT).show();
            }
        });

        setListeners();
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private void setListeners() {
        findServicesBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.find_service_btn:
                if (serviceSpinnerValue.equals("Please choose a service")) {
                    Toast.makeText(getActivity(), "Please select a service to continue", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(view.getContext(), FacilitySearchResultsActivity.class);
                    intent.putExtra(SERVICE_KEY, serviceSpinnerValue);
                    startActivity(intent);
                }
        }


    }

}
