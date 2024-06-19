package org.example.obrasliterarias.service;

import org.example.obrasliterarias.model.Libro;

import java.util.List;

public interface ILibroService {
    List<Libro> findByAutor( String autor);
    List<Libro> findBookByName( String name);
    List<Libro> findAll();
    void save(Libro libro);

}
