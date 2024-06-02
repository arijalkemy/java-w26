package com.mercadolibre.deportes_n.service;
import org.springframework.stereotype.Service;

import com.mercadolibre.deportes_n.model.Deporte;
import com.mercadolibre.deportes_n.repository.RepositorioDeporte;

import java.util.List;

@Service
public class ServicioBusquedaDeportes {

    public List<Deporte> encontrarDeportes(){
        return  RepositorioDeporte.getInstance().getAll();
    }

    public List<Deporte> encontrarDeportes(String deporte){
        return  RepositorioDeporte.getInstance().getAll().stream().filter(deporte1 -> deporte1.getNombre().equals(deporte)).toList();
    }
}
