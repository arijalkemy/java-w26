package org.bootcamp.joyeria.service;

import org.bootcamp.joyeria.dto.RequestJewelryDTO;
import org.bootcamp.joyeria.dto.ResponseJewelryDTO;

import java.util.List;

public interface IJewelryService {
    ResponseJewelryDTO createJewelry(RequestJewelryDTO requestJewelryDTO);
    List<ResponseJewelryDTO> getAllJewelry();
    Void deleteJewelry(int id);
    ResponseJewelryDTO updateJewelry(int id, RequestJewelryDTO requestJewelryDTO);
}