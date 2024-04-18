package com.Ejercicio.Deportistas.Repository;

import com.Ejercicio.Deportistas.Entity.Sport;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SportRepository {
    public static List<Sport> sportList = List.of(
            new Sport("Tennis", "Principiante"),
            new Sport("Basket", "Intermedio"),
            new Sport("Futbol", "Avanzado"));


   
}
