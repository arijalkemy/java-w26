package org.ggomezr.showroommysql.domain.repository;

import org.ggomezr.showroommysql.domain.model.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothingRepository extends JpaRepository<Clothing, Long>{
    List<Clothing> findBySize(String size);
    List<Clothing> findByNameEqualsIgnoreCase(String name);
}
