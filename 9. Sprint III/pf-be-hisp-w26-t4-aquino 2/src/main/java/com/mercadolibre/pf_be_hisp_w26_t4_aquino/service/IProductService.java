package com.mercadolibre.pf_be_hisp_w26_t4_aquino.service;

import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.response.WarehouseProductStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_aquino.dtos.response.ProductDTO;
import java.util.List;

public interface IProductService {
    List<ProductDTO> searchAllProducts(String productType);
    WarehouseProductStockDTO searchProductStockInWarehouses(Long productId);
}
