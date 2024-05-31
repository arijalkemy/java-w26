package com.example.ejercicios_dto_y_response_entityvivo_2.repository;

import com.example.ejercicios_dto_y_response_entityvivo_2.entity.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SportRepository {
    private List<Sport> sportList;
    //Creando un repository básico
    public SportRepository() {
        this.sportList = new ArrayList<>();
        sportList.add(new Sport("Basket",2L));
        sportList.add(new Sport("Futball",5L));
        sportList.add(new Sport("American Football",10L));
    }
    public List<Sport > getAll(){
        return sportList;
    }

    public Optional<Sport> getSport(String name){
        return sportList.stream()
                .filter(sport -> sport.getName().equals(name))
                .findFirst();
    }

}
