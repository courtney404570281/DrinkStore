package com.courtney.drinkstore;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DrinkViewModel extends AndroidViewModel {

    LiveData<List<Drink>> drinkLiveData;

    public DrinkViewModel(@NonNull Application application) {
        super(application);
        drinkLiveData = DrinkDatabase.getInstance(application.getApplicationContext()).drinkDao().getDrinks();
    }

    public LiveData<List<Drink>> getDrinks() {
        return drinkLiveData;
    }
}
