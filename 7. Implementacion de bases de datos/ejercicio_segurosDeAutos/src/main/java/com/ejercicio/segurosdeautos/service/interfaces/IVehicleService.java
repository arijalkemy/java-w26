package com.ejercicio.segurosdeautos.service.interfaces;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVehicleService {
    List<String> getAllPatents();
}