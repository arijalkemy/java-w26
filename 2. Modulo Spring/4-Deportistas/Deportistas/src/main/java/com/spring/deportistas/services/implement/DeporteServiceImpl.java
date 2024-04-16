package com.spring.deportistas.services.implement;

import com.spring.deportistas.DTOs.DeportistaDTO;
import com.spring.deportistas.models.Deporte;
import com.spring.deportistas.models.Persona;
import com.spring.deportistas.services.IDeporteService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DeporteServiceImpl implements IDeporteService {
    @Override
    public List<String> consultarDeportes() {
        List<String> deportesNombres = new ArrayList<>();
        for(Deporte deporte : deportes){
            deportesNombres.add(deporte.getNombre());
        }
        return deportesNombres;
    }

    @Override
    public Deporte buscarUnDeporte(String nombre) throws Exception {
        try {
            Deporte resultado = deportes.stream().filter(x -> x.getNombre().equals(nombre)).findFirst().get();
            return resultado;
        } catch (Exception e) {
            throw new Exception("No se encontró el deporte");
        }
    }

    @Override
    public List<DeportistaDTO> buscarDeportistas() {
        List<DeportistaDTO> deportistas = new ArrayList<>();
        for(Persona persona : personas){
            deportistas.add(new DeportistaDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre()));
        }
        return deportistas;
    }
}
