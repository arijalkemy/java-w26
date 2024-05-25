package com.example.demo.repository;

import com.example.demo.model.entity.Clothes;
import com.example.demo.model.entity.Sale;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISaleRepository extends ElasticsearchRepository<Sale,Long> {

    @Query("{\"bool\":{\"must\":[{\"match\":{\"date\":\"?0\"}}]}}")
    List<Clothes> findAllClothesBySaleDate(LocalDate date);

    @Query("{\"bool\":{\"must\":[{\"match\":{\"_id\":\"?0\"}}]}}")
    List<Clothes> findAllClothesBySale(Long saleId);

}
