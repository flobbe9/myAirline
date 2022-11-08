package com.example.myAirline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GenericController {
    
    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }
}