package com.showroom.showroom.service;

import com.showroom.showroom.dto.ClothResponseDTO;
import com.showroom.showroom.model.Cloth;
import com.showroom.showroom.model.SaleDetail;
import com.showroom.showroom.repository.ClothRepository;
import com.showroom.showroom.repository.SaleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClothServiceImpl implements IClothService {

    @Autowired
    private ClothRepository clothRepository;

    @Autowired
    private SaleDetailRepository saleDetailRepository;

    @Override
    @Transactional
    public Long save(Cloth cloth) {
        clothRepository.save(cloth);
        return cloth.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClothResponseDTO> getAll() {
        return clothRepository.findAll().stream().map(ClothServiceImpl::mapClothResponseDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public ClothResponseDTO getById(Long id) {
        return mapClothResponseDTO(clothRepository.findClothById(id));
    }

    @Transactional
    @Override
    public ClothResponseDTO update(Long id, Cloth cloth) {
        cloth.setId(id);
        clothRepository.save(cloth);
        return mapClothResponseDTO(cloth);
    }

    @Override
    @Transactional
    public String delete(Long id) {
        List<SaleDetail> saleDetails = saleDetailRepository.findByClothId(id);
        if (!saleDetails.isEmpty()) {
            return "Cannot delete Cloth with id " + id + " because it is associated with sale details.";
        }

        clothRepository.deleteById(id);
        return "Deleted Cloth with id: " + id;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClothResponseDTO> getClothBySize(String size) {
        return clothRepository.findClothBySize(size).stream().map(ClothServiceImpl::mapClothResponseDTO).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClothResponseDTO> getClothByName(String name) {
        return clothRepository.findClothByNameContaining(name).stream().map(ClothServiceImpl::mapClothResponseDTO).toList();
    }

    static public ClothResponseDTO mapClothResponseDTO(Cloth cloth) {
        return ClothResponseDTO.builder()
                .name(cloth.getName())
                .brand(cloth.getBrand())
                .color(cloth.getColor())
                .type(cloth.getType())
                .sellPrice(cloth.getPrice())
                .size(cloth.getSize())
                .build();
    }
}
