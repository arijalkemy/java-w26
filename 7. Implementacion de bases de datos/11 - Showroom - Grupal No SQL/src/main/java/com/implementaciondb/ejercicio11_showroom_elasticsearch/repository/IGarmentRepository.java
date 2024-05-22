package com.implementaciondb.ejercicio11_showroom_elasticsearch.repository;

import com.implementaciondb.ejercicio11_showroom_elasticsearch.model.entity.Garment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGarmentRepository extends ElasticsearchRepository<Garment, String> {

    List<Garment> findAllBySize(Integer size);

    List<Garment> findAll();
    List<Garment> findAllByNameContainsIgnoreCase(String name);

}
