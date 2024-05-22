package com.bootcamp.jewerly.mapper;

import com.bootcamp.jewerly.dto.JewerlyDTO;
import com.bootcamp.jewerly.model.Jewerly;
import org.modelmapper.ModelMapper;

import java.util.List;

public class JewerlyMapper {

    public static JewerlyDTO jewerlyToJewerlyDTO (Jewerly jewerly){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(jewerly, JewerlyDTO.class);
    }

    public static Jewerly jewerlyDTOToJewerly (JewerlyDTO jewerlyDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(jewerlyDTO, Jewerly.class);
    }

    public static List<JewerlyDTO> jewerlyListToJewerlyDTOList (List<Jewerly> jewerlyList){
        return jewerlyList.stream().map(JewerlyMapper::jewerlyToJewerlyDTO).toList();
    }

}
