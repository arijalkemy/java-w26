package org.mercadolibre.deportistas.repository;

import lombok.Getter;
import org.mercadolibre.deportistas.model.Deporte;
import org.mercadolibre.deportistas.model.DeportistaDTO;
import org.mercadolibre.deportistas.model.Persona;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Repositorio {
    @Getter
    private List<Persona> listaDePersonas;
    @Getter
    private List<Deporte> listaDeDeportes;

    public Repositorio(){
        this.listaDeDeportes = List.of(
                new Deporte("Futbol", "Amateur"),
                new Deporte("Tenis", "Profesional")
        );
        this.listaDePersonas = List.of(
                new Persona("Lautaro", "Oleastro", 26, this.listaDeDeportes.get(0)),
                new Persona("Otra", "Persona", 26, this.listaDeDeportes.get(1)),
                new Persona("Tercera", "Persona", 26)
        );
    }

    public List<DeportistaDTO> getDeportistas(){
        ArrayList<DeportistaDTO> listaDeportistas = new ArrayList<>();
        for (Persona persona : this.listaDePersonas){
            if (persona.esDeportista()){
                listaDeportistas.add(
                        new DeportistaDTO(
                                persona.getNombre() +" "+ persona.getApellido(),
                                persona.getDeporte().getNombre()
                        )
                );
            }
        }

        return listaDeportistas;
    }

    public String getNivelDeDeporte(String nombreDeporte){
        Optional<Deporte> deporte = this.listaDeDeportes.stream().filter(x -> nombreDeporte.equals(x.getNombre())).findFirst();
        if (deporte.isPresent()) {
            return deporte.get().getNivel();
        } else {
            return "No se encontro el deporte";
        }
    }
}
