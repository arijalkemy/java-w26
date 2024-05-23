package org.ggomezr.showroomelasticsearch.application.service.impl;

import org.ggomezr.showroomelasticsearch.application.service.interfaces.IClothingService;
import org.ggomezr.showroomelasticsearch.domain.dto.ClothingDTO;
import org.ggomezr.showroomelasticsearch.domain.dto.ResponseDTO;
import org.ggomezr.showroomelasticsearch.domain.exception.NotFoundException;
import org.ggomezr.showroomelasticsearch.domain.model.Clothing;
import org.ggomezr.showroomelasticsearch.domain.repository.IClothingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

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
        List<Clothing> savedClothingList = (List<Clothing>) clothingRepository.saveAll(clothingList);
        return savedClothingList.stream()
                .map(this::convertToDto).toList();
    }

    @Override
    public List<ClothingDTO> getAllClothing() {
        Iterable<Clothing> clothingList = clothingRepository.findAll();
        Stream<Clothing> clothingStream = StreamSupport.stream(clothingList.spliterator(), false);
        return clothingStream
                .map(this::convertToDto).toList();
    }

    @Override
    public ClothingDTO getClothingById(String id) {
        Optional<Clothing> existingClothing = clothingRepository.findById(id);
        if(existingClothing.isEmpty()) throw new NotFoundException("Clothing not found");

        return convertToDto(existingClothing.get());
    }

    @Override
    public ClothingDTO updateClothing(String id, ClothingDTO clothingDTO) {
        Optional<Clothing> existingClothing = clothingRepository.findById(id);
        if(existingClothing.isEmpty()) throw new NotFoundException("Clothing not found");

        Clothing clothing = convertToEntity(clothingDTO);
        clothing.setCode(id);

        Clothing updatedClothing = clothingRepository.save(clothing);
        return convertToDto(updatedClothing);
    }

    @Override
    public ResponseDTO deleteClothing(String id) {
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