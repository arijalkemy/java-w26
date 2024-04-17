package com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.service;

import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.models.Sport;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ISportRepository {
    public List<Sport> getSportList();

    public ResponseEntity<Integer> findSport(String name);
}
