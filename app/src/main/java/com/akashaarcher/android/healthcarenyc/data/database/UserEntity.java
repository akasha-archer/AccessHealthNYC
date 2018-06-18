package com.akashaarcher.android.healthcarenyc.data.database;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity (tableName = "user_info")
public class UserEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "user_name")
    private String name;

    @Ignore
    @ColumnInfo(name = "user_income")
    private String income;

    @Ignore
    @ColumnInfo(name = "user_family_size")
    private String familySize;

    @Ignore
    public UserEntity(String name, String income, String familySize) {
        this.name = name;
        this.income = income;
        this.familySize = familySize;
    }

    public UserEntity(@NonNull String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getFamilySize() {
        return familySize;
    }

    public void setFamilySize(String familySize) {
        this.familySize = familySize;
    }
}
