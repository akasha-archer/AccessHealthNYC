package com.akashaarcher.android.healthcarenyc.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.akashaarcher.android.healthcarenyc.R;
import com.akashaarcher.android.healthcarenyc.model.HhcFacility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akashaarcher on 4/5/18.
 */

public class HhcFacilityAdapter extends RecyclerView.Adapter<HhcFacilityAdapter.HhcFacilityViewHolder> {

    List<HhcFacility> hhcFacilities = new ArrayList<>();

    public HhcFacilityAdapter() {
    }

    @NonNull
    @Override
    public HhcFacilityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hhc_result_layout, parent, false);
        HhcFacilityViewHolder vh = new HhcFacilityViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull HhcFacilityAdapter.HhcFacilityViewHolder holder, int position) {
        HhcFacility facility = hhcFacilities.get(position);
        holder.bind(facility);
    }

    @Override
    public int getItemCount() {
        return hhcFacilities.size();
    }

    public void setData(List<HhcFacility> listResults) {
        this.hhcFacilities = listResults;
        notifyDataSetChanged();
    }


    public class HhcFacilityViewHolder extends RecyclerView.ViewHolder {

        private TextView hhcFacilityname;
        private TextView hhcFacilityStreet;
        private TextView hhcFacilityCity;
        private TextView hhcFacilityState;
        private TextView hhcFacilityZip;
        private ImageView hhcFaveFacilityIv;
        private ImageView hhcShareFacilityIv;


        public HhcFacilityViewHolder(View itemView) {
            super(itemView);

            hhcFacilityname = (TextView) itemView.findViewById(R.id.hhc_facility_name);
            hhcFacilityStreet = (TextView) itemView.findViewById(R.id.hhc_street);
            hhcFacilityCity = (TextView) itemView.findViewById(R.id.hhc_city);
            hhcFacilityState = (TextView) itemView.findViewById(R.id.hhc_state);
            hhcFacilityZip = (TextView) itemView.findViewById(R.id.hhc_zip);
            hhcFaveFacilityIv = (ImageView) itemView.findViewById(R.id.search_favorite_button);
            hhcShareFacilityIv = (ImageView) itemView.findViewById(R.id.search_share_button);
        }


        public void bind(HhcFacility facility) {
            hhcFacilityname.setText(facility.getFacilityName());
            hhcFacilityStreet.setText(facility.getLocation1Address());
            hhcFacilityCity.setText(facility.getLocation1City());
            hhcFacilityState.setText(facility.getLocation1State());
            hhcFacilityZip.setText(facility.getLocation1Zip());
        }
    }
}
