package org.example.obras_literalias.repository;

import org.example.obras_literalias.domain.ObraLiteraria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObraRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    Page<ObraLiteraria> findByAuthor(String author, Pageable pageable);
    Page<ObraLiteraria> findByNameContains(String title, Pageable pageable);
    Page<ObraLiteraria> findTop5ByOrderByAmountOfPagesDesc(Pageable pageable);
    Page<ObraLiteraria> findByPublishingYearIsLessThan(Integer year, Pageable pageable);
    Page<ObraLiteraria> findByEditorial(String editorial, Pageable pageable);
    @Query("{\"match\": {\"author\": {\"query\": \"?0\"}}}")
    Page<ObraLiteraria> findByAuthorName(String author, Pageable pageable);

}
