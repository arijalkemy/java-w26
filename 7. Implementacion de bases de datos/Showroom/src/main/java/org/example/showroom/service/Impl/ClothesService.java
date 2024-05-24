package org.example.showroom.service.Impl;

import org.example.showroom.exceptions.NotFoundException;
import org.example.showroom.models.Clothes;
import org.example.showroom.models.DTO.ClothesRequestDTO;
import org.example.showroom.models.DTO.ClothesResponseDTO;
import org.example.showroom.repository.IClothesRepository;
import org.example.showroom.service.IClothesService;
import org.example.showroom.service.IInternalClotheSaleService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService implements IClothesService, IInternalClotheSaleService {

    private final String NOT_FOUND_MESSAGE= "the clothing with the code provided does not exist";

    private final ModelMapper mapper;

    private final IClothesRepository clothesRepository;

    public ClothesService(IClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
        mapper=new ModelMapper();
    }

    @Override
    public ClothesResponseDTO findByCode(Long code) {
        return convertModelToDTO(foundByCode(code));
    }

    @Override
    public ClothesResponseDTO createNewClothes(ClothesRequestDTO newClothe) {
        Clothes clothe = this.convertDTOtoModel(newClothe);
        clothe = clothesRepository.save(clothe);
        return convertModelToDTO(clothe);
    }

    @Override
    public List<ClothesResponseDTO> findAllClothes() {
        return clothesRepository.findAll()
                .stream()
                .map(this::convertModelToDTO)
                .toList();
    }

    @Override
    public ClothesResponseDTO updateClotheByCode(Long code, ClothesRequestDTO clothe) {
        foundByCode(code);
        Clothes clotheToUpdate = convertDTOtoModel(clothe);
        clotheToUpdate.setCode(code);
        clotheToUpdate = clothesRepository.save(clotheToUpdate);
        return convertModelToDTO(clotheToUpdate);
    }

    @Override
    public String deleteClotheByCode(Long code) {
        foundByCode(code);
        clothesRepository.deleteById(code);
        return "The clothes was deleted successfully";
    }

    @Override
    public List<ClothesResponseDTO> findClothesBySize(String size) {
        return clothesRepository.findAllBySize(size)
                .stream()
                .map(this::convertModelToDTO)
                .toList();
    }

    @Override
    public List<ClothesResponseDTO> findClothesByName(String name) {
        return clothesRepository.findAllByNameContainingIgnoreCase(name)
                .stream()
                .map(this::convertModelToDTO)
                .toList();
    }

    public Clothes foundByCode(Long code){
        return clothesRepository.findById(code).orElseThrow(()->
                new NotFoundException(NOT_FOUND_MESSAGE));
    }

    private Clothes convertDTOtoModel(ClothesRequestDTO clothe){
        return mapper.map(clothe,Clothes.class);
    }
    private ClothesResponseDTO convertModelToDTO(Clothes clothe){
        return mapper.map(clothe,ClothesResponseDTO.class);
    }
}
