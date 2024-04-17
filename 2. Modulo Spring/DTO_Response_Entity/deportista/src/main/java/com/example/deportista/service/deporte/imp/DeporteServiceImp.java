package com.example.deportista.service.deporte.imp;

import com.example.deportista.dto.DeporteDTO;
import com.example.deportista.model.Deporte;
import com.example.deportista.repository.DeporteRepository;
import com.example.deportista.service.deporte.IDeporteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteServiceImp implements IDeporteService {

    @Override
    public ResponseEntity<List<Deporte>> getDeportes() {
        List<Deporte> deportes = new DeporteRepository().getDeportes();

        if(deportes.isEmpty()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(deportes, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> getNivel(String deporte) {
        String nivel = DeporteDTO.getNivel(deporte);
        if(nivel.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nivel, HttpStatus.OK);
    }
}
