package com.Ejercicio.Deportistas.Service;

import com.Ejercicio.Deportistas.Entity.DTO.PersonDTO;
import com.Ejercicio.Deportistas.Entity.Sport;
import java.util.List;
import java.util.Optional;

public interface ISport {
    List<Sport> getSports();

    Optional<String> getLevelSportBy(String name);
}
