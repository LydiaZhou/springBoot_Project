package com.practice.service;

import com.practice.dao.FoodDao;
import com.practice.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FoodService {
    private FoodDao foodDao;

    public Food getFood(int id) {
        return foodDao.getFood(id);
    }

    public List<Food> getCategory(int category) {
        Food a = new Food(10, "Bana", 3, 3, "AAA");
        List<Food> foodList = new ArrayList<>();
        foodList.add(a);
        try {
            foodList = foodDao.getCategory(category);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        Map<Integer, Food> foodMap = new HashMap<Integer, Food>();
//        for (Food f: foodList) {
//            foodMap.put(f.getCategory(), f);
//        }
//        return foodMap;
        return foodList;
    }

    @Autowired
    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }
}
