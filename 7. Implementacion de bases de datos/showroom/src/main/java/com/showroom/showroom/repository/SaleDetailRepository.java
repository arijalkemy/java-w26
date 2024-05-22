package com.showroom.showroom.repository;

import com.showroom.showroom.model.SaleDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SaleDetailRepository extends CrudRepository<SaleDetail, Long> {
    List<SaleDetail> findBySaleId(Long saleId);
    List<SaleDetail> findByClothId(Long clothId);

}

