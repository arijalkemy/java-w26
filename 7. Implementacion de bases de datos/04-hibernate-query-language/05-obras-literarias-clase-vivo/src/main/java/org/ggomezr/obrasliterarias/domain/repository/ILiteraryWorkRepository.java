package org.ggomezr.obrasliterarias.domain.repository;

import org.ggomezr.obrasliterarias.domain.model.LiteraryWork;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILiteraryWorkRepository extends ElasticsearchRepository<LiteraryWork, String> {
    List<LiteraryWork> findByAuthor(String author);
    List<LiteraryWork> findByTitleContaining(String title);
    List<LiteraryWork> findTop5ByOrderByPagesDesc();
    List<LiteraryWork> findByReleaseDateYearBefore(Integer releaseDateYear);
    List<LiteraryWork> findByEditorial(String editorial);
}
