package com.example.showroom.repository;

import com.example.showroom.model.Sales;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalesRepository extends ElasticsearchRepository<Sales, String> {
    List<Sales> findAllByDate(LocalDate date);
}