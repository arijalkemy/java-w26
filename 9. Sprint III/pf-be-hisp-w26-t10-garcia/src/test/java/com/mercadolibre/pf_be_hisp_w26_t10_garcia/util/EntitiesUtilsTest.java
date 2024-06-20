package com.mercadolibre.pf_be_hisp_w26_t10_garcia.util;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.BatchListProductDTO;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.BatchStockDTO;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.SectorDTO;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EntitiesUtilsTest {

    public static Warehouse warehouseComplete(){

        HashSet<Sector> sectors = new HashSet<>();
        sectors.add(sector());

        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);
        warehouse.setName("Warehouse Test");
        warehouse.setSupervisor(supervisor());
        warehouse.setSectors(sectors);

        return warehouse;
    }

    public static Warehouse warehouse(){

        Warehouse warehouse = new Warehouse();
        warehouse.setId(1);
        warehouse.setName("Warehouse Test");
        warehouse.setSupervisor(supervisor());

        return warehouse;
    }

    public static UserAccount supervisor(){
        UserAccount supervisor = new UserAccount();
        supervisor.setUserId(1L);
        supervisor.setFirstName("Pedrito");
        supervisor.setLastName("Perez");
        supervisor.setUsername("nhoyosp");
        supervisor.setPassword("$2a$10$QdjO1iHy/vOEpbIyb5gTuuysQWbrLOSzM8PTSL2kwWSUpL3NgYY0G");
        supervisor.setUserRole(Rol.SUPERVISOR);

        return supervisor;
    }

    public static Product  mazanaProductComplete(){
        Product product = mazanaProduct();
        product.setCategory(category());
        return product;
    }

    public static Product  mazanaProduct(){
        Product product = new Product();
        product.setId(1);
        product.setName("Mazana Verde");
        product.setPrice(1250.0);
        return product;
    }

    public static Category category(){
        Category category = new Category();
        category.setId(1);
        category.setName("FR");
        return category;
    }

    public static Sector sector(){
        Sector sector = new Sector();
        sector.setId(1);
        sector.setName("Sector Frescos");
        sector.setDescription("Frescos sector fruits");
        sector.setCategory(category());
        sector.setBatches(batches());
        return sector;
    }

    public static Sector sectorWithoutBatches(){
        Sector sector = new Sector();
        sector.setId(1);
        sector.setName("Sector Frescos");
        sector.setDescription("Frescos sector fruits");
        sector.setCategory(category());
        return sector;
    }

    public static Sector sectorComplete(){
        Sector sector = sector();
        sector.setWarehouse(warehouse());
        return sector;
    }

    public static HashSet<Batch> batches(){
        HashSet<Batch> batches = new HashSet<>();
        batches.add(firstBatch());
        batches.add(secondBatch());

        return batches;
    }

    public static Batch firstBatch(){
        Batch batch = new Batch();
        batch.setId(1);
        batch.setBatchNumber(125000);
        batch.setCurrentQuantity(100);
        batch.setDueDate(LocalDate.of(2024,7,30));
        batch.setProduct(mazanaProductComplete());
        return batch;
    }

    public static Batch secondBatch(){
        Batch batch = new Batch();
        batch.setId(2);
        batch.setBatchNumber(320000);
        batch.setCurrentQuantity(50);
        batch.setDueDate(LocalDate.of(2024,7,15));
        batch.setProduct(mazanaProductComplete());
        return batch;
    }

    public static Batch firstBatchComplete(){
        Batch batch = firstBatch();
        batch.setSector(sector());
        return batch;
    }

    public static Batch secondBatchComplete(){
        Batch batch = secondBatch();
        batch.setSector(sector());
        return batch;
    }

    public static BatchListProductDTO firsrtResponse(){
        BatchListProductDTO batchListProductDTO = new BatchListProductDTO();
        List<BatchStockDTO> batchStockDTOList = new ArrayList<>();
        batchStockDTOList.add(new BatchStockDTO(320000,50,LocalDate.of(2024,7,15)));
        batchStockDTOList.add(new BatchStockDTO(125000,100,LocalDate.of(2024,7,30)));

        batchListProductDTO.setBatch_stock(batchStockDTOList);
        batchListProductDTO.setProduct_id(1);
        batchListProductDTO.setSection(new SectorDTO(1,1));
        return batchListProductDTO;
    }

    public static BatchListProductDTO secondBatchResponse(){
        BatchListProductDTO batchListProductDTO = new BatchListProductDTO();
        List<BatchStockDTO> batchStockDTOList = new ArrayList<>();
        batchStockDTOList.add(new BatchStockDTO(125000,100,LocalDate.of(2024,7,30)));
        batchStockDTOList.add(new BatchStockDTO(320000,50,LocalDate.of(2024,7,15)));

        batchListProductDTO.setBatch_stock(batchStockDTOList);
        batchListProductDTO.setProduct_id(1);
        batchListProductDTO.setSection(new SectorDTO(1,1));
        return batchListProductDTO;
    }
}
