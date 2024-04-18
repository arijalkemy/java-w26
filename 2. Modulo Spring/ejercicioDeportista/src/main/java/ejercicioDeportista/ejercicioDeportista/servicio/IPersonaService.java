package ejercicioDeportista.ejercicioDeportista.servicio;

import ejercicioDeportista.ejercicioDeportista.entidades.PersonaDTO;

import java.util.List;

public interface IPersonaService {
    public List<PersonaDTO> obtenerPersonasDeportistas();
}
