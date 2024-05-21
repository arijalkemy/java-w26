package org.example.joyeria.service;

import org.example.joyeria.dto.JoyaDTO;
import org.example.joyeria.dto.JoyaDTOReq;

import java.util.List;

public interface IJoyasService {
    public List<JoyaDTO> findAll();
    public JoyaDTO update(Long id, JoyaDTOReq joya);
    public JoyaDTO delete(Long id);
    public JoyaDTO create(JoyaDTOReq joyaDTO);
}
