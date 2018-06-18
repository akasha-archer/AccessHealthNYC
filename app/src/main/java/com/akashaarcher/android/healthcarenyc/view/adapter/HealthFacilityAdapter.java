package com.akashaarcher.android.healthcarenyc.view.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.akashaarcher.android.healthcarenyc.R;
import com.akashaarcher.android.healthcarenyc.model.HealthFacility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akashaarcher on 4/5/18.
 */

public class HealthFacilityAdapter extends RecyclerView.Adapter<HealthFacilityAdapter.HealthCenterViewHolder> {

    List<HealthFacility> healthFacilities = new ArrayList<>();

    public HealthFacilityAdapter() {
    }

    @NonNull
    @Override
    public HealthCenterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.facility_result_layout, parent, false);
        HealthCenterViewHolder vh = new HealthCenterViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull HealthCenterViewHolder holder, int position) {
        HealthFacility facility = healthFacilities.get(position);
        holder.bind(facility);
    }


    @Override
    public int getItemCount() {
        return healthFacilities.size();
    }

    public void setData(List<HealthFacility> listResults) {
        this.healthFacilities = listResults;
        notifyDataSetChanged();
    }


    public class HealthCenterViewHolder extends RecyclerView.ViewHolder {

        private TextView healthFacilityNameTv;
        private TextView healthFacilityAddressTv;
        private TextView healthFacilityPhoneTv;
        private TextView healthFacilityWebsiteTv;
        private ImageView healthFaveFacilityIv;
        private ImageView healthShareFacilityIv;


        public HealthCenterViewHolder(View itemView) {
            super(itemView);

            healthFacilityNameTv = (TextView) itemView.findViewById(R.id.facility_name_local);
            healthFacilityAddressTv = (TextView) itemView.findViewById(R.id.facility_address_local);
            healthFacilityPhoneTv = (TextView) itemView.findViewById(R.id.facility_phone_local);
            healthFacilityWebsiteTv = (TextView) itemView.findViewById(R.id.facility_website_local);
            healthFaveFacilityIv = (ImageView) itemView.findViewById(R.id.search_favorite_button_local);
            healthShareFacilityIv = (ImageView) itemView.findViewById(R.id.search_share_button_local);
        }


        public void bind(final HealthFacility facility) {
            healthFacilityNameTv.setText(facility.getHealthFacilityName());
            healthFacilityAddressTv.setText(facility.getHealthFacilityAddress());
            healthFacilityPhoneTv.setText(facility.getHealthFacilityPhone());
            healthFacilityWebsiteTv.setText(facility.getHealthFacilityWebsite());

            healthFaveFacilityIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // add to favorites
                    Toast.makeText(view.getContext(), facility.getHealthFacilityName() + " has been added to your favorites.", Toast.LENGTH_SHORT).show();
                }
            });

            healthShareFacilityIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Sharing facility info via appropriate application on user's phone
                    String location = view.getResources().getString(facility.getHealthFacilityAddress());
                    String phoneNum = view.getResources().getString(facility.getHealthFacilityPhone());
                    String websiteurl = view.getResources().getString(facility.getHealthFacilityWebsite());

                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "Check out this health clinic location: " + facility.getHealthFacilityName() + ". "
                            + location + ". " + "Phone number: " + phoneNum + " and website: " + websiteurl);
                    sendIntent.setType("text/plain");
                    view.getContext().startActivity(sendIntent);
                }
            });

        }
    }
}
