package org.example.dto_p1_sports.sport;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SportRepository {

    public List<Sport> findSports(){
        List<Sport> allSports = new ArrayList<>();
        allSports.add(new Sport("Basketball", "A"));
        allSports.add(new Sport("Football", "S"));
        allSports.add(new Sport("Soccer", "SS"));
        allSports.add(new Sport("Baseball", "B"));
        allSports.add(new Sport("Rugby", "S"));
        allSports.add(new Sport("Badminton", "EX"));

        return allSports;
    }
}
