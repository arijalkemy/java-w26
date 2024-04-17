package com.example.deportistas.service.impl;

import com.example.deportistas.model.Deporte;
import com.example.deportistas.service.IDeporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteImpl implements IDeporte {
    private static List<Deporte> deportes = new ArrayList<>();
    static {deportes.add(new Deporte("futbol",5));
        deportes.add(new Deporte("tenis",3));
        deportes.add(new Deporte("basket",2));
        deportes.add(new Deporte("voley",4));
        deportes.add(new Deporte("ajedrez",2));
    }
    @Override
    public List<Deporte> TodoDeportes() {
        return deportes;
    }

    @Override
    public int verDeporte(String nombre) {
        List<Deporte> result = deportes.stream()
                .filter(d -> d.getNombre().equals(nombre))
                .toList();

        if (result.size() == 0){
            return 0;
        }
        return result.get(0).getNivel();
    }
}
