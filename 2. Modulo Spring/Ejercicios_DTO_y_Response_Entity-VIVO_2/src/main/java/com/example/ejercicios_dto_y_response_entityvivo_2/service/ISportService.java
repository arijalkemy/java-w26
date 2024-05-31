package com.example.ejercicios_dto_y_response_entityvivo_2.service;

import com.example.ejercicios_dto_y_response_entityvivo_2.dto.DeportistDTO;
import com.example.ejercicios_dto_y_response_entityvivo_2.dto.SportDTO;

import java.util.List;

public interface ISportService {
    List<SportDTO> getAll();

    SportDTO getSport(String name);

    List<DeportistDTO> getDeportist();
}
