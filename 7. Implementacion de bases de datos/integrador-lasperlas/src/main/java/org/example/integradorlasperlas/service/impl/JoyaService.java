package org.example.integradorlasperlas.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.integradorlasperlas.exception.ConflictException;
import org.example.integradorlasperlas.exception.NotFoundException;
import org.example.integradorlasperlas.model.Joya;
import org.example.integradorlasperlas.model.dto.JoyaRequestDTO;
import org.example.integradorlasperlas.model.dto.JoyaResponseDTO;
import org.example.integradorlasperlas.model.dto.JoyaUpdateDTO;
import org.example.integradorlasperlas.repository.IJoyaRepository;
import org.example.integradorlasperlas.service.IJoyaService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JoyaService implements IJoyaService {
    private final ObjectMapper objectMapper;

    private final IJoyaRepository joyaRepository;
    private Joya mapToEntity(JoyaRequestDTO joyaRequestDTO){
        return objectMapper.convertValue(joyaRequestDTO, Joya.class);
    }

    private Joya mapToEntity(JoyaUpdateDTO joyaUpdateDTO){
        return objectMapper.convertValue(joyaUpdateDTO, Joya.class);
    }
    private JoyaResponseDTO mapToDTO(Joya joya){
        return objectMapper.convertValue(joya, JoyaResponseDTO.class);
    }
    @Override
    public JoyaResponseDTO getJewel(Long id) {
        Optional<Joya> joya = joyaRepository.findById(id);
        if (joya.isPresent()){
            return mapToDTO(joya.get());
        } else {
            throw new NotFoundException("La joya no se ha encontrado");
        }
    }

    @Override
    public List<JoyaResponseDTO> getAllJewels() {
        List<Joya> joyaList = joyaRepository.findAll();
        return joyaList.stream().map(this::mapToDTO).toList();
    }

    @Override
    public JoyaRequestDTO createJewel(JoyaRequestDTO joyaRequestDTO) {
        Joya joya = mapToEntity(joyaRequestDTO);
        joyaRepository.save(joya);
        return joyaRequestDTO;
    }

    @Override
    public JoyaUpdateDTO updateJewel(JoyaUpdateDTO joyaUpdateDTO) {
        getJewel(joyaUpdateDTO.getNro_identificatorio());
        joyaRepository.save(mapToEntity(joyaUpdateDTO));
        return joyaUpdateDTO;
    }

    @Override
    public String deleteJewel(Long id) {
        Optional<Joya> joya = joyaRepository.findById(id);
        if (joya.isPresent()){
            joyaRepository.deleteById(id);
            return "Se ha eliminado el registro con id: " + joya.get().getNro_identificatorio();
        } else {
            throw new NotFoundException("La joya no se ha encontrado");
        }
    }

    @Override
    public String logicalDeleteJewel(Long id) {
        Optional<Joya> joya = joyaRepository.findById(id);
        if (joya.isPresent()){
            if (joya.get().isVentaONo()){
                joya.get().setVentaONo(false);
                joyaRepository.save(joya.get());
            } else {
                throw new ConflictException("No se puede eliminar la joya");
            }
            return "Se ha eliminado de manera lógica el registro con id: " + joya.get().getNro_identificatorio();
        } else {
            throw new NotFoundException("La joya no se ha encontrado");
        }
    }

    @Override
    public List<JoyaResponseDTO> logicalGetAllJewels() {
        List<Joya> joyaList = joyaRepository.findAll().stream().filter(Joya::isVentaONo).toList();
        return joyaList.stream().map(this::mapToDTO).toList();
    }
}
