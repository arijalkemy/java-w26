package com.implementaciondb.ejercicio10_showroom.repository;

import com.implementaciondb.ejercicio10_showroom.model.entity.Garment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGarmentRepository extends JpaRepository<Garment, Long> {

    List<Garment> findAllBySize(Integer size);

//    @Query ("SELECT g " +
//            "FROM Garment g " +
//            "WHERE LOWER(g.name) LIKE LOWER('%:name%')"
//    )
//    List<Garment> findAllByNameContains(@Param("name") String name);

    List<Garment> findAllByNameContainsIgnoreCase(String name);

}
