package com.example.ejercicios_dto_y_response_entityvivo.service;

import com.example.ejercicios_dto_y_response_entityvivo.DTO.ResponseDTO;

public interface IAgeService {
    ResponseDTO calculateAge(Integer day, Integer month, Integer year);
}
