package org.example.obrasliterarias.repository;

import org.example.obrasliterarias.entity.ObraLiteraria;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface IObraLiteriaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    Page<ObraLiteraria> findByAuthor(String author, Pageable pageable);

    Page<ObraLiteraria> findByNameContains(String title, Pageable pageable);

    Page<ObraLiteraria> findTop5ByOrderByAmountOfPagesDesc(Pageable pageable);

    Page<ObraLiteraria> findByPublishingYearIsLessThan(Integer year, Pageable pageable);

    Page<ObraLiteraria> findByEditorial(String editorial, Pageable pageable);
}
