package com.example.myAirline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.myAirline.models.AppUser;
import com.example.myAirline.repositories.AppUserRepository;


@Service
public class AppUserService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;


    public AppUser addNew(AppUser appUser) {
        return save(appUser);
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

    
    private AppUser save(AppUser appUser) {
        return appUserRepository.save(appUser);
    }
}