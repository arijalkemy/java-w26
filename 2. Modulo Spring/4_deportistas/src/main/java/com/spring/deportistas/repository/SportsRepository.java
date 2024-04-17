package com.spring.deportistas.repository;

import com.spring.deportistas.models.Sport;

import java.util.List;
import java.util.Map;

public class SportsRepository {

    private Map<String, Sport> sportsMap;

    public SportsRepository() {
        this.sportsMap = Map.of(
                "futbol_profesional", new Sport("Futbol", "Profesional"),
                "tenis_semiprofesional", new Sport("Tenis", "Semi-profesional"),
                "boxeo_amateur", new Sport("Boxeo", "Amateur")
        );
    }

    public Map<String, Sport> getSportsMap() {
        return sportsMap;
    }

    public void setSportsMap(Map<String, Sport> sports) {
        this.sportsMap = sports;
    }

    public List<Sport> getSportsList() {
        return this.sportsMap.values().stream().toList();
    }
}
