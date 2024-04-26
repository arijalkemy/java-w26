package org.example.deportistas.services.implementacion;

import org.example.deportistas.models.*;
import org.example.deportistas.models.dtos.DeportistaResponseDTO;
import org.example.deportistas.services.IDeportes;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class DeportesImpl implements IDeportes {

    private List<Deporte> deportes;
    private List<Persona> deportistas;

    public DeportesImpl() {
        deportes = Arrays.asList(
                new Deporte("Tenis","Amateur"),
                new Deporte("Futbol","Profesional"),
                new Deporte("Basketball","Semi-pro"),
                new Deporte ("Natación","Profesional")
        );
        deportistas = Arrays.asList(
                new Persona("Pepito","Perez",25, deportes.get(0)),
                new Persona("Armando","Casas",32, deportes.get(1)),
                new Persona("Esteban","Quito",24, deportes.get(2)),
                new Persona("Armando","Paredes",18, deportes.get(3)),
                new Persona("Daniela","Perez",12, deportes.get(0)),
                new Persona("Natalia","Perez",29, deportes.get(1))
                );

    }

    @Override
    public List<Deporte> findSports() {
        return deportes;
    }

    @Override
    public Deporte findSport(String nameSport) {
        Deporte deporteResponse = new Deporte();
        return deportes.stream().filter(x-> x.getNombre().equals(nameSport)).findFirst().orElse(deporteResponse);
    }

    @Override
    public List<DeportistaResponseDTO> findSportsPerson() {
        List<DeportistaResponseDTO> response = new ArrayList<>();
        this.deportistas.forEach(x->{
           response.add(new DeportistaResponseDTO(x.getNombre(),x.getApellido(),x.getDeporte().getNombre()));
        });
        return response;
    }
}
