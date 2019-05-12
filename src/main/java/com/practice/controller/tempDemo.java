package com.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tempDemo {
    @RequestMapping("/demo")
    public String index() {
        return "Hello World";
    }
}
