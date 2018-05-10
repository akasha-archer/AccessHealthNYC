package com.akashaarcher.android.healthcarenyc.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.akashaarcher.android.healthcarenyc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by akashaarcher on 4/4/18.
 */

public class UserInfoFragment extends Fragment {

    @BindView(R.id.edit_family_size)
    EditText familySizeEt;

    @BindView(R.id.edit_family_income)
    EditText familyIncomeEt;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_pager_user_info, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
