package com.akashaarcher.android.healthcarenyc.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akashaarcher.android.healthcarenyc.R;

import butterknife.ButterKnife;

public class FavoritesFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorites, container, false);

        return view;
    }

    public void onResume(){
        super.onResume();

        // Change title of Fragment
        ((MainActivity) getActivity())
                .setActionBarTitle(R.string.favorites_action_bar_title);
    }
}
