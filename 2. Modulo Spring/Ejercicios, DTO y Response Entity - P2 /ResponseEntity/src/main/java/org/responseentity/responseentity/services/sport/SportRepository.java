package org.responseentity.responseentity.services.sport;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportRepository {
    private List<SportDTO> sports;

    public SportRepository() {
        this.sports = new ArrayList<>();
    }

    public List<SportDTO> listAllSport(){
        return this.sports;
    }

    public SportDTO getSportByName(String name){
        return this.sports
                .stream()
                .filter(
                        sportDTO -> sportDTO.getName().equals(name))
                .findFirst()
                .orElse( null);
    }

    public void insertSport(SportDTO sport){
        this.sports.add(sport);
    }

    public void deleteSport(String sportName){
        List<SportDTO> tempList = this.sports
                .stream()
                .filter(
                        sportDTO -> !sportDTO.getName().equals(sportName)
                ).toList();
        if(!tempList.isEmpty()){
            this.sports = tempList;
        }
    }
}
