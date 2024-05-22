package com.showroom.showroomelastic.service;

import com.showroom.showroomelastic.dto.ClothResponseDTO;
import com.showroom.showroomelastic.model.Cloth;
import com.showroom.showroomelastic.repository.ClothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothServiceImpl implements IClothService{

    @Autowired
    private ClothRepository clothRepository;

    @Override
    public String save(Cloth cloth) {
        clothRepository.save(cloth);
        return cloth.getId();
    }

    @Override
    public List<ClothResponseDTO> getAll() {

        return clothRepository.findAll().stream().map(ClothServiceImpl::mapClothResponseDTO).toList();
    }

    @Override
    public ClothResponseDTO getById(String id) {
        System.out.println(clothRepository.findById(id));
        return mapClothResponseDTO(clothRepository.findById(id).get());
    }

    @Override
    public ClothResponseDTO update(String id, Cloth cloth) {
        cloth.setId( id );
        clothRepository.save(cloth);
        return mapClothResponseDTO(cloth);
    }

    @Override
    public String delete(String id) {
        clothRepository.deleteById(id);
        return "Deleted Cloth with id: " + id;
    }

    @Override
    public List<ClothResponseDTO> getClothBySize(String size) {
        return clothRepository.findClothBySize(size).stream().map(ClothServiceImpl::mapClothResponseDTO).toList();
    }

    @Override
    public List<ClothResponseDTO> getClothByName(String name) {
        return clothRepository.findClothByNameContaining(name).stream().map(ClothServiceImpl::mapClothResponseDTO).toList();
    }

    static public ClothResponseDTO mapClothResponseDTO(Cloth cloth) {
        return ClothResponseDTO.builder()
                .name(cloth.getName())
                .brand(cloth.getBrand())
                .color(cloth.getColor())
                .type(cloth.getType())
                .sellPrice(cloth.getSellPrice())
                .size(cloth.getSize())
                .amount(cloth.getAmount()).build();
    }
}
