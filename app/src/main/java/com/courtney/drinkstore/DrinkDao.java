package com.courtney.drinkstore;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DrinkDao {
    @Query("SELECT * FROM drink")
    LiveData<List<Drink>> getDrinks();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Drink drink);

    @Delete
    void delete(Drink drink);
}
