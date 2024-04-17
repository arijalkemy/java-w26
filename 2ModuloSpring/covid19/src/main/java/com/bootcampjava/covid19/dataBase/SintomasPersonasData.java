package com.bootcampjava.covid19.dataBase;

import com.bootcampjava.covid19.model.Persona;
import com.bootcampjava.covid19.model.Sintoma;
import lombok.Data;

import java.util.*;
@Data
public class SintomasPersonasData {
    private Map<Persona, List<Sintoma>> uniones = new HashMap<Persona, List<Sintoma>>();
    /**
     * Realiza una unión aleatoria de personas con síntomas.
     *
     * @param personas Lista de personas.
     * @param sintomas Lista de síntomas.
     * @return Mapa con personas y sus síntomas asignados aleatoriamente.
     */
    public Map<Persona, List<Sintoma>> unionAleatoria(List<Persona> personas, List<Sintoma> sintomas) {
        if (personas == null || sintomas == null || personas.isEmpty() || sintomas.isEmpty()) {
            throw new IllegalArgumentException("Listas de personas o síntomas vacías o nulas.");
        }

        Map<Persona, List<Sintoma>> unionAleatoria = new HashMap<>();

        // Crear copia de las listas para no modificar las originales
        List<Persona> personasDisponibles = new ArrayList<>(personas);
        List<Sintoma> sintomasDisponibles = new ArrayList<>(sintomas);

        // Recorrer las personas disponibles
        for (Persona persona : personasDisponibles) {
            // Obtener una cantidad aleatoria de síntomas a asignar
            int cantidadSintomas = new Random().nextInt(sintomasDisponibles.size()) + 1;

            // Seleccionar aleatoriamente la cantidad de síntomas
            List<Sintoma> sintomasPersona = new ArrayList<>();
            for (int i = 0; i < cantidadSintomas; i++) {
                int indiceAleatorio = new Random().nextInt(sintomasDisponibles.size());
                Sintoma sintomaAleatorio = sintomasDisponibles.remove(indiceAleatorio);
                sintomasPersona.add(sintomaAleatorio);
            }

            // Agregar la persona y sus síntomas a la unión aleatoria
            unionAleatoria.put(persona, sintomasPersona);
        }

        return unionAleatoria;
    }
}
