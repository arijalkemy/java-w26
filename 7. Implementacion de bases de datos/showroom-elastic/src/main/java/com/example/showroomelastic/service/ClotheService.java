package com.example.showroomelastic.service;

import com.example.showroomelastic.dto.PrendaRequestDto;
import com.example.showroomelastic.dto.PrendaResponseDto;
import com.example.showroomelastic.models.Clothe;
import com.example.showroomelastic.repository.IClotheRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClotheService implements IClotheService {

    @Autowired
    IClotheRepository clotheRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PrendaResponseDto> getAll() {
        return clotheRepository
                .findAll()
                .stream()
                .map(element -> modelMapper.map(element, PrendaResponseDto.class))
                .toList();
    }

    @Override
    public PrendaResponseDto getClotheById(String id) {
        return modelMapper.map(clotheRepository.findById(id), PrendaResponseDto.class);
    }

    @Override
    public PrendaResponseDto createClothe(PrendaRequestDto prendaRequestDto) {
        return modelMapper.map(clotheRepository.save(modelMapper.map(prendaRequestDto, Clothe.class)), PrendaResponseDto.class);
    }

    @Override
    public PrendaResponseDto updateClothe(String id, PrendaRequestDto prendaRequestDto) {
        if(!existsById(id))
            throw new RuntimeException("La prenda no existe");

        Clothe clothe = modelMapper.map(prendaRequestDto, Clothe.class);
        clothe.setId(id);
        clotheRepository.save(clothe);
        return modelMapper.map(clothe, PrendaResponseDto.class);
    }

    @Override
    public String deleteClothe(String id) {
        if(!existsById(id))
            throw new RuntimeException("La prenda no existe");

        clotheRepository.deleteById(id);
        return "Clothe product removed successfully";
    }

    @Override
    public List<PrendaResponseDto> getClothesBySize(String size) {
        return clotheRepository.findBySize(size)
                .stream()
                .map(element -> modelMapper.map(element, PrendaResponseDto.class))
                .toList();
    }

    @Override
    public List<PrendaResponseDto> searchClothes(String name) {
        return clotheRepository.findByNombreContaining(name)
                .stream()
                .map(element -> modelMapper.map(element, PrendaResponseDto.class))
                .toList();
    }

    private Boolean existsById(String id) {
        return clotheRepository.existsById(id);
    }
}
