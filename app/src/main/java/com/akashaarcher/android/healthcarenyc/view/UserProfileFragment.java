package com.akashaarcher.android.healthcarenyc.view;

import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.akashaarcher.android.healthcarenyc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by akashaarcher on 4/7/18.
 */

public class UserProfileFragment extends Fragment implements View.OnClickListener {

    @BindView(R.id.profile_user_greeting)
    TextView profileUserGreetingTv;

    @BindView(R.id.edit_profile_btn)
    Button editProfileBtn;

    @BindView(R.id.approve_profile_edit)
    ImageView approveProfileChangesIv;

    @BindView(R.id.cancel_profile_edit)
    ImageView cancelProfileChangesIv;

    @BindView(R.id.profile_name_edit)
    EditText profileNameEt;

    @BindView(R.id.profile_income_edit)
    EditText familyIncomeEt;

    @BindView(R.id.profile_family_size_edit)
    EditText familySizeEt;

    @BindView(R.id.profile_name_set)
    TextView profileNameValueTv;

    @BindView(R.id.profile_income_set)
    TextView familyIncomeValueTv;

    @BindView(R.id.profile_family_size_set)
    TextView familySizeValueTv;

    private Unbinder unbinder;

    private String displayName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        unbinder = ButterKnife.bind(this, view);

        setListeners();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    private void setListeners() {
        editProfileBtn.setOnClickListener(this);
        approveProfileChangesIv.setOnClickListener(this);
        cancelProfileChangesIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.edit_profile_btn:
                editProfileBtn.setVisibility(View.INVISIBLE);
                approveProfileChangesIv.setVisibility(View.VISIBLE);
                cancelProfileChangesIv.setVisibility(View.VISIBLE);

                profileNameValueTv.setVisibility(View.INVISIBLE);
                profileNameEt.setVisibility(View.VISIBLE);
                familyIncomeValueTv.setVisibility(View.INVISIBLE);
                familyIncomeEt.setVisibility(View.VISIBLE);
                familySizeValueTv.setVisibility(View.INVISIBLE);
                familySizeEt.setVisibility(View.VISIBLE);
                break;

            case R.id.approve_profile_edit:
                editProfileBtn.setVisibility(View.VISIBLE);
                approveProfileChangesIv.setVisibility(View.INVISIBLE);
                cancelProfileChangesIv.setVisibility(View.INVISIBLE);

                displayName = profileNameEt.getText().toString();
                profileNameEt.setVisibility(View.INVISIBLE);
                profileNameValueTv.setText(displayName);
                profileNameValueTv.setVisibility(View.VISIBLE);

                familyIncomeValueTv.setText(null);
                familyIncomeValueTv.setVisibility(View.VISIBLE);
                familyIncomeEt.setVisibility(View.INVISIBLE);

                familySizeValueTv.setText(null);
                familySizeValueTv.setVisibility(View.VISIBLE);
                familySizeEt.setVisibility(View.INVISIBLE);

                profileUserGreetingTv.setText("Hello " + displayName);
                break;

            case R.id.cancel_profile_edit:
                editProfileBtn.setVisibility(View.VISIBLE);
                approveProfileChangesIv.setVisibility(View.INVISIBLE);
                cancelProfileChangesIv.setVisibility(View.INVISIBLE);

                profileNameValueTv.setVisibility(View.VISIBLE);
                profileNameEt.setVisibility(View.INVISIBLE);
                familyIncomeValueTv.setVisibility(View.VISIBLE);
                familyIncomeEt.setVisibility(View.INVISIBLE);
                familySizeValueTv.setVisibility(View.VISIBLE);
                familySizeEt.setVisibility(View.INVISIBLE);
                break;
        }
    }

}
