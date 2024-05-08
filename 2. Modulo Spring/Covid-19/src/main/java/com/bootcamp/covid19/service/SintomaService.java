package com.bootcamp.covid19.service;

import com.bootcamp.covid19.dto.Sintoma.NivelGravedadSintomaDto;
import com.bootcamp.covid19.dto.Sintoma.SintomaDto;
import com.bootcamp.covid19.entity.Sintoma;
import com.bootcamp.covid19.repository.SintomaRepository;
import com.bootcamp.covid19.service.Interfaces.ISintomaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SintomaService implements ISintomaService {
    @Override
    public List<SintomaDto> getAll() {

        List<SintomaDto> listSintomaDto = new ArrayList<>();

        SintomaRepository.listSintomas.stream().forEach(s -> {

            SintomaDto sintomaDto = new SintomaDto();
            sintomaDto.setCodigo(s.getCodigo());
            sintomaDto.setNombre(s.getNombre());
            sintomaDto.setNivelDeGravedad(s.getNivelDeGravedad());

            listSintomaDto.add(sintomaDto);
        });

        return listSintomaDto;
    }

    @Override
    public NivelGravedadSintomaDto getByName(String name) {

        Sintoma sintoma = SintomaRepository.listSintomas.stream().filter(s -> s.getNombre().equalsIgnoreCase(name)).findFirst().orElse(null);

        if(sintoma == null) return null;

        NivelGravedadSintomaDto nivelGravedadSintomaDto = new NivelGravedadSintomaDto();

        nivelGravedadSintomaDto.setNivelDeGravedad(sintoma.getNivelDeGravedad());

        return nivelGravedadSintomaDto;
    }
}
