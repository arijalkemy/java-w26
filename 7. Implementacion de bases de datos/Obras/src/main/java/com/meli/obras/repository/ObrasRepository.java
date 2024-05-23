package com.meli.obras.repository;

import com.meli.obras.model.Obras;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObrasRepository extends ElasticsearchRepository<Obras, String> {
    List<Obras> findAll();
    List<Obras> findByAutor(String autor);
    List<Obras> findByTituloContains(String title);
    List<Obras> findTop5ByOrderByPaginasDesc();
    List<Obras> findBypublicacionIsLessThan(Integer year);
    List<Obras> findByEditorial(String editorial);
}
