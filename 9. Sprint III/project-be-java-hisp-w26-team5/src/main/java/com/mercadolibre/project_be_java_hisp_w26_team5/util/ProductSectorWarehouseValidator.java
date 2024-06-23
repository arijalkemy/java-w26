package com.mercadolibre.project_be_java_hisp_w26_team5.util;

import com.mercadolibre.project_be_java_hisp_w26_team5.exceptions.error.WrongSectorException;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.Product;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.Sector;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductSectorWarehouseValidator {
    private final Product product;
    private final Sector sector;
    private final Warehouse warehouse;

    public void validate(){
        if (!sector.getWarehouse().getId().equals(warehouse.getId())) {
            throw new WrongSectorException("The sector does not belong to that warehouse");
        }
        if (!sector.getType().equals(product.getType())) {
            throw new WrongSectorException("The product does not belong to that sector");
        }
    }
}
