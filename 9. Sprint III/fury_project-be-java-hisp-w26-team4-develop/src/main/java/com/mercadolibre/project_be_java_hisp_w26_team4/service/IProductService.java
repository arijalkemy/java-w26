package com.mercadolibre.project_be_java_hisp_w26_team4.service;

import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.WarehouseProductStockDTO;
import com.mercadolibre.project_be_java_hisp_w26_team4.dtos.response.ProductDTO;
import java.util.List;

public interface IProductService {
    List<ProductDTO> searchAllProducts(String productType);
    WarehouseProductStockDTO searchProductStockInWarehouses(Long productId);
}
