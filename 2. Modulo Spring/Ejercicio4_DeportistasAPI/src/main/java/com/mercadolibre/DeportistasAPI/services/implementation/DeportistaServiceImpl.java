package com.mercadolibre.DeportistasAPI.services.implementation;

import com.mercadolibre.DeportistasAPI.model.Deporte;
import com.mercadolibre.DeportistasAPI.repository.RepoBD;
import com.mercadolibre.DeportistasAPI.services.IDeportistaService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeportistaServiceImpl implements IDeportistaService {
    //Logica para la obtención de todos los reportes registrados
    @Override
    public List<Deporte> obtDeportes() {
        return RepoBD.deportes;
    }

    //Logica para la obtención y devolución del nivel del deporte por nombre
    @Override
    public String obtDeportePorNombre(String nombre) {
        Deporte deporte = RepoBD.deportes.stream().filter(d -> d.getNombre().equals(nombre)).findFirst().orElse(null);
        if(deporte == null) return null;
        else return deporte.getNivel();
    }


}
