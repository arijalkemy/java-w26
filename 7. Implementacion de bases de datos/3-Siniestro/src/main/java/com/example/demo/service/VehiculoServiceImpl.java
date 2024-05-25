package com.example.demo.service;

import com.example.demo.dto.response.PatenteDTO;
import com.example.demo.dto.response.PatenteMarcaDTO;
import com.example.demo.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    @Autowired
    private IVehiculoRepository vehiculoRepository;

    // Listar patente sde vehiculos
    @Override
    public List<PatenteDTO> listarPatentes() {
        List<String> patentes = vehiculoRepository.findAllPatentes();
        List<PatenteDTO> patenteDTOs = new ArrayList<>();
        for (String patente : patentes) {
            PatenteDTO patenteDTO = new PatenteDTO(patente);
            patenteDTOs.add(patenteDTO);
        }
        return patenteDTOs;
    }

    // Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    @Override
    public List<PatenteMarcaDTO> listarPatenteYMarcaOrdenadosPorAnio() {
        List<Object[]> resultados = vehiculoRepository.findAllPatenteAndMarcaOrderByAnioFabricacion();
        List<PatenteMarcaDTO> vehiculos = new ArrayList<>();
        for (Object[] resultado : resultados) {
            PatenteMarcaDTO patenteMarcaDTO = new PatenteMarcaDTO((String) resultado[0], (String) resultado[1]);
            vehiculos.add(patenteMarcaDTO);
        }
        return vehiculos;
    }

    // Listar la patente de todos los vehículos que tengan más de cuatro
    // ruedas y hayan sido fabricados en el corriente año.
    @Override
    public List<PatenteDTO> listarPatentesParaVehiculosConRuedasYAnioActual() {
        List<String> patentes = vehiculoRepository.findPatenteByRuedasYAnio();
        List<PatenteDTO> patenteDTOs = new ArrayList<>();
        for (String patente : patentes) {
            PatenteDTO patenteDTO = new PatenteDTO(patente);
            patenteDTOs.add(patenteDTO);
        }
        return patenteDTOs;
    }
}
