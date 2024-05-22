package com.example.movieshqlasync.repository;

import com.example.movieshqlasync.model.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClotheRepository extends JpaRepository<Clothe, Integer> {
    List<Clothe> findAllByTalle(String size);
    List<Clothe> findAllByNombreContains(String name);

}
