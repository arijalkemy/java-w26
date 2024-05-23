package com.bootcamp.joyerialasperlas.service;

import com.bootcamp.joyerialasperlas.models.Jewel;

import java.util.List;

public interface IJewelryService {
    Jewel addJewel(Jewel j);

    List<Jewel> getAllJewels();

    Jewel deleteJewel(Long id);

    Jewel modifyJewelParticularity(Long id, Jewel j);
}
