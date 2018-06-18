package com.akashaarcher.android.healthcarenyc.data.database;


import android.arch.lifecycle.LiveData;
import android.content.Context;

import java.util.List;

public class UserRepository {

    private static UserRepository instance;
    public LiveData<UserEntity> userName;
    private UserInfoDatabase db;

    public UserRepository(Context context) {
        db = UserInfoDatabase.getInstance(context);
    }

    public static UserRepository getInstance(Context context) {
        if (instance == null) {
            instance = new UserRepository(context);
        }
        return instance;
    }

    public LiveData <UserEntity> getUser() {
        return db.userDao().getUserName();
    }

}
