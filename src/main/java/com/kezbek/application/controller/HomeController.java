package com.kezbek.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping(value = "/home")
    public String homeController(){
        return "welcome to Home";
    }
}
