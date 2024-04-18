package com.EjercicioSpring.Ejercicio13_LinkTracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkResponseDTO implements Serializable {

    Integer linkId;
    String originalUrl;
    String maskedUrl;
    int redirectCoutn;
    boolean isValid;

    public LinkResponseDTO(Integer linkId, String originalUrl, String maskedUrl, int redirectCoutn, boolean isValid) {
        this.linkId = linkId;
        this.originalUrl = originalUrl;
        this.maskedUrl = maskedUrl;
        this.redirectCoutn = redirectCoutn;
        this.isValid = isValid;
    }
}
