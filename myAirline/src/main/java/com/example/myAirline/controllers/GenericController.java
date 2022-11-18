package com.example.myAirline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Thymeleaf Controller for pages that don't need much back end.
 * 
 * @since 1.0
 * @author Florin Schikarski
 */
@Controller
public class GenericController {
    
    @GetMapping("/")
    public String getIndexPage() {
        return "index";
    }
}