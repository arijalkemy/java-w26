package com.asinc_ejerciciocovid19.servicio.implementacion;

import com.asinc_ejerciciocovid19.dto.PersonaSintomaDTO;
import com.asinc_ejerciciocovid19.dto.SintomaDTO;
import com.asinc_ejerciciocovid19.entidad.Persona;
import com.asinc_ejerciciocovid19.entidad.Sintoma;
import com.asinc_ejerciciocovid19.repositorio.Repositorio;
import com.asinc_ejerciciocovid19.servicio.IPersonaServicio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PersonaServicioImplementacion implements IPersonaServicio {
    @Override
    public List<PersonaSintomaDTO> obtenerPersonasDeRiesgo() {
        List<PersonaSintomaDTO> personasMayoresConSintomas = new ArrayList<>();

        for (Persona persona : Repositorio.listaPersonas.stream()
                                    .filter(p -> p.getEdad()>60 && p.getSintomas() != null).toList()) {
            personasMayoresConSintomas.add(convertirPersonADTO(persona));
        };
        return personasMayoresConSintomas;
    }

    public PersonaSintomaDTO convertirPersonADTO(Persona persona) {
        List<SintomaDTO> sintomasDto = new ArrayList<>();
        if (persona.getSintomas() != null) {

            for (Sintoma sintoma : persona.getSintomas()) {
                sintomasDto.add(new SintomaDTO(sintoma.getCodigo(), sintoma.getNombre(), sintoma.getNivelDeGravedad()));
            }
        }
        return new PersonaSintomaDTO(persona.getNombre(), persona.getApellido(), sintomasDto);
    }
}
