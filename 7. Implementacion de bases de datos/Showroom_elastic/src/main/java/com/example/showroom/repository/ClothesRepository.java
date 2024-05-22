package com.example.showroom.repository;

import com.example.showroom.model.Clothes;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClothesRepository extends ElasticsearchRepository<Clothes, String> {
     List<Clothes> findAllByBrandContains(String name);
     List<Clothes> findAllBySize(String size);
}