package com.meli.obras.service;

import com.meli.obras.model.Obras;

import java.util.List;

public interface IObrasService {
    List<Obras> findAll();
    Obras save(Obras obras);
    List<Obras> findByAutor(String nombre);
    List<Obras> findByTitulo(String titulo);
    List<Obras> findTop5ByOrderByPageCountDesc();
    List<Obras> findBypublicacionIsLessThan(Integer year);
    List<Obras> findByEditorial(String editorial);
}
