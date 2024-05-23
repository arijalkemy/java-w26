package org.example.showroom.service;

import org.example.showroom.dto.clothe.ClotheRequestDto;
import org.example.showroom.dto.clothe.ClotheResponseDto;
import org.example.showroom.entity.Clothe;

import java.util.List;

public interface IClothesService {
    List<ClotheResponseDto> getAll(String name);

    ClotheResponseDto save(ClotheRequestDto requestDto);

    ClotheResponseDto getClotheById(Long id);

    ClotheResponseDto putClotheById(Long id, ClotheRequestDto requestDto);

    void deleteClotheById(Long id);

    List<ClotheResponseDto> getClotheBySize(String size);

    Clothe getClotheByIdEntity(Long id);
}
