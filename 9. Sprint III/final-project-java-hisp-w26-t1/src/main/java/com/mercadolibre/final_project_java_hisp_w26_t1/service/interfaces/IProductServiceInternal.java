package com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces;

import com.mercadolibre.final_project_java_hisp_w26_t1.entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface IProductServiceInternal {

    Product findById(Integer id);


}
