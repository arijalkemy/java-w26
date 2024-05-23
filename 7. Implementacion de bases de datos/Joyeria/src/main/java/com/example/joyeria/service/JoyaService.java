package com.example.joyeria.service;

import com.example.joyeria.dto.IdDTO;
import com.example.joyeria.dto.JoyaDTO;
import com.example.joyeria.dto.ResponseDTO;
import com.example.joyeria.model.Joya;
import com.example.joyeria.repository.JoyaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JoyaService implements IJoyaService{
    private final JoyaRepository joyaRepository;

    public JoyaService (JoyaRepository joyaRepository){
        this.joyaRepository = joyaRepository;
    }

    @Override
    public IdDTO createJoya(JoyaDTO joya) {
        joya.setId(null);
        Joya joyaToSave = joyaDTOToJoya(joya);
        joyaToSave.setVentaONo(true);
        Joya joyaSaved = joyaRepository.save(joyaToSave);
        return new IdDTO(joyaSaved.getId());
    }

    @Override
    public List<JoyaDTO> getAllJoyas() {
        List<Joya> joyas = joyaRepository.findAll();
        return listJoyaToListJoyaDTO(joyas);
    }

    @Override
    public ResponseDTO deleteJoya(Long id) {
        Joya joyaToDelete = joyaRepository.findById(id).orElse(null);
        joyaToDelete.setVentaONo(false);
        joyaRepository.save(joyaToDelete);
        return new ResponseDTO("Joya eliminada con exito");
    }

    @Override
    public JoyaDTO updateJoya(Long id, JoyaDTO joya) {
        Joya joyaBase = joyaRepository.findById(id).orElse(null);
        Joya joyaToUpdate = joyaDTOToJoya(joya);
        joyaToUpdate.setId(id);
        if(joyaToUpdate.getVentaONo() == null)  joyaToUpdate.setVentaONo(joyaBase.getVentaONo());
        joyaRepository.save(joyaToUpdate);
        return joyaToJoyaDTO(joyaToUpdate);
    }

    public JoyaDTO joyaToJoyaDTO(Joya joya){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(joya, JoyaDTO.class);
    }

    public Joya joyaDTOToJoya(JoyaDTO joya){
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(joya, Joya.class);
    }

    public List<JoyaDTO> listJoyaToListJoyaDTO(List<Joya> joyas){
        List<JoyaDTO> listToReturn = new ArrayList<>();
        for (Joya joya : joyas) {
            if(joya.getVentaONo()) listToReturn.add(joyaToJoyaDTO(joya));
        }
        return listToReturn;
    }

    public List<Joya> listJoyaDTOToListJoya(List<JoyaDTO> joyas){
        List<Joya> listToReturn = new ArrayList<>();
        for (JoyaDTO joya : joyas) {
            listToReturn.add(joyaDTOToJoya(joya));
        }
        return listToReturn;
    }
}
