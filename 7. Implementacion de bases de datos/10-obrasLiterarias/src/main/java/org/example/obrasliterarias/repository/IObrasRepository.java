package org.example.obrasliterarias.repository;

import org.example.obrasliterarias.model.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObrasRepository extends ElasticsearchRepository<Obra, String> {
    List<Obra> findAll();
    List<Obra> findObrasByAutor(String autor);
    List<Obra> findObrasByNombreContains(String nombre);
    List<Obra> findTop05ByOrderByPaginasDesc();
    List<Obra> findObrasByAnioPublicacionBefore(Integer anioPublicacion);
    List<Obra> findObrasByEditorial(String editorial);

}
