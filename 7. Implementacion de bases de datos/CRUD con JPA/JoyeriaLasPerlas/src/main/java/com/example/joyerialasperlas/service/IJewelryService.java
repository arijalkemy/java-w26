package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.model.Jewelry;

import java.util.List;

public interface IJewelryService {
    void saveJewelry(Jewelry jewelry);
    List<Jewelry> getAllJewelry();
    void deleteJewelry(Long id);
    Jewelry updateJewelry(Long id, Jewelry updatedJewelry);
}
