package com.Ejercicio.Deportistas.Repository;

import com.Ejercicio.Deportistas.Entity.Sport;

import java.util.List;

public interface ISportRepository {
    List<Sport> findAllSports();
}
