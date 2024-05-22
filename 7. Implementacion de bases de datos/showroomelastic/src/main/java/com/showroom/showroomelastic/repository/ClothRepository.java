package com.showroom.showroomelastic.repository;

import com.showroom.showroomelastic.model.Cloth;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothRepository extends ElasticsearchRepository<Cloth, String> {
    List<Cloth> findAll();
    List<Cloth> findClothBySize( String size );
    List<Cloth> findClothByNameContaining( String name );
}
