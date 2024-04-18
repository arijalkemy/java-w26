package org.responseentity.responseentity.services.sport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportService implements ISportService {

    @Autowired
    SportRepository sportRepository;

    @Override
    public void insertSport(SportDTO sport) {
        this.sportRepository.insertSport(sport);
    }

    @Override
    public List<SportDTO> getSports() {
        return this.sportRepository.listAllSport();
    }

    @Override
    public SportDTO findSportByName(String sportName) {
        return this.sportRepository.getSportByName(sportName);
    }

    @Override
    public List<SportDTO> deleteSporte(String sportName) {
        this.sportRepository.deleteSport(sportName);
        return this.sportRepository.listAllSport();
    }
}
