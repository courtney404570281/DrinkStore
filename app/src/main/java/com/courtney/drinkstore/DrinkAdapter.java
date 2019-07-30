package com.courtney.drinkstore;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkViewHolder> {

    List<Drink> drinks;

    public DrinkAdapter(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    @NonNull
    @Override
    public DrinkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DrinkViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_ice, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkViewHolder holder, int position) {
        Drink d = drinks.get(position);
        if (d != null) {
            holder.bindTo(d);
        }
    }

    @Override
    public int getItemCount() {
        return (drinks == null) ? 0 : drinks.size();
    }
}
