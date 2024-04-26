package com.Ejercicio.Edades.Service;

import org.springframework.stereotype.Component;

@Component
public interface BirthToAge {
    Integer birthToAge(Integer day, Integer month , Integer year);
}
