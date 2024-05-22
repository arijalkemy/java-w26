package com.example.showroomelastic.repository;

import com.example.showroomelastic.models.Sale;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface ISaleRepository extends ElasticsearchRepository<Sale, String> {
    List<Sale> findAll();
    List<Sale> findByFecha(LocalDate fecha);
    Sale findByNumero(String numero);
}
