package com.spring.deportistas.services.services.impl;

import com.spring.deportistas.models.Sport;
import com.spring.deportistas.repository.SportsRepository;
import com.spring.deportistas.services.ISportsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsServicesImpl implements ISportsService {

    private final SportsRepository sportsMap;

    public SportsServicesImpl() {
        this.sportsMap = new SportsRepository();
    }

    @Override
    public List<Sport> getAllSports() {
        return this.sportsMap.getSportsList();
    }

    @Override
    public Sport getSportByName(String name) {
        return this.sportsMap.getSportsList().stream()
                .filter(sport -> sport.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}
