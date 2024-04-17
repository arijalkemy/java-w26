package com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.service.sportimpl;

import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.models.Sport;
import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.service.ISportRepository;
import com.deportistas.ejercicios_dto_y_response_entityvivo_deportistas.service.ISportService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportImpl implements ISportService {

    @Autowired
    ISportRepository repository;

    @Override
    public List<Sport> getAllSports() {
        return repository.getSportList();
    }

    @Override
    public ResponseEntity<Integer> findSport(String sportName) {
        return repository.findSport(sportName);
    }
}
