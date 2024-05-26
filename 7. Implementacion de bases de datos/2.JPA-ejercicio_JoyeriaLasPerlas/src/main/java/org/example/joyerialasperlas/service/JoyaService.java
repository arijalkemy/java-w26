package org.example.joyerialasperlas.service;

import org.example.joyerialasperlas.dto.JoyaRequestDTO;
import org.example.joyerialasperlas.dto.JoyaResponseDTO;
import org.example.joyerialasperlas.exception.NotFoundException;
import org.example.joyerialasperlas.model.Joya;
import org.example.joyerialasperlas.repository.JoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class JoyaService implements IJoyaService {

    @Autowired
    private JoyaRepository joyaRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    @Transactional(readOnly = true)
    public List<JoyaResponseDTO> findAll() {
        return joyaRepository.findAll()
                .stream()
                .map(joya -> modelMapper.map(joya, JoyaResponseDTO.class))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Joya findById(Long id) {
        return joyaRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No se encontró la joya con id" + id)
        );
    }


    @Override
    @Transactional
    public Long create(JoyaRequestDTO joyaDto) {
        Joya joya = joyaRepository.save(modelMapper.map(joyaDto, Joya.class));
        return joya.getNro_identificatorio();
    }

    @Override
    @Transactional
    public JoyaResponseDTO update(Long id, JoyaRequestDTO joyaDto) {
        Joya joya = findById(id);
        joya.setMaterial(joyaDto.getMaterial());
        joya.setNombre(joyaDto.getNombre());
        joya.setPeso(joyaDto.getPeso());
        joya.setParticularidad(joyaDto.getParticularidad());
        joya.setVentaONo(joyaDto.isVentaONo());
        joya.setPosee_piedra(joyaDto.isPosee_piedra());
        return modelMapper.map(joyaRepository.save(joya),JoyaResponseDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        joyaRepository.deleteById(id);
    }
}
