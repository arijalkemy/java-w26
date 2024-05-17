package co.com.mercadolibre.miniseries.service;

import co.com.mercadolibre.miniseries.dto.MiniSerieDTO;

import java.util.List;

public interface IMiniSerieService {
    MiniSerieDTO create(MiniSerieDTO miniSerieDTO);
    List<MiniSerieDTO> findAll();
    MiniSerieDTO findById(Long id);
    MiniSerieDTO update(MiniSerieDTO miniSerieDTO, Long id);
    Boolean delete(Long id);
}
