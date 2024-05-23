package com.ejercicio.showroomnosql.service.implementations;

import com.ejercicio.showroomnosql.dto.ClotheDTO;
import com.ejercicio.showroomnosql.dto.MessageResponseDTO;
import com.ejercicio.showroomnosql.entity.Clothe;
import com.ejercicio.showroomnosql.exception.NotFoundException;
import com.ejercicio.showroomnosql.repository.ClotheRepository;
import com.ejercicio.showroomnosql.service.interfaces.IClotheService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClotheService implements IClotheService {
    private final ClotheRepository clotheRepository;
    private final ModelMapper modelMapper;

    public ClotheService(ClotheRepository clotheRepository, ModelMapper modelMapper) {
        this.clotheRepository = clotheRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MessageResponseDTO createClothe(ClotheDTO clotheDTO) {
        Clothe toSave = modelMapper.map(clotheDTO, Clothe.class);
        Clothe saved = clotheRepository.save(toSave);
        return new MessageResponseDTO("Code " + saved.getCode());
    }

    @Override
    public List<Clothe> getAllClothes(Pageable pageable) {
        Page<Clothe> page = (Page<Clothe>) clotheRepository.findAll();
        return page.stream().collect(Collectors.toList());
    }

    @Override
    public Clothe getClotheByCode(String code) {
        Optional<Clothe> searchResult = clotheRepository.findById(code);
        if(searchResult.isPresent()) return searchResult.get();
        throw new NotFoundException("No se encontraron resultados para el code: " + code);
    }

    @Override
    public Clothe updateClothe(long code, ClotheDTO clotheDTO) {
        return null;
    }

    @Override
    public MessageResponseDTO deleteClothe(long code) {
        return null;
    }

    @Override
    public List<Clothe> getAllClothesByWaist(String waist) {
        return null;
    }

    @Override
    public List<Clothe> getAllClothesByName(String name) {
        return null;
    }
}
