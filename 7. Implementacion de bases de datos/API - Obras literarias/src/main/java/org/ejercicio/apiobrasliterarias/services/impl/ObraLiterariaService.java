package org.ejercicio.apiobrasliterarias.services.impl;

import org.ejercicio.apiobrasliterarias.dtos.ObraLiterariaDto;
import org.ejercicio.apiobrasliterarias.dtos.ObraLiterariaRequestDto;
import org.ejercicio.apiobrasliterarias.models.ObraLiteraria;
import org.ejercicio.apiobrasliterarias.repositories.IObraLiterariaRepository;
import org.ejercicio.apiobrasliterarias.services.IObraLiterariaService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObraLiterariaService implements IObraLiterariaService {

    @Autowired
    private IObraLiterariaRepository obraLiterariaRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ObraLiterariaDto> findByAutor(String autor) {
        return modelMapper.map(obraLiterariaRepository.findByAutor(autor),new TypeToken<List<ObraLiterariaDto>>(){}
                .getType());
    }

    @Override
    public List<ObraLiterariaDto> findByNombreContainingIgnoreCase(String nombre) {
        return modelMapper.map(obraLiterariaRepository.findByNombreContainingIgnoreCase(nombre)
                ,new TypeToken<List<ObraLiterariaDto>>(){}.getType());
    }

    @Override
    public List<ObraLiterariaDto> findTop5ByOrderByCantidadDePaginasDesc() {
        return modelMapper.map(obraLiterariaRepository.findTop5ByOrderByCantidadDePaginasDesc(),
                new TypeToken<List<ObraLiterariaDto>>(){}.getType());
    }

    @Override
    public List<ObraLiterariaDto> findByAnioPrimeraPublicacionBefore(Integer anioPrimeraPublicacion) {
        return modelMapper.map(obraLiterariaRepository.findByAnioPrimeraPublicacionBefore(anioPrimeraPublicacion),
                new TypeToken<List<ObraLiterariaDto>>(){}.getType());
    }

    @Override
    public List<ObraLiterariaDto> findByEditorial(String editorial) {
        return modelMapper.map(obraLiterariaRepository.findByEditorial(editorial),
                new TypeToken<List<ObraLiterariaDto>>(){}.getType());
    }

    @Override
    public ObraLiterariaDto save(ObraLiterariaRequestDto obraLiterariaRequestDto) {
        ObraLiteraria obraLiteraria = modelMapper.map(obraLiterariaRequestDto, ObraLiteraria.class);
        obraLiteraria = obraLiterariaRepository.save(obraLiteraria);
        return modelMapper.map(obraLiteraria,ObraLiterariaDto.class);
    }

    @Override
    public List<ObraLiterariaDto> saveAll(List<ObraLiterariaDto> obrasLiterariaDtos) {
        List<ObraLiteraria> obraLiterarias  = modelMapper.map(obrasLiterariaDtos, new TypeToken<List<ObraLiteraria>>(){}
                .getType());
        Iterable<ObraLiteraria> iObrasLiterarias = obraLiterariaRepository.saveAll(obraLiterarias);
        List<ObraLiterariaDto> obrasLiterariaReturn= new ArrayList<>();
        for (ObraLiteraria obraLiteraria : iObrasLiterarias){
            obrasLiterariaReturn.add(modelMapper.map(obraLiteraria,ObraLiterariaDto.class));
        }
        return obrasLiterariaReturn;
    }
}
