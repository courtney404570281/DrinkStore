package com.courtney.drinkstore;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Database(entities = Drink.class, version = 1)
public abstract class DrinkDatabase extends RoomDatabase {
    public abstract DrinkDao drinkDao();
    public static DrinkDatabase instance = null;

    public static DrinkDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, DrinkDatabase.class, "drink-database")
                    .addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);
                        }
                    })
                    .build();
            fillDataFromJson(instance.drinkDao(), context);
        }
        return instance;
    }

    private static void fillDataFromJson(DrinkDao drinkDao, Context context) {
        InputStream is = context.getResources().openRawResource(R.raw.ice);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder builder = new StringBuilder();
        String line;

        try {
            while ( (line = reader.readLine()) != null) {
                builder.append(line);
            }

            JSONArray array = new JSONArray(builder.toString());
            for (int i = 0; i < array.length(); i++) {
                JSONObject d = array.getJSONObject(i);
                Drink drink = new Drink(d.getString("BrandName"),
                        d.getString("Area"),
                        d.getString("StoreName"),
                        d.getString("Phone"));
                new Thread(() -> drinkDao.insert(drink)).start();
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }


    }
}
