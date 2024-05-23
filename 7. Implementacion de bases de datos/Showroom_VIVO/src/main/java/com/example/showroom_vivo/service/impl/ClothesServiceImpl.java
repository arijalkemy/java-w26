package com.example.showroom_vivo.service.impl;

import com.example.showroom_vivo.dto.ClothesDTO;
import com.example.showroom_vivo.dto.ResponseDTO;
import com.example.showroom_vivo.model.Clothes;
import com.example.showroom_vivo.repository.ClothesRepository;
import com.example.showroom_vivo.service.IClothesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothesServiceImpl implements IClothesService {
    @Autowired
    ClothesRepository clothesRepository;

    @Override
    public ResponseDTO createClothes(ClothesDTO clothes) {
        Clothes newClothes = clothesRepository.save(clothesDTOToClothes(clothes));
        String message = "The clothes "+ newClothes.getCode()+" has been created";
        return new ResponseDTO(message);
    }

    @Override
    public List<ClothesDTO> getAllClothes() {
        List<ClothesDTO> clothesList = new ArrayList<>();
        for(Clothes c: clothesRepository.findAll()){
            clothesList.add(clothesToClothesDTO(c));
        }
        return clothesList;
    }

    @Override
    public ClothesDTO getClothesById(Long id) {
        return clothesToClothesDTO(clothesRepository.findById(id).orElse(null));
    }

    @Override
    public ResponseDTO updateClothes(Long id, ClothesDTO clothes) {
        clothes.setCode(id);
        clothesRepository.save(clothesDTOToClothes(clothes));
        String message = "The clothes "+ id+" has been updated";
        return new ResponseDTO(message);
    }

    @Override
    public ResponseDTO deleteClothes(Long id) {
        clothesRepository.deleteById(id);
        String message = "The clothes "+ id+" has been deleted";
        return new ResponseDTO(message);
    }

    @Override
    public List<ClothesDTO> getClothesBySize(Double size) {
        List<Clothes> clothes = clothesRepository.findBySize(size);
        return clothes.stream().map(this::clothesToClothesDTO).collect(Collectors.toList());
    }

    @Override
    public List<ClothesDTO> getClothesByName(String name) {
        List<Clothes> clothesL = clothesRepository.findClothesByNameContainsIgnoreCase(name.toLowerCase());
        return clothesL.stream().map(this::clothesToClothesDTO).collect(Collectors.toList());
    }

    public Clothes clothesDTOToClothes(ClothesDTO clothes){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(clothes, Clothes.class);
    }

    public ClothesDTO clothesToClothesDTO(Clothes clothes){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(clothes, ClothesDTO.class);
    }
}
