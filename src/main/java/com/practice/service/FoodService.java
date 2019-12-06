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
//        try {
//            List<Food> foodList = foodDao.getCategory(category);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        List<Food> foodList = foodDao.getCategory(category);
        return foodList;
    }

    public List<Food> getAll() {
        return foodDao.getAll();
    }

    @Autowired
    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }
}
