package org.example.literary_works.repository;

import org.example.literary_works.models.LiteraryWork;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ILiteraryWorkRepository extends ElasticsearchRepository<LiteraryWork, String> {
    @Override
    List<LiteraryWork> findAll();

    List<LiteraryWork> findByAuthorIgnoreCase(String author);
    List<LiteraryWork> findLiteraryWorkByTitleContainingIgnoreCase(String title);
    List<LiteraryWork> findTop5ByOrderByPagesQuantityDesc();
    List<LiteraryWork> findLiteraryWorkByYearFirstPublicationBefore(int yearFirstPublication);
    List<LiteraryWork> findByPublisherContainingIgnoreCase(String publisher);
}
