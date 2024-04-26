package com.deporte.deportistas.Service;

import com.deporte.deportistas.Repository.DeporteRepository;
import com.deporte.deportistas.Service.Interfaces.IDeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeporteService implements IDeporteService {

    DeporteRepository deporteRepository = new DeporteRepository();

    @Override
    public String getDeportes() {
        return deporteRepository.getDeportes().toString();
    }

    @Override
    public String getDeporteByName(String nombre) {
        return this.deporteRepository.getDeporteByName(nombre).toString();
    }
}
