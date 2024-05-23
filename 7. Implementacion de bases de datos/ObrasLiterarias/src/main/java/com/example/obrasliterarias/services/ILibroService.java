package com.example.obrasliterarias.services;

import com.example.obrasliterarias.entity.Libro;

import java.time.LocalDate;
import java.util.List;

public interface ILibroService {
    List<Libro> obtenerTodoLosLibros();
    public Libro guardar(Libro libro);
    public List<Libro> buscarPorAutor(String autor);
    List<Libro> findByNombreContaining(String nombre);
    List<Libro> findTop5ByOrderByCantidadDePaginasDesc();
    List<Libro> findByFechaPublicacionBefore(LocalDate localDate);
    List<Libro> findByEditorial(String editorial);
}
