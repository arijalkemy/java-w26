package com.example.ejercicio_lasperlas.service;

import com.example.ejercicio_lasperlas.dto.JewelDTO;
import com.example.ejercicio_lasperlas.exception.NotFoundException;
import com.example.ejercicio_lasperlas.model.Jewel;
import com.example.ejercicio_lasperlas.repository.JewelRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JewelService implements IJewelService {

    private final JewelRepository jewelRepository;
    private final ObjectMapper objectMapper;

    public JewelService(JewelRepository jewelRepository, ObjectMapper objectMapper) {
        this.jewelRepository = jewelRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    @Transactional
    public Jewel saveJewel(JewelDTO jewel) {
        Jewel toSave = objectMapper.convertValue(jewel, Jewel.class);
        return jewelRepository.save(toSave);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Jewel> getAllJewels() {
        return jewelRepository.findAll()
                .stream()
                .filter(jewel -> jewel.isForSale())
                .toList();
    }

    @Override
    @Transactional
    public void deleteJewel(long id) {
        Jewel toDelete = getJewel(id);
        toDelete.setForSale(false);
        jewelRepository.save(toDelete);
    }

    @Override
    @Transactional(readOnly = true)
    public Jewel getJewel(long id) {
        Jewel result = jewelRepository.getReferenceById(id);
        if(result == null) throw new NotFoundException("No se encontraron resultados para el id: " + id);
        return result;
    }

    @Override
    @Transactional
    public JewelDTO updateJewel(JewelDTO jewelRequestDTO) {
        getJewel(jewelRequestDTO.getId());
        Jewel toUpdate = objectMapper.convertValue(jewelRequestDTO, Jewel.class);
        Jewel updated = jewelRepository.save(toUpdate);
        return objectMapper.convertValue(updated, JewelDTO.class);
    }
}
