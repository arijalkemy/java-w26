package org.bootcamp.showroom.services.impl;

import lombok.RequiredArgsConstructor;
import org.bootcamp.showroom.dtos.ClotheResponseDto;
import org.bootcamp.showroom.dtos.ClotheUpdateDto;
import org.bootcamp.showroom.dtos.ClothesRequestDto;
import org.bootcamp.showroom.dtos.MessageResponseDTO;
import org.bootcamp.showroom.entities.Clothe;
import org.bootcamp.showroom.exceptions.NotFoundException;
import org.bootcamp.showroom.repository.IClothesRepository;
import org.bootcamp.showroom.services.IClothesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothesServiceImpl implements IClothesService {

    private final IClothesRepository clothesRepository;
    private final ModelMapper mapper;

    @Override
    public ClotheResponseDto create(ClothesRequestDto clothe) {
        Clothe savedClothe = clothesRepository
                .save(mapper.map(clothe, Clothe.class));

        return mapper.map(savedClothe, ClotheResponseDto.class);
    }

    @Override
    public List<ClotheResponseDto> getAllClothes() {
        return clothesRepository.findAll()
                .stream()
                .map(clothe -> mapper.map(clothe, ClotheResponseDto.class))
                .toList();
    }

    @Override
    public ClotheResponseDto getByCode(String code) {
        Clothe clothe = clothesRepository.findClotheByCode(code)
                .orElseThrow(() -> new NotFoundException("No encontrado"));

        return mapper.map(clothe, ClotheResponseDto.class);
    }

    @Override
    public ClotheResponseDto update(String code, ClotheUpdateDto clothe) {
        Clothe foundedClothe = clothesRepository.findClotheByCode(code)
                .orElseThrow(() -> new NotFoundException("No encontrado"));

        foundedClothe.builder()
                .name(clothe.getName())
                .code(clothe.getCode())
                .brand(clothe.getBrand())
                .colour(clothe.getColour())
                .waist(clothe.getWaist())
                .clotheType(clothe.getType())
                .amount(clothe.getAmount())
                .salePrice(clothe.getSalePrice())
                .build();

        clothesRepository.save(foundedClothe);
        return mapper.map(foundedClothe, ClotheResponseDto.class);
    }

    @Override
    public MessageResponseDTO delete(String code) {
        Clothe foundedClothe = clothesRepository.findClotheByCode(code)
                .orElseThrow(() -> new NotFoundException("No encontrado"));

        clothesRepository.delete(foundedClothe);
        return new MessageResponseDTO("Eliminado correctamente");
    }


    @Override
    public List<ClotheResponseDto> getAllClothesByWaist(String waist) {
        return clothesRepository.findClotheByWaistEquals(waist)
                .stream()
                .map(clothe -> mapper.map(clothe, ClotheResponseDto.class))
                .toList();
    }

    @Override
    public List<ClotheResponseDto> getAllClothesByName(String name) {
        return clothesRepository.findClotheByNameIgnoreCase(name)
                .stream()
                .map(clothe -> mapper.map(clothe, ClotheResponseDto.class))
                .toList();
    }
}
