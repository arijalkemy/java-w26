package co.com.mercadolibre.deportistas.repository;

import co.com.mercadolibre.deportistas.entity.Deporte;
import co.com.mercadolibre.deportistas.entity.dto.PersonaDeporteDto;

import java.util.List;

public interface IDeporteRepository {

    List<Deporte> buscarTodos();
    String existeDeporte(String nombre);
    List<PersonaDeporteDto> listarPersonasDeportistas();
}
