package com.mercadolibre.project_be_java_hisp_w26_team5.service;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.ProductDetailResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.ProductStockResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.StockInWarehouseResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_team5.enums.TypeProduct;
import com.mercadolibre.project_be_java_hisp_w26_team5.exceptions.error.NotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_team5.mapper.ProductMapper;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.*;
import com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces.IBatchRepository;
import com.mercadolibre.project_be_java_hisp_w26_team5.repository.interfaces.IProductRepository;
import com.mercadolibre.project_be_java_hisp_w26_team5.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
public class ProductServiceImplTest {

    @Mock
    IProductRepository productRepository;

    @Mock
    private IBatchRepository batchRepository;

    @InjectMocks
    ProductServiceImpl productService;

    static Product apple;
    static Product banana;
    private static Product product;
    private static UserEntity user;
    private static Warehouse warehouse;
    private static Sector sector;
    private static Batch batch1;
    private static Batch batch2;
    private static Batch batch3;
    private static List<Batch> listBatch;

    /* 3 semanas es el minimo a vencer de un lote.*/ int WEEKSEXPIRATION = 3;
    LocalDate expirationDate = LocalDate
            .now()
            .plusWeeks(WEEKSEXPIRATION);

    @BeforeAll
    static void setUp() {
        apple = Product
                .builder()
                .id(1)
                .name("Apple")
                .type(TypeProduct.FS)
                .seller(mock(UserEntity.class))
                .build();
        banana = Product
                .builder()
                .id(2)
                .name("Banana")
                .type(TypeProduct.FS)
                .seller(mock(UserEntity.class))
                .build();

        product = Product
                .builder()
                .id(1)
                .name("Product Name")
                .description("Product Description")
                .type(TypeProduct.FF)
                .seller(mock(UserEntity.class))
                .build();

        user = UserEntity
                .builder()
                .id(1)
                .build();

        warehouse = Warehouse
                .builder()
                .id(1)
                .manager(user)
                .build();

        sector = Sector
                .builder()
                .id(1)
                .warehouse(warehouse)
                .build();


        batch1 = Batch
                .builder()
                .id(1)
                .product(product)
                .sector(sector)
                .batchNumber("1")
                .currentQuantity(10)
                .dueDate(LocalDate
                        .now()
                        .plusWeeks(2))
                .build();

        batch2 = Batch
                .builder()
                .id(2)
                .product(product)
                .sector(sector)
                .batchNumber("2")
                .currentQuantity(20)
                .dueDate(LocalDate
                        .now()
                        .plusWeeks(4))
                .build();

        batch3 = Batch
                .builder()
                .id(2)
                .product(product)
                .sector(sector)
                .batchNumber("2")
                .currentQuantity(20)
                .dueDate(LocalDate
                        .now()
                        .plusWeeks(1))
                .build();

        listBatch = List.of(batch1, batch2);
    }

    @Test
    @DisplayName("Test getProducts with list response [apple,banana] success")
    void testGetProductsSuccess() {
        //arrange
        List<Product> products = List.of(apple, banana);
        when(productRepository.findAll()).thenReturn(products);

        //expected
        List<ProductDetailResponseDto> expected = ProductMapper.toProductDetailResponseDtoList(
                products);
        List<ProductDetailResponseDto> result = productService.getProducts();

        //assert
        assertEquals(expected, result);
        assertEquals(expected.size(), result.size());
    }

    @Test
    @DisplayName("Test getProducts with empty list response [] success")
    void testGetProductsEmptyList() {
        //arrange
        when(productRepository.findAll()).thenReturn(List.of());

        //expected
        List<ProductDetailResponseDto> expected = ProductMapper.toProductDetailResponseDtoList(List.of());
        List<ProductDetailResponseDto> result = productService.getProducts();

        //assert
        assertEquals(expected, result);
        assertEquals(expected.size(), result.size());
    }

    @Test
    @DisplayName("Test getProductsByCategory with list response [apple,banana] success")
    void testGetProductsByCategorySuccess() {
        //arrange
        List<Product> productsFresh = List.of(apple, banana);
        when(productRepository.findByType(TypeProduct.FS)).thenReturn(productsFresh);

        //expected
        List<ProductDetailResponseDto> expected = ProductMapper.toProductDetailResponseDtoList(
                productsFresh);
        List<ProductDetailResponseDto> result = productService.getProductsByCategory(List.of(apple
                .getType()
                .name()));

        //assert
        assertEquals(expected, result);
        assertEquals(expected.size(), result.size());
    }

    @Test
    @DisplayName("Obtengo la ubicación del producto con id:1 cuando existe y se encuentran lotes ordenados por numero de lote.")
    public void productLocationIsReturnedWhenProductExistsAndBatchesAreFound() {
        //Arrange
        Integer productId = 1;
        Integer managerId = 1;
        String order = "L";

        when(productRepository.existsById(productId)).thenReturn(true);
        when(batchRepository.findAllByProductIdAndDueDateGreaterThanEqualOrderByBatchNumber(
                productId,
                expirationDate)).thenReturn(listBatch);

        //Act
        productService.getProductLocationById(productId, managerId, order);

        //Assert
        verify(productRepository).existsById(1);
        verify(batchRepository).findAllByProductIdAndDueDateGreaterThanEqualOrderByBatchNumber(
                productId,
                expirationDate);
    }

