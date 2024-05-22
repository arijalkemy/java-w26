package org.ggomezr.empresadeseguros.application.service.impl;

import org.ggomezr.empresadeseguros.application.service.interfaces.ISinisterService;
import org.ggomezr.empresadeseguros.domain.dto.ResponseDTO;
import org.ggomezr.empresadeseguros.domain.dto.SinisterDTO;
import org.ggomezr.empresadeseguros.domain.exception.NotFoundException;
import org.ggomezr.empresadeseguros.domain.model.Sinister;
import org.ggomezr.empresadeseguros.domain.repository.ISinisterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SinisterService implements ISinisterService {

    private final ISinisterRepository sinisterRepository;
    private final ModelMapper modelMapper;

    public SinisterService(ISinisterRepository sinisterRepository, ModelMapper modelMapper) {
        this.sinisterRepository = sinisterRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SinisterDTO createSinister(SinisterDTO sinisterDTO) {
        Sinister sinister = convertToEntity(sinisterDTO);
        Sinister savedSinister = sinisterRepository.save(sinister);
        return  convertToDTO(savedSinister);
    }

    @Override
    public List<SinisterDTO> createSinisters(List<SinisterDTO> sinisterDTOList) {
        List<Sinister> sinisters = sinisterDTOList.stream().map(this::convertToEntity).toList();
        List<Sinister> savedSinisters = sinisterRepository.saveAll(sinisters);
        return savedSinisters.stream().map(this::convertToDTO).toList();
    }

    @Override
    public List<SinisterDTO> getAllSinisters() {
        return sinisterRepository.findAll().stream().map(this::convertToDTO).toList();
    }

    @Override
    public SinisterDTO getSinisterById(Long id) {
        Optional<Sinister> sinister = sinisterRepository.findById(id);

        if(sinister.isEmpty()) throw new NotFoundException("Sinister not found");

        return convertToDTO(sinister.get());
    }

    @Override
    public SinisterDTO updateSinister(Long id, SinisterDTO sinisterDTO) {
        Optional<Sinister> sinister = sinisterRepository.findById(id);

        if(sinister.isEmpty()) throw new NotFoundException("Sinister not found");

        Sinister updatedSinister = convertToEntity(sinisterDTO);
        updatedSinister.setId(sinister.get().getId());

        sinisterRepository.save(updatedSinister);

        return convertToDTO(updatedSinister);
    }

    @Override
    public ResponseDTO deleteSinister(Long id) {
        Optional<Sinister> sinister = sinisterRepository.findById(id);

        if(sinister.isEmpty()) throw new NotFoundException("Sinister not found");

        sinisterRepository.deleteById(id);

        return new ResponseDTO("Sinister deleted successfully");
    }

    private SinisterDTO convertToDTO(Sinister sinister) {
        return modelMapper.map(sinister, SinisterDTO.class);
    }

    private Sinister convertToEntity(SinisterDTO sinisterDTO) {
        return modelMapper.map(sinisterDTO, Sinister.class);
    }
}

