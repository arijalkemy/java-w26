package com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.service;

import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.ProductDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.ProductPromoDTO;
import com.mercadolibre.pf_be_hisp_w26_t4_molinaperera.dtos.response.WarehouseProductStockDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> searchAllProducts(String productType);
    WarehouseProductStockDTO searchProductStockInWarehouses(Long productId);

    ProductPromoDTO setProductPromo(Long id, Double porcentage);

    List<ProductPromoDTO> getProductPromoList();
}
