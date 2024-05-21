package com.example.obrasliterarias.services;

import com.example.obrasliterarias.entity.Libro;
import com.example.obrasliterarias.repository.ILibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LibroServiceImpl implements ILibroService{

    private final ILibroRepository libroRepository;

    @Override
    public List<Libro> obtenerTodoLosLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public List<Libro> buscarPorAutor(String autor) {
        return libroRepository.findByAutor(autor);
    }

    @Override
    public List<Libro> findByNombreContaining(String nombre) {
        return libroRepository.findByNombreContaining(nombre);
    }

    @Override
    public List<Libro> findTop5ByOrderByCantidadDePaginasDesc() {
        return libroRepository.findTop5ByOrderByCantidadDePaginasDesc();
    }

    @Override
    public List<Libro> findByFechaPublicacionBefore(LocalDate localDate) {
        return libroRepository.findByFechaPublicacionBefore(localDate);
    }

    @Override
    public List<Libro> findByEditorial(String editorial) {
        return libroRepository.findByEditorialContaining(editorial);
    }
}
