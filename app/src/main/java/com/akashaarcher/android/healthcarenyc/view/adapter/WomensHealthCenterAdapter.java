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

public class WomensHealthCenterAdapter extends RecyclerView.Adapter<WomensHealthCenterAdapter.WomensHealthCenterViewHolder> {

    List<WomensHealthFacility> healthFacilities = new ArrayList<>();

    public WomensHealthCenterAdapter() {
    }

    @NonNull
    @Override
    public WomensHealthCenterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.facility_result_layout, parent, false);
        WomensHealthCenterAdapter.WomensHealthCenterViewHolder vh = new WomensHealthCenterAdapter.WomensHealthCenterViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull WomensHealthCenterViewHolder holder, int position) {
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


    public class WomensHealthCenterViewHolder extends RecyclerView.ViewHolder {

        private TextView womensFacilityNameTv;
        private TextView womensFacilityAddressTv;
        private TextView womensFacilityPhoneTv;
        private TextView womensFacilityWebsiteTv;
        private ImageView womensFaveFacilityIv;
        private ImageView womensShareFacilityIv;


        public WomensHealthCenterViewHolder(View itemView) {
            super(itemView);

            womensFacilityNameTv = (TextView) itemView.findViewById(R.id.facility_name_local);
            womensFacilityAddressTv = (TextView) itemView.findViewById(R.id.facility_address_local);
            womensFacilityPhoneTv = (TextView) itemView.findViewById(R.id.facility_phone_local);
            womensFacilityWebsiteTv = (TextView) itemView.findViewById(R.id.facility_website_local);
            womensFaveFacilityIv = (ImageView) itemView.findViewById(R.id.search_favorite_button_local);
            womensShareFacilityIv = (ImageView) itemView.findViewById(R.id.search_share_button_local);
        }


        public void bind(WomensHealthFacility facility) {
            womensFacilityNameTv.setText(facility.getWomenHealthFacilityName());
            womensFacilityAddressTv.setText(facility.getWomenHealthFacilityAddress());
            womensFacilityPhoneTv.setText(facility.getWomenHealthFacilityPhone());
            womensFacilityWebsiteTv.setText(facility.getWomenHealthFacilityWebsite());
        }
    }
}
