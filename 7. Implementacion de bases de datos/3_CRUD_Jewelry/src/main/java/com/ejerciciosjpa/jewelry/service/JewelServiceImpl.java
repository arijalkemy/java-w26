package com.ejerciciosjpa.jewelry.service;

import com.ejerciciosjpa.jewelry.dto.JewelResponseDto;
import com.ejerciciosjpa.jewelry.entity.Jewel;
import com.ejerciciosjpa.jewelry.repository.IJewelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelServiceImpl implements IJewelService{

    @Autowired
    IJewelRepository jewelRepository;
    @Override
    public JewelResponseDto create(Jewel jewel) {
        JewelResponseDto jewelResponseDto = new JewelResponseDto();
        jewelRepository.save(jewel);
        jewelResponseDto.setNroIdentificatorio(jewel.getNroIdentificatorio());
        jewelResponseDto.setNombre(jewel.getNombre());
        return jewelResponseDto;
    }

    @Override
    public List<Jewel> getJewelCatalogue() {
        List<Jewel> jewelsWithoutFilter = jewelRepository.findAll();
        return jewelsWithoutFilter.stream().filter(e-> e.getVentaONo().equals(true)).toList();
    }

    @Override
    public void deleteJewel(Long id) {
        Jewel jewelToDelete = jewelRepository.getReferenceById(id);
        jewelToDelete.setVentaONo(false);
        jewelRepository.save(jewelToDelete);
    }

    @Override
    public Jewel update(Long id, Jewel jewel) {
        ModelMapper modelMapper = new ModelMapper();
        Jewel jewelToUpdate = jewelRepository.getReferenceById(id);
        jewelToUpdate.setNroIdentificatorio(jewel.getNroIdentificatorio());
        modelMapper.map(jewel,jewelToUpdate);
        jewelRepository.save(jewelToUpdate);
        return jewel;
    }
}
