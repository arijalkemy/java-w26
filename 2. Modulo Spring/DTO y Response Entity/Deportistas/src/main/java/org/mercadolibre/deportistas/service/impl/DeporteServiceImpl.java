package org.mercadolibre.deportistas.service.impl;

import org.mercadolibre.deportistas.model.Deporte;
import org.mercadolibre.deportistas.model.DeportistaDTO;
import org.mercadolibre.deportistas.repository.Repositorio;
import org.mercadolibre.deportistas.service.IDeporteService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeporteServiceImpl implements IDeporteService {
    Repositorio repositorio = new Repositorio();

    @Override
    public List<Deporte> getDeportes() {
        return repositorio.getListaDeDeportes();
    }

    @Override
    public String getNivelDeDeporte(String nombreDeporte) {
        return repositorio.getNivelDeDeporte(nombreDeporte);
    }

    @Override
    public List<DeportistaDTO> getDeportistas() {
        return repositorio.getDeportistas();
    }

}
