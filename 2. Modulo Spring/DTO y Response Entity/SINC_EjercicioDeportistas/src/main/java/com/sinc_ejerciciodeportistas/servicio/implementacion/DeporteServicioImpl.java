package com.sinc_ejerciciodeportistas.servicio.implementacion;

import com.sinc_ejerciciodeportistas.dto.DeporteDTO;
import com.sinc_ejerciciodeportistas.entidades.Deporte;
import com.sinc_ejerciciodeportistas.repositorio.Repositorio;
import com.sinc_ejerciciodeportistas.servicio.IDeporteServicio;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DeporteServicioImpl implements IDeporteServicio {

    @Override
    public List<DeporteDTO> obtenerTodosLosDeportes() {
        List<DeporteDTO> listaDeporteDTO = new ArrayList<>();
        for (Deporte deporte : Repositorio.listaDeportes) {
            listaDeporteDTO.add(convertirADTO(deporte));
        }
        return listaDeporteDTO;
    }

    private static DeporteDTO convertirADTO(Deporte deporte){
        DeporteDTO deporteDTO = new DeporteDTO(deporte.getNombre(), deporte.getNivel());
        return deporteDTO;
    }

    @Override
    public String buscarDeportePorNombre(String nombreDeporte) {
        Deporte deporte = Repositorio.listaDeportes.stream()
                .filter(d -> d.getNombre().equals(nombreDeporte))
                .findFirst()
                .orElse(null);

        return "Se encontro el deporte: " + deporte.getNombre() +
                " con un nivel: " + deporte.getNivel();
    }
}
