package co.com.mercadolibre.deportistas.service.impl;

import co.com.mercadolibre.deportistas.entity.Deporte;
import co.com.mercadolibre.deportistas.entity.dto.PersonaDeporteDto;
import co.com.mercadolibre.deportistas.repository.IDeporteRepository;
import co.com.mercadolibre.deportistas.service.IDeporteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeporteService implements IDeporteService {

    private IDeporteRepository repositorio;

    public DeporteService(IDeporteRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Deporte> buscarTodos() {
        return this.repositorio.buscarTodos();
    }

    @Override
    public String existeDeporte(String nombre) {
        return this.repositorio.existeDeporte(nombre);
    }

    @Override
    public List<PersonaDeporteDto> listarPersonasDeportistas() {
        return this.repositorio.listarPersonasDeportistas();
    }


}
