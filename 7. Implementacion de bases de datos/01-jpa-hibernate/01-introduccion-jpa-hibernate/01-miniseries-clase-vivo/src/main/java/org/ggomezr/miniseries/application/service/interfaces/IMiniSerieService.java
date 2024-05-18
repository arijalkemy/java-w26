package org.ggomezr.miniseries.application.service.interfaces;

import org.ggomezr.miniseries.domain.dto.MiniSerieDTO;
import org.ggomezr.miniseries.domain.dto.ResponseDTO;

import java.util.List;

public interface IMiniSerieService {
    MiniSerieDTO createMiniserie(MiniSerieDTO miniSerieDTO);
    MiniSerieDTO getMiniSerieById(Long id);
    MiniSerieDTO updateMiniSerie(MiniSerieDTO miniSerieDTO, Long id);
    ResponseDTO deleteMiniSerie(Long id);
    List<MiniSerieDTO> getAllMiniSeries();
}
