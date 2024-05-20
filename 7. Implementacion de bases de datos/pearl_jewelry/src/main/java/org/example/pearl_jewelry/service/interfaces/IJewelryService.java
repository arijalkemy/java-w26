package org.example.pearl_jewelry.service.interfaces;

import org.example.pearl_jewelry.dto.JewelDto;
import org.example.pearl_jewelry.dto.SuccessDto;
import org.example.pearl_jewelry.dto.UpdateDto;

import java.util.List;

public interface IJewelryService {
    SuccessDto createJewel(JewelDto newJewel);
    List<JewelDto> getJewelList();
    SuccessDto deleteJewel(Long id);
    UpdateDto updateJewel(Long id, JewelDto updatedJewel);
}
