package com.practice.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempDemo {
    @RequestMapping("/demo")
    public String index() {
        return "Hello World";
    }
}
