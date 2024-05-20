package com.backendbootcamp.firstcrud.service;

import com.backendbootcamp.firstcrud.model.Jewel;
import com.backendbootcamp.firstcrud.model.ResponseDto;

import java.util.List;

public interface IJewelService {
    ResponseDto saveJewel(Jewel jewel);
    List<Jewel> getAllJewels();
    ResponseDto deleteJewel(Long id);
}
