package com.mercadolibre.project_be_java_hisp_w26_team4.repository;

import com.mercadolibre.project_be_java_hisp_w26_team4.model.ProductType;
import com.mercadolibre.project_be_java_hisp_w26_team4.model.ProductTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeRepository extends JpaRepository<ProductType, Long>{
    ProductType findByDescription(ProductTypeEnum description);
}
