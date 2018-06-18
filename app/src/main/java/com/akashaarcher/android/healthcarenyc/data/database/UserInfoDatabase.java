package com.akashaarcher.android.healthcarenyc.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {UserEntity.class}, version = 1, exportSchema = false)
public abstract class UserInfoDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "UserInfoDatabase.db";
    private static volatile UserInfoDatabase instance;

    // Synchronization object >> to make sure 2 parts of the app don't try to create an instance of the db at the same time
    private static final Object LOCK = new Object();

    public abstract UserDao userDao();


    public static UserInfoDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                    UserInfoDatabase.class, DATABASE_NAME)
                    .build();
                }
            }
        }
        return instance;
    }
}
