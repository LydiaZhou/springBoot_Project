package com.practice.dao;

import com.practice.model.Food;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private Map<Food, Integer> items = new HashMap<Food, Integer>();

    public ShoppingCart() {}

    public Map<Food, Integer> getItems() {
        return items;
    }

    public Integer checkOut(){
        Integer totalCalories = 0;
        for (Map.Entry<Food, Integer> entry : items.entrySet()) {
            totalCalories += entry.getKey().getCalories() * entry.getValue();
        }
        return totalCalories;
    }

    public Integer addItem(Food f) {
        if (items.containsKey(f)){
            items.put(f, items.get(f) + 1);
        } else {
            items.put(f, 1);
        }
        return items.get(f);
    }

    public Integer minusItem(Food f) {
        if (items.get(f) > 1) {
            items.put(f, items.get(f) - 1);
        }
        return items.get(f);
    }

    public void deleteItem(Food f) {
        items.remove(f);
    }
}
