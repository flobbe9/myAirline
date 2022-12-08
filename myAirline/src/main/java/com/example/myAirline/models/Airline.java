package com.example.myAirline.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Class defining an airline.
 * 
 * @since 1.0
 * @author Florin Schikarski
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Airline {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @EqualsAndHashCode.Exclude
     private Long id;
    
     @Column(nullable = false)
     private String name;  
     

     public Airline(String name) {

          this.name = name;
     }


     @Override
     public String toString() {

          return this.name;
     }
}