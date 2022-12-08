package com.example.myAirline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myAirline.models.Country;


@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    
}