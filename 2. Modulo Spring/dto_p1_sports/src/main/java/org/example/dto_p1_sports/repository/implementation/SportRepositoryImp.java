package org.example.dto_p1_sports.repository.implementation;

import org.example.dto_p1_sports.repository.interfaces.ISportRepository;
import org.example.dto_p1_sports.entity.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SportRepositoryImp implements ISportRepository {
    List<Sport> allSports = new ArrayList<>();
    public SportRepositoryImp() {
        allSports.add(new Sport("Basketball", "A"));
        allSports.add(new Sport("Football", "S"));
        allSports.add(new Sport("Soccer", "SS"));
        allSports.add(new Sport("Baseball", "B"));
        allSports.add(new Sport("Rugby", "S"));
        allSports.add(new Sport("Badminton", "EX"));
    }

    @Override
    public List<Sport> findAll() {
        return allSports;
    }

    @Override
    public Sport findByName(String name) {
        return allSports.stream()
                .filter(sport -> sport.getName().toLowerCase().trim().equals(name.toLowerCase().trim()))
                .findFirst()
                .orElse(null);
    }
}
