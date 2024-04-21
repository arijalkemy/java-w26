package com.example.concesionariaautos.service;

import com.example.concesionariaautos.dto.AutoDTO;
import com.example.concesionariaautos.model.Auto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServiceAuto {

    public void addAuto(Auto auto);
    public List<AutoDTO> getAllAutos();

    public List<Auto> getCarsByDate(String since, String to);

    List<Auto> getCarsByPrice(String since, String to);
    List<Auto> getCarById(String id);
}
