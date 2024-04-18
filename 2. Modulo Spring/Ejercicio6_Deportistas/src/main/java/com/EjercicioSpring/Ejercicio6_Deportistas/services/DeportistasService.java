package com.EjercicioSpring.Ejercicio6_Deportistas.services;

import com.EjercicioSpring.Ejercicio6_Deportistas.baseDeDatos.BaseDeDatos;
import com.EjercicioSpring.Ejercicio6_Deportistas.dto.DeporteDTO;
import com.EjercicioSpring.Ejercicio6_Deportistas.dto.DeportistaDTO;
import com.EjercicioSpring.Ejercicio6_Deportistas.entities.Deporte;
import com.EjercicioSpring.Ejercicio6_Deportistas.entities.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class DeportistasService {

    private BaseDeDatos bd = BaseDeDatos.getBaseDeDatos();

    public List<DeportistaDTO> getDeportistas() {
        List<DeportistaDTO> deportistasDTO = new ArrayList<>();
        List<Deporte> deportes = bd.getDeportes();
        List<Persona> personas = bd.getPersonas();
        Random random = new Random();

        for (Persona persona : personas) {
            Deporte deporteAleatorio = deportes.get(random.nextInt(deportes.size()));
            DeportistaDTO deportistaDTO = new DeportistaDTO(
                    persona.getNombre(), persona.getApellido(), deporteAleatorio.getNombre()
            );
            deportistasDTO.add(deportistaDTO);
        }

        return deportistasDTO;
    }

    public List<DeporteDTO> getAllDeportes() {
        List<Deporte> deportes =  bd.getDeportes();
        List<DeporteDTO> deportesDTO =  new ArrayList<>();
        for (Deporte deporte : deportes) {
            deportesDTO.add(new DeporteDTO(deporte.getNombre(), deporte.getNivel()));
        }
        return deportesDTO;
    }

    public DeporteDTO getDeporteByName(String nombre) {
        Optional<Deporte> deporteEncontrado = bd.getDeportes().stream()
                .filter(x -> x.getNombre().toLowerCase().equals(nombre.toLowerCase()))
                .findFirst();
        return deporteEncontrado.map(deporte -> new DeporteDTO(deporte.getNombre(), deporte.getNivel())).orElse(null);
    }

}
