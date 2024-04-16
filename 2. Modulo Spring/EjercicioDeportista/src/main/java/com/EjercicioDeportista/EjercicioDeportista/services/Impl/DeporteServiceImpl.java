package com.EjercicioDeportista.EjercicioDeportista.services.Impl;

import com.EjercicioDeportista.EjercicioDeportista.clases.Deporte;
import com.EjercicioDeportista.EjercicioDeportista.services.IDeporteService;
import com.EjercicioDeportista.EjercicioDeportista.utils.Datos;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeporteServiceImpl implements IDeporteService {
    @Override
    public Optional<Deporte> findSportsName(String name) {
        List<Deporte> listDeportes = Datos.obtenerDeportes();
        for (Deporte item:listDeportes) {
            if(name.toLowerCase().equals(item.getNombre().toLowerCase()))
            {
                return Optional.of(item);
            }
        }
        return  Optional.empty();
    }
}
