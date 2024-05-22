package jpa.ejercicioelasticsearch.repository;

import jpa.ejercicioelasticsearch.model.ObraLiteraria;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {

    List<ObraLiteraria> findByAuthor(String author);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<ObraLiteraria> findAllByKeyWordFromTitle(String keyWord);

    List<ObraLiteraria> findTop5ByOrderByNumberPagesDesc();

    List<ObraLiteraria> findByYearPublicationBefore(int year);

    List<ObraLiteraria> findAllByEditorial(String editorial);


}
