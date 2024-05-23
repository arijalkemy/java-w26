package com.example.showroom.repository;

import com.example.showroom.entity.Cloth;
import com.example.showroom.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ISalesRepository extends JpaRepository<Sale, Long> {

}
