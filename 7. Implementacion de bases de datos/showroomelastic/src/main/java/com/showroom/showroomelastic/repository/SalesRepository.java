package com.showroom.showroomelastic.repository;

import com.showroom.showroomelastic.model.Sale;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesRepository extends ElasticsearchRepository<Sale, String> {

    List<Sale> findAll();
    Sale findSaleByDate(LocalDate date);
}
