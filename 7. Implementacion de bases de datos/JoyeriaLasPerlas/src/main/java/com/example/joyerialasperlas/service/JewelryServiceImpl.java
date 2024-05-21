package com.example.joyerialasperlas.service;

import org.modelmapper.ModelMapper;
import com.example.joyerialasperlas.dto.JewelryDto;
import com.example.joyerialasperlas.entity.Jewelry;
import com.example.joyerialasperlas.exception.NotFoundException;
import com.example.joyerialasperlas.repository.JewelryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelryServiceImpl implements IJewelryService {


    @Autowired
    JewelryRepository jewelryRepository;


    ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional
    public String createJewelry(JewelryDto jewelryDto) {
        Jewelry jewelry = jewelryRepository.save(dtoToEntity(jewelryDto));
        return "Jewelry created with id: " + jewelry.getId();
    }

    @Override
    public List<JewelryDto> getAllJewelry() {
        List<Jewelry> jewelryList = jewelryRepository.findAll();
        return jewelryList.stream().map(this::entityToDto).toList();
    }

    @Override
    public String deleteJewelry(Long id) {
        Jewelry jewelry = jewelryRepository.findById(id).orElse(null);
        if (jewelry == null)
            throw new NotFoundException("Jewelry with id: " + id + " not found");
        jewelry.setSaleOrNot(false);
        jewelryRepository.save(jewelry);
        return "Jewelry with id: " + id + " deleted";
    }

    @Override
    public JewelryDto updateJewelry(Long id, JewelryDto updatedJewelry) {
        Jewelry jewelry = jewelryRepository.findById(id).orElse(null);
        if (jewelry == null)
            throw new NotFoundException("Jewelry with id: " + id + " not found");
        jewelry.setName(updatedJewelry.getName());
        jewelry.setMaterial(updatedJewelry.getMaterial());
        jewelry.setWeight(updatedJewelry.getWeight());
        jewelry.setDescription(updatedJewelry.getDescription());
        jewelry.setHasGem(updatedJewelry.isHasGem());
        jewelry.setSaleOrNot(updatedJewelry.isSaleOrNot());
        jewelryRepository.save(jewelry);
        return entityToDto(jewelry);
    }


    private Jewelry dtoToEntity(JewelryDto jewelryDto) {
        Jewelry jewelry = modelMapper.map(jewelryDto, Jewelry.class);
        jewelry.setSaleOrNot(true);
        return jewelry;
    }

    private JewelryDto entityToDto(Jewelry jewelry) {
       return modelMapper.map(jewelry, JewelryDto.class);
    }
}
