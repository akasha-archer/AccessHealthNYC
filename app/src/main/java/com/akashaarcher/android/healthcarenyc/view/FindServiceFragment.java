package com.akashaarcher.android.healthcarenyc.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.akashaarcher.android.healthcarenyc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by akashaarcher on 4/7/18.
 */

public class FindServiceFragment extends Fragment {

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

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
