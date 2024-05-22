package com.example.showroomelastic.repository;

import com.example.showroomelastic.models.Clothe;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClotheRepository extends ElasticsearchRepository<Clothe, String> {
    List<Clothe> findAll();
    List<Clothe> findBySize(String size);
    List<Clothe> findByNombreContaining(String name);
}
