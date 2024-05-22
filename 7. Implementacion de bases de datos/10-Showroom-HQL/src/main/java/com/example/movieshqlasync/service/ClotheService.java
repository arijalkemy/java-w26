package com.example.movieshqlasync.service;

import com.example.movieshqlasync.controller.ClotheController;
import com.example.movieshqlasync.dto.request.ClotheRequestDto;
import com.example.movieshqlasync.dto.response.ClotheResponseDto;
import com.example.movieshqlasync.model.Clothe;
import com.example.movieshqlasync.repository.IClotheRepository;
import com.example.movieshqlasync.utils.ClotheMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClotheService implements IClotheService{
    @Autowired
    IClotheRepository iClotheRepository;

    @Override
    public ClotheResponseDto addClothe(ClotheRequestDto clotheRequestDto) {
        Clothe clothe = ClotheMapper.mapToEntity(clotheRequestDto);

        return ClotheMapper.mapToResponseDto(iClotheRepository.save(clothe));
    }

    @Override
    public List<ClotheResponseDto> getAllClothes() {
        return ClotheMapper.mapToListResponseDto(iClotheRepository.findAll());
    }

    @Override
    public ClotheResponseDto getClotheById(int id) {
        return ClotheMapper.mapToResponseDto(iClotheRepository.findById(id).orElseThrow());
    }

    @Override
    public ClotheResponseDto editClothe(int id, ClotheRequestDto clotheRequestDto) {
        Clothe clothe = iClotheRepository.findById(id).orElseThrow();

        clothe.setNombre(clotheRequestDto.getNombre());
        clothe.setMarca(clotheRequestDto.getMarca());
        clothe.setColor(clotheRequestDto.getColor());
        clothe.setTipo(clotheRequestDto.getTipo());
        clothe.setTalle(clotheRequestDto.getTalle());
        clothe.setPrecio(clotheRequestDto.getPrecio());
        clothe.setCantidad(clotheRequestDto.getCantidad());

        return ClotheMapper.mapToResponseDto(iClotheRepository.save(clothe));
    }

    @Override
    public void deleteClothe(int id) {
        Clothe clothe = iClotheRepository.findById(id).orElseThrow();

        iClotheRepository.delete(clothe);
    }

    @Override
    public List<ClotheResponseDto> getClothesBySize(String size) {
        return ClotheMapper.mapToListResponseDto(iClotheRepository.findAllByTalle(size));
    }

    @Override
    public List<ClotheResponseDto> getClothesByTShirt(String name) {
        return ClotheMapper.mapToListResponseDto(iClotheRepository.findAllByNombreContains(name));
    }
}
