package com.mercadolibre.ejerciciodeportistas.service;

import com.mercadolibre.ejerciciodeportistas.model.dto.SportPersonDTO;
import com.mercadolibre.ejerciciodeportistas.model.entity.Person;

import java.util.List;

public interface IPersonService {
    public List<SportPersonDTO> findAll();
}
