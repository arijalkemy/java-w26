package com.example.joyeria.service;

import com.example.joyeria.model.Jewel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IJewelryService {
    ResponseEntity<?> saveJewel(Jewel jewel);
    List<Jewel> getJewels();

    ResponseEntity<?> deleteJewel(Long id);

    ResponseEntity<?> editJewel(Long idModificar, Jewel jewel);

}
