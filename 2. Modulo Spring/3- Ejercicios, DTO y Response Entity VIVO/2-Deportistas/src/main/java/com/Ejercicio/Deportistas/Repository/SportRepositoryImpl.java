package com.Ejercicio.Deportistas.Repository;

import com.Ejercicio.Deportistas.Entity.Sport;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SportRepositoryImpl implements ISportRepository {

    private static List<Sport> sports;

    public SportRepositoryImpl() {
        sports = new ArrayList<>();
        sports.add(new Sport("Futbol", "Profesional"));
        sports.add(new Sport("Baloncesto", "Amateur"));
        sports.add(new Sport("Tenis", "Profesional"));
        sports.add(new Sport("Natacion", "Recreativo"));
        sports.add(new Sport("Atletismo", "Profesional"));
    }

    @Override
    public List<Sport> findAllSports() {
        return sports;
    }
}
