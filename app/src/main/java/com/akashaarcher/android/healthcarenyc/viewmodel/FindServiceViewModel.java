package com.akashaarcher.android.healthcarenyc.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.akashaarcher.android.healthcarenyc.data.database.UserEntity;
import com.akashaarcher.android.healthcarenyc.data.database.UserRepository;


public class FindServiceViewModel extends AndroidViewModel {

    public LiveData<UserEntity> users;
    private UserRepository repository;


    public FindServiceViewModel(@NonNull Application application) {
        super(application);
        repository = UserRepository.getInstance(application.getApplicationContext());
        users = repository.userName;
    }

    public String getUserInput() {
       return repository.getUser().toString();
    }

}
