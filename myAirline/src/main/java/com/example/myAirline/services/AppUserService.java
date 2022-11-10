package com.example.myAirline.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.myAirline.models.AppUser;
import com.example.myAirline.repositories.AppUserRepository;


@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public AppUser addNew(AppUser appUser) {

        validate(appUser);

        if (exists(appUser)) 
            throw new IllegalStateException("User with email " + appUser.getEmail() + " does already exist.");

        appUser.setAge(appUser.calculateAge());

        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));

        // TODO: send confirmation email

        return appUserRepository.save(appUser);
    }


    public AppUser getByEmail(String email) {

        return appUserRepository.findByEmail(email).orElseThrow(() -> 
            new IllegalStateException("Could not find user: " + email));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        return appUserRepository.findByEmail(username).orElseThrow(() -> 
            new UsernameNotFoundException("Could not find user: " + username));
    }


/////////


    /**
     * Checks some attributes of an AppUser.
     *  
     * @param appUser to check.
     * @return true if all attributes are valid.
     * @throws IllegalStateException if one attribute is not valid.
     */
    private boolean validate(AppUser appUser) {

        if (appUser.getBirthday().isAfter(LocalDate.now()))
            throw new IllegalStateException("Birthday cannot be in the future.");

        return true;
    }


    private boolean exists(AppUser appUser) {

        return appUserRepository.existsByEmail(appUser.getEmail());
    }
}