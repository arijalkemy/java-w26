package org.example.covid19.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.covid19.dto.SintomaDto;
import org.example.covid19.entities.Sintoma;
import org.example.covid19.repository.SintomasRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SintomasServiceImpl implements ISintomasService {
    @Autowired
    SintomasRepositorio sintomasRepositorio;

    @Override
    public List<SintomaDto> obtenerListaDeSintomas() {
        ObjectMapper mapper = new ObjectMapper();

        return sintomasRepositorio.getListaDeSintomas().stream()
                .map(sintoma -> mapper.convertValue(sintoma, SintomaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SintomaDto obtenerSintomaPorNombre(String nombre) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Sintoma> sintoma = sintomasRepositorio.buscarSintoma(nombre);
        return mapper.convertValue(sintoma.get(), SintomaDto.class);
    }
}
