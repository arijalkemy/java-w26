package com.example.movieshqlasync.utils;

import com.example.movieshqlasync.dto.request.ClotheRequestDto;
import com.example.movieshqlasync.dto.response.ClotheResponseDto;
import com.example.movieshqlasync.model.Clothe;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ClotheMapper {
    public static List<ClotheResponseDto> mapToListResponseDto(List<Clothe> clothes){
        List<ClotheResponseDto> actorsResponse = new ArrayList<>();

        for (Clothe clothe : clothes){
            actorsResponse.add(mapToResponseDto(clothe));
        }

        return actorsResponse;
    }

    public static ClotheResponseDto mapToResponseDto(Clothe clothe){
        return new ModelMapper().map(clothe, ClotheResponseDto.class);
    }
    public static Clothe mapToEntity(ClotheRequestDto clotheRequestDto){
        return new ModelMapper().map(clotheRequestDto, Clothe.class);
    }
}
