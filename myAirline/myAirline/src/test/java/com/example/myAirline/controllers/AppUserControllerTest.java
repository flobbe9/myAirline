package com.example.myAirline.controllers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.myAirline.enums.AppUserRole;
import com.example.myAirline.models.AppUser;
import com.example.myAirline.services.AppUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


@SpringBootTest
@AutoConfigureMockMvc
public class AppUserControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppUserService appUserService;

    private AppUser appUser = new AppUser("florin.schikarski@gmail.com",
                                          "password",
                                          AppUserRole.USER,
                                          "Florin",
                                          "Schikarski", 
                                          LocalDate.of(2001, 02, 12));


    // TODO: does not work at the moment (some problem with GrantedAuthority)
    // @Test
    public void testAddNew() throws Exception {

        mockMvc.perform(post("/appUser/addNew")
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(objectToJson(appUser)))
               .andExpect(status().isOk())
               .andReturn();
    }


    // @Test
    public void testGetByUserName() throws Exception {

        mockMvc.perform(get("/appUser/getByUserName?userName=florin.schikarski@gmail.com"))
               .andExpect(status().isOk())
               .andReturn();
    }


////////


    private String objectToJson(Object obj) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        return objectMapper.writeValueAsString(obj);
    }
}