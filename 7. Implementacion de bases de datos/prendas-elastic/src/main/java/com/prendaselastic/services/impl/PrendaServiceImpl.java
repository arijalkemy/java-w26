package com.prendaselastic.services.impl;

import com.prendaselastic.DTOs.request.PrendaRequestDTO;
import com.prendaselastic.DTOs.response.PrendaResponseDTO;
import com.prendaselastic.exceptions.PrendaNotFoundException;
import com.prendaselastic.models.Prenda;
import com.prendaselastic.repositories.IPrendaRepository;
import com.prendaselastic.services.IPrendaService;
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
            throw new PrendaNotFoundException("Prenda not found");
        }

        Prenda prenda = modelMapper.map(
                prendaDTO,
                Prenda.class
        );
        prenda.setCodigo(code);

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
                .orElseThrow(() -> new PrendaNotFoundException("Prenda not found"));
    }

}
