package com.meli.ejerciciopracticocovid19.Modelo;

import com.meli.ejerciciopracticocovid19.DTO.PersonaDTO;
import com.meli.ejerciciopracticocovid19.DTO.SintomaDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectList {

    public static List<SintomaDTO> sintomasList = new ArrayList<>();
    public static List<PersonaDTO> personasList = new ArrayList<>();

    static {

        Random random = new Random();

        String[] nombres = {"Juan", "María", "Pedro", "Luis", "Ana", "Carlos", "Laura", "Sofía", "Diego", "Elena"};
        String[] apellidos = {"García", "Martínez", "Rodríguez", "López", "González", "Pérez", "Sánchez", "Díaz", "Romero", "Santiago"};
        String[] sintomas = {"Fiebre", "Escalofrios", "Tos", "Estornudos"};
        String[] intensidad = {"Alta", "Media", "Baja"};

        // Agregar síntomas a la lista de síntomas
        for (String sintoma : sintomas) {
            sintomasList.add(new SintomaDTO(sintomasList.size() + 1, sintoma.toUpperCase(), intensidad[random.nextInt(intensidad.length)]));
        }

        // Generar listas de síntomas para cada persona
        for (int i = 0; i < 20; i++) {
            List<SintomaDTO> listaDeSintomas = new ArrayList<>();
            int cantidadSintomas = random.nextInt(sintomas.length) + 1;
            for (int j = 0; j < cantidadSintomas; j++) {
                int indiceSintoma = random.nextInt(sintomasList.size());
                SintomaDTO sintoma = sintomasList.get(indiceSintoma);
                if (!listaDeSintomas.contains(sintoma)) {
                    listaDeSintomas.add(sintoma);
                }
            }
            String nombre = nombres[random.nextInt(nombres.length)];
            String apellido = apellidos[random.nextInt(apellidos.length)];
            String intensidadAleatoria = intensidad[random.nextInt(intensidad.length)];
            personasList.add(new PersonaDTO(nombre, apellido, listaDeSintomas, random.nextInt(86) + 1, intensidadAleatoria));
        }
    }
}
