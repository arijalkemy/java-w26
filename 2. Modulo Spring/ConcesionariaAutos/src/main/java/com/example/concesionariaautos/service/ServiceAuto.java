package com.example.concesionariaautos.service;

import com.example.concesionariaautos.dto.AutoDTO;
import com.example.concesionariaautos.model.Auto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServiceAuto {
    void addAuto(Auto auto);

    List<AutoDTO> getAllAutos();

    List<Auto> getCarsByDate(String since, String to);

    List<Auto> getCarsByPrice(Integer since, Integer to);
    Auto getCarInfo(Integer id);
}
