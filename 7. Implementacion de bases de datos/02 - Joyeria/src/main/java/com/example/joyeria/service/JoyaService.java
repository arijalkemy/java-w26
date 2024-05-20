package com.example.joyeria.service;

import com.example.joyeria.dto.request.JoyaRequestDto;
import com.example.joyeria.dto.response.JoyaResponseDto;
import com.example.joyeria.exception.NotFoundException;
import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.IJoyaRepository;
import com.example.joyeria.utils.JoyaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoyaService implements IJoyaService{
    @Autowired
    IJoyaRepository iJoyaRepository;

    @Override
    public int agregarJoya(JoyaRequestDto joyaRequestDto) {
        Joya joya = iJoyaRepository.save(JoyaMapper.mapRequestToEntity(joyaRequestDto));

        return joya.getId();
    }

    @Override
    public List<JoyaResponseDto> obtenerJoyas() {
        List<JoyaResponseDto> joyasResponse = new ArrayList<>();
        for (Joya joya : iJoyaRepository.findAll()) {
            if(joya.isEnVenta())
                joyasResponse.add(JoyaMapper.mapEntityToResponse(joya));
        }

        return joyasResponse;
    }

    @Override
    public void eliminarJoya(int id) {
        Joya joya = obtenerJoya(id);

        joya.setEnVenta(false);

        iJoyaRepository.save(joya);
    }

    @Override
    public JoyaResponseDto editarJoya(int id, JoyaRequestDto joyaRequestDto) {
        Joya joya = obtenerJoya(id);

        joya.setNombre(joyaRequestDto.getNombre());
        joya.setMaterial(joyaRequestDto.getMaterial());
        joya.setParticularidad(joyaRequestDto.getParticularidad());
        joya.setPeso(joyaRequestDto.getPeso());
        joya.setPoseePiedra(joyaRequestDto.isPoseePiedra());

        iJoyaRepository.save(joya);

        return JoyaMapper.mapEntityToResponse(joya);
    }

    private Joya obtenerJoya(int id){
        return iJoyaRepository.findById(id)
                .orElseThrow(()->new NotFoundException("No se encontro el usuario"));
    }
}
