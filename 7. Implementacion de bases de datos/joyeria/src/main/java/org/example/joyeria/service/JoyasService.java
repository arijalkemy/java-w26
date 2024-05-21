package org.example.joyeria.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.example.joyeria.dto.JoyaDTO;
import org.example.joyeria.dto.JoyaDTOReq;
import org.example.joyeria.exception.JoyaNotFound;
import org.example.joyeria.model.Joya;
import org.example.joyeria.repository.IJoyasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyasService implements IJoyasService {

    @Autowired
    IJoyasRepository repository;
    
    private final ModelMapper modelMapper = new ModelMapper();
    
    @Override
    public List<JoyaDTO> findAll() {
        List<Joya> joyas = repository.findAll();
        List<Joya> joyasFiltradas = joyas.stream()
                .filter(j -> j.isVentaONo())
                .toList();
        return joyasFiltradas.stream().map(
                j -> modelMapper.map(j, JoyaDTO.class)
        ).toList();
    }

    @Override
    public JoyaDTO update(Long id, JoyaDTOReq joyaDTOReq) {
        Joya joya = getJoyaById(id);

        joya.setNombre(joyaDTOReq.getNombre());
        joya.setMaterial(joyaDTOReq.getMaterial());
        joya.setPeso(joyaDTOReq.getPeso());
        joya.setParticularidad(joyaDTOReq.getParticularidad());
        joya.setPoseePiedra(joyaDTOReq.getPoseePiedra());

        Joya joyaActualizada = repository.save(joya);
        return modelMapper.map(joyaActualizada, JoyaDTO.class);
    }

    private Joya getJoyaById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new JoyaNotFound("no existe esa joya")
        );
    }

    @Override
    public JoyaDTO delete(Long id) {
        Joya joya = getJoyaById(id);
        joya.setVentaONo(false);
        repository.save(joya);
        return modelMapper.map(joya, JoyaDTO.class);
    }

    @Override
    public JoyaDTO create(JoyaDTOReq joyaDTO) {
        Joya joya = modelMapper.map(joyaDTO, Joya.class);
        joya.setVentaONo(true);
        repository.save(joya);
        return modelMapper.map(joya, JoyaDTO.class);
    }
}
