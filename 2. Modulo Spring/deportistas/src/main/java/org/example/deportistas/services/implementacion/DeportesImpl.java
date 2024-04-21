package org.example.deportistas.services.implementacion;

import org.example.deportistas.models.*;
import org.example.deportistas.models.dtos.DeportistasResponseDTO;
import org.example.deportistas.services.IDeportes;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class DeportesImpl implements IDeportes {

    private List<Deportes> deportes;
    private List<Personas> deportistas;

    public DeportesImpl() {
        deportes = Arrays.asList(
                new Deportes("Tenis","Amateur"),
                new Deportes("Futbol","Profesional"),
                new Deportes("Basketball","Semi-pro"),
                new Deportes("Natación","Profesional")
        );
        deportistas = Arrays.asList(
                new Personas("Pepito","Perez",25, deportes.get(0)),
                new Personas("Armando","Casas",32, deportes.get(1)),
                new Personas("Esteban","Quito",24, deportes.get(2)),
                new Personas("Armando","Paredes",18, deportes.get(3)),
                new Personas("Daniela","Perez",12, deportes.get(0)),
                new Personas("Natalia","Perez",29, deportes.get(1))
                );

    }

    @Override
    public List<Deportes> findSports() {
        return deportes;
    }

    @Override
    public Deportes findSport(String nameSport) {
        Deportes deporteResponse = null;
        return deportes.stream().filter(x-> x.getNombre().equals(nameSport)).findFirst().orElse(deporteResponse);
    }

    @Override
    public List<DeportistasResponseDTO> findSportsPerson() {
        List<DeportistasResponseDTO> response = new ArrayList<>();
        this.deportistas.forEach(x->{
           response.add(new DeportistasResponseDTO(x.getNombre(),x.getApellido(),x.getDeporte().getNombre()));
        });
        return response;
    }
}
