package com.example.myAirline.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.myAirline.enums.AppUserRole;
import com.example.myAirline.models.AppUser;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(OrderAnnotation.class)
public class AppUserServiceTest {
    
    @Autowired
    private AppUserService appUserService;

    private AppUser appUser = new AppUser("florin.schikarski@gmail.com",
                                          "password",
                                          AppUserRole.USER,
                                          "Florin",
                                          "Schaikarski",
                                          LocalDate.of(2001, 02, 12));


    @Test
    @Order(1)
    void testAddNew() {

        AppUser addedAppUser = appUserService.addNew(appUser);

        assertEquals(appUser, addedAppUser);

        assertEquals(21, addedAppUser.getAge());

        assertNotEquals("password", addedAppUser.getPassword());

        assertThrows(IllegalStateException.class, () -> appUserService.addNew(appUser));
    }


    @Test
    void testGetByEmail() {

        assertEquals(appUser, appUserService.getByEmail("florin.schikarski@gmail.com"));
    }
}