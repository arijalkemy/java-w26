package com.example.movieshqlasync.service;

import com.example.movieshqlasync.dto.request.ClotheRequestDto;
import com.example.movieshqlasync.dto.response.ClotheResponseDto;

import java.util.List;

public interface IClotheService {
    ClotheResponseDto addClothe(ClotheRequestDto clotheRequestDto);
    List<ClotheResponseDto> getAllClothes();
    ClotheResponseDto getClotheById(int id);
    ClotheResponseDto editClothe(int id, ClotheRequestDto clotheRequestDto);
    void deleteClothe(int id);
    List<ClotheResponseDto> getClothesBySize(String size);
    List<ClotheResponseDto> getClothesByTShirt(String name);
}
