package com.mercadolibre.project_be_java_hisp_w26_t7.service;

import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.product.ProductResponseDTO;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection.IProductResponseProjection;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.projection.IWarehouseBatchProduct;
import com.mercadolibre.project_be_java_hisp_w26_t7.dtos.warehouse.StockQuantityResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_t7.entity.ProductSeller;
import com.mercadolibre.project_be_java_hisp_w26_t7.exceptions.NotFoundException;
import com.mercadolibre.project_be_java_hisp_w26_t7.repository.IProductSellerRepository;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.DataUtils;
import org.junit.jupiter.api.Assertions;
import com.mercadolibre.project_be_java_hisp_w26_t7.repository.IWarehouseRepository;
import com.mercadolibre.project_be_java_hisp_w26_t7.util.TestDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private IProductSellerRepository productSellerRepository;
    @Mock
    private IWarehouseRepository warehouseRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    void setUp() {

    }

    @Test
    @DisplayName("Debería retornar todos los productos en una lista de ProductResponseDTO sin importar la categoría")
    void getProductsTestWithOutCategoryTestHappyPath() {
        // Arrange
        String category = null;
        List<IProductResponseProjection> products = DataUtils.getProductsResponseProjection();
        List<ProductResponseDTO> expected = DataUtils.getProductsResponseDTO();

        when(productSellerRepository.findAllJoinProduct()).thenReturn(products);

        // Act
        List<ProductResponseDTO> output = productService.getProducts(category);

        // Assert
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Debería retornar la excepción NotFoundException porque la lista de productos está vacía " +
            "sin importar la categoría")
    void getProductsTestWithOutCategoryTestUnHappyPath() {
        // Arrange
        String category = null;
        List<IProductResponseProjection> products = List.of();

        when(productSellerRepository.findAllJoinProduct()).thenReturn(products);

        // Act and Assert
        assertThrows(NotFoundException.class, () -> productService.getProducts(category));
    }

    @Test
    @DisplayName("Debería retornar todos los productos con categoría FS en una lista de ProductResponseDTO")
    void getProductsTestWithFreshCategoryTestHappyPath() {
        // Arrange
        String category = "FS";
        String categoryMock = "FRESCO";

        List<IProductResponseProjection> products = DataUtils.getProductsFresh();
        List<ProductResponseDTO> expected = DataUtils.getProductsFreshDTO();

        when(productSellerRepository.findAllByCategory(categoryMock)).thenReturn(products);

        // Act
        List<ProductResponseDTO> output = productService.getProducts(category);

        // Assert
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Debería retornar todos los productos con categoría RF en una lista de ProductResponseDTO")
    void getProductsTestWithCooledCategoryTestHappyPath() {
        // Arrange
        String category = "RF";
        String categoryMock = "REFRIGERADO";

        List<IProductResponseProjection> products = DataUtils.getProductsCooled();
        List<ProductResponseDTO> expected = DataUtils.getProductsCooledDTO();

        when(productSellerRepository.findAllByCategory(categoryMock)).thenReturn(products);

        // Act
        List<ProductResponseDTO> output = productService.getProducts(category);

        // Assert
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Debería retornar todos los productos con categoría FF en una lista de ProductResponseDTO")
    void getProductsTestWithFrozenCategoryTestHappyPath() {
        // Arrange
        String category = "FF";
        String categoryMock = "CONGELADO";

        List<IProductResponseProjection> products = DataUtils.getProductsFrozen();
        List<ProductResponseDTO> expected = DataUtils.getProductsFrozenDTO();

        when(productSellerRepository.findAllByCategory(categoryMock)).thenReturn(products);

        // Act
        List<ProductResponseDTO> output = productService.getProducts(category);

        // Assert
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("Debería retornar la excepción NotFoundException porque la categoría enviada no es valida")
    void getProductsTestWithNotValidCategoryTestUnHappyPath() {
        // Arrange
        String category = "FSDR";

        // Act and Assert
        assertThrows(NotFoundException.class, () -> productService.getProducts(category));
    }

    @Test
    @DisplayName("Debería retornar la excepción NotFoundException porque no hay productos con la categoría enviada")
    void getProductsTestWithCategoryTestUnHappyPath() {
        String category = "FF";
        String categoryMock = "CONGELADO";

        List<IProductResponseProjection> products = List.of();

        when(productSellerRepository.findAllByCategory(categoryMock)).thenReturn(products);

        // Act and Assert
        assertThrows(NotFoundException.class, () -> productService.getProducts(category));
        verify(productSellerRepository, atLeast(1)).findAllByCategory(categoryMock);
    }

    @Test
    void findBatchListByProductTest() {
        // Arrange

        // Act
        productService.findBatchListByProduct(null, null);
        // Assert
    }

    @Test
    @DisplayName("Test - Find the product seller with ID 100 where an exception " +
            "will be generated because it is not registered.")
    void findStockQuantityForEachWarehouseTestException() {
        //Arrange
        Long id = 100L;

        Mockito.when(productSellerRepository.findById(id)).thenReturn(Optional.empty());
        //Act - Assert
        Assertions.assertThrows(NotFoundException.class,
                () -> productService.findStockQuantityForEachWarehouse(id));

    }

    @Test
    @DisplayName("Test - Find the product seller with ID 2 where an exception " +
            "will be generated because it is out of stock")
    void productSellerRegisteredOutStockException() {
        //Arrange
        Long id = 2L;
        ProductSeller productSeller = new ProductSeller();
        List<IWarehouseBatchProduct> warehouseBatchProduct = new ArrayList<>();

        Mockito.when(productSellerRepository.findById(id))
                .thenReturn(Optional.of(productSeller));
        Mockito.when(warehouseRepository.CalculationCuantityTheProductWarehouse(2L))
                .thenReturn(warehouseBatchProduct);
        //Act - Assert
        Assertions.assertThrows(NotFoundException.class,
                () -> productService.findStockQuantityForEachWarehouse(id));
    }

    @Test
    @DisplayName("Test - Find the product seller with ID 1 and cuantity for each Warehouse")
    void findStockQuantityForEachWarehouseTest() {
        // Arrange
        Long id = 1L;
        ProductSeller productSeller = TestDataGenerator.getProductSeller();
        List<IWarehouseBatchProduct> warehouseBatchProduct = TestDataGenerator.getIWarehouseBatchProduct();
        StockQuantityResponseDto expected_stockQuantityResponseDto = TestDataGenerator.getStockQuantityResponseDto();


        Mockito.when(productSellerRepository.findById(id))
                .thenReturn(Optional.of(productSeller));
        Mockito.when(warehouseRepository.CalculationCuantityTheProductWarehouse(id))
                .thenReturn(warehouseBatchProduct);

        // Act
        StockQuantityResponseDto obtained_stockQuantityResponseDto =
                productService.findStockQuantityForEachWarehouse(id);

        // Assert
        Assertions.assertInstanceOf(StockQuantityResponseDto.class, obtained_stockQuantityResponseDto);
        Assertions.assertNotNull(obtained_stockQuantityResponseDto);
        Assertions.assertEquals(
                expected_stockQuantityResponseDto.toString(),
                obtained_stockQuantityResponseDto.toString());

    }

}