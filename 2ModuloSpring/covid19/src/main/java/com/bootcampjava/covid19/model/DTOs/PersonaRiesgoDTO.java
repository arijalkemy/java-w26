package com.bootcampjava.covid19.model.DTOs;

import com.bootcampjava.covid19.model.Persona;
import com.bootcampjava.covid19.model.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaRiesgoDTO implements Serializable {

    String nombreYApellido;


}
