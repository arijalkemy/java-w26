package com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.service;

import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.models.Sport;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISportService {

    public List<Sport> getAllSports();

    public ResponseEntity<Integer> findSport(String name);
}
