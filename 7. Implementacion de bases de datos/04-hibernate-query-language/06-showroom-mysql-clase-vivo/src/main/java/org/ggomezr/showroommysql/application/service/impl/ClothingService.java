package org.ggomezr.showroommysql.application.service.impl;

import org.ggomezr.showroommysql.application.service.interfaces.IClothingService;
import org.ggomezr.showroommysql.domain.dto.ClothingDTO;
import org.ggomezr.showroommysql.domain.dto.ResponseDTO;
import org.ggomezr.showroommysql.domain.exception.NotFoundException;
import org.ggomezr.showroommysql.domain.model.Clothing;
import org.ggomezr.showroommysql.domain.repository.IClothingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothingService implements IClothingService {

    private final IClothingRepository clothingRepository;
    private final ModelMapper modelMapper;

    public ClothingService(IClothingRepository clothingRepository, ModelMapper modelMapper) {
        this.clothingRepository = clothingRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClothingDTO createClothing(ClothingDTO clothingDTO) {
        Clothing clothing = convertToEntity(clothingDTO);
        Clothing savedClothing = clothingRepository.save(clothing);
        return convertToDto(savedClothing);
    }

    @Override
    public List<ClothingDTO> createClothingBatch(List<ClothingDTO> clothingDTOList) {
        List<Clothing> clothingList = clothingDTOList.stream()
                .map(this::convertToEntity).toList();
        List<Clothing> savedClothingList = clothingRepository.saveAll(clothingList);
        return savedClothingList.stream()
                .map(this::convertToDto).toList();
    }

    @Override
    public List<ClothingDTO> getAllClothing() {
        List<Clothing> clothingList = clothingRepository.findAll();
        return clothingList.stream()
                .map(this::convertToDto).toList();
    }

    @Override
    public ClothingDTO getClothingById(Long id) {
        Optional<Clothing> existingClothing = clothingRepository.findById(id);
        if(existingClothing.isEmpty()) throw new NotFoundException("Clothing not found");

        return convertToDto(existingClothing.get());
    }

    @Override
    public ClothingDTO updateClothing(Long id, ClothingDTO clothingDTO) {
        Optional<Clothing> existingClothing = clothingRepository.findById(id);
        if(existingClothing.isEmpty()) throw new NotFoundException("Clothing not found");

        Clothing clothing = convertToEntity(clothingDTO);
        clothing.setCode(id);

        Clothing updatedClothing = clothingRepository.save(clothing);
        return convertToDto(updatedClothing);
    }

    @Override
    public ResponseDTO deleteClothing(Long id) {
        Optional<Clothing> existingClothing = clothingRepository.findById(id);
        if(existingClothing.isEmpty()) throw new NotFoundException("Clothing not found");

        clothingRepository.deleteById(id);
        return new ResponseDTO("Clothing deleted successfully");
    }

    @Override
    public List<ClothingDTO> getClothingBySize(String size) {
        List<Clothing> clothingList = clothingRepository.findBySize(size);
        return clothingList.stream()
                .map(this::convertToDto).toList();
    }

    @Override
    public List<ClothingDTO> getClothingByName(String name) {
        List<Clothing> clothingList = clothingRepository.findByNameEqualsIgnoreCase(name);
        return clothingList.stream()
                .map(this::convertToDto).toList();
    }

    private ClothingDTO convertToDto(Clothing clothing) {
        return modelMapper.map(clothing, ClothingDTO.class);
    }

    private Clothing convertToEntity(ClothingDTO clothingDTO) {
        return modelMapper.map(clothingDTO, Clothing.class);
    }
}