    @Test
    @DisplayName("Obtengo la ubicación del producto con id:1 cuando existe y se encuentran lotes ordenados por cantidad.")
    public void productLocationIsReturnedWhenProductExistsAndBatchesAreFoundOrderByQuantity() {
        //Arrange
        Integer productId = 1;
        Integer managerId = 1;
        String order = "C";
        listBatch = listBatch
                .stream()
                .sorted(Comparator.comparing(Batch::getCurrentQuantity))
                .toList();

        when(productRepository.existsById(productId)).thenReturn(true);
        when(batchRepository.findAllByProductIdAndDueDateGreaterThanEqualOrderByCurrentQuantity(
                productId,
                expirationDate)).thenReturn(listBatch);

        //Act
        productService.getProductLocationById(productId, managerId, order);

        //Assert
        verify(productRepository).existsById(1);
        verify(batchRepository).findAllByProductIdAndDueDateGreaterThanEqualOrderByCurrentQuantity(
                productId,
                expirationDate);
    }

    @Test
    @DisplayName("Obtengo la ubicación del producto con id:1 cuando existe y se encuentran lotes ordenados por fecha de vencimiento.")
    public void productLocationIsReturnedWhenProductExistsAndBatchesAreFoundOrderByExpirationDate() {
        //Arrange
        Integer productId = 1;
        Integer managerId = 1;
        String order = "F";
        listBatch = listBatch
                .stream()
                .sorted(Comparator.comparing(Batch::getDueDate))
                .toList();

        when(productRepository.existsById(productId)).thenReturn(true);
        when(batchRepository.findAllByProductIdAndDueDateGreaterThanEqualOrderByDueDate(
                productId,
                expirationDate)).thenReturn(listBatch);

        //Act
        productService.getProductLocationById(productId, managerId, order);

        //Assert
        verify(productRepository).existsById(productId);
        verify(batchRepository).findAllByProductIdAndDueDateGreaterThanEqualOrderByDueDate(
                productId,
                expirationDate);
    }

    @Test
    @DisplayName("Busco la ubicación del producto con id:1 cuando no existe y se lanza una excepción")
    public void exceptionIsThrownWhenProductDoesNotExist() {
        //Arrange
        Integer productId = 1;
        Integer managerId = 1;
        String order = "L";
        when(productRepository.existsById(productId)).thenReturn(false);

        //Act & Assert
        assertThrows(NotFoundException.class,
                () -> productService.getProductLocationById(productId, managerId, order));

        verify(productRepository).existsById(productId);
        verify(batchRepository,
                never()).findAllByProductIdAndDueDateGreaterThanEqualOrderByBatchNumber(
                productId,
                expirationDate);
    }

    @Test
    @DisplayName("Busco la ubicación del producto con id:1 cuando no se encuentran lotes y se lanza una excepción")
    public void exceptionIsThrownWhenNoBatchesAreFoundForProduct() {
        //Arrange
        Integer productId = 1;
        Integer managerId = 1;
        String order = "L";
        when(productRepository.existsById(1)).thenReturn(true);
        when(batchRepository.findAllByProductIdAndDueDateGreaterThanEqualOrderByBatchNumber(
                productId,
                expirationDate)).thenReturn(Collections.emptyList());

        //Act & Assert
        assertThrows(NotFoundException.class,
                () -> productService.getProductLocationById(productId, managerId, order));

        verify(productRepository).existsById(productId);
        verify(batchRepository).findAllByProductIdAndDueDateGreaterThanEqualOrderByBatchNumber(
                productId,
                expirationDate);
    }

    @Test
    @DisplayName("Busco la ubicación del producto con id:1 cuando no se encuentra el warehouse del manager y se lanza una excepción")
    public void exceptionIsThrownWhenNoBatchesAreFoundInManagersWarehouse() {
        // Arrange
        Integer productId = 1;
        Integer managerId = 2;
        String order = "L";
        when(productRepository.existsById(productId)).thenReturn(true);
        when(batchRepository.findAllByProductIdAndDueDateGreaterThanEqualOrderByBatchNumber(
                productId,
                expirationDate)).thenReturn(listBatch);

        // Act & Assert
        assertThrows(NotFoundException.class,
                () -> productService.getProductLocationById(productId, managerId, order));
        verify(productRepository).existsById(productId);
        verify(batchRepository).findAllByProductIdAndDueDateGreaterThanEqualOrderByBatchNumber(
                productId,
                expirationDate);
    }

    @Test
    @DisplayName("Obtengo el stock total de los warehouses del producto con id:1 cuando existe y se encuentran lotes.")
    public void totalStockOfWarehousesIsReturnedWhenProductExistsAndBatchesAreFound() {
        //Arrange
        int productId = 1;
        when(productRepository.existsById(productId)).thenReturn(true);
        when(batchRepository.findAllByProductId(productId)).thenReturn(listBatch);

        ProductStockResponseDTO expected = ProductStockResponseDTO
                .builder()
                .productId(productId)
                .warehouses(List.of(StockInWarehouseResponseDTO
                        .builder()
                        .warehouseCode(1)
                        .totalQuantity(30)
                        .build()))
                .build();

        //Act
        ProductStockResponseDTO result = productService.getTotalStockOfWarehouses(productId);

        //Assert
        verify(productRepository).existsById(productId);
        verify(batchRepository).findAllByProductId(productId);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Obtengo el stock total de los warehouses del producto con id:1 cuando no se encuentran lotes y se lanza una excepción.")
    public void exceptionIsThrownWhenNoBatchesAreFoundForProductStock() {
        //Arrange
        int productId = 1;
        when(productRepository.existsById(productId)).thenReturn(true);
        when(batchRepository.findAllByProductId(productId)).thenReturn(Collections.emptyList());

        //Act & Assert
        assertThrows(NotFoundException.class,
                () -> productService.getTotalStockOfWarehouses(productId));

        verify(productRepository).existsById(productId);
        verify(batchRepository).findAllByProductId(productId);
    }

}
