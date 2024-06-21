package com.mercadolibre.pf_be_hisp_w26_t7_villarraga.service;

import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.beans.AuthDataUtil;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.batch.BSResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.product.*;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.projection.IBatchSectionProductProjection;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.projection.IProductResponseProjection;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.projection.IWarehouseBatchProduct;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.dtos.warehouse.StockQuantityResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.ProductSeller;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.Seller;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.entity.StorageType;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.repository.*;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.DataUtils;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.ProductUtil;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.TestDataGenerator;
import com.mercadolibre.pf_be_hisp_w26_t7_villarraga.util.enums.MessageError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private IProductSellerRepository productSellerRepository;
    @Mock
    private IProductRepository productRepository;
    @Mock
    private IBatchRepository batchRepository;
    @Mock
    private IWarehouseRepository warehouseRepository;
    @Mock
    private ISellerRepository sellerRepository;
    @Mock
    private IStorageTypeRepository storageTypeRepository;

    @InjectMocks
    private ProductServiceImpl productService;
    @Mock
    private AuthDataUtil authDataUtil;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
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
    @DisplayName("Debería retornar la excepción NotFoundException porque la lista de productos está vacía " + "sin importar la categoría")
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
    @DisplayName("Test - Find the product seller with ID 100 where an exception " + "will be generated because it is not registered.")
    void findStockQuantityForEachWarehouseTestException() {
        //Arrange
        Long id = 100L;

        Mockito.when(productSellerRepository.findById(id)).thenReturn(Optional.empty());
        //Act - Assert
        Assertions.assertThrows(NotFoundException.class, () -> productService.findStockQuantityForEachWarehouse(id));

    }

    @Test
    @DisplayName("Test - Find the product seller with ID 2 where an exception " + "will be generated because it is out of stock")
    void productSellerRegisteredOutStockException() {
        //Arrange
        Long id = 2L;
        ProductSeller productSeller = new ProductSeller();
        List<IWarehouseBatchProduct> warehouseBatchProduct = new ArrayList<>();

        Mockito.when(productSellerRepository.findById(id)).thenReturn(Optional.of(productSeller));
        Mockito.when(warehouseRepository.CalculationCuantityTheProductWarehouse(2L)).thenReturn(warehouseBatchProduct);
        //Act - Assert
        Assertions.assertThrows(NotFoundException.class, () -> productService.findStockQuantityForEachWarehouse(id));
    }

    @Test
    @DisplayName("Test - Find the product seller with ID 1 and cuantity for each Warehouse")
    void findStockQuantityForEachWarehouseTest() {
        // Arrange
        Long id = 1L;
        ProductSeller productSeller = TestDataGenerator.getProductSeller();
        List<IWarehouseBatchProduct> warehouseBatchProduct = TestDataGenerator.getIWarehouseBatchProduct();
        StockQuantityResponseDto expected_stockQuantityResponseDto = TestDataGenerator.getStockQuantityResponseDto();


        Mockito.when(productSellerRepository.findById(id)).thenReturn(Optional.of(productSeller));
        Mockito.when(warehouseRepository.CalculationCuantityTheProductWarehouse(id)).thenReturn(warehouseBatchProduct);

        // Act
        StockQuantityResponseDto obtained_stockQuantityResponseDto = productService.findStockQuantityForEachWarehouse(id);

        // Assert
        Assertions.assertInstanceOf(StockQuantityResponseDto.class, obtained_stockQuantityResponseDto);
        Assertions.assertNotNull(obtained_stockQuantityResponseDto);
        Assertions.assertEquals(expected_stockQuantityResponseDto.toString(), obtained_stockQuantityResponseDto.toString());

    }

    @Test
    @DisplayName("Test checkLocationForProduct - Happy Path")
    void testCheckLocationForProduct_HappyPath() {
        Long idProduct = 1L;
        String order = null;
        Long idRepresentative = 1L;

        ProductSeller mockProduct = new ProductSeller();
        mockProduct.setId(idProduct);

        List<IBatchSectionProductProjection> mockProjections = Stream.of(createProjection(100, 50, LocalDate.now().plusWeeks(4), 1L, 1L, idProduct), createProjection(101, 30, LocalDate.now().plusWeeks(5), 1L, 1L, idProduct)).collect(Collectors.toList());

        when(authDataUtil.getIdSession()).thenReturn(idRepresentative);
        when(productSellerRepository.findById(idProduct)).thenReturn(Optional.of(mockProduct));
        when(batchRepository.findProductBySectionWarehouse(idProduct, idRepresentative)).thenReturn(mockProjections);

        LocationForProductDTO response = productService.checkLocationForProduct(idProduct, order);

        assertNotNull(response);
        assertEquals(idProduct, response.getProductId());
        assertEquals(1, response.getSection().getSectionCode());
        assertEquals(1, response.getSection().getWarehouseCode());

        assertEquals(2, response.getBatchStock().size());

        response.getBatchStock().forEach(batch -> assertTrue(batch.getDueDate().isAfter(LocalDate.now().plusWeeks(3))));
    }

    @Test
    @DisplayName("Test checkLocationForProduct - Not Happy Path (Product Not Found)")
    void testCheckLocationForProduct_ProductNotFound() {
        Long idProduct = 1L;
        String order = null;

        when(productSellerRepository.findById(idProduct)).thenReturn(Optional.empty());

        NotFoundException thrown = assertThrows(NotFoundException.class, () -> productService.checkLocationForProduct(idProduct, order));

        assertEquals(MessageError.PRODUCT_NOT_FOUND.getMessage(idProduct), thrown.getMessage());
    }

    @Test
    @DisplayName("Test checkLocationForProduct - Not Happy Path (Batch Not Found)")
    void testCheckLocationForProduct_BatchNotFound() {
        Long idProduct = 1L;
        String order = null;
        Long idRepresentative = 1L;

        ProductSeller mockProduct = new ProductSeller();
        mockProduct.setId(idProduct);

        when(authDataUtil.getIdSession()).thenReturn(idRepresentative);
        when(productSellerRepository.findById(idProduct)).thenReturn(Optional.of(mockProduct));
        when(batchRepository.findProductBySectionWarehouse(idProduct, idRepresentative)).thenReturn(Collections.emptyList());

        NotFoundException thrown = assertThrows(NotFoundException.class, () -> productService.checkLocationForProduct(idProduct, order));

        assertEquals("The product was not found in any of the batches", thrown.getMessage());
    }

    @Test
    @DisplayName("Test checkLocationForProduct - Not Happy Path (Invalid Order)")
    void testCheckLocationForProduct_InvalidOrder() {
        Long idProduct = 1L;
        String order = "invalid_order";

        BadRequestException thrown = assertThrows(BadRequestException.class, () -> productService.checkLocationForProduct(idProduct, order));

        assertEquals(MessageError.INVALID_SORTING.getMessage(), thrown.getMessage());
    }

    @Test
    @DisplayName("Test checkLocationForProduct - Happy Path (Order by Batch)")
    void testCheckLocationForProduct_HappyPathOrderByBatch() {
        Long idProduct = 1L;
        String order = "L";
        Long idRepresentative = 1L;

        ProductSeller mockProduct = new ProductSeller();
        mockProduct.setId(idProduct);

        List<IBatchSectionProductProjection> mockProjections = Stream.of(createProjection(100, 50, LocalDate.of(2024, 9, 1), 1L, 1L, idProduct), createProjection(101, 40, LocalDate.of(2024, 11, 15), 2L, 1L, idProduct), createProjection(102, 60, LocalDate.of(2024, 10, 1), 1L, 2L, idProduct)).collect(Collectors.toList());

        when(authDataUtil.getIdSession()).thenReturn(idRepresentative);
        when(productSellerRepository.findById(idProduct)).thenReturn(Optional.of(mockProduct));
        when(batchRepository.findProductBySectionWarehouse(idProduct, idRepresentative)).thenReturn(mockProjections);

        LocationForProductDTO response = productService.checkLocationForProduct(idProduct, order);

        assertNotNull(response);
        assertEquals(idProduct, response.getProductId());
        assertEquals(1, response.getSection().getSectionCode());
        assertEquals(1, response.getSection().getWarehouseCode());
        assertEquals(3, response.getBatchStock().size());

        assertEquals(100, response.getBatchStock().get(0).getId());
        assertEquals(101, response.getBatchStock().get(1).getId());
        assertEquals(102, response.getBatchStock().get(2).getId());
    }

    @Test
    @DisplayName("Test checkLocationForProduct - Happy Path (Order by Current Quantity)")
    void testCheckLocationForProduct_HappyPathOrderByCurrentQuantity() {
        Long idProduct = 1L;
        String order = "C";
        Long idRepresentative = 1L;

        ProductSeller mockProduct = new ProductSeller();
        mockProduct.setId(idProduct);

        List<IBatchSectionProductProjection> mockProjections = Stream.of(createProjection(100, 50, LocalDate.of(2024, 8, 15), 1L, 1L, idProduct), createProjection(101, 40, LocalDate.of(2024, 9, 1), 2L, 1L, idProduct), createProjection(102, 60, LocalDate.of(2024, 10, 1), 1L, 2L, idProduct)).collect(Collectors.toList());

        when(authDataUtil.getIdSession()).thenReturn(idRepresentative);
        when(productSellerRepository.findById(idProduct)).thenReturn(Optional.of(mockProduct));
        when(batchRepository.findProductBySectionWarehouse(idProduct, idRepresentative)).thenReturn(mockProjections);

        LocationForProductDTO response = productService.checkLocationForProduct(idProduct, order);

        assertNotNull(response);
        assertEquals(idProduct, response.getProductId());
        assertEquals(1, response.getSection().getSectionCode());
        assertEquals(1, response.getSection().getWarehouseCode());
        assertEquals(3, response.getBatchStock().size());

        assertEquals(101, response.getBatchStock().get(0).getId());
        assertEquals(100, response.getBatchStock().get(1).getId());
        assertEquals(102, response.getBatchStock().get(2).getId());

        response.getBatchStock().forEach(batch -> assertTrue(batch.getDueDate().isAfter(LocalDate.now().plusWeeks(3))));
    }

    @Test
    @DisplayName("Test checkLocationForProduct - Happy Path (Order by Due Date)")
    void testCheckLocationForProduct_HappyPathOrderByDueDate() {
        Long idProduct = 1L;
        String order = "F";
        Long idRepresentative = 1L;

        ProductSeller mockProduct = new ProductSeller();
        mockProduct.setId(idProduct);

        List<IBatchSectionProductProjection> mockProjections = Stream.of(createProjection(100, 50, LocalDate.of(2024, 10, 1), 1L, 1L, idProduct), createProjection(101, 40, LocalDate.of(2024, 10, 15), 2L, 1L, idProduct), createProjection(102, 60, LocalDate.of(2024, 11, 1), 1L, 2L, idProduct)).collect(Collectors.toList());

        when(authDataUtil.getIdSession()).thenReturn(idRepresentative);
        when(productSellerRepository.findById(idProduct)).thenReturn(Optional.of(mockProduct));
        when(batchRepository.findProductBySectionWarehouse(idProduct, idRepresentative)).thenReturn(mockProjections);

        LocationForProductDTO response = productService.checkLocationForProduct(idProduct, order);

        assertNotNull(response);
        assertEquals(idProduct, response.getProductId());
        assertEquals(1, response.getSection().getSectionCode());
        assertEquals(1, response.getSection().getWarehouseCode());
        assertEquals(3, response.getBatchStock().size());

        assertEquals(100, response.getBatchStock().get(0).getId());
        assertEquals(101, response.getBatchStock().get(1).getId());
        assertEquals(102, response.getBatchStock().get(2).getId());
    }

    @Test
    @DisplayName("Test getProductBatchByOrder with invalid order")
    void testGetProductBatchByOrder_InvalidOrder() {
        List<BSResponseDTO> responseList = Arrays.asList(new BSResponseDTO(1, 10, LocalDate.now()), new BSResponseDTO(2, 20, LocalDate.now().plusDays(1)));

        List<BSResponseDTO> result = ProductUtil.getProductBatchByOrder(responseList, "INVALID_ORDER");

        assertSame(responseList, result);
    }

    @Test
    @DisplayName("Test checkLocationForProduct - No Batches Found")
    void testCheckLocationForProduct_NoBatchesFound() {
        Long idProduct = 1L;
        ProductSeller mockProduct = new ProductSeller();
        Long idRepresentative = 1L;
        mockProduct.setId(idProduct);

        when(authDataUtil.getIdSession()).thenReturn(idRepresentative);


        when(productSellerRepository.findById(idProduct)).thenReturn(Optional.of(mockProduct));
        when(batchRepository.findProductBySectionWarehouse(idProduct, idRepresentative)).thenReturn(Collections.emptyList());

        NotFoundException thrown = assertThrows(NotFoundException.class, () -> productService.checkLocationForProduct(idProduct, null));

        assertEquals("The product was not found in any of the batches", thrown.getMessage());
    }

    @Test
    @DisplayName("Test checkLocationForProduct - Product Appears in Less Than Two Batches")
    void testCheckLocationForProduct_ProductAppearsInLessThanTwoBatches() {
        Long idProduct = 1L;
        String order = null;
        Long idRepresentative = 1L;

        ProductSeller mockProduct = new ProductSeller();
        mockProduct.setId(idProduct);

        List<IBatchSectionProductProjection> mockProjections = Stream.of(createProjection(100, 50, LocalDate.of(2024, 10, 1), 1L, 1L, idProduct)).collect(Collectors.toList());

        when(authDataUtil.getIdSession()).thenReturn(idRepresentative);
        when(productSellerRepository.findById(idProduct)).thenReturn(Optional.of(mockProduct));
        when(batchRepository.findProductBySectionWarehouse(idProduct, idRepresentative)).thenReturn(mockProjections);

        BadRequestException thrown = assertThrows(BadRequestException.class, () -> productService.checkLocationForProduct(idProduct, order));
        assertEquals("Product must appear in at least two different batches", thrown.getMessage());
    }

    @Test
    @DisplayName("Test checkLocationForProduct - Product Appears in the Same Batch Multiple Times")
    void testCheckLocationForProduct_ProductAppearsInSameBatchMultipleTimes() {
        Long idProduct = 1L;
        String order = null;
        Long idRepresentative = 1L;

        ProductSeller mockProduct = new ProductSeller();
        mockProduct.setId(idProduct);

        List<IBatchSectionProductProjection> mockProjections = Stream.of(createProjection(100, 50, LocalDate.of(2024, 10, 1), 1L, 1L, idProduct), createProjection(100, 30, LocalDate.of(2024, 11, 1), 1L, 1L, idProduct)).collect(Collectors.toList());

        when(authDataUtil.getIdSession()).thenReturn(idRepresentative);
        when(productSellerRepository.findById(idProduct)).thenReturn(Optional.of(mockProduct));
        when(batchRepository.findProductBySectionWarehouse(idProduct, idRepresentative)).thenReturn(mockProjections);

        BadRequestException thrown = assertThrows(BadRequestException.class, () -> productService.checkLocationForProduct(idProduct, order));

        assertEquals("Product appears in the same batch multiple times", thrown.getMessage());
    }


    private IBatchSectionProductProjection createProjection(int batchNumber, int currentQuantity, LocalDate dueDate, Long sectionCode, Long warehouseCode, Long productId) {
        return new IBatchSectionProductProjection() {
            @Override
            public Integer getBatchNumber() {
                return batchNumber;
            }

            @Override
            public Integer getCurrentQuantity() {
                return currentQuantity;
            }

            @Override
            public LocalDate getDueDate() {
                return dueDate;
            }

            @Override
            public Long getSectionCode() {
                return sectionCode;
            }

            @Override
            public Long getWarehouseCode() {
                return warehouseCode;
            }

            @Override
            public Long getProductId() {
                return productId;
            }

            @Override
            public List<BSResponseDTO> getBatchStock() {
                return Collections.emptyList();

            }
        };
    }

    @Test
    @DisplayName("create product seller, product exist but no associated to seller")
    public void createProductExist() {
        Long sellerId = 1L;
        Seller seller = DataUtils.getSeller();
        StorageType storageType = DataUtils.getStorageType();
        Product product = DataUtils.getProduct();
        String description = product.getDescription();
        ProductSeller productSeller = DataUtils.getProductSeller();
        ProductCreateResponseDto expected = ProductCreateResponseDto.builder().build();
        ListProductRequestDto body = ListProductRequestDto.builder().products(List.of(ProductRequestDto.builder().price(23.3).description(description).storageType("Fresh").build())).build();

        when(authDataUtil.getIdSession()).thenReturn(sellerId);
        when(sellerRepository.findById(sellerId)).thenReturn(Optional.of(seller));
        when(storageTypeRepository.findByName("Fresh")).thenReturn(Optional.of(storageType));
        when(productRepository.findByDescriptionAndStorageType(description, storageType)).thenReturn(Optional.of(product));
        when(productSellerRepository.findByProductAndSeller(product, seller)).thenReturn(Optional.of(productSeller));
        ProductCreateResponseDto actual = productService.createProduct(1L, body);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("create product seller, product no exist and no associated to seller")
    public void createProductNoExists() {
        Long sellerId = 1L;
        Seller seller = DataUtils.getSeller();
        StorageType storageType = DataUtils.getStorageType();
        Product product = DataUtils.getProduct();
        String description = product.getDescription();
        ProductSeller productSeller = DataUtils.getProductSeller();
        ProductCreateResponseDto expected = ProductCreateResponseDto.builder().build();
        ListProductRequestDto body = ListProductRequestDto.builder().products(List.of(ProductRequestDto.builder().price(23.3).description(description).storageType("Fresh").build())).build();

        when(authDataUtil.getIdSession()).thenReturn(sellerId);
        when(sellerRepository.findById(sellerId)).thenReturn(Optional.of(seller));
        when(storageTypeRepository.findByName("Fresh")).thenReturn(Optional.of(storageType));
        when(productRepository.findByDescriptionAndStorageType(description, storageType)).thenReturn(Optional.empty());
        when(productRepository.save(Product.builder().description(description).storageType(storageType).build())).thenReturn(product);
        when(productSellerRepository.findByProductAndSeller(product, seller)).thenReturn(Optional.of(productSeller));
        ProductCreateResponseDto actual = productService.createProduct(1L, body);
        assertEquals(expected, actual);
    }

    @Test
    public void createProductSellerEmpty() {
        Long sellerId = 1L;
        Seller seller = DataUtils.getSeller();
        StorageType storageType = DataUtils.getStorageType();
        Product product = DataUtils.getProduct();
        double price = 23.3;
        String description = product.getDescription();
        ProductSeller productSeller = DataUtils.getProductSeller();
        ProductCreateResponseDto expected = ProductCreateResponseDto.builder().build();
        ListProductRequestDto body = ListProductRequestDto.builder().products(List.of(ProductRequestDto.builder().price(price).description(description).storageType("Fresh").build())).build();
        when(authDataUtil.getIdSession()).thenReturn(sellerId);
        when(sellerRepository.findById(sellerId)).thenReturn(Optional.of(seller));
        when(storageTypeRepository.findByName("Fresh")).thenReturn(Optional.of(storageType));
        when(productRepository.findByDescriptionAndStorageType(description, storageType)).thenReturn(Optional.empty());
        when(productRepository.save(Product.builder().description(description).storageType(storageType).build())).thenReturn(product);
        when(productSellerRepository.findByProductAndSeller(product, seller)).thenReturn(Optional.empty());
        when(productSellerRepository.save(ProductSeller.builder().price(BigDecimal.valueOf(price)).seller(seller).product(product).build())).thenReturn(productSeller);
        ProductCreateResponseDto actual = productService.createProduct(1L, body);
        assertEquals(expected, actual);
    }
}