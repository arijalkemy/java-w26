package com.example.sinisestros.service.impl;

import com.example.sinisestros.dto.VehiculoPatMarModDto;
import com.example.sinisestros.models.Siniestro;
import com.example.sinisestros.repository.ISiniestroRepository;
import com.example.sinisestros.service.ISiniestroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SiniestroServiceImpl implements ISiniestroService {

    private final ISiniestroRepository siniestroRepository;
    private final ObjectMapper objectMap;
    @Override
    public List<VehiculoPatMarModDto> getinformacionVehiculoSiniestroMayoraDiezMil() {
        return siniestroRepository.getDatosVehiculosWherePerdidaMayorQue1000().stream()
                .map(s -> objectMap.convertValue(s.getVehiculoDenunciado(), VehiculoPatMarModDto.class)).toList();
    }


    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un
    // siniestro con pérdida mayor de 10000 pesos.

    //public List<VehiculoPatMarModDto> get



    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida
    // mayor de 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos


}
