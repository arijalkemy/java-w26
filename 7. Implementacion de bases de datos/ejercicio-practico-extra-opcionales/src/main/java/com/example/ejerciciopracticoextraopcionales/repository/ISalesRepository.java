package com.example.ejerciciopracticoextraopcionales.repository;

import com.example.ejerciciopracticoextraopcionales.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ISalesRepository extends JpaRepository<Sale, Long> {

}
