package org.ggomezr.joyerialasperlas.application.service.interfaces;

import org.ggomezr.joyerialasperlas.domain.dto.JoyaDTO;
import org.ggomezr.joyerialasperlas.domain.dto.ResposeDTO;

import java.util.List;

public interface IJoyaService {
    ResposeDTO createJoya(JoyaDTO joyaDTO);
    JoyaDTO getJoyaById(Long id);
    List<JoyaDTO> getAll();
    ResposeDTO deleteJoya(Long id);
    ResposeDTO updateJoya(Long id, JoyaDTO joyaDTO);
}
