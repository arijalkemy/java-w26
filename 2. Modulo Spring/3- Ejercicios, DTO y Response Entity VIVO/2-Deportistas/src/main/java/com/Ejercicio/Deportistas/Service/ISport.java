package com.Ejercicio.Deportistas.Service;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface Sport {
    List<Sport> getSports();
}
