package com.EjercicioSpring.Ejercicio13_LinkTracker.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkIdResponseDTO implements Serializable {

    Integer linkId;
    String maskedUrl;

}
