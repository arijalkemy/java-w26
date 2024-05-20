package org.example.joyerialasperlas.service;

import org.example.joyerialasperlas.DTO.JoyaResquestDTO;

import java.util.List;
import java.util.UUID;

public interface IJoyeriaService {
   UUID saveJoyeria(JoyaResquestDTO joyaResquestDTO);
   List<JoyaResquestDTO> listAllJoyeria();
   JoyaResquestDTO updateJoyeria(UUID id, JoyaResquestDTO joyaResquestDTO);
    void deleteJoyeria(UUID id);
}
