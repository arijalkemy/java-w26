package org.example.showroom.repository;

import org.example.showroom.models.Clothes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IClothesRepository extends ElasticsearchRepository<Clothes, String> {
    List<Clothes> findAll();
    Page<Clothes> findAllBySize(String size, Pageable pageable);
    Page<Clothes> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
}
