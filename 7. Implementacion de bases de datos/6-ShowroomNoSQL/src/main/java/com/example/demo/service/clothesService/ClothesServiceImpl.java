package com.example.demo.service.clothesService;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.clothesDTO.ClothesRequestDTO;
import com.example.demo.model.dto.clothesDTO.ClothesResponseDTO;
import com.example.demo.model.entity.Clothes;
import com.example.demo.repository.IClothesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesServiceImpl implements IClothesService {

    private final IClothesRepository clothesRepository;

    private final ObjectMapper objectMapper;

    public ClothesServiceImpl(IClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public ClothesResponseDTO createClothes(ClothesRequestDTO clothesRequestDTO) {
        Clothes savedClothes = clothesRepository.save(mapToEntity(clothesRequestDTO));
        return mapToDTO(savedClothes);
    }

    @Override
    public List<ClothesResponseDTO> getAllClothes(){
        List<Clothes> allClothes = (List<Clothes>) clothesRepository.findAll();
        return allClothes.stream().map(this::mapToDTO).toList();
    }

    @Override
    public ClothesResponseDTO getClothesByCode(Long code) {
        Clothes clothes = clothesRepository.findByCode(code);
        if (clothes != null) {
            return mapToDTO(clothes);
        } else {
            throw new NotFoundException("Clothes with code " + code + " not found");
        }
    }

    @Override
    public ClothesResponseDTO updateClothes(Long code, ClothesRequestDTO clothesRequestDTO) {
        Clothes clothes = mapToEntity(clothesRequestDTO);
        clothes.setCode(code);
        Clothes savedClothes = clothesRepository.save(clothes);
        return mapToDTO(savedClothes);
    }

    @Override
    public String deleteClothes(Long code) {
        Clothes clothes = clothesRepository.findByCode(code);
        clothesRepository.delete(clothes);
        return "Se elimino con exito";
    }

    @Override
    public List<ClothesResponseDTO> getClothesBySize(String size) {
        return clothesRepository.findBySize(size).stream().map(this::mapToDTO).toList();
    }

    @Override
    public List<ClothesResponseDTO> getClothesByType(String type) {
        return clothesRepository.findByType(type).stream().map(this::mapToDTO).toList();
    }

    private Clothes mapToEntity(ClothesRequestDTO clothesRequestDTO) {
        //return objectMapper.convertValue(clothesRequestDTO, Clothes.class);
        Clothes clothes = new Clothes();
        clothes.setName(clothesRequestDTO.getName());
        clothes.setType(clothesRequestDTO.getType());
        clothes.setBrand(clothesRequestDTO.getBrand());
        clothes.setColor(clothesRequestDTO.getColor());
        clothes.setSize(clothesRequestDTO.getSize());
        clothes.setAmount(clothesRequestDTO.getAmount());
        clothes.setSalePrice(clothesRequestDTO.getSalePrice());
        return clothes;
    }

    private ClothesResponseDTO mapToDTO(Clothes clothes) {
        //return objectMapper.convertValue(clothes, ClothesResponseDTO.class);
        return new ClothesResponseDTO(
                clothes.getCode(),
                clothes.getName(),
                clothes.getType(),
                clothes.getBrand(),
                clothes.getColor(),
                clothes.getSize(),
                clothes.getAmount(),
                clothes.getSalePrice());
    }
}
