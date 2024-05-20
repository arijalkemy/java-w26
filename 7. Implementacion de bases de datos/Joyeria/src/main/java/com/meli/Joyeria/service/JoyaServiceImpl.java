package com.meli.Joyeria.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.Joyeria.dto.CreateResponseDto;
import com.meli.Joyeria.dto.JoyaDto;
import com.meli.Joyeria.model.Joya;
import com.meli.Joyeria.repository.IJoyaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JoyaServiceImpl implements IJoyaService{

    private final IJoyaRepository joyaRepository;

    ObjectMapper mapper = new ObjectMapper();

    @Override
    @Transactional( Transactional.TxType.REQUIRED )
    public CreateResponseDto createJoya(JoyaDto joya) {
        Joya joyaMapped = new Joya(joya.getNombre(), joya.getMaterial(), joya.getPeso(), joya.getParticularidad(),
                joya.getPoseePiedra());

        joyaRepository.save(joyaMapped);

        return CreateResponseDto.builder()
                .status("200")
                .id(joyaMapped.getId())
                .build();
    }

    @Override
    public List<JoyaDto> getAllJoya() {
        return joyaRepository.findAll().stream().map(
                joya -> mapper.convertValue(joya, JoyaDto.class)
        ).toList();
    }

    @Override
    public void deleteJoya(Long id) {
        Joya joya = findById(id);

        joya.setVentaONo(true);
        joyaRepository.save(joya);
    }

    @Override
    public JoyaDto updateJoya(Long id, JoyaDto joyaDto) {
        Joya joya = findById(id);

        joya.setNombre(joyaDto.getNombre());
        joya.setMaterial(joyaDto.getMaterial());
        joya.setPeso(joyaDto.getPeso());
        joya.setParticularidad(joyaDto.getParticularidad());
        joya.setPoseePiedra(joyaDto.getPoseePiedra());
        joya.setVentaONo(joyaDto.getVentaONo());

        joyaRepository.save(joya);
        return joyaDto;
    }
    
    private Joya findById(Long id) {
        return joyaRepository.findById(id).orElseThrow(() -> new RuntimeException("Joya not found"));
    }
}
