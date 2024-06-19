package org.example.obrasliterarias.service;

import org.example.obrasliterarias.model.Libro;
import org.example.obrasliterarias.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class LibroServiceImpl implements  ILibroService{

    @Autowired
    private ILibroRepository libroRepository;

    @Override
    public List<Libro> findByAutor(String autor) {
        return libroRepository.findByAutorContaining(autor);
    }

    @Override
    public List<Libro> findBookByName(String nombre) {
        return libroRepository.findByNombre(nombre);
    }
    @Override
    public void save(Libro libro) {
        libroRepository.save(libro);
    }

    @Override
    public List<Libro> findAll() {
        Iterable<Libro> iterableLibro =  libroRepository.findAll();
        return StreamSupport.stream(iterableLibro.spliterator(), false).toList();
    }
}
