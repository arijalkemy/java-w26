package com.example.JoyeriaLasPerlas.service;

import com.example.JoyeriaLasPerlas.dto.exception.JewelNotfoundException;
import com.example.JoyeriaLasPerlas.dto.jewel.JewelCompleteResponseDto;
import com.example.JoyeriaLasPerlas.dto.jewel.JewelRequestDto;
import com.example.JoyeriaLasPerlas.dto.jewel.JewelResponseDto;
import com.example.JoyeriaLasPerlas.model.Jewel;
import com.example.JoyeriaLasPerlas.repository.IJewelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JewelService implements IJewelService {

    @Autowired
    IJewelRepository jewelRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public JewelResponseDto addJewel(JewelRequestDto jewelRequestDto) {
        JewelResponseDto jewelSaved = modelMapper.map(jewelRepository.save(modelMapper.map(jewelRequestDto, Jewel.class)), JewelResponseDto.class);
        jewelSaved.setStatusCode(201);
        return jewelSaved;
    }

    @Override
    public List<JewelCompleteResponseDto> getAllJewels() {
        return jewelRepository.findAll()
                .stream()
                .filter(Jewel::getIsOnSale)
                .map( jewel -> modelMapper.map(jewel, JewelCompleteResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public String deleteJewel(Long id) {

        Jewel jewel = findJewelById(id);
        if(jewel == null)
            throw new JewelNotfoundException("Jewel not found");

        jewel.setIsOnSale(false);
        jewelRepository.save(jewel);

        return "Jewel deleted successfully";
    }

    @Override
    public JewelCompleteResponseDto updateJewel(Long id, JewelRequestDto jewelRequestDto) {


        Jewel jewel = findJewelById(id);
        if(jewel == null)
            throw new JewelNotfoundException("Jewel not found");

        jewel = modelMapper.map(jewelRequestDto, Jewel.class);
        jewel.setId(id);
        jewel = jewelRepository.save(jewel);
        return modelMapper.map(jewel, JewelCompleteResponseDto.class);
    }

    private Jewel findJewelById(Long id) {
        return jewelRepository.findById(id)
                .orElse(null);
    }
}
