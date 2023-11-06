package com.jeanjuste.springmid24229.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/index")
    public String showHomePage(){
        return "index";
    }
}