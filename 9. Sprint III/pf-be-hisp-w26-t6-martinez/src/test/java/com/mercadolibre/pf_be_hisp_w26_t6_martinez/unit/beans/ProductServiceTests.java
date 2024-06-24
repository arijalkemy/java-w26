package com.mercadolibre.pf_be_hisp_w26_t6_martinez.unit.beans;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.ProductDto.ProductDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.ProductDto.ProductsResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.SectionDto.ListProductsBatchDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.SectionDto.SectionDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.WarehouseDto.ProductByWarehouseDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.dtos.WarehouseDto.WarehouseQuantityDto;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.Sector;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository.IProductsRepository;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.repository.IWarehousesRepository;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.services.product.ProductServiceImpl;
import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.StorageType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

    @Mock
    IProductsRepository productsRepository;

    @Mock
    IWarehousesRepository warehousesRepository;

    @InjectMocks
    ProductServiceImpl productService;

    static List<Warehouse> warehouses = new ArrayList<>();
    static Product product;

    private static ProductsResponseDto allProductsDto;
    private static List<Product>  allProducts;
    private static Product p1;
    private static ProductDto pd1;

    @BeforeEach
    void setup(){

        p1 =Product.builder().id(1L).name("Apple").unitPrice(10.0).storageType(StorageType.FS).build();
        Product p2 =Product.builder().id(2L).name("Ice Cream").unitPrice(15.0).storageType(StorageType.FF).build();

        pd1 = ProductDto.builder().id(1L).name("Apple").price(10).category(StorageType.FS).build();
        ProductDto pd2 = ProductDto.builder().id(2L).name("Ice Cream").price(15).category(StorageType.FF).build();

        allProducts = List.of(p1,p2);
        allProductsDto = ProductsResponseDto.builder().products(List.of( pd1, pd2)).build();

        // To test stock for each warehouse
        product = Product.builder().id(1L).name("Yogurt").storageType(StorageType.RF).unitPrice(1000.00)
                .build();

        Batch batch1 = Batch.builder().batchNumber(1025).product(product).quantity(40).id(1L)
                .dueDate(LocalDateTime.parse("2024-06-13T00:00"))
                .build();
        Batch batch2 = Batch.builder().batchNumber(124).product(product).quantity(400).id(1L)
                .dueDate(LocalDateTime.parse("2024-06-14T00:00"))
                .build();

        Sector frozenSector = Sector.builder().sectorCode(1L).storageType(StorageType.RF)
                .batches(List.of(batch1)).build();

        Sector frozenSector2 = Sector.builder().sectorCode(1L).storageType(StorageType.RF)
                .batches(List.of(batch2)).build();

        Warehouse warehouse1 = Warehouse.builder().warehouseCode(1).sectors(List.of(frozenSector)).build();
        Warehouse warehouse2 = Warehouse.builder().warehouseCode(2).sectors(List.of(frozenSector2)).build();

        warehouses = List.of(warehouse1,warehouse2);
    }

    @Test
    @DisplayName("List all products Test")
    public void testListAllProducts() {

        when( productsRepository.findAll()).thenReturn(allProducts);

        ProductsResponseDto response = productService.getAllProductsByCategory(null);

        Assertions.assertEquals(allProductsDto, response);
    }

    @Test
    @DisplayName("List all fresh products test")
    public void testListAllFreshProducts() {

        when( productsRepository.findAllByStorageType(StorageType.FS))
                .thenReturn( List.of(p1) );

        ProductsResponseDto response = productService.getAllProductsByCategory("FS");
        ProductsResponseDto expected =ProductsResponseDto.builder().products(List.of(pd1)).build();

        Assertions.assertEquals(expected, response);
    }

    @Test
    @DisplayName("No refrigerated products")
    public void testNoRefrigeratedProducts() {
        Assertions.assertThrows(NotFoundException.class, () -> productService.getAllProductsByCategory("RF"));
    }

    @Test
    @DisplayName("Invalid category test")
    public void testInvalidCategory() {
        Assertions.assertThrows(BadRequestException.class, () -> productService.getAllProductsByCategory("test"));
    }

    @Test
    @DisplayName("Find product stock in all warehouses - Good case")
    public void findProductStockInAllWarehouses(){

        // Act
        Mockito.when(productsRepository.findById(product.getId())).thenReturn(Optional.of(product));
        Mockito.when(warehousesRepository.findAll()).thenReturn(warehouses);

        ProductByWarehouseDto response = productService.getTotalStockByProduct(product.getId());
        int totalQuantityResponse = response.getWarehouses()
                .stream()
                .mapToInt(WarehouseQuantityDto::getTotalQuantity)
                .sum();

        // Asert
        Assertions.assertEquals(440, totalQuantityResponse);
    }

    @Test
    @DisplayName("Find product stock in all warehouses - bad case")
    public void findProductStockInAllWarehousesBadCase(){

        // Act
        Mockito.when(productsRepository.findById(4000L)).thenReturn(Optional.empty());

        // Asert
        Assertions.assertThrows(NotFoundException.class, () -> productService.getTotalStockByProduct(4000L));
    }

    @Test
    @DisplayName("Get batch_stock list, sector_code and warehouse_code of product: 1")
    void getBatchStockListByProductId(){
        // Arrange
        String username = "charlie";
        Mockito.when(productsRepository.findById(product.getId())).thenReturn(Optional.of(product));
        Mockito.when(warehousesRepository.findBySupervisorUsername(username)).thenReturn(this.warehouses.get(0));

        ListProductsBatchDto expectedResponse = ListProductsBatchDto.builder()
                .section(SectionDto.builder()
                        .sectionCode(1L)
                        .warehouseCode(1)
                        .build())
                .productId(1L)
                .batchStock(List.of())
                .build();

        // Act
        ListProductsBatchDto response = this.productService
                .listBatchsByProductId(product.getId(),username,null );

        // Assert
        Assertions.assertEquals(expectedResponse, response);
    }

    @Test
    @DisplayName("Get batch_stock list, sector_code and warehouse_code of product: 1 & order by quantity (C)")
    void getBatchStockListByProductIdAndOrderByQuantity(){
        this.getBatchStockListByProductIdAndOrderBy("C");
    }

    @Test
    @DisplayName("Get batch_stock list, sector_code and warehouse_code of product: 1 & order by batch_number (L)")
    void getBatchStockListByProductIdAndOrderByBatch(){
        this.getBatchStockListByProductIdAndOrderBy("L");
    }

    @Test
    @DisplayName("Get batch_stock list, sector_code and warehouse_code of product: 1 & order by due_date (D)")
    void getBatchStockListByProductIdAndOrderByDueDate(){
        this.getBatchStockListByProductIdAndOrderBy("F");
    }

    @Test
    @DisplayName("Error on get batch_stock list, sector_code and warehouse_code of product: 1 & unknown order type: K")
    void getBatchStockListByProductIdByUnknownOrderType(){
        // Arrange
        String username = "charlie";
        Mockito.when(productsRepository.findById(product.getId())).thenReturn(Optional.of(product));
        Mockito.when(warehousesRepository.findBySupervisorUsername(username)).thenReturn(this.warehouses.get(0));

        // Act & Assert
        Assertions.assertThrows(
                BadRequestException.class,
                () -> this.productService.listBatchsByProductId(product.getId(),username,"K" ));
    }

    @Test
    @DisplayName("Error on get batch_stock list, sector_code and warehouse_code unknown product: 10000")
    void getBatchStockListByUnknownProductId(){
        // Arrange
        String username = "charlie";
        Long productId = 10000L;
        Mockito.when(productsRepository.findById(productId)).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(
                NotFoundException.class,
                () -> this.productService.listBatchsByProductId(productId, username,null ));
    }

    // ----------
    private void getBatchStockListByProductIdAndOrderBy(String order){
        // Arrange
        String username = "charlie";
        Batch batch3 = Batch.builder().batchNumber(1026).product(product).quantity(60).id(1L)
                .dueDate(LocalDateTime.parse("2024-06-15T00:00"))
                .build();

        List<Batch> asd = new ArrayList<>(warehouses.get(0).getSectors().get(0).getBatches().stream().toList());
        asd.add(batch3);
        warehouses.get(0).getSectors().get(0).setBatches(asd);

        Mockito.when(productsRepository.findById(product.getId())).thenReturn(Optional.of(product));
        Mockito.when(warehousesRepository.findBySupervisorUsername(username)).thenReturn(this.warehouses.get(0));

        ListProductsBatchDto expectedResponse = ListProductsBatchDto.builder()
                .section(SectionDto.builder()
                        .sectionCode(1L)
                        .warehouseCode(1)
                        .build())
                .productId(1L)
                .batchStock(List.of())
                .build();

        // Act
        ListProductsBatchDto response = this.productService
                .listBatchsByProductId(product.getId(),username,order );

        // Assert
        Assertions.assertEquals(expectedResponse, response);
    }
}
