package com.practice.web;

import com.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
    private UserService userService;

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
            // login successfully, re-direct to the main page
            return new ModelAndView("main");
        }
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
