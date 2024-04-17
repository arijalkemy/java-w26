package com.bootcampjava.covid19.model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SintomaDTO implements Serializable {
    String nombre;
    String nivelDeGravedad;
}
