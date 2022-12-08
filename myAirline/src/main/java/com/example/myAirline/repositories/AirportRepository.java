package com.example.myAirline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myAirline.models.Airport;


@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
    
}