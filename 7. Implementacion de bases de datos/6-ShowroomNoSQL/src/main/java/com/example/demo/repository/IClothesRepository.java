package com.example.demo.repository;

import com.example.demo.model.entity.Clothes;
import org.springframework.stereotype.Repository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

@Repository
public interface IClothesRepository extends ElasticsearchRepository<Clothes,Integer> {

    Clothes findByCode(Long code);
    List<Clothes> findBySize(String size);
    List<Clothes> findByType(String type);
}
