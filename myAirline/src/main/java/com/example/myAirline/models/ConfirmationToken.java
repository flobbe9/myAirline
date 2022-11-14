package com.example.myAirline.models;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class ConfirmationToken {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String token = UUID.randomUUID().toString();

    @Column(nullable = false)
    private final LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime confirmedAt;

    @Column(nullable = false)
    private String appUserEmail;


    public ConfirmationToken(LocalDateTime expiresAt, 
                             String appUserEmail) {

        this.expiresAt = expiresAt;
        this.appUserEmail = appUserEmail;
    }


    @Override
    public boolean equals(Object obj) {

        if (obj != null && obj instanceof ConfirmationToken) 
            return this.token.equals(((ConfirmationToken)(obj)).getToken());

        
        
        return false;
    }
}