package Ejercicio.ElasticSearch.Repository;

import Ejercicio.ElasticSearch.Entity.LiteraryWork;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IElasticRepository extends ElasticsearchRepository<LiteraryWork, String> {
    List<LiteraryWork> findByAuthor(String author);

    List<LiteraryWork> findByNameLike(String name);

    List<LiteraryWork> findAllByPagesOrderByPagesDesc();

    List<LiteraryWork> findByPublicationDateLessThanEqual(int anio);

    List<LiteraryWork> findByPublicationDateLessThanEqual(LocalDate publicationDate);

    List<LiteraryWork> findByEditorial(String editorial);
}
