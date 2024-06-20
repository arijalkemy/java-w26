package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service;

import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.ShoppingCart;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.Warehouse;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IWarehouseService {
    Warehouse findById(Integer id);
    //Double getCantInboundOrderForMonth(Integer idWarehouse);
}
