package com.akashaarcher.android.healthcarenyc.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.akashaarcher.android.healthcarenyc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by akashaarcher on 4/7/18.
 */

public class CalculateCostFragment extends Fragment {

    @BindView(R.id.tv_question_household_size)
    TextView tvQuestionHouseholdSize;

    @BindView(R.id.spn_family_size)
    Spinner spinnerFamilySize;

    @BindView(R.id.tv_question_income)
    TextView tvQuestionIncome;

    @BindView(R.id.spn_income)
    Spinner spinnerIncome;

    @BindView(R.id.tv_fee_level)
    TextView tvFeeLevel;

    @BindView(R.id.tv_question_fee_level)
    TextView tvQuestionFeeLevel;

    @BindView(R.id.btn_calculate_fees)
    Button btnCalculateFees;

    private int feeLevel;

    private Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculate_cost, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hideAllViews();

        btnCalculateFees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Fragment fragment = new MedicalCostsFragment();
//                Bundle bundle = new Bundle();
//                bundle.putInt("User_Fee_Level", feeLevel);
//                fragment.setArguments(bundle);
//                getFragmentManager().beginTransaction().replace(R.id.fl_fragment_host, fragment).commit();
            }
        });


        spinnerFamilySize.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ArrayAdapter<CharSequence> spinnerTwoArray;

                switch (position) {
                    case 0:
                        hideAllViews();
                        break;
                    case 1:
                        setUpSecondSpinner(R.array.fam_size_1);
                        break;
                    case 2:
                        setUpSecondSpinner(R.array.fam_size_2);
                        break;
                    case 3:
                        setUpSecondSpinner(R.array.fam_size_3);
                        break;
                    case 4:
                        setUpSecondSpinner(R.array.fam_size_4);
                        break;
                    case 5:
                        setUpSecondSpinner(R.array.fam_size_5);
                        break;
                    case 6:
                        setUpSecondSpinner(R.array.fam_size_6);
                        break;
                    case 7:
                        setUpSecondSpinner(R.array.fam_size_7);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Do Nothing
            }
        });

        spinnerIncome.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        hideThirdRowContent();
                        break;
                    case 1:
                        feeLevel = 1;
                        tvFeeLevel.setText(String.valueOf(feeLevel));
                        showThirdRowContent();
                        break;
                    case 2:
                        feeLevel = 2;
                        tvFeeLevel.setText(String.valueOf(feeLevel));
                        showThirdRowContent();
                        break;
                    case 3:
                        feeLevel = 3;
                        tvFeeLevel.setText(String.valueOf(feeLevel));
                        showThirdRowContent();
                        break;
                    case 4:
                        feeLevel = 4;
                        tvFeeLevel.setText(String.valueOf(feeLevel));
                        showThirdRowContent();
                        break;
                    case 5:
                        feeLevel = 5;
                        tvFeeLevel.setText(String.valueOf(feeLevel));
                        showThirdRowContent();
                        break;
                    case 6:
                        feeLevel = 6;
                        tvFeeLevel.setText(String.valueOf(feeLevel));
                        showThirdRowContent();
                        break;
                    case 7:
                        feeLevel = 7;
                        tvFeeLevel.setText(String.valueOf(feeLevel));
                        showThirdRowContent();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Do Nothing
            }
        });
    }


    private void setUpSecondSpinner(Integer spinnerArray) {
        ArrayAdapter<CharSequence> spinnerTwoArray;
        spinnerTwoArray = ArrayAdapter.createFromResource(getActivity(), spinnerArray, R.layout.spinner_item_text_centered);
        spinnerTwoArray.setDropDownViewResource(R.layout.spinner_item_text_centered);
        spinnerIncome.setAdapter(spinnerTwoArray);
        showSecondSpinner();
    }

    private void showSecondSpinner() {
        hideAllViews();
        tvQuestionIncome.setEnabled(true);
        tvQuestionIncome.setVisibility(View.VISIBLE);
        tvQuestionIncome.setAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left));
        spinnerIncome.setEnabled(true);
        spinnerIncome.setVisibility(View.VISIBLE);
        spinnerIncome.setAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left));
    }

    private void hideThirdRowContent() {
        tvQuestionFeeLevel.setEnabled(false);
        tvQuestionFeeLevel.setVisibility(View.GONE);
        tvFeeLevel.setEnabled(false);
        tvFeeLevel.setVisibility(View.GONE);
        btnCalculateFees.setEnabled(false);
        btnCalculateFees.setVisibility(View.GONE);
    }

    private void showThirdRowContent() {
        hideThirdRowContent();
        tvQuestionFeeLevel.setEnabled(true);
        tvQuestionFeeLevel.setVisibility(View.VISIBLE);
        tvQuestionFeeLevel.setAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left));
        tvFeeLevel.setEnabled(true);
        tvFeeLevel.setVisibility(View.VISIBLE);
        tvFeeLevel.setAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left));
        btnCalculateFees.setEnabled(true);
        btnCalculateFees.setVisibility(View.VISIBLE);
        btnCalculateFees.setAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.slide_in_left));
    }

    private void hideAllViews() {
        tvQuestionIncome.setEnabled(false);
        tvQuestionIncome.setVisibility(View.GONE);
        spinnerIncome.setEnabled(false);
        spinnerIncome.setVisibility(View.GONE);
        tvQuestionFeeLevel.setEnabled(false);
        tvQuestionFeeLevel.setVisibility(View.GONE);
        tvFeeLevel.setEnabled(false);
        tvFeeLevel.setVisibility(View.GONE);
        btnCalculateFees.setEnabled(false);
        btnCalculateFees.setVisibility(View.GONE);
    }


}




