package meli.bootcamp.jewelry.dto.mapper;

import meli.bootcamp.jewelry.dto.JewelRequestDTO;
import meli.bootcamp.jewelry.dto.JewelResponseDTO;
import meli.bootcamp.jewelry.entity.Jewel;
import org.modelmapper.ModelMapper;

public class Mapper {
    static ModelMapper mapper = new ModelMapper();

    public static JewelResponseDTO toDto(Jewel jewel){
        return mapper.map(jewel, JewelResponseDTO.class);
    }

    public static Jewel toEntity(JewelRequestDTO jewelDTO){
        return mapper.map(jewelDTO, Jewel.class);
    }

    public static Jewel toEntity(JewelResponseDTO jewelDTO){
        return mapper.map(jewelDTO, Jewel.class);
    }
}
