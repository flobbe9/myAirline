package com.example.myAirline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myAirline.models.Plane;


@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
    
}