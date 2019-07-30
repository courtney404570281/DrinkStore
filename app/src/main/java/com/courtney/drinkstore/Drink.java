package com.courtney.drinkstore;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Drink {
    @NonNull
    String brandName;
    @NonNull
    String area;
    @NonNull
    String storeName;
    @NonNull
    @PrimaryKey
    String phone;

    public Drink(@NonNull String brandName, @NonNull String area, @NonNull String storeName, @NonNull String phone) {
        this.brandName = brandName;
        this.area = area;
        this.storeName = storeName;
        this.phone = phone;
    }

    @NonNull
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(@NonNull String brandName) {
        this.brandName = brandName;
    }

    @NonNull
    public String getArea() {
        return area;
    }

    public void setArea(@NonNull String area) {
        this.area = area;
    }

    @NonNull
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(@NonNull String storeName) {
        this.storeName = storeName;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    public void setPhone(@NonNull String phone) {
        this.phone = phone;
    }
}
