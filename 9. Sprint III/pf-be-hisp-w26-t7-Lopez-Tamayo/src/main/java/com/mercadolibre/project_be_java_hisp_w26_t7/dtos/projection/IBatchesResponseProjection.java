package com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection;

import java.time.LocalDate;

import com.mercadolibre.project_be_java_hisp_w26_t7.entity.Section;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.StorageType;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.Warehouse;
import java.util.Set;

public interface IBatchesResponseProjection {


    Integer getBatchNumber();

    LocalDate getDueDate(); 

    Integer getCurrentQuantity();

    Long getProductId(); 

    Long getStorageType();

}
