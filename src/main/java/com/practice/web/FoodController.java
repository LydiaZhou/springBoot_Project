package com.practice.web;

import com.practice.model.Food;
import com.practice.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/main")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Food>> pageResult() {
        return ResponseEntity.ok(foodService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Food>> pageResult(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(foodService.getCategory(id));
    }

//    @Autowired
//    public void setUserService(FoodService foodService) {
//        this.foodService = foodService;
//    }
}
