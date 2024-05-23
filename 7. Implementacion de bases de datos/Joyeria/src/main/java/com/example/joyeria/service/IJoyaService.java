package com.example.joyeria.service;

import com.example.joyeria.dto.IdDTO;
import com.example.joyeria.dto.JoyaDTO;
import com.example.joyeria.dto.ResponseDTO;

import java.util.List;

public interface IJoyaService {
    IdDTO createJoya(JoyaDTO joya);
    List<JoyaDTO> getAllJoyas();
    ResponseDTO deleteJoya(Long id);
    JoyaDTO updateJoya(Long id, JoyaDTO joya);

}
