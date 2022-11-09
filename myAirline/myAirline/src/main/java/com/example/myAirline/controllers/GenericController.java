package com.example.myAirline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Thymeleaf Controller for pages that don't need much back end.
 */
@Controller
public class GenericController {
    
    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }
}