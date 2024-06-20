package com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.unit.service;


import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.dtos.BatchListProductDTO;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service.implementations.ProductServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service.implementations.SearchServiceImp;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service.implementations.SectorServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.service.implementations.WarehouseServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t10_guzmanq.util.EntitiesUtilsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SearchServiceControllerTest {

    @Mock
    private ProductServiceImpl productService;

    @Mock
    private WarehouseServiceImpl warehouseService;

    @Mock
    private SectorServiceImpl sectorService;

    @InjectMocks
    private SearchServiceImp searchService;


    @DisplayName("US-03: Search productses on batch")
    @Test
    public void sectorProductBatch() {
        //Arrange
        Product product = EntitiesUtilsTest.mazanaProduct();
        Warehouse warehouse = EntitiesUtilsTest.warehouse();
        Sector sector = EntitiesUtilsTest.sector();

        //Act
        when(productService.findById(1)).thenReturn(product);
        when(warehouseService.findById(1)).thenReturn(warehouse);
        when(sectorService.searchSectorByCategoryAndWorehouse(product.getCategory(),warehouse)).thenReturn(sector);

        //Assert
        BatchListProductDTO response = searchService.searchProduct(1, null);
        Assertions.assertEquals(EntitiesUtilsTest.firsrtResponse(), response);

    }


    @DisplayName("US-03: Search products on batches filter due date")
    @Test
    public void sectorProductBatchOrderByDateTest() {
        //Arrange
        Product product = EntitiesUtilsTest.mazanaProduct();
        Warehouse warehouse = EntitiesUtilsTest.warehouse();
        Sector sector = EntitiesUtilsTest.sector();

        //Act
        when(productService.findById(1)).thenReturn(product);
        when(warehouseService.findById(1)).thenReturn(warehouse);
        when(sectorService.searchSectorByCategoryAndWorehouse(product.getCategory(),warehouse)).thenReturn(sector);

        //Assert
        BatchListProductDTO response = searchService.searchProduct(1, "F");
        Assertions.assertEquals(EntitiesUtilsTest.secondBatchResponse(), response);

    }

    @DisplayName("US-03: Search products on batches filter current quantity")
    @Test
    public void sectorProductBatchOrderByCurrentQuantityTest() {
        //Arrange
        Product product = EntitiesUtilsTest.mazanaProduct();
        Warehouse warehouse = EntitiesUtilsTest.warehouse();
        Sector sector = EntitiesUtilsTest.sector();

        //Act
        when(productService.findById(1)).thenReturn(product);
        when(warehouseService.findById(1)).thenReturn(warehouse);
        when(sectorService.searchSectorByCategoryAndWorehouse(product.getCategory(),warehouse)).thenReturn(sector);

        //Assert
        BatchListProductDTO response = searchService.searchProduct(1, "C");
        Assertions.assertEquals(EntitiesUtilsTest.secondBatchResponse(), response);

    }

    @DisplayName("US-03: Search products on batches filter current quantity")
    @Test
    public void sectorProductBatchOrderByBatchTest() {
        //Arrange
        Product product = EntitiesUtilsTest.mazanaProduct();
        Warehouse warehouse = EntitiesUtilsTest.warehouse();
        Sector sector = EntitiesUtilsTest.sector();

        //Act
        when(productService.findById(1)).thenReturn(product);
        when(warehouseService.findById(1)).thenReturn(warehouse);
        when(sectorService.searchSectorByCategoryAndWorehouse(product.getCategory(),warehouse)).thenReturn(sector);

        //Assert
        BatchListProductDTO response = searchService.searchProduct(1, "L");
        Assertions.assertEquals(EntitiesUtilsTest.firsrtResponse(), response);

    }


    @DisplayName("US-03: Search products on batches, filter name dont exist")
    @Test
    public void sectorProductBatchNotFoundFilterTest() {
        Product product = EntitiesUtilsTest.mazanaProduct();
        Warehouse warehouse = EntitiesUtilsTest.warehouse();
        Sector sector = EntitiesUtilsTest.sector();

        when(productService.findById(1)).thenReturn(product);
        when(warehouseService.findById(1)).thenReturn(warehouse);
        when(sectorService.searchSectorByCategoryAndWorehouse(product.getCategory(),warehouse)).thenReturn(sector);

        //Asserts
        Assertions.assertThrows(NotFoundException.class, () -> searchService.searchProduct(1, "X"));



    }







}
