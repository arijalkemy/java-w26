package com.meli.covid19.services.impl;

import com.meli.covid19.dto.SintomaDTO;
import com.meli.covid19.services.ISintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimtomaImpl implements ISintoma {

    private static List<SintomaDTO> sintomas = new ArrayList<>();
    static {
        sintomas.add(new SintomaDTO(1,"Fiebre","Alto"));
        sintomas.add(new SintomaDTO(2,"Tos","Alto"));
        sintomas.add(new SintomaDTO(3,"Dolor de garganta","Medio"));
        sintomas.add(new SintomaDTO(4,"Perdida del gusto","Alto"));
        sintomas.add(new SintomaDTO(5,"Congestion nasal","Bajo"));
        sintomas.add(new SintomaDTO(6,"Dificultad para respirar","Alto"));
    }

    @Override
    public List<SintomaDTO> verSintomas(){
        return sintomas;
    }

    @Override
    public String buscarSintoma(String nombre){
        List<SintomaDTO> sintomasFiltrados = sintomas.stream().filter(s -> s.getNombre().equals(nombre)).toList();
        if(sintomasFiltrados.size()==0){
            return "No registrado";
        }else {
            return sintomasFiltrados.get(0).getNivel_de_gravedad();
        }
    }
}
