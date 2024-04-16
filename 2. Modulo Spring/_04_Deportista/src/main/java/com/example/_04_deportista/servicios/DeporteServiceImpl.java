package com.example._04_deportista.servicios;

import com.example._04_deportista.model.Deporte;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteServiceImpl implements IDeporteService {

    static List<Deporte> deportes;
    static{
      deportes = new ArrayList<>();
      deportes.add(new Deporte("futbol", 4));
      deportes.add(new Deporte("basquet", 1));
      deportes.add(new Deporte("voley", 2));
    }

    @Override
    public List<Deporte> obtenerDeportes() {
        return deportes;
    }

    @Override
    public int obtenerNivelDeDeporte(String nombre) {
        Deporte deporte = deportes.stream()
                .filter(d->d.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);

        if(deporte!=null)
            return deporte.getNivel();
        return 0;
    }
}
