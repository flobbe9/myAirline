package com.example.myAirline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myAirline.models.Airline;


@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
    
}