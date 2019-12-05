package com.practice.web;

import com.practice.model.Food;
import com.practice.service.FoodService;
import com.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {
    private UserService userService;
    private FoodService foodService;

    // Re-direct user to the login page first
    @RequestMapping(value = {"/", "/index.html"})
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    // Check the user identity, login page
//    @RequestMapping(value = {"/login", "/loginCheck.html"})
    @RequestMapping(value = "/loginCheck.html")
//    public ModelAndView loginCheck(@RequestParam("username") String username,@RequestParam("userpassword") String userpassword) {
    public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
        boolean loginIndicator = userService.userCheck(loginCommand.getUserName(), loginCommand.getPassword());

        if (!loginIndicator) {
            return new ModelAndView("login", "error", "Username or password error");
        } else {
            // login successfully, re-direct to the main page with foods show
//            List<Food> meats = foodService.getCategory(1);
//            List<Food> vegetables = foodService.getCategory(2);
//            int tmp = userService.getMatchCount("admin", "admin");
//            Food a = foodService.getFood(1);
//            Food a = new Food(1, "Bana", 3, 3, "AAA");
//            List<Food> fruits = new ArrayList<>();
//            fruits.add(a);
//            List<Food> fruits = new ArrayList<>();
            List<Food> fruits = foodService.getCategory(3);

//            List<Food> others = foodService.getCategory(4);

            ModelAndView model =  new ModelAndView("main");
            model.addObject("fruits", fruits);
            return model;
        }
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserService(FoodService foodService) {
        this.foodService = foodService;
    }
}
