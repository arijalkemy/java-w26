package com.EjercicioDeportista.EjercicioDeportista.services.Impl;

import com.EjercicioDeportista.EjercicioDeportista.clases.Deporte;
import com.EjercicioDeportista.EjercicioDeportista.services.IDeporteService;
import com.EjercicioDeportista.EjercicioDeportista.utils.Datos;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class DeporteServiceImpl implements IDeporteService {
    @Override
    public Optional<Deporte> findSportsName(String name) {
        List<Deporte> listDeportes = Datos.obtenerDeportes();

        Deporte deporteEncontrado = listDeportes.stream().filter(x->x.getNombre().toLowerCase().equals(name.toLowerCase())).findFirst().orElse(null);
        if(deporteEncontrado != null)
        {
            return Optional.of(deporteEncontrado);
        }
        return  Optional.empty();
    }
}
