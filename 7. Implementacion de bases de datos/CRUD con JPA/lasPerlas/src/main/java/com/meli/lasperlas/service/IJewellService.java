package com.meli.lasperlas.service;

import com.meli.lasperlas.dto.NewJewellResponseDTO;
import com.meli.lasperlas.dto.RequestJewellDTO;
import com.meli.lasperlas.dto.RequestUpdateJewellDTO;
import com.meli.lasperlas.dto.ResponseJewellDTO;

import java.util.List;

public interface IJewellService {
    List<ResponseJewellDTO> getJewells();
    NewJewellResponseDTO saveJewell(RequestJewellDTO jewell);
    void deleteJewell(Long id);
    ResponseJewellDTO update(Long id, RequestUpdateJewellDTO requestUpdateJewellDTO);
    //JewellDTO findJewellById(Long id);

}
