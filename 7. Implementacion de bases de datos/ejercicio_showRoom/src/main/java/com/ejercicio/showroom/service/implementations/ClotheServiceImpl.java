package com.ejercicio.showroom.service.implementations;

import com.ejercicio.showroom.dto.MessageResponseDTO;
import com.ejercicio.showroom.dto.ClotheDTO;
import com.ejercicio.showroom.entities.Clothe;
import com.ejercicio.showroom.exception.NotFoundException;
import com.ejercicio.showroom.repository.ClotheRepository;
import com.ejercicio.showroom.service.interfaces.IClotheService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClotheServiceImpl implements IClotheService {

    private final ClotheRepository clotheRepository;
    private final ObjectMapper objectMapper;

    public ClotheServiceImpl(ClotheRepository clotheRepository, ObjectMapper objectMapper) {
        this.clotheRepository = clotheRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public MessageResponseDTO createClothe(ClotheDTO clotheDTO) {
        Clothe toCreate = objectMapper.convertValue(clotheDTO, Clothe.class);
        Clothe created = clotheRepository.save(toCreate);
        return new MessageResponseDTO("Code " + created.getCode());
    }

    @Override
    public List<Clothe> getAllClothes() {
        return clotheRepository.findAll();
    }

    @Override
    public Clothe getClotheByCode(long code) {
        Optional<Clothe> searchResult = clotheRepository.findById(code);
        if(searchResult.isPresent()) return searchResult.get();
        throw new NotFoundException("No se encontraron resultados para el code: " + code);
    }

    @Override
    public Clothe updateClothe(long code, ClotheDTO clotheDTO) {
        getClotheByCode(code);
        Clothe toUpdate = objectMapper.convertValue(clotheDTO, Clothe.class);
        toUpdate.setCode(code);
        return clotheRepository.save(toUpdate);
    }

    @Override
    public MessageResponseDTO deleteClothe(long code) {
        Clothe searchResult = getClotheByCode(code);
        clotheRepository.delete(searchResult);
        return new MessageResponseDTO("Prenda eliminada con exito");
    }

    @Override
    public List<Clothe> getAllClothesByWaist(String waist) {
        return clotheRepository.findClothesByWaist(waist);
    }

    @Override
    public List<Clothe> getAllClothesByName(String name) {
        return clotheRepository.findClothesByName(name);
    }
}
