package com.mercadolibre.Obras_Literarias.service.impl;

import com.mercadolibre.Obras_Literarias.dto.ObraLiterariaDto;
import com.mercadolibre.Obras_Literarias.dto.ObraLiterariaResponseDto;
import com.mercadolibre.Obras_Literarias.model.ObraLiteraria;
import com.mercadolibre.Obras_Literarias.repository.IObraLiterariaRepository;
import com.mercadolibre.Obras_Literarias.service.IObraLiterariaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaService implements IObraLiterariaService {

    @Autowired
    IObraLiterariaRepository iObraLiterariaRepository;

    @Override
    public ObraLiterariaResponseDto saveObra(ObraLiterariaDto obraLiterariaDto) {
        ModelMapper mapper = new ModelMapper();
        ObraLiteraria obraLiteraria = mapper.map(obraLiterariaDto, ObraLiteraria.class);
        iObraLiterariaRepository.save(obraLiteraria);
        return mapper.map(iObraLiterariaRepository.save(obraLiteraria),ObraLiterariaResponseDto.class);
    }

    @Override
    public List<ObraLiterariaResponseDto> getObrasByAutor(String autor){
        ModelMapper mapper = new ModelMapper();
        return iObraLiterariaRepository.findByAutor(autor).stream().map(
                obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaResponseDto.class)
        ).toList();
    }

    @Override
    public List<ObraLiterariaResponseDto> getObrasByTitulo(String titulo){
        ModelMapper mapper = new ModelMapper();
        return iObraLiterariaRepository.findByNombreIsLike(titulo).stream().map(
                obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaResponseDto.class)
        ).toList();
    }
    @Override
    public List<ObraLiterariaResponseDto> getObrasTop5QuantityPages(){
        ModelMapper mapper = new ModelMapper();
        return iObraLiterariaRepository.findTop5ByOrderByCantidadPaginasDesc()
                .stream().map(o-> mapper.map(o,ObraLiterariaResponseDto.class)).toList();
    }

    @Override
    public List<ObraLiterariaResponseDto>  getObrasBefore(int anio){
        ModelMapper mapper = new ModelMapper();
        return  iObraLiterariaRepository.findObraLiterariaByAnioPublicacionIsBefore(anio).stream()
                .map(obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaResponseDto.class))
                .toList();
    }

    @Override
    public List<ObraLiterariaResponseDto> getObrasByEditorial(String editorial){
        ModelMapper mapper = new ModelMapper();
        return iObraLiterariaRepository.findObraLiterariaByEditorial(editorial).stream().map(
                obraLiteraria -> mapper.map(obraLiteraria, ObraLiterariaResponseDto.class)
        ).toList();
    }
}
