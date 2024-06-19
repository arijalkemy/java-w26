package com.mercadolibre.sprint3_individual_perez.utils;

import com.mercadolibre.sprint3_individual_perez.dto.SectionDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.AllWarehousesDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.ResponseBatchDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.WarehouseDTO;
import com.mercadolibre.sprint3_individual_perez.dto.response.WarehouseStockDTO;
import com.mercadolibre.sprint3_individual_perez.entity.*;
import com.mercadolibre.sprint3_individual_perez.enums.Category;
import com.mercadolibre.sprint3_individual_perez.projections.BatchStockProjection;
import com.mercadolibre.sprint3_individual_perez.projections.SectionProjection;
import com.mercadolibre.sprint3_individual_perez.projections.WarehouseProjection;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class CustomObjectMapper {
    /**
     * Returns an AllWarehosueDto with idProduct 1 and 1 warehouse with warehousecode 1 and total items 1
     * @return
     */
    public static AllWarehousesDTO allWarehousesDTOGenerator(){
        WarehouseDTO warehouseDTO = WarehouseDTO.builder().warehouseCode(1).total(1).build();
        return AllWarehousesDTO.builder().idProduct(1).warehousesDTO(List.of(warehouseDTO)).build();
    }

    /**
     * Returns an Optional<Product>.
     * @return
     */
    public static Optional<Product> productGenerator(){
        User uss = User.builder().id(1L).build();
        return  Optional.of(new Product(1L,"1", 1.1, Category.FF, null, null,uss));
    }

    /**
     * Returns an WarehosueDto List with  warehousecode 1 and total items 1
     * @return
     */
    public static List<WarehouseProjection> warehouseProjectionListGenerator(){
        WarehouseProjection warehouseProjection = WarehouseProjection.builder().id(1L).totalQuantity(1L).build();

        return List.of(warehouseProjection);
    }

    /**
     * Returns an WarehosueDto with all fields with value 1
     * @return WarehouseStockDTO
     */
    public static WarehouseStockDTO warehouseStockDTOGenerator(){
        SectionDTO sectionDTO = SectionDTO.builder().sectionCode(1).warehouseCode(1).build();
        ResponseBatchDTO responseBatchDTO = ResponseBatchDTO.builder().idBatch(1).currentQuantity(1).dueDate(LocalDate.of(10,2,1)).build();
        return WarehouseStockDTO.builder().sectionDTO(sectionDTO).idProduct(1).batchDTOList(List.of(responseBatchDTO)).build();
    }

    public static List<Warehouse> warehouseGenerator(){
        return  List.of(Warehouse.builder().id(1L).name("Test").sections(List.of()).people(List.of()).build());
    }

    public static Optional<User> userGenerator(){
        return Optional.of(User.builder().build());
    }

    public static Optional<SectionProjection> sectionGenerator(){
        ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
        SectionProjection projection = factory.createProjection(SectionProjection.class);
        projection.setId(1L);
        return Optional.of(projection);
    }

    public static List<BatchStockProjection> batchStockProjectionListGenerator(){
        return List.of(new BatchStockProjection(1L, 1, LocalDate.of(10,2,1)));
    }
}
