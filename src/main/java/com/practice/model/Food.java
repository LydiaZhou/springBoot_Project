package com.practice.model;

import java.io.Serializable;

public class Food implements Serializable {
    private long id;
    private String foodName;
    private int calories;
    private int category;
    private String img;

    public Food() {
    }

    public Food(long id, String foodName, int calories, int category, String img) {
        this.id = id;
        this.foodName = foodName;
        this.calories = calories;
        this.category = category;
        this.img = img;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
