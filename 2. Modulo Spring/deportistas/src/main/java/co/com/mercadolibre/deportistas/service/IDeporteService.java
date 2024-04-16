package co.com.mercadolibre.deportistas.service;

import co.com.mercadolibre.deportistas.entity.Deporte;
import co.com.mercadolibre.deportistas.entity.dto.PersonaDeporteDto;

import java.util.List;

public interface IDeporteService {
    List<Deporte> buscarTodos();
    String existeDeporte(String nombre);
    List<PersonaDeporteDto> listarPersonasDeportistas();
}
