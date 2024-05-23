package org.ggomezr.showroomelasticsearch.domain.repository;

import org.ggomezr.showroomelasticsearch.domain.model.Sale;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ISaleRepository extends ElasticsearchRepository<Sale, String>{
    List<Sale> findByDate(LocalDate date);
}
