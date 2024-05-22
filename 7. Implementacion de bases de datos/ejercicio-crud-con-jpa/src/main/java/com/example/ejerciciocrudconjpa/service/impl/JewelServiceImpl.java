package com.example.ejerciciocrudconjpa.service.impl;

import com.example.ejerciciocrudconjpa.dto.request.CreateJewelRequestDto;
import com.example.ejerciciocrudconjpa.dto.request.UpdateJewelRequestDto;
import com.example.ejerciciocrudconjpa.dto.response.JewelResponseDto;
import com.example.ejerciciocrudconjpa.dto.response.ResponseDto;
import com.example.ejerciciocrudconjpa.exception.NotFoundException;
import com.example.ejerciciocrudconjpa.model.Jewel;
import com.example.ejerciciocrudconjpa.repository.IJewelRepository;
import com.example.ejerciciocrudconjpa.service.IJewelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JewelServiceImpl implements IJewelService {
    @Autowired
    private IJewelRepository jewelRepository;

    @Override
    @Transactional
    public ResponseDto createJewel(CreateJewelRequestDto createJewelRequestDto) {
        Jewel jewel = new ModelMapper().map(createJewelRequestDto, Jewel.class);
        jewel.setVentaONo(true);
        jewelRepository.save(jewel);

        return ResponseDto.builder()
            .message("The jewel was saved successfully with id '" + jewel.getNroIdentificatorio()+"'")
            .build();
    }

    @Override
    @Transactional(readOnly = true)
    public List<JewelResponseDto> findAllJewels() {
        List<Jewel> jewels = jewelRepository.findAll();
        ModelMapper mapper = new ModelMapper();

        return jewels.stream().filter(Jewel::getVentaONo).map(jewel -> mapper.map(jewel, JewelResponseDto.class)).toList();
    }

    @Override
    @Transactional
    public void deleteJewel(Integer id) {
        Jewel jewel = jewelRepository.findById(id).orElseThrow(
            () -> new NotFoundException("No jewel found with id: " + id)
        );
        jewel.setVentaONo(false);
        jewelRepository.save(jewel);
    }

    @Override
    @Transactional
    public JewelResponseDto updateJewel(Integer id, UpdateJewelRequestDto updateJewelRequestDto) {
        Jewel jewel = jewelRepository.findById(id).orElseThrow(
            () -> new NotFoundException("No jewel found with id: " + id)
        );

        updateFields(jewel, updateJewelRequestDto);

        return new ModelMapper().map(
            jewelRepository.save(jewel),
            JewelResponseDto.class
        );
    }

    private void updateFields(Jewel jewel, UpdateJewelRequestDto updateJewelRequestDto) {
        if(updateJewelRequestDto.getNombre() != null) {
            jewel.setNombre(updateJewelRequestDto.getNombre());
        }
        if(updateJewelRequestDto.getMaterial() != null) {
            jewel.setMaterial(updateJewelRequestDto.getMaterial());
        }
        if(updateJewelRequestDto.getPeso() != null) {
            jewel.setPeso(updateJewelRequestDto.getPeso());
        }
        if(updateJewelRequestDto.getParticularidad() != null) {
            jewel.setParticularidad(updateJewelRequestDto.getParticularidad());
        }
        if(updateJewelRequestDto.getPoseePiedra() != null) {
            jewel.setPoseePiedra(updateJewelRequestDto.getPoseePiedra());
        }
    }
}
