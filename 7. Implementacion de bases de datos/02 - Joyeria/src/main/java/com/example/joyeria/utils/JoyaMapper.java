package com.example.joyeria.utils;

import com.example.joyeria.dto.request.JoyaRequestDto;
import com.example.joyeria.dto.response.JoyaResponseDto;
import com.example.joyeria.model.Joya;
import org.modelmapper.ModelMapper;

public class JoyaMapper {
    static ModelMapper mapper = new ModelMapper();

    public static Joya mapRequestToEntity(JoyaRequestDto joyaDto){
        return mapper.map(joyaDto, Joya.class);
    }

    public static JoyaResponseDto mapEntityToResponse(Joya joya){
        return mapper.map(joya, JoyaResponseDto.class);
    }

}
