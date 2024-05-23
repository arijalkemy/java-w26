package org.example.showroom.service.impl;

import org.example.showroom.dto.clothe.ClotheRequestDto;
import org.example.showroom.dto.clothe.ClotheResponseDto;
import org.example.showroom.entity.Clothe;
import org.example.showroom.exception.NotFoundException;
import org.example.showroom.repository.IClotheRepository;
import org.example.showroom.service.IClothesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClothesServiceImpl implements IClothesService {
    private final IClotheRepository clotheRepository;

    public ClothesServiceImpl(@Autowired IClotheRepository clotheRepository) {
        this.clotheRepository = clotheRepository;
    }

    @Override
    @Transactional
    public ClotheResponseDto save(ClotheRequestDto requestDto) {
        ModelMapper modelMapper = new ModelMapper();
        Clothe saved = clotheRepository.save(modelMapper.map(requestDto, Clothe.class));
        return modelMapper.map(saved, ClotheResponseDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClotheResponseDto> getAll(String name) {
        if (!name.isEmpty()) {
            return mapListClothes(clotheRepository.findByNameContains(name));
        }
        return mapListClothes(clotheRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public ClotheResponseDto getClotheById(Long id) {
        ModelMapper modelMapper = new ModelMapper();
        Clothe find = findById(id);
        return modelMapper.map(find, ClotheResponseDto.class);
    }

    @Override
    @Transactional
    public ClotheResponseDto putClotheById(Long id, ClotheRequestDto requestDto) {
        findById(id);
        ModelMapper modelMapper = new ModelMapper();
        Clothe saved = modelMapper.map(requestDto, Clothe.class);
        saved.setId(id);
        return modelMapper.map(clotheRepository.save(saved), ClotheResponseDto.class);
    }

    @Override
    @Transactional
    public void deleteClotheById(Long id) {
        clotheRepository.deleteById(id);
    }

    @Override
    public List<ClotheResponseDto> getClotheBySize(String size) {
        return mapListClothes(clotheRepository.findBySize(size));
    }

    @Transactional
    protected Clothe findById(Long id) {
        return clotheRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
    }

    private List<ClotheResponseDto> mapListClothes(List<Clothe> clothes) {
        ModelMapper modelMapper = new ModelMapper();
        return clothes
                .stream().map(clothe -> modelMapper.map(clothe, ClotheResponseDto.class))
                .toList();
    }

    @Override
    public Clothe getClotheByIdEntity(Long id) {
        return clotheRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found"));
    }
}
