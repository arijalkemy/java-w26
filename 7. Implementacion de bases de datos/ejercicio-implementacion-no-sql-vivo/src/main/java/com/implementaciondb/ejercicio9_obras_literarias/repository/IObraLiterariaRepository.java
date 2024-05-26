package com.implementaciondb.ejercicio9_obras_literarias.repository;

import com.implementaciondb.ejercicio9_obras_literarias.model.domain.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    List<ObraLiteraria> findAllByAuthor(String author);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<ObraLiteraria> findAllByKeyWordFromTitle(String title);

    List<ObraLiteraria> findTop5ByOrderByNumberPagesDesc();

    @Query("{\"bool\": {\"must\": [{\"range\": {\"year_publication\": {\"lt\": ?0}}}]}}")
    List<ObraLiteraria> findByYearPublicationBefore(int year);

    List<ObraLiteraria> findAllByEditoria(String editorial);
}
