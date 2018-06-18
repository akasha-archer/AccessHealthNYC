package com.akashaarcher.android.healthcarenyc.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.akashaarcher.android.healthcarenyc.data.network.HhcClient;
import com.akashaarcher.android.healthcarenyc.model.HhcFacility;
import com.akashaarcher.android.healthcarenyc.model.HhcFeeLevelCosts;

import java.util.List;

import retrofit2.Call;

public class MedicalServicesCostViewModel extends ViewModel {

    private HhcClient client;

    public MedicalServicesCostViewModel (HhcClient client) {
        this.client = client;
    }

    public Call<List<HhcFeeLevelCosts>> getHhcServicesCost() {
        return client.getHhcService().getServiceCosts();
    }

}
