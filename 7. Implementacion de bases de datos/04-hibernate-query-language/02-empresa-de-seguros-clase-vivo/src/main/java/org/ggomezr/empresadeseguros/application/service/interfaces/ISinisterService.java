package org.ggomezr.empresadeseguros.application.service.interfaces;

import org.ggomezr.empresadeseguros.domain.dto.ResponseDTO;
import org.ggomezr.empresadeseguros.domain.dto.SinisterDTO;

import java.util.List;

public interface ISinisterService {
    SinisterDTO createSinister(SinisterDTO sinisterDTO);
    List<SinisterDTO> createSinisters(List<SinisterDTO> sinisterDTOList);
    List<SinisterDTO> getAllSinisters();
    SinisterDTO getSinisterById(Long id);
    SinisterDTO updateSinister(Long id, SinisterDTO sinisterDTO);
    ResponseDTO deleteSinister(Long id);
}
