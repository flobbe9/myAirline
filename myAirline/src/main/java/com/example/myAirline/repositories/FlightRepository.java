package com.example.myAirline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myAirline.models.Flight;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    
}