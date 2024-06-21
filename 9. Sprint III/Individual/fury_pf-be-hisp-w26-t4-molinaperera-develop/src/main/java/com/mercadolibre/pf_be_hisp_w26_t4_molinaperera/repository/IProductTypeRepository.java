package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.repository;

import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.ProductType;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.model.ProductTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeRepository extends JpaRepository<ProductType, Long>{
    ProductType findByDescription(ProductTypeEnum description);
}
