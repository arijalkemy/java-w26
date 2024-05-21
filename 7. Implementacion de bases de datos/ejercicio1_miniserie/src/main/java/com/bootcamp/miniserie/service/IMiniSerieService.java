package com.bootcamp.miniserie.service;

import java.util.List;

import com.bootcamp.miniserie.dto.MiniSerieDTO;
import com.bootcamp.miniserie.dto.ResponseDTO;

public interface IMiniSerieService {

    List<MiniSerieDTO> getMiniSeries();

    ResponseDTO saveMiniSerie(MiniSerieDTO miniSerieDto);

    ResponseDTO deleteMiniSerie(long id);

    MiniSerieDTO findMiniSerie(long id);

    ResponseDTO updateMiniSerie(MiniSerieDTO miniSerieDto);

}