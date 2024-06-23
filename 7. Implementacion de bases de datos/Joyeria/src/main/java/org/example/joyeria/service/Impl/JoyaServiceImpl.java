package org.example.joyeria.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.joyeria.dto.JoyaDTO;
import org.example.joyeria.dto.JoyaResponseDTO;
import org.example.joyeria.entity.Joya;
import org.example.joyeria.repository.JoyaRepository;
import org.example.joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class JoyaServiceImpl implements IJoyaService {

    @Autowired
    private JoyaRepository joyaRepository;

    private ObjectMapper objectMapper;

    public JoyaServiceImpl() {
        this.objectMapper = new ObjectMapper();

    }

    @Override
    public JoyaResponseDTO create(JoyaDTO joya) {
        return new JoyaResponseDTO(joyaRepository.save(convertToJoya(joya)).getNro_id());
    }

    @Override
    public List<JoyaDTO> getAllJoyas() {
        List<Joya> joyas = joyaRepository.findAll().stream().filter(Joya::isVentaONo).toList();
        return joyas.stream().map(this::convertToJoyaDTO).collect(toList());
    }

    @Override
    public JoyaDTO update(JoyaDTO joya, Long id) {
        Joya joyaUpdated = joyaRepository.findById(id).get();
        if (joyaUpdated != null) {
            joyaUpdated.setNombre(joya.getNombre());
            joyaUpdated.setMaterial(joya.getMaterial());
            joyaUpdated.setPeso(joya.getPeso());
            joyaUpdated.setParticularidad(joya.getParticularidad());
            joyaUpdated.setPosee_piedra(joya.isPosee_piedra());
            joyaUpdated.setVentaONo(joya.isVentaONo());
            joyaRepository.save(joyaUpdated);

            return convertToJoyaDTO(joyaUpdated);
        }

        return new JoyaDTO();

    }

    @Override
    public JoyaResponseDTO delete(Long id) {
        Joya joyaUpdated = joyaRepository.findById(id).get();
        if (joyaUpdated != null) {
            joyaUpdated.setVentaONo(false);
            joyaRepository.save(joyaUpdated);
            return new JoyaResponseDTO(joyaUpdated.getNro_id());
        }
        return new JoyaResponseDTO();

    }

    Joya convertToJoya(JoyaDTO joya) {
        return objectMapper.convertValue(joya, Joya.class);

    }

    JoyaDTO convertToJoyaDTO(Joya joya) {
        return objectMapper.convertValue(joya, JoyaDTO.class);
    }
}
