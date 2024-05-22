package com.example.showroom.service.Impl;

import com.example.showroom.model.Clothes;
import com.example.showroom.model.dto.RequesUpdateClotheDTO;
import com.example.showroom.model.dto.RequestAddClotheDTO;
import com.example.showroom.repository.ClothesRepository;
import com.example.showroom.service.IClothesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ClothesService implements IClothesService {

    @Autowired
    ClothesRepository clothesRepository;

    @Override
    public String createClothes(RequestAddClotheDTO clothes) {
        clothesRepository.save(clothesDtoToClothes(clothes));
        return "Se ha creado con exito";
    }

    @Override
    public RequestAddClotheDTO getClothes(String id) {
        return clothesToClothesDto(clothesRepository.findById(id).orElse(null));
    }

    @Override
    public List<RequestAddClotheDTO> getAllClothes() {
        return StreamSupport.stream(clothesRepository.findAll().spliterator(), false)
                .map(this::clothesToClothesDto)
                .collect(Collectors.toList());
    }

    @Override
    public String updateClothes(RequesUpdateClotheDTO clothes) {
        Clothes clothe = clothesDtoUToClothes(clothes);
        Optional<Clothes> clothesExist = clothesRepository.findById(clothes.getId());
        if(clothesExist.isEmpty())
            return "Clothes doesn't exist";

        clothesRepository.save(clothe);
        return "Clothes update";
    }

    @Override
    public String deleteClothes(String id) {
        Optional<Clothes> clothes = clothesRepository.findById(id);
        if (clothes.isEmpty())
            return "Clothes does not exists";
        clothesRepository.delete(clothes.get());
        return "Clothe id " + id +"delete";
    }

    @Override
    public List<RequestAddClotheDTO> getAllClothesBySize(String size){
        return StreamSupport.stream(clothesRepository.findAllBySize(size).spliterator(), false)
                .map(this::clothesToClothesDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RequestAddClotheDTO> getAllClothesByName(String name)
    {
        return clothesRepository.findAllByBrandContains(name).stream()
                .map(this::clothesToClothesDto)
                .collect(Collectors.toList());
    }

    public Clothes clothesDtoToClothes(RequestAddClotheDTO clothesDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(clothesDto, Clothes.class);
    }

    public RequestAddClotheDTO clothesToClothesDto(Clothes clothes) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(clothes, RequestAddClotheDTO.class);
    }

    public Clothes clothesDtoUToClothes(RequesUpdateClotheDTO clothes) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(clothes, Clothes.class);
    }
}
