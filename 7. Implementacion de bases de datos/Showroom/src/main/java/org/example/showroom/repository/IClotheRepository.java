package org.example.showroom.repository;

import org.example.showroom.entity.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClotheRepository extends JpaRepository<Clothe, Long> {
    List<Clothe> findBySize(String size);

    List<Clothe> findByNameContains(String query);
}
