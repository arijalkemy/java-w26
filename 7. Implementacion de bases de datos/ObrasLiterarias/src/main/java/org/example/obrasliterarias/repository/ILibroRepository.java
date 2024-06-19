package org.example.obrasliterarias.repository;

import org.example.obrasliterarias.model.Libro;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ILibroRepository extends ElasticsearchRepository<Libro, String> {
    List<Libro> findByAutorContaining(String autor);
    List<Libro> findByNombre(String nombre);
}
