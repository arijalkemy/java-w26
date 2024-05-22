package com.showroom.showroom.repository;

import com.showroom.showroom.model.Cloth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothRepository extends CrudRepository<Cloth, Long> {
    List<Cloth> findAll();
    List<Cloth> findClothBySize( String size );
    Cloth findClothById( Long id );
    List<Cloth> findClothByNameContaining( String name );
}
