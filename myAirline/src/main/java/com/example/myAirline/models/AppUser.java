package com.example.myAirline.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.myAirline.enums.AppUserRole;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class AppUser implements UserDetails {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) 
    private AppUserRole role;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private LocalDate birthday;

    private Integer age;

    // private List<Booking> bookings; // TODO: uncomment when Booking is created

    private Boolean isAccountNonExpired = true;

    private Boolean isAccountNonLocked = true;

    private Boolean isCredentialsNonExpired = true;

    private Boolean isEnabled = false;


    public AppUser(String email, 
                   String password, 
                   AppUserRole role,
                   String firstName, 
                   String lastName, 
                   LocalDate birthday) {

        this.email = email;
        this.password = password;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.age = calculateAge();
    }
    
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return this.role.getGrantedAuthorities();
    }


    @Override
    public String getUsername() {

        return this.email;
    }


    @Override
    public boolean isAccountNonExpired() {

        return this.isAccountNonExpired;
    }


    @Override
    public boolean isAccountNonLocked() {

        return this.isAccountNonLocked;
    }


    @Override
    public boolean isCredentialsNonExpired() {

        return this.isCredentialsNonExpired;
    }

    
    @Override
    public boolean isEnabled() {

        return this.isEnabled;
    }


    @Override
    public String toString() {

        return this.email;
    }


    @Override
    public boolean equals(Object obj) {

        if (this == obj) 
            return true;

        if (obj != null && obj instanceof AppUser) 
            return this.email.equals(((AppUser)(obj)).getEmail());

        return false;
    }
    
    
    public int calculateAge() {

        return (int) birthday.until(LocalDate.now(), ChronoUnit.YEARS);
    }
}