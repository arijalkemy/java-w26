package com.example.ejercicio_obrasliterarias.repository;

import com.example.ejercicio_obrasliterarias.entities.LiteraryWork;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface LiteraryWorkRepository extends ElasticsearchRepository<LiteraryWork, String> {
    @Query("{\"bool\": {\"must\": [{\"match\": {\"author\": \"?0\"}}]}}")
    Page<LiteraryWork> findAllByAuthor(String author, Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    Page<LiteraryWork> findAllByTitle(String title, Pageable pageable);

    Page<LiteraryWork> findTop5ByOrderByPagesDesc(Pageable pageable);

    @Query("{\"range\": {\"firstPublicationYear\": {\"lt\": ?0}}}")
    Page<LiteraryWork> findAllBeforeYear(int year, Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"editorial\": \"?0\"}}]}}")
    Page<LiteraryWork> findAllByEditorial(String editorial, Pageable pageable);
}
