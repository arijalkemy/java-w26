package org.example.ejerciciojoyeria.service.impl;

import org.example.ejerciciojoyeria.dto.JoyaRequestDTO;
import org.example.ejerciciojoyeria.dto.JoyaResponseDTO;
import org.example.ejerciciojoyeria.exception.NotFoundException;
import org.example.ejerciciojoyeria.models.Joya;
import org.example.ejerciciojoyeria.repository.IJoyeriaRepository;
import org.example.ejerciciojoyeria.service.IJoyeriaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyeriaServiceImpl implements IJoyeriaService {
    private final IJoyeriaRepository joyeriaRepository;
    private ModelMapper mapper  ;

    public JoyeriaServiceImpl(IJoyeriaRepository joyeriaRepository) {
        this.joyeriaRepository = joyeriaRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public String saveJoya(JoyaRequestDTO joya) {
        Joya joya1=joyeriaRepository.save(mapToEntity(joya));

        return "Se guardó la joya correctamente con el id " + joya1.getId();
    }

    @Override
    public List<JoyaResponseDTO> getAllJoyas() {
        return joyeriaRepository.findAllByVentaTrue().stream().map(this::mapToDTO).toList();
    }

    @Override
    public JoyaResponseDTO getJoyaById(Long id) {
        return mapToDTO(joyeriaRepository.findById(id).orElseThrow(() -> new NotFoundException("Joya no encontrada")));
    }

    @Override
    public String deleteJoya(Long id) {
        Joya joyaDeleteLogic = joyeriaRepository.findById(id).orElseThrow(() -> new NotFoundException("Joya no encontrada"));
        joyaDeleteLogic.setVenta(false);
        joyaDeleteLogic.setId(id);
        joyeriaRepository.save(joyaDeleteLogic);
        return "Se eliminó la joya correctamente con el id " + id;
    }

    @Override
    public String updateJoya(Long id, JoyaRequestDTO joya) {
        Joya joyaToUpdate = mapToEntity(joya);
        joyaToUpdate.setId(id);
        joyeriaRepository.save(joyaToUpdate);
        return "Joya actualizada correctamente con el id " + id;
    }

    public Joya mapToEntity(JoyaRequestDTO joya) {
        return mapper.map(joya, Joya.class);
    }

    public JoyaResponseDTO mapToDTO(Joya joya) {
        return mapper.map(joya, JoyaResponseDTO.class);
    }
}
