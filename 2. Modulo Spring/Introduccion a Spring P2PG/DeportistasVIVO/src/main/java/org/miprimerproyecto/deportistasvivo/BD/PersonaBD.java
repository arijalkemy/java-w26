package org.miprimerproyecto.deportistasvivo.BD;

import org.miprimerproyecto.deportistasvivo.DTO.DeporteDTO;
import org.miprimerproyecto.deportistasvivo.DTO.PersonaDTO;

import java.util.ArrayList;
import java.util.List;

public class PersonaBD {
    private static final ArrayList<PersonaDTO> personaList = new ArrayList<>();

    static {
        personaList.add(new PersonaDTO(454, "Facundo", "Molina", 30 , new DeporteDTO(123, "Futbol", 4) ));
        personaList.add(new PersonaDTO(455, "Mateo", "Rodriguez", 21 , new DeporteDTO(124, "Natacion", 1) ));
        personaList.add(new PersonaDTO(456, "Carla", "Lopetegue", 34, new DeporteDTO(125, "Tenis", 2)));
    }

    public List<PersonaDTO> getPersonaList() {
        return personaList.stream().toList();
    }

    /*public PersonaDTO getPersonaById(int id) {
        return personaList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }*/

}
