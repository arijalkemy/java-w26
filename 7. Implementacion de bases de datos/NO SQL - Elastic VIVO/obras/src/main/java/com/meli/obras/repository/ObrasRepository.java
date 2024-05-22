package com.meli.obras.repository;

import com.meli.obras.entities.Obras;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ObrasRepository extends ElasticsearchRepository<Obras, String> {
    List<Obras> findAll();
    List<Obras> findByAutor(String autor);
    List<Obras> findByNombre(String autor);
    List<Obras> findTop5ByOrderByPáginasDesc();

    List<Obras> findByPublicacionIsLessThan(Integer year);
}
