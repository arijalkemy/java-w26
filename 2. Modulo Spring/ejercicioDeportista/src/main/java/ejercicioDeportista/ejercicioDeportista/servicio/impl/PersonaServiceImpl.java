package ejercicioDeportista.ejercicioDeportista.servicio.impl;

import ejercicioDeportista.ejercicioDeportista.entidades.Deporte;
import ejercicioDeportista.ejercicioDeportista.entidades.Persona;
import ejercicioDeportista.ejercicioDeportista.entidades.PersonaDTO;
import ejercicioDeportista.ejercicioDeportista.repositorios.DeporteRepositorio;
import ejercicioDeportista.ejercicioDeportista.repositorios.PersonaRepositorio;
import ejercicioDeportista.ejercicioDeportista.servicio.IPersonaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService {

    private PersonaRepositorio personaRepositorio;

    public PersonaServiceImpl() {

        Deporte deporte1 = new Deporte("Fútbol", "Profesional");
        Deporte deporte2 = new Deporte("Natación", "Amateur");
        Deporte deporte3 = new Deporte("Tenis", "Intermedio");

        this.personaRepositorio = new PersonaRepositorio(
                List.of(new Persona("Juan", "Pérez", 30, deporte1),
                        new Persona("María", "Gómez", 25, deporte2),
                        new Persona("Carlos", "López", 35, deporte3)
                )
        );
    }


    public List<PersonaDTO> obtenerPersonasDeportistas() {
        return this.personaRepositorio.obtenerPersonas().stream().map(this::crearPersonaDto).toList();
    }


    public PersonaDTO crearPersonaDto(Persona persona) {
        return new PersonaDTO(persona.getNombre(), persona.getApellido(), persona.getDeporte().getNombre());
    }
}
