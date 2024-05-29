package com.prendas.services.impl;

import com.prendas.DTOs.request.PrendaRequestDTO;
import com.prendas.DTOs.response.PrendaResponseDTO;
import com.prendas.exceptions.PrendaNotFound;
import com.prendas.models.Prenda;
import com.prendas.repositories.IPrendaRepository;
import com.prendas.services.IPrendaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PrendaServiceImpl implements IPrendaService {

    private final IPrendaRepository prendaRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public PrendaResponseDTO crear(PrendaRequestDTO prendaDTO) {
        Prenda prenda = modelMapper.map(
                prendaDTO,
                Prenda.class
        );
        prendaRepository.save(prenda);

        return modelMapper.map(
                prenda,
                PrendaResponseDTO.class
        );
    }

    @Override
    public List<PrendaResponseDTO> getAll() {
        return prendaRepository
                .findAll()
                .stream()
                .map(prenda -> modelMapper.map(
                        prenda,
                        PrendaResponseDTO.class
                ))
                .toList();
    }

    @Override
    public List<PrendaResponseDTO> findByName(String nombre) {
        return prendaRepository.findByNombre(nombre)
                .stream()
                .map(prenda -> modelMapper.map(
                        prenda,
                        PrendaResponseDTO.class
                ))
                .toList();
    }

    @Override
    public PrendaResponseDTO findByCode(String code) {
        return modelMapper.map(
                findPrendaByCode(code),
                PrendaResponseDTO.class
        );
    }

    @Override
    public PrendaResponseDTO update(String code, PrendaRequestDTO prendaDTO) {
        if(!prendaRepository.existsById(code)){
            throw new PrendaNotFound("Prenda not found");
        }

        Prenda prenda = modelMapper.map(
                prendaDTO,
                Prenda.class
        );
        prenda.setId(code);

        prendaRepository.save(prenda);

        return modelMapper.map(
                prenda,
                PrendaResponseDTO.class
        );
    }

    @Override
    public void delete(String code) {
        Prenda prenda = findPrendaByCode(code);
        prendaRepository.delete(prenda);
    }

    @Override
    public List<PrendaResponseDTO> findBySize(String size) {
        return prendaRepository
                .findByTalle(size)
                .stream()
                .map(prenda -> modelMapper.map(
                        prenda,
                        PrendaResponseDTO.class
                ))
                .toList();
    }


    private Prenda findPrendaByCode(String code) {
        return prendaRepository
                .findById(code)
                .orElseThrow(() -> new PrendaNotFound("Prenda not found"));
    }

}
