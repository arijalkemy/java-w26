package com.bootcamp.jewerly.service;

import java.util.List;

import com.bootcamp.jewerly.dto.JewerlyDTO;
import com.bootcamp.jewerly.dto.ResponseDTO;

public interface IJewerlyService {

    List<JewerlyDTO> getAll();

    ResponseDTO create(JewerlyDTO jewerlyDto);

    ResponseDTO delete(long id);

    JewerlyDTO getById(long id);

    JewerlyDTO update(JewerlyDTO jewerlyDto);

}
