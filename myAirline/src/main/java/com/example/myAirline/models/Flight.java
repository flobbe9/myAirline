package com.example.myAirline.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Class defining a flight.
 * 
 * @since 1.0
 * @author Florin Schikasrki
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Flight {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(nullable = false) // TODO: number must be unique, maybe auto generate with hibernate...
    private Integer number;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "plane_id")
    private Plane plane;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "flights")
    private List<Airport> airports;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    @Column(nullable = false)
    private LocalDateTime localDepartureTime;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    @Column(nullable = false)
    private LocalDateTime localLandingTime;

    /** In minutes */
    @Column(nullable = false)
    private Double duration; // TODO: set this one by method, consider the time zones of the airports, 2 digits after comma

    @Column(nullable = false)
    private Integer gate;

    
    @Override
    public String toString() {
        
        return "Flight " + this.number + " from " /* departureAirport name */ + " to " + /* destinationAirport name */ ".";
    }
}