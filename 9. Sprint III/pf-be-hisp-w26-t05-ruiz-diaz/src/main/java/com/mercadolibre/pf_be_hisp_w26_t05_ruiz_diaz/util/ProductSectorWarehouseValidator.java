package com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.util;

import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.exceptions.error.WrongSectorException;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Product;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Sector;
import com.mercadolibre.pf_be_hisp_w26_t05_ruiz_diaz.model.Warehouse;
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
