package com.meli.covid19.repository;

import com.meli.covid19.dto.PersonaDTO;
import com.meli.covid19.dto.SintomaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListData {
    public final static List<SintomaDTO> listSintomas = new ArrayList<>();
    public final static List<PersonaDTO> listPersonas = new ArrayList<>();

    static{
        String[] nombres = {"Juan", "María", "Pedro", "Luis", "Ana", "Carlos", "Laura", "Sofía", "Diego", "Elena"};
        String[] apellidos = {"García", "Martínez", "Rodríguez", "López", "González", "Pérez", "Sánchez", "Díaz", "Romero", "Santiago"};
        String[] sintomas = {"Tos", "Fiebre", "Dolor de cabeza", "Mareo", "Vertigo"};
        String[] intensidad = {"Alta", "Media", "Baja"};

        Random random = new Random();

        for(String sintomas1 : sintomas) {
            listSintomas.add(new SintomaDTO(listSintomas.size()+1,sintomas1,random.nextInt(6)+1));
        }

        List<List<SintomaDTO>> sintomasPersonas = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            List<SintomaDTO> sintomaDTOS = new ArrayList<>();
            int cantidad_sintomas = random.nextInt(sintomas.length)+1;
            for(int j = 0; j < cantidad_sintomas; j++) {
                sintomaDTOS.add(listSintomas.get(random.nextInt(sintomas.length)));
            }
            sintomasPersonas.add(sintomaDTOS);
        }

        for (int i = 0; i < 10; i++) {
            listPersonas.add(new PersonaDTO(listPersonas.size()+1,nombres[random.nextInt(nombres.length)],apellidos[random.nextInt(apellidos.length)],random.nextInt(50)+1,sintomasPersonas.get(random.nextInt(sintomasPersonas.size()))));
        }

    }
}
