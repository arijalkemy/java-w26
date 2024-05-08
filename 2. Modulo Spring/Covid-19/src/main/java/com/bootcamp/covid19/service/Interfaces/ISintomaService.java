package com.bootcamp.covid19.service.Interfaces;

import com.bootcamp.covid19.dto.Sintoma.NivelGravedadSintomaDto;
import com.bootcamp.covid19.dto.Sintoma.SintomaDto;

import java.util.List;

public interface ISintomaService {

    List<SintomaDto> getAll();

    NivelGravedadSintomaDto getByName(String name);

}
