package com.ejerciciosdto.deportes.service;

import com.ejerciciosdto.deportes.models.Deporte;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceDeporteImpl implements IDeporte{
    Deporte futbol = new Deporte("Futbol","Avanzado");
    Deporte basquet = new Deporte("Basquet","Intermedio");
    Deporte baseball = new Deporte("Baseball","INtermedio");

    List<Deporte> deportes = List.of(futbol, basquet, baseball);

    @Override
    public List<Deporte> findSports() {
        return deportes;
    }

    @Override
    public String findSportByName(String name) {
        Optional<Deporte> result = deportes.stream().filter(e -> name.equals(e.getNombre())).findFirst();
        return result.map(Deporte::getNivel).orElse(null);
    }
}
