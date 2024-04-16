package org.example.dtosport.service.impl;

import org.example.dtosport.entity.Sport;
import org.example.dtosport.service.ISport;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class SportImpl implements ISport {

    private final List<Sport> sportsList;

    public SportImpl(@Qualifier("listSport") List<Sport> sportsList) {
        this.sportsList = sportsList;
    }

    @Override
    public List<Sport> findAll() {
        return this.sportsList;
    }

    @Override
    public Sport findByName(String name) {
        return this.sportsList.stream().filter(sport -> sport.getName().equals(name)).findFirst().orElse(null);
    }
}
