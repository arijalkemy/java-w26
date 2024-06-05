package org.example.testjpahql.service;

import org.example.testjpahql.entity.dto.SerieDTO;

import java.util.List;

public interface ISerieService {

    List<SerieDTO> getSerieWithSeasons(Integer seasonsNum);
}
