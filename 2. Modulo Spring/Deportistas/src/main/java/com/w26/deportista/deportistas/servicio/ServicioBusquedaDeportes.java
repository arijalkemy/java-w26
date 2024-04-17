package com.w26.deportista.deportistas.servicio;

import com.w26.deportista.deportistas.modelo.Deporte;
import com.w26.deportista.deportistas.repositorio.AbstractRepositorio;
import com.w26.deportista.deportistas.repositorio.RepositorioDeporte;
import org.springframework.stereotype.Service;

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
