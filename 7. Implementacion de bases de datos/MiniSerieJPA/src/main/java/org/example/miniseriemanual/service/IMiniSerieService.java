package org.example.miniseriemanual.service;

import org.example.miniseriemanual.dto.MiniSerieDto;
import org.example.miniseriemanual.model.MiniSerie;

public interface IMiniSerieService {
    MiniSerie save(MiniSerieDto miniSerie);
}
