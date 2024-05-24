package org.example.apiobrasliterarias.service;

import org.example.apiobrasliterarias.DTO.ResposeObraLiterariaDTO;
import org.example.apiobrasliterarias.repository.IObraLiterariaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaServiceImpl implements IObraLiterariaService {
    private final IObraLiterariaRepository obraLiterariaRepository;
    private final ModelMapper modelMapper;

    public ObraLiterariaServiceImpl(IObraLiterariaRepository obraLiterariaRepository) {
        this.obraLiterariaRepository = obraLiterariaRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<ResposeObraLiterariaDTO> getByAutor(String autor) {
        return obraLiterariaRepository.findByAutor(autor).stream()
                .map(obraLiteraria -> modelMapper.map(obraLiteraria, ResposeObraLiterariaDTO.class))
                .toList();
    }

    @Override
    public List<ResposeObraLiterariaDTO> getByKeyword(String keyword) {
        return obraLiterariaRepository.findByNombreContaining(keyword).stream()
                .map(obraLiteraria -> modelMapper.map(obraLiteraria, ResposeObraLiterariaDTO.class))
                .toList();
    }

    @Override
    public List<ResposeObraLiterariaDTO> getTopFiveByPages() {
        return obraLiterariaRepository.findTop5ByOrderByCantidadPaginasDesc().stream()
                .map(obraLiteraria -> modelMapper.map(obraLiteraria, ResposeObraLiterariaDTO.class))
                .toList();
    }

    @Override
    public List<ResposeObraLiterariaDTO> getByBeforeYear(int year) {
        return obraLiterariaRepository.findByAnioPublicacionBefore(year).stream()
                .map(obraLiteraria -> modelMapper.map(obraLiteraria, ResposeObraLiterariaDTO.class))
                .toList();
    }

    @Override
    public List<ResposeObraLiterariaDTO> getByEditorial(String editorial) {
        return obraLiterariaRepository.findByEditorial(editorial).stream()
                .map(obraLiteraria -> modelMapper.map(obraLiteraria, ResposeObraLiterariaDTO.class))
                .toList();
    }
}
