package com.example.obrasliterarias.repository;

import com.example.obrasliterarias.entity.Libro;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ILibroRepository extends ElasticsearchRepository<Libro,String> {
    List<Libro> findAll();
    List<Libro> findByAutor(String autor);
    List<Libro> findByNombreContaining(String nombre);
    List<Libro> findTop5ByOrderByCantidadDePaginasDesc();
    List<Libro> findByFechaPublicacionBefore(LocalDate localDate);
    List<Libro> findByEditorialContaining(String editorial);
}
