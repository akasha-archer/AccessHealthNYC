package com.akashaarcher.android.healthcarenyc.data.database;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertNewUser(UserEntity user);

    @Delete
    void deleteUser(UserEntity user);

    @Query("SELECT user_name FROM user_info")
    LiveData <UserEntity> getUserName();

}
