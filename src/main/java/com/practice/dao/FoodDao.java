package com.practice.dao;

import com.practice.model.Food;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FoodDao {
    final static Logger logger = Logger.getLogger(FoodDao.class);
    private JdbcTemplate jdbcTemplate;
    private final static String foodgetIdQuery = "SELECT * FROM t_food WHERE id =?";
    private final static String foodgetCatQuery = "SELECT * FROM t_food WHERE category=?";

    public Food getFood(int id) {
        Food obj = new Food();
        jdbcTemplate.query(foodgetIdQuery,new Object[]{id},
        new RowCallbackHandler() {
            public void processRow(ResultSet row) throws SQLException {
                obj.setId(((Integer) row.getInt("id")).intValue());
                obj.setFoodName((String) row.getString("name"));
                obj.setCalories(((Integer) row.getInt("calories")).intValue());
                obj.setCategory(((Integer) row.getInt("category")).intValue());
                obj.setImg((String) row.getString("img"));
            }
        });
        return obj;
    }
//    public Food getFood(int id) {
//        return jdbcTemplate.queryForObject(foodgetIdQuery, new Object[]{id}, (rs, rowNum) ->
//            new Food(
//                    rs.getInt("id"),
//                    rs.getString("name"),
//                    rs.getInt("calories"),
//                    rs.getInt("category"),
//                    rs.getString("img")
//            ));
//    }

    public List<Food> getCategory(int category) {
        List<Food> foods = new ArrayList<>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(foodgetCatQuery, category);

        for (Map row : rows) {
            Food obj = new Food();

            obj.setId(((Integer) row.get("id")).intValue());
            obj.setFoodName((String) row.get("name"));
            obj.setCalories(((Integer) row.get("calories")).intValue());
            obj.setCategory(((Integer) row.get("category")).intValue());
            obj.setImg((String) row.get("img"));
            foods.add(obj);
        }

        logger.info(rows);

        return foods;
//        return jdbcTemplate.query(
//            foodgetCatQuery,
//            new Object[]{category},
//            (rs, rowNum) ->
//                    (new Food(
//                    rs.getInt("id"),
//                    rs.getString("name"),
//                    rs.getInt("calories"),
//                    rs.getInt("category"),
//                    rs.getString("img")
//                )
//            )
//        );
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}


