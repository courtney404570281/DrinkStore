package com.courtney.drinkstore;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DrinkViewHolder extends RecyclerView.ViewHolder {

    private final TextView brandText;
    private final TextView areaText;
    private final TextView storeText;

    public DrinkViewHolder(@NonNull View itemView) {
        super(itemView);
        brandText = itemView.findViewById(R.id.txt_brand);
        areaText = itemView.findViewById(R.id.txt_area);
        storeText = itemView.findViewById(R.id.txt_store);
    }

    public void bindTo(Drink drink) {
        brandText.setText(drink.brandName);
        areaText.setText(drink.area);
        storeText.setText(drink.storeName);
    }
}
