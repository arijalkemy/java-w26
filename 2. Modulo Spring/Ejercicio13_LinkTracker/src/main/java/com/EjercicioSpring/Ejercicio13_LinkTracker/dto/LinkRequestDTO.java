package com.EjercicioSpring.Ejercicio13_LinkTracker.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LinkRequestDTO implements Serializable {

    String url;
    String password;

}
