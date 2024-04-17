package org.bootcamp.deportes;

import org.bootcamp.deportes.domain.Deporte;
import org.bootcamp.deportes.domain.Persona;
import org.bootcamp.deportes.repository.DeportistaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class EjercicioDeportesDtoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EjercicioDeportesDtoApplication.class, args);
        DeportistaRepository deportistaRepository = new DeportistaRepository();

        Deporte deporte = new Deporte("Basquetball", "medio");
        Deporte deporte2 = new Deporte("Futboll", "bajo");
        Deporte deporte3 = new Deporte("Voleibol", "alto");

        Persona persona = new Persona("Juan", "Perez", 24);
        Persona persona2 = new Persona("Camila", "Sanchez", 13);
        Persona persona3 = new Persona("Isabella", "Villamizar", 19);
        Persona persona4 = new Persona("Dixon", "Romero", 20);

        deportistaRepository.guardarDeportistas(deporte, Arrays.asList(persona, persona4));
        deportistaRepository.guardarDeportistas(deporte2, Arrays.asList(persona2, persona3));
        deportistaRepository.guardarDeportistas(deporte3,
                Arrays.asList(persona, persona2, persona3, persona4));
    }

}
