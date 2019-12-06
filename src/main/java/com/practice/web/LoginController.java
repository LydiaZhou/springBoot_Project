package com.practice.web;

import com.practice.model.Food;
import com.practice.service.FoodService;
import com.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/loginCheck")
    public ResponseEntity<Boolean> pageResult(@RequestBody @Valid LoginCommand loginCommand) {
        boolean loginIndicator = userService.userCheck(loginCommand);
        return ResponseEntity.ok(loginIndicator);
    }

//    // Check the user identity, login page
//    @RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
//    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
//        boolean loginIndicator = userService.userCheck(loginCommand.getUserName(), loginCommand.getPassword());
//        if (!loginIndicator) {
//            return new ModelAndView("login", "error", "Username or password error");
//        } else {
//            return new ModelAndView("main", "username", loginCommand.getUserName());
////            List<Food> fruits = foodService.getCategory(3);
////            ModelAndView model =  new ModelAndView("main");
////            model.addObject("fruits", fruits);
////            return model;
//        }
//    }

//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
}