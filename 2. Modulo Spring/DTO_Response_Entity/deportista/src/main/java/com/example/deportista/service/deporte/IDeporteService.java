package com.example.deportista.service.deporte;

import com.example.deportista.dto.DeporteDTO;
import com.example.deportista.model.Deporte;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IDeporteService {
    ResponseEntity<List<Deporte>> getDeportes();
    ResponseEntity<String> getNivel(String deporte);
}
