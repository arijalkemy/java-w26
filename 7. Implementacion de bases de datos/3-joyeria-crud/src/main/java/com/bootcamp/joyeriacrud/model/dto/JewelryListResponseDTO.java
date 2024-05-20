package com.bootcamp.joyeriacrud.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class JewelryListResponseDTO {
    private List<JewelryResponseDTO> jewelryRequestDTOS;
}
