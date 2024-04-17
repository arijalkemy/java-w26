package com.example.EjercicioDeporte.service.impl;

import com.example.EjercicioDeporte.dto.DeporteDTO;
import com.example.EjercicioDeporte.model.Deporte;
import com.example.EjercicioDeporte.repository.Repository;
import com.example.EjercicioDeporte.service.IDeporteService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeporteServiceImpl implements IDeporteService {

    @Override
    public List<DeporteDTO> buscarTodosDeportes() {
        return Repository.deportes.stream().map(DeporteServiceImpl::convertirADTO).toList();
    }

    @Override
    public String buscarPorNombre(String name) {
        for (Deporte deporte : Repository.deportes) {
            if (deporte.getNombre().equalsIgnoreCase(name)) {
                return "Nivel del deporte " + name + ": " + deporte.getNivel();
            }
        }
        return null;

    }

    private static DeporteDTO convertirADTO(Deporte deporte) {
        DeporteDTO dto = new DeporteDTO();
        dto.setNombre(deporte.getNombre());
        dto.setNivel(deporte.getNivel());
        return dto;
    }


}
