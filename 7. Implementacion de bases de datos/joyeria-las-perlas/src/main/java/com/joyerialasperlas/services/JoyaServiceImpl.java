package com.joyerialasperlas.services;

import com.joyerialasperlas.DTOs.JoyaDTO;
import com.joyerialasperlas.DTOs.JoyaResponseDTO;
import com.joyerialasperlas.exceptions.JoyaNotFound;
import com.joyerialasperlas.models.Joya;
import com.joyerialasperlas.repositories.IJoyaRepository;
import com.joyerialasperlas.services.interfaces.IJoyaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JoyaServiceImpl implements IJoyaService {

    IJoyaRepository joyaRepository;
    ModelMapper modelMapper = new ModelMapper();


    public JoyaServiceImpl(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    @Transactional
    public JoyaResponseDTO create(JoyaDTO joyaDTO) {
        Joya newJoya = modelMapper.map(joyaDTO, Joya.class);

        newJoya = joyaRepository.save(newJoya);

        return modelMapper.map(newJoya, JoyaResponseDTO.class);
    }

    @Override
    @Transactional
    public JoyaResponseDTO findById(Long id) {
        Joya joya = this.getJoyaById(id);

        return modelMapper.map(joya, JoyaResponseDTO.class);
    }

    @Override
    @Transactional
    public List<JoyaResponseDTO> findAll() {

        List<Joya> filteredJoyas = joyaRepository.findAll().stream()
                .filter(Joya::getVentaONo)
                .toList();


        return filteredJoyas.stream().map(
                j -> modelMapper.map(j, JoyaResponseDTO.class)
        ).toList();
    }

    @Override
    @Transactional
    public JoyaResponseDTO update(Long id, JoyaDTO joyaDTO) {
        if(joyaRepository.existsById(id)){
            ModelMapper modelMapper = new ModelMapper();
            Joya joyaUpdated = modelMapper.map(joyaDTO, Joya.class);
            joyaUpdated.setId(id);
            joyaRepository.save(joyaUpdated);
            return modelMapper.map(joyaUpdated, JoyaResponseDTO.class);
        } else {
            throw new JoyaNotFound("Joya not found");
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {

        Joya joya = getJoyaById(id);

        joya.setVentaONo(false);
    }

    private Joya getJoyaById(Long id){
        return joyaRepository
                .findById(id)
                .orElseThrow(()-> new JoyaNotFound("Joya not found"));
    }
}
