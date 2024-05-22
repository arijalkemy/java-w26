package com.example.joyeriaLasPerlas.service;

import com.example.joyeriaLasPerlas.dto.JewerlyRequestDTO;
import com.example.joyeriaLasPerlas.dto.JewerlyResponseDTO;
import com.example.joyeriaLasPerlas.model.Jewerly;
import com.example.joyeriaLasPerlas.repository.IJewerlyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JewerlyServiceImpl implements IJewerlyService {

    public IJewerlyRepository jewerlyRepository;
    public ModelMapper modelMapper;

    public JewerlyServiceImpl(IJewerlyRepository jewerlyRepository) {
        this.jewerlyRepository = jewerlyRepository;
    }

    @Override
    public void createJewerly(JewerlyRequestDTO jewerlyRequestDTO) {
        jewerlyRepository.save(mapToEntity(jewerlyRequestDTO));
    }

    @Override
    public List<JewerlyResponseDTO> getAllRegisteredJewerlies() {
        List<Jewerly> jewerlies = jewerlyRepository.findAllByVentaONoIsTrue();
        List<JewerlyResponseDTO> jewerlyResponseDTOS = new ArrayList<>();
        modelMapper.map(jewerlies, jewerlyResponseDTOS);
        return jewerlyResponseDTOS;
    }

    @Override
    public void deleteJewerlyById(Long id) {
        Jewerly jewerly = jewerlyRepository.findById(id).orElseThrow(null);
        if (jewerly != null) {
            jewerly.setVentaONo(false);
        }
    }

    @Override
    public JewerlyResponseDTO updateJewerly(Long id, JewerlyRequestDTO jewerlyRequestDTO) {
        Jewerly joyaOriginal = jewerlyRepository.findById(id).orElseThrow(null);

        joyaOriginal.setNombre(jewerlyRequestDTO.getNombre());
        joyaOriginal.setMaterial(jewerlyRequestDTO.getMaterial());
        joyaOriginal.setPeso(jewerlyRequestDTO.getPeso());
        joyaOriginal.setParticularidad(jewerlyRequestDTO.getParticularidad());
        joyaOriginal.setPosee_piedra(jewerlyRequestDTO.getPosee_piedra());
        joyaOriginal.setVentaONo(jewerlyRequestDTO.getVentaONo());

        return modelMapper.map(joyaOriginal, JewerlyResponseDTO.class);
    }

    public Jewerly mapToEntity(JewerlyRequestDTO jewerlyRequestDTO) {
        Jewerly jewerly = new Jewerly();
        modelMapper.map(jewerlyRequestDTO, jewerly);
        return jewerly;
    }

    public JewerlyResponseDTO mapToDTO(Jewerly jewerly) {
        JewerlyResponseDTO jewerlyResponseDTO = new JewerlyResponseDTO();
        modelMapper.map(jewerly, jewerlyResponseDTO);
        return jewerlyResponseDTO;
    }
}
