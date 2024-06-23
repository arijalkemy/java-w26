package org.example.libreria.service.impl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.libreria.dto.ObraLiterariaRequestDTO;
import org.example.libreria.dto.ObraLiterariaResponseDTO;
import org.example.libreria.entity.ObraLiteraria;
import org.example.libreria.repository.IObraLiterariaRepository;
import org.example.libreria.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ObraLiteriariaServiceImpl implements IObraLiterariaService {


    @Autowired
    private IObraLiterariaRepository obraLiterariaRepository;

    private final ObjectMapper mapper;

    public ObraLiteriariaServiceImpl() {
        this.mapper = new ObjectMapper();
    }

    @Override
    public void saveObraLiteraria(ObraLiterariaRequestDTO obraLiteraria) {
        ObraLiteraria obraLiterariaSave = mapper.convertValue(obraLiteraria, ObraLiteraria.class);
        obraLiterariaRepository.save(obraLiterariaSave);
    }


    @Override
    public void saveObrasLiterarias(List<ObraLiterariaRequestDTO> obrasLiterarias) {
        obrasLiterarias.forEach(obraLiteraria ->
                obraLiterariaRepository.save(mapper.convertValue(obraLiteraria, ObraLiteraria.class))
        );
    }

    @Override
    public List<ObraLiterariaResponseDTO> getObrasLiterariasByAutor(String autor) {
        List<ObraLiteraria> obraLiterariasList = obraLiterariaRepository.findByAutorContaining(autor);
        return obraLiterariasList.stream().map(obraLiteraria ->
             mapper.convertValue(obraLiteraria, ObraLiterariaResponseDTO.class)
        ).toList();
    }

    @Override
    public List<ObraLiterariaResponseDTO> getObrasLiterariasByNombre(String nombre) {
        List<ObraLiteraria> obraLiterariasList = obraLiterariaRepository.findByNombreContaining(nombre);
        return obraLiterariasList.stream().map(obraLiteraria ->
                mapper.convertValue(obraLiteraria, ObraLiterariaResponseDTO.class)
        ).toList();
    }

    @Override
    public List<ObraLiterariaResponseDTO> getObrasLiterariasTopOrderPages() {
        List<ObraLiteraria> obraLiterariasList = obraLiterariaRepository.findTop5ByOrderByCantidadPaginasDesc();

        return obraLiterariasList.stream().map(obraLiteraria ->
                mapper.convertValue(obraLiteraria, ObraLiterariaResponseDTO.class)
        ).toList();
    }

    @Override
    public List<ObraLiterariaResponseDTO> getObrasLiterariasBeforYearPublication(Integer year) {
        List<ObraLiteraria> obraLiterariasList = obraLiterariaRepository.findByAnioPublicacionBefore(year);
        return obraLiterariasList.stream().map(obraLiteraria ->
                mapper.convertValue(obraLiteraria, ObraLiterariaResponseDTO.class)
        ).toList();
    }

    @Override
    public List<ObraLiterariaResponseDTO> getObrasLiterariasByEditorial(String editorial) {
        List<ObraLiteraria> obraLiterariasList = obraLiterariaRepository.findByEditorial(editorial);
        return obraLiterariasList.stream().map(obraLiteraria ->
                mapper.convertValue(obraLiteraria, ObraLiterariaResponseDTO.class)
        ).toList();
    }
}
