package com.akashaarcher.android.healthcarenyc.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.akashaarcher.android.healthcarenyc.R;
import com.akashaarcher.android.healthcarenyc.model.HhcFacility;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akashaarcher on 4/5/18.
 */

public class HhcFacilityAdapter extends RecyclerView.Adapter<HhcFacilityAdapter.HhcFacilityViewHolder> {

    Context context;
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


        public void bind(final HhcFacility facility) {
            hhcFacilityname.setText(facility.getFacilityName());
            hhcFacilityStreet.setText(facility.getLocation1Address());
            hhcFacilityCity.setText(facility.getLocation1City());
            hhcFacilityState.setText(facility.getLocation1State());
            hhcFacilityZip.setText(facility.getLocation1Zip());

            hhcFaveFacilityIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // add to favorites
                    Toast.makeText(view.getContext(), facility.getFacilityName() + " has been added to your favorites.", Toast.LENGTH_SHORT).show();
                }
            });

            hhcShareFacilityIv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Sharing facility info via appropriate application on user's phone
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "Check out this hospital location: " + facility.getFacilityName() + ". "
                            + facility.getLocation1Address()  + facility.getLocation1City()
                            + facility.getLocation1State() + facility.getLocation1Zip());
                    sendIntent.setType("text/plain");
                    view.getContext().startActivity(sendIntent);
                }
            });

        }

    }
}
