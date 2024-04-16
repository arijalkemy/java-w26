package com.ej2p1.athletes.services.implementations;

import com.ej2p1.athletes.model.Sport;
import com.ej2p1.athletes.services.ISportsViewer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportsViewerImpl implements ISportsViewer {

    private List<Sport> sports = new ArrayList<>();

    @Override
    public List<Sport> findAllSports() {
        Sport football = new Sport("Football", "Easy");
        Sport basketball = new Sport("Basketball", "Medium");
        Sport tennis = new Sport("Tennis", "Hard");

        sports.add(football);
        sports.add(basketball);
        sports.add(tennis);

        return sports;
    }

    @Override
    public String findSportLevelByName(String sportName) {
        Sport football = new Sport("Football", "Easy");
        Sport basketball = new Sport("Basketball", "Medium");
        Sport tennis = new Sport("Tennis", "Hard");

        sports.add(football);
        sports.add(basketball);
        sports.add(tennis);

        for (Sport sport : sports) {
            if (sport.getName().equalsIgnoreCase(sportName)) {
                return sport.getLevel();
            }
        }
        return null;
    }
}
