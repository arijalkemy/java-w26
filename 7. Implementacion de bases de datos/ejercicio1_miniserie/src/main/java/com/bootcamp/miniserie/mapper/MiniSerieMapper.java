package com.bootcamp.miniserie.mapper;

import com.bootcamp.miniserie.dto.MiniSerieDTO;
import com.bootcamp.miniserie.model.MiniSerie;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class MiniSerieMapper {

    private MiniSerieMapper() {
    }

    public static MiniSerie miniSerieDTOToMiniSerie(MiniSerieDTO miniSerieDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(miniSerieDTO, MiniSerie.class);
    }

    public static MiniSerieDTO miniSerieToMiniSerieDTO(MiniSerie miniSerie) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(miniSerie, MiniSerieDTO.class);
    }

    public static List<MiniSerieDTO> miniSerieListToMiniSerieDTOList(List<MiniSerie> miniSeries) {
        return miniSeries.stream()
                .map(MiniSerieMapper::miniSerieToMiniSerieDTO)
                .toList();
    }

}
