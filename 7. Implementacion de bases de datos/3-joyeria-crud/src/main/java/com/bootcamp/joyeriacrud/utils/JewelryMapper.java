package com.bootcamp.joyeriacrud.utils;

import com.bootcamp.joyeriacrud.model.Jewelry;
import com.bootcamp.joyeriacrud.model.dto.JewelryRequestDTO;
import com.bootcamp.joyeriacrud.model.dto.JewelryResponseDTO;
import org.modelmapper.ModelMapper;

public class JewelryMapper {
    public static Jewelry mapRequestDTOToEntity(JewelryRequestDTO jewelryRequestDTO) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(jewelryRequestDTO, Jewelry.class);
    }

    public static JewelryRequestDTO mapEntityToRequestDTO(Jewelry jewelry) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(jewelry, JewelryRequestDTO.class);
    }

    public static JewelryResponseDTO mapEntityToResponseDTO(Jewelry jewelry) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(jewelry, JewelryResponseDTO.class);
    }
}
