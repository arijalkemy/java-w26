package com.EjercicioSpring.Ejercicio13_LinkTracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Link {

    @Id
    Integer linkId;
    String originalUrl;
    String maskedUrl;
    String password;
    int redirectCoutn;
    boolean isValid;

    public Link(Integer linkId, String originalUrl, String password) {
        this.linkId = linkId;
        this.originalUrl = originalUrl;
        this.password = password;
        this.isValid = true;
        this.maskedUrl = ".../link/" + linkId;
        redirectCoutn = 0;
    }

    public void increaseCounter() {
        this.redirectCoutn++;
    }
}
