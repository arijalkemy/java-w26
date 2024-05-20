package org.example.joyeria.service.impl;

import org.example.joyeria.dto.SuccessResponseDto;
import org.example.joyeria.dto.jewel.JewelRequestDto;
import org.example.joyeria.dto.jewel.JewelResponseDto;
import org.example.joyeria.exception.JewelNotFound;
import org.example.joyeria.model.Jewel;
import org.example.joyeria.repository.IJewerlyRepository;
import org.example.joyeria.service.IJewerlyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class JewerlyServiceImpl implements IJewerlyService {
    private final IJewerlyRepository jewerlyRepository;

    public JewerlyServiceImpl(@Autowired IJewerlyRepository jewerlyRepository) {
        this.jewerlyRepository = jewerlyRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<JewelResponseDto> getAllJewels() {
        return getJewelsSell(true);
    }

    @Override
    @Transactional
    public SuccessResponseDto postCreateJewel(JewelRequestDto JewelRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        Jewel jewel = modelMapper.map(JewelRequestDto, Jewel.class);
        Jewel created = jewerlyRepository.save(jewel);
        return new SuccessResponseDto("jewel created with id " + created.getId());
    }

    @Override
    @Transactional
    public void deleteJewelById(Long id) {
        Jewel jewel = findById(id);
        jewel.setSell(false);
        jewerlyRepository.save(jewel);
    }

    @Override
    @Transactional
    public JewelResponseDto updateJewel(Long id, JewelRequestDto jewelRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        Jewel jewel = findById(id);
        Jewel temp = modelMapper.map(jewelRequestDto, Jewel.class);
        temp.setId(id);
        Jewel saved = jewerlyRepository.save(temp);
        return modelMapper.map(saved, JewelResponseDto.class);
    }

    protected Jewel findById(Long id) {
        return jewerlyRepository.findById(id).orElseThrow(() ->
                new JewelNotFound("jewel with id " + id + " not found.", HttpStatus.NOT_FOUND));
    }

    @Transactional(readOnly = true)
    protected List<JewelResponseDto> getJewelsSell(Boolean sell) {
        ModelMapper modelMapper = new ModelMapper();
        return jewerlyRepository.findJewelsSell(sell)
                .orElseThrow(() -> new JewelNotFound("not found jewels", HttpStatus.NOT_FOUND))
                .stream()
                .map(jewel -> modelMapper.map(jewel, JewelResponseDto.class))
                .toList();
    }
}
