package com.mercadolibre.sprint_3_team_12.utils;

import com.mercadolibre.sprint_3_team_12.dto.SectionDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductCreationDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductCreationListRequestDTO;
import com.mercadolibre.sprint_3_team_12.dto.request.ProductDTO;
import com.mercadolibre.sprint_3_team_12.dto.response.*;
import com.mercadolibre.sprint_3_team_12.entity.*;
import com.mercadolibre.sprint_3_team_12.enums.Category;
import com.mercadolibre.sprint_3_team_12.projections.BatchStockProjection;
import com.mercadolibre.sprint_3_team_12.projections.ScarceWarehouseProjection;
import com.mercadolibre.sprint_3_team_12.projections.SectionProjection;
import com.mercadolibre.sprint_3_team_12.projections.WarehouseProjection;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
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
        return  Optional.of(new Product(1L,"1", 1.1, Category.FF, null, null, null));
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
        ResponseBatchDTO responseBatchDTO = ResponseBatchDTO.builder().idBatch(1).currentQuantity(1).dueDate(LocalDate.parse("1993-09-21")).build();
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
        return List.of(new BatchStockProjection(1L, 1, LocalDate.parse("1993-09-21")));
    }

    public static ProductCreationListRequestDTO productCreationListRequestDTOGenerator(){
        ProductCreationDTO product1 = new ProductCreationDTO("Product toy", 10.0, Category.FF);


        // Create a list to hold ProductCreationDTO objects
        List<ProductCreationDTO> productList = new ArrayList<>();
        productList.add(product1);


        ProductCreationListRequestDTO productCreationListRequestDTO = new ProductCreationListRequestDTO();
        productCreationListRequestDTO.setProductCreationDTO(productList);
        return productCreationListRequestDTO;
    }

    public static List<ScarceWarehouseProjection> createScarceWarehouseProjections() {
        List<ScarceWarehouseProjection> projections = new ArrayList<>();

        // Crear instancias de ScarceWarehouseProjection usando el builder generado por Lombok
        projections.add(ScarceWarehouseProjection.builder()
                .warehouseID(1L)
                .productID(101L)
                .productQuantity(50L)
                .build());

        projections.add(ScarceWarehouseProjection.builder()
                .warehouseID(2L)
                .productID(102L)
                .productQuantity(30L)
                .build());

        return projections;
    }

    public static List<ScarceWarehouseDTO> scarceWarehouseDTOListGenerator() {
        return List.of(
                ScarceWarehouseDTO.builder()
                        .warehouseCode(1L)
                        .products(
                                List.of(
                                        ProductDTO
                                                .builder()
                                                .idProduct(101)
                                                .quantity(50)
                                                .build())).build(),
                ScarceWarehouseDTO.builder()
                        .warehouseCode(2L)
                        .products(
                                List.of(
                                        ProductDTO
                                                .builder()
                                                .idProduct(102)
                                                .quantity(30)
                                                .build())).build()
        );
    }
}
