package com.example.myAirline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myAirline.models.AppUser;
import com.example.myAirline.services.AppUserService;


@RestController
@RequestMapping("/appUser")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    
    @PostMapping("/addNew")
    public AppUser addNew(@RequestBody AppUser appUser) {
        return appUserService.addNew(appUser);
    }


    @GetMapping("/getByUserName") 
    public AppUser getByUserName(@RequestParam("userName") String userName) {
        return appUserService.getByEmail(userName);
    }
}