package com.meli.obras.service.impl;

import com.meli.obras.model.Obras;
import com.meli.obras.repository.ObrasRepository;
import com.meli.obras.service.IObrasService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class obrasServiceImpl implements IObrasService {
    private final ObrasRepository obrasRepository;

    public obrasServiceImpl(ObrasRepository obrasRepository) {
        this.obrasRepository = obrasRepository;
    }

    @Override
    public List<Obras> findAll() {
        return obrasRepository.findAll();
    }

    @Override
    public Obras save(Obras obras) {
        return obrasRepository.save(obras);
    }

    @Override
    public List<Obras> findByAutor(String nombre) {
        return obrasRepository.findByAutor(nombre);
    }

    @Override
    public List<Obras> findByTitulo(String titulo) {
        return obrasRepository.findByTituloContains(titulo);
    }

    @Override
    public List<Obras> findTop5ByOrderByPageCountDesc() {
        return obrasRepository.findTop5ByOrderByPaginasDesc();
    }

    @Override
    public List<Obras> findBypublicacionIsLessThan(Integer year) {
        return obrasRepository.findBypublicacionIsLessThan(year);
    }

    @Override
    public List<Obras> findByEditorial(String editorial) {
        return obrasRepository.findByEditorial(editorial);
    }
}
