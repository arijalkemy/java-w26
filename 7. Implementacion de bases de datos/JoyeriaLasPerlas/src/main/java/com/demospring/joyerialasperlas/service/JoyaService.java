package com.demospring.joyerialasperlas.service;

import com.demospring.joyerialasperlas.dto.JoyaRequestDTO;
import com.demospring.joyerialasperlas.exception.NotFoundException;
import com.demospring.joyerialasperlas.model.Joya;
import com.demospring.joyerialasperlas.repository.IJoyaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JoyaService implements IJoyaService {
    private final IJoyaRepository joyaRepository;

    @Override
    @Transactional
    public Long createJoya(JoyaRequestDTO joya){
        return joyaRepository.save(mapToEntity(joya)).getId();
    }

    @Override
    @Transactional
    public List<Joya> getAllJoyas() {
        return joyaRepository.findAllByVentaONo(true);
    }

    @Override
    @Transactional
    public void deleteJoya(Long id) {
        Joya joya = findJoyaById(id);
        joya.setVentaONo(false);
        updateJoya(id, mapToDto(joya));
    }

    @Override
    @Transactional
    public void updateJoya(Long id, JoyaRequestDTO joya) {
        findJoyaById(id);
        joyaRepository.save(mapToEntity(joya));
    }

    private Joya mapToEntity(JoyaRequestDTO joya){
        return new ModelMapper().map(joya, Joya.class);
    }

    private JoyaRequestDTO mapToDto(Joya joya){
        return new ModelMapper().map(joya, JoyaRequestDTO.class);
    }

    private Joya findJoyaById(Long id){
        return joyaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(Joya.class.getSimpleName(), id));
    }
}
