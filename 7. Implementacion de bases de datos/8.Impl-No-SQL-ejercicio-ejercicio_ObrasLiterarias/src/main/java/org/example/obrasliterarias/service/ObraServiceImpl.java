package org.example.obrasliterarias.service;

import org.example.obrasliterarias.dto.ObraDto;
import org.example.obrasliterarias.model.Obra;
import org.example.obrasliterarias.repository.IObraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ObraServiceImpl implements IObraService {

    @Autowired
    private IObraRepository libroRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ObraDto> findByAutor(String autor) {
        return libroRepository.findByAutorContaining(autor)
                .stream()
                .map(libro -> modelMapper.map(libro, ObraDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> findObraByName(String nombre) {
        return libroRepository.findByNombre(nombre).stream()
                .map(libro -> modelMapper.map(libro, ObraDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void save(ObraDto obraDto) {
        libroRepository.save(modelMapper.map(obraDto, Obra.class));
    }

    @Override
    public List<ObraDto> findAll() {
        Iterable<Obra> iterableLibro = libroRepository.findAll();

        return StreamSupport.stream(iterableLibro.spliterator(), false)
                .toList().stream()
                .map(libro -> modelMapper.map(libro, ObraDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraDto> findTopFivePagesObra() {
        return libroRepository.findTop5ByOrderByPaginasDesc()
                .stream()
                .map(obra -> modelMapper.map(obra, ObraDto.class)).toList();
    }

    @Override
    public List<ObraDto> findObrasBeforeYear(Integer year) {
        return libroRepository.findByAnoIsLessThan(year)
                .stream()
                .map(obra -> modelMapper.map(obra, ObraDto.class))
                .toList();
    }

    @Override
    public List<ObraDto> findObraByEditorial(String editorial) {
        return libroRepository.findObraByEditorial(editorial)
                .stream()
                .map(obra -> modelMapper.map(obra, ObraDto.class))
                .toList();
    }
}
