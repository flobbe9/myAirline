package com.example.myAirline.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.myAirline.enums.AppUserRole;
import com.example.myAirline.models.AppUser;


@SpringBootTest
@AutoConfigureMockMvc
public class AppUserServiceTest {
    
    @Autowired
    private AppUserService appUserService;

    private AppUser appUser = new AppUser("florin.schikarski@gmail.com",
                                          "password",
                                          AppUserRole.USER,
                                          "Florin",
                                          "Schikarski",
                                          LocalDate.of(2001, 02, 12));

                                          private AppUser appUser2 = new AppUser("florin.schikarski@gmail.com",
                                          "password",
                                          AppUserRole.USER,
                                          "Florin",
                                          "Schikarski",
                                          LocalDate.of(2001, 02, 12));

    private AppUser returnedAppUser;


    @Test
    void testAddNew() {

        returnedAppUser = appUserService.addNew(appUser);

        assertEquals(appUser, returnedAppUser);
    }


    @Test
    void testGetByEmail() {

        appUserService.addNew(appUser);

        assertEquals(appUser, appUserService.getByEmail("florin.schikarski@gmail.com"));
    }
}