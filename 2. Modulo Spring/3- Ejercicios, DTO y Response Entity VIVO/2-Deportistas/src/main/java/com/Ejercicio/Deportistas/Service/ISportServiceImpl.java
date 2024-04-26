package com.Ejercicio.Deportistas.Service;

import com.Ejercicio.Deportistas.Entity.Sport;
import com.Ejercicio.Deportistas.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ISportServiceImpl implements ISport {
    @Autowired
    Repository repository;

    @Override
    public List<Sport> getSports() {
        return Repository.sportList;
    }

    @Override
    public Optional<String> getLevelSportBy(String name) {
        return Repository.sportList.stream()
                .filter(sport -> sport.getName().equals(name))
                .findFirst()
                .map(Sport::getLevel);
    }

}
