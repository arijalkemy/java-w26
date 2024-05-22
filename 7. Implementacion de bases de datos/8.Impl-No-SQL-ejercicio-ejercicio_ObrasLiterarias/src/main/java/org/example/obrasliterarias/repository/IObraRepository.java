package org.example.obrasliterarias.repository;

import org.example.obrasliterarias.model.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IObraRepository extends ElasticsearchRepository<Obra, String> {
    List<Obra> findByAutorContaining(String autor);

    List<Obra> findByNombre(String nombre);

    List<Obra> findTop5ByOrderByPaginasDesc();

    List<Obra> findByAnoIsLessThan(Integer ano);

    List<Obra> findObraByEditorial(String editorial);
}
