package com.meli.obrasliterarias.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obrasliterarias.dto.ObrasLiterariasDTO;
import com.meli.obrasliterarias.dto.ResponseDTO;
import com.meli.obrasliterarias.model.ObrasLiterarias;
import com.meli.obrasliterarias.repository.IObrasRepository;
import com.meli.obrasliterarias.service.IObrasService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ObrasService implements IObrasService {

    private final IObrasRepository obrasRepository;


    @Override
    public ResponseDTO createObra(ObrasLiterariasDTO obra) {
        obrasRepository.save(ObraDTOToObra(obra));
        return new ResponseDTO("La obra ha sido creada");
    }

    @Override
    public List<ObrasLiterariasDTO> listObrasByAutor (String nombre){
        List<ObrasLiterarias> obras = obrasRepository.findObrasLiterariasByNombreDeAutor(nombre);
        List<ObrasLiterariasDTO> responseList = new ArrayList<>();
        for(ObrasLiterarias obra: obras){
            responseList.add(ObraToObraDTO(obra));
        }
        return responseList;
    }


    public ObrasLiterarias ObraDTOToObra(ObrasLiterariasDTO obra) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(obra, ObrasLiterarias.class);
    }
    public ObrasLiterariasDTO ObraToObraDTO(ObrasLiterarias obra) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(obra, ObrasLiterariasDTO.class);
    }
}
