package com.example.Sports.service;

import com.example.Sports.entity.Sport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportService implements ISport {

    private static List<Sport> sports;

    public SportService() {
        sports = new ArrayList<>();
        sports.add(new Sport("Football", "Professional"));
        sports.add(new Sport("Basketball", "Amateur"));
        sports.add(new Sport("Tennis", "Professional"));
        sports.add(new Sport("Golf", "Amateur"));
    }


    @Override
    public List<Sport> findAll() {
        return sports;
    }

    @Override
    public Sport findByName(String name) {
        for (Sport sport : sports) {
            if (sport.getName().equals(name)) {
                return sport;
            }
        }
        return null;
    }
}
