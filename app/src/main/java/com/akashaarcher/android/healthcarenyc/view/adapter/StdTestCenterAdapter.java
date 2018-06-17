package com.akashaarcher.android.healthcarenyc.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.akashaarcher.android.healthcarenyc.R;
import com.akashaarcher.android.healthcarenyc.model.WomensHealthFacility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akashaarcher on 4/5/18.
 */

public class StdTestCenterAdapter extends RecyclerView.Adapter<StdTestCenterAdapter.StdTestCenterViewHolder> {

    List<WomensHealthFacility> healthFacilities = new ArrayList<>();

    public StdTestCenterAdapter() {
    }

    @NonNull
    @Override
    public StdTestCenterAdapter.StdTestCenterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.facility_result_layout, parent, false);
        StdTestCenterAdapter.StdTestCenterViewHolder vh = new StdTestCenterAdapter.StdTestCenterViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull StdTestCenterAdapter.StdTestCenterViewHolder holder, int position) {
        WomensHealthFacility facility = healthFacilities.get(position);
        holder.bind(facility);
    }


    @Override
    public int getItemCount() {
        return healthFacilities.size();
    }

    public void setData(List<WomensHealthFacility> listResults) {
        this.healthFacilities = listResults;
        notifyDataSetChanged();
    }


    public class StdTestCenterViewHolder extends RecyclerView.ViewHolder {

        private TextView stdFacilityNameTv;
        private TextView stdFacilityAddressTv;
        private TextView stdFacilityPhoneTv;
        private TextView stdFacilityWebsiteTv;
        private ImageView stdFaveFacilityIv;
        private ImageView stdShareFacilityIv;


        public StdTestCenterViewHolder(View itemView) {
            super(itemView);

            stdFacilityNameTv = (TextView) itemView.findViewById(R.id.facility_name_local);
            stdFacilityAddressTv = (TextView) itemView.findViewById(R.id.facility_address_local);
            stdFacilityPhoneTv = (TextView) itemView.findViewById(R.id.facility_phone_local);
            stdFacilityWebsiteTv = (TextView) itemView.findViewById(R.id.facility_website_local);
            stdFaveFacilityIv = (ImageView) itemView.findViewById(R.id.search_favorite_button_local);
            stdShareFacilityIv = (ImageView) itemView.findViewById(R.id.search_share_button_local);
        }


        public void bind(WomensHealthFacility facility) {
            stdFacilityNameTv.setText(facility.getHealthFacilityName());
            stdFacilityAddressTv.setText(facility.getHealthFacilityAddress());
            stdFacilityPhoneTv.setText(facility.getHealthFacilityPhone());
            stdFacilityWebsiteTv.setText(facility.getHealthFacilityWebsite());
        }
    }

}
