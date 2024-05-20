package org.example.jewels.service;

import org.example.jewels.dto.JewelDto;
import org.example.jewels.dto.SuccessDto;

public interface IJewelsService {
    SuccessDto createJewel(JewelDto newJewel);
}
