package com.mercadolibre.pf_be_hisp_w26_t07_torres.service;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.beans.AuthDataUtil;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.batch.BSResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.enums.Category;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.enums.OperationEnum;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.enums.StatusCodeEnum;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.product.*;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IBatchSectionProductProjection;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IProductResponseProjection;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.projection.IWarehouseBatchProduct;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.warehouse.StockQuantityResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.ProductSeller;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.Seller;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.StorageType;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.repository.*;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.DataUtils;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.ProductUtil;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.TestDataGenerator;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.MessageError;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.SuccessMessageEnum;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private IProductRepository productRepository;

    @Mock
    private IBatchRepository batchRepository;
    @Mock
    private IProductSellerRepository productSellerRepository;
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

    @Test
    @DisplayName("Test checkLocationForProduct - Happy Path")
    void testCheckLocationForProduct_HappyPath() {
        Long idProduct = 1L;
        String order = null;
        Long idRepresentative = 1L;

        ProductSeller mockProduct = new ProductSeller();
        mockProduct.setId(idProduct);

        List<IBatchSectionProductProjection> mockProjections = Stream.of(
                DataUtils.createProjection(100, 50, LocalDate.now().plusWeeks(4),
                        1L, 1L, idProduct),
                DataUtils.createProjection(101, 30, LocalDate.now().plusWeeks(5),
                        1L, 1L, idProduct)
        ).collect(Collectors.toList());

        when(authDataUtil.getIdSession()).thenReturn(idRepresentative);
        when(productSellerRepository.existsById(idProduct)).thenReturn(true);
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

        NotFoundException thrown = assertThrows(NotFoundException.class, () ->
                productService.checkLocationForProduct(idProduct, order));

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
        when(productSellerRepository.existsById(idProduct)).thenReturn(true);
        when(batchRepository.findProductBySectionWarehouse(idProduct, idRepresentative)).thenReturn(Collections.emptyList());

        NotFoundException thrown = assertThrows(NotFoundException.class, () ->
                productService.checkLocationForProduct(idProduct, order));

        assertEquals("The product was not found in any of the batches", thrown.getMessage());
    }

    @Test
    @DisplayName("Test checkLocationForProduct - Not Happy Path (Invalid Order)")
    void testCheckLocationForProduct_InvalidOrder() {
        Long idProduct = 1L;
        String order = "invalid_order";

        BadRequestException thrown = assertThrows(BadRequestException.class, () ->
                productService.checkLocationForProduct(idProduct, order));

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

        List<IBatchSectionProductProjection> mockProjections = Stream.of(
                DataUtils.createProjection(100, 50, LocalDate.of(2024, 9, 1),
                        1L, 1L, idProduct),
                DataUtils.createProjection(101, 40, LocalDate.of(2024, 11, 15),
                        2L, 1L, idProduct),
                DataUtils.createProjection(102, 60, LocalDate.of(2024, 10, 1),
                        1L, 2L, idProduct)
        ).collect(Collectors.toList());

        when(authDataUtil.getIdSession()).thenReturn(idRepresentative);
        when(productSellerRepository.existsById(idProduct)).thenReturn(true);
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

        List<IBatchSectionProductProjection> mockProjections = Stream.of(
                DataUtils.createProjection(100, 50, LocalDate.of(2024, 8, 15),
                        1L, 1L, idProduct),
                DataUtils.createProjection(101, 40, LocalDate.of(2024, 9, 1),
                        2L, 1L, idProduct),
                DataUtils.createProjection(102, 60, LocalDate.of(2024, 10, 1),
                        1L, 2L, idProduct)
        ).collect(Collectors.toList());

        when(authDataUtil.getIdSession()).thenReturn(idRepresentative);
        when(productSellerRepository.existsById(idProduct)).thenReturn(true);
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

        List<IBatchSectionProductProjection> mockProjections = Stream.of(
                DataUtils.createProjection(100, 50, LocalDate.of(2024, 10, 1),
                        1L, 1L, idProduct),
                DataUtils.createProjection(101, 40, LocalDate.of(2024, 10, 15),
                        2L, 1L, idProduct),
                DataUtils.createProjection(102, 60, LocalDate.of(2024, 11, 1),
                        1L, 2L, idProduct)
        ).collect(Collectors.toList());

        when(authDataUtil.getIdSession()).thenReturn(idRepresentative);
        when(productSellerRepository.existsById(idProduct)).thenReturn(true);
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
        List<BSResponseDTO> responseList = Arrays.asList(
                new BSResponseDTO(1, 10, LocalDate.now()),
                new BSResponseDTO(2, 20, LocalDate.now().plusDays(1))
        );

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


        when(productSellerRepository.existsById(idProduct)).thenReturn(true);
        when(batchRepository.findProductBySectionWarehouse(idProduct, idRepresentative)).thenReturn(Collections.emptyList());

        NotFoundException thrown = assertThrows(NotFoundException.class, () ->
                productService.checkLocationForProduct(idProduct, null)
        );

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

        List<IBatchSectionProductProjection> mockProjections = Stream.of(
                DataUtils.createProjection(100, 50, LocalDate.of(2024, 10, 1),
                        1L, 1L, idProduct)
        ).collect(Collectors.toList());

        when(authDataUtil.getIdSession()).thenReturn(idRepresentative);
        when(productSellerRepository.existsById(idProduct)).thenReturn(true);
        when(batchRepository.findProductBySectionWarehouse(idProduct, idRepresentative)).thenReturn(mockProjections);

        BadRequestException thrown = assertThrows(BadRequestException.class, () ->
                productService.checkLocationForProduct(idProduct, order)
        );
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

        List<IBatchSectionProductProjection> mockProjections = Stream.of(
                DataUtils.createProjection(100, 50, LocalDate.of(2024, 10, 1),
                        1L, 1L, idProduct),
                DataUtils.createProjection(100, 30, LocalDate.of(2024, 11, 1),
                        1L, 1L, idProduct)
        ).collect(Collectors.toList());

        when(authDataUtil.getIdSession()).thenReturn(idRepresentative);
        when(productSellerRepository.existsById(idProduct)).thenReturn(true);
        when(batchRepository.findProductBySectionWarehouse(idProduct, idRepresentative)).thenReturn(mockProjections);

        BadRequestException thrown = assertThrows(BadRequestException.class, () ->
                productService.checkLocationForProduct(idProduct, order)
        );

        assertEquals("Product appears in the same batch multiple times", thrown.getMessage());
    }

    //  Check if Seller exists with sellerId
    //  Check that the list of products isn't empty
    //  For each product
    //      Check that the product's storage type exists
    //      Save the product that is not in the DB
    @Test
    @DisplayName("Product: Create new product with non existent seller")
    public void CreateProductSeller_SellerNotExist() {
        // Arrange
        Long wrongSellerId = 999L;
        when(sellerRepository.findById(wrongSellerId)).thenReturn(Optional.empty());
        // Act
        // Assert
        NotFoundException thrown = assertThrows(
                NotFoundException.class,
                () -> productService.createProductSeller(wrongSellerId, new ListProductRequestDto())
        );
        assertEquals(MessageError.SELLER_NOT_FOUND.getMessage(), thrown.getMessage());
    }

    @Test
    @DisplayName("Product: Create new product with empty product list")
    public void CreateProductSeller_EmptyList() {
        // Arrange
        Long sellerId = 1L;
        Seller seller = Seller.builder()
                .id(sellerId)
                .name("SELLER_NAME")
                .description("SELLER_DESC")
                .build();
        when(sellerRepository.findById(sellerId)).thenReturn(TestDataGenerator.getOptionalObject(seller));
        // Act
        // Assert
        BadRequestException thrown = assertThrows(
                BadRequestException.class,
                () -> productService.createProductSeller(sellerId, ListProductRequestDto
                        .builder()
                                .products(new ArrayList<>())
                        .build())
        );
        assertEquals(MessageError.EMPTY_LIST_ERROR.getMessage("products"), thrown.getMessage());
    }

    @Test
    @DisplayName("Product: Create new product with wrong storage type")
    public void CreateProductSeller_BadStorage() {
        // Arrange
        Long sellerId = 1L;
        Seller seller = Seller.builder()
                .id(sellerId)
                .name("SELLER_NAME")
                .description("SELLER_DESC")
                .build();
        when(sellerRepository.findById(sellerId)).thenReturn(TestDataGenerator.getOptionalObject(seller));

        List<ProductRequestDto> products = new ArrayList<>();
        String storageType = "INVALID_STORAGE_TYPE";
        ProductRequestDto productToSave = ProductRequestDto
                .builder()
                .description("PRODUCT_DESC")
                .price(29.9)
                .storageType(storageType)
                .build();
        products.add(productToSave);
        ListProductRequestDto requestDto = ListProductRequestDto
                .builder()
                .products(products)
                .build();

        when(storageTypeRepository.findStorageTypeByNameEqualsIgnoreCase(storageType)).thenReturn(Optional.empty());
        // Act
        // Assert
        BadRequestException thrown = assertThrows(
                BadRequestException.class,
                () -> productService.createProductSeller(sellerId, requestDto)
        );
        assertEquals(MessageError.STORAGE_TYPE_NOT_FOUND.getMessage(), thrown.getMessage());
    }

    @Test
    @DisplayName("Product: Create new product")
    public void CreateProductSeller_Ok() {
        // Arrange
        Long sellerId = 1L;
        Seller seller = Seller.builder()
                .id(sellerId)
                .name("SELLER_NAME")
                .description("SELLER_DESC")
                .build();
        when(sellerRepository.findById(sellerId)).thenReturn(TestDataGenerator.getOptionalObject(seller));

        List<ProductRequestDto> products = new ArrayList<>();
        String storageTypeName = Category.FS.toString();
        ProductRequestDto productToSaveDto = ProductRequestDto
                .builder()
                .description("PRODUCT_DESC")
                .price(29.9)
                .storageType(storageTypeName)
                .build();
        products.add(productToSaveDto);
        ListProductRequestDto requestDto = ListProductRequestDto
                .builder()
                .products(products)
                .build();

        StorageType storageType = StorageType.builder()
                .name(storageTypeName)
                .build();
        when(storageTypeRepository.findStorageTypeByNameEqualsIgnoreCase(storageTypeName))
                .thenReturn(TestDataGenerator.getOptionalObject(storageType));


        Product product = Product.builder()
                .storageType(storageType)
                .description(productToSaveDto.getDescription())
                .build();
        ProductSeller productToSave = ProductSeller.builder()
                .seller(seller)
                .product(product)
                .price(BigDecimal.valueOf(productToSaveDto.getPrice()))
                .build();

        ProductCreateResponseDto expectedDto = ProductCreateResponseDto
                .builder()
                .code(StatusCodeEnum.SUCCESSFUL.getId())
                .message(SuccessMessageEnum.PRODUCTS_CREATED.getMessage("products"))
                .operation(OperationEnum.CREATE.getId())
                .build();
        // Act
        // Assert
        ProductCreateResponseDto responseDto = productService.createProductSeller(sellerId, requestDto);
        verify(productSellerRepository, atLeast(1)).save(productToSave);
        assertThat(responseDto).usingRecursiveComparison().isEqualTo(expectedDto);
    }

    //  Check if Seller exists with sellerId
    //  Check that the product with productId is in the DB
    //  Save the product
    @Test
    @DisplayName("Product: Update product non existent Seller")
    public void UpdateProductSeller_SellerNotExist() {
        // Arrange
        Long wrongSellerId = 999L;
        when(sellerRepository.existsById(wrongSellerId)).thenReturn(false);

        Long productSellerId = 999L;
        // Act
        // Assert
        NotFoundException thrown = assertThrows(
                NotFoundException.class,
                () -> productService.updateProductSeller(wrongSellerId, productSellerId, new ProductRequestDto())
        );
        assertEquals(MessageError.SELLER_NOT_FOUND.getMessage(), thrown.getMessage());
    }

    @Test
    @DisplayName("Product: Update product non existent ProductSeller")
    public void UpdateProductSeller_ProductSellerNotExist() {
        // Arrange
        Long sellerId = 1L;
        when(sellerRepository.existsById(sellerId)).thenReturn(true);

        Long wrongProductSellerId = 999L;
        when(productSellerRepository.findById(wrongProductSellerId)).thenReturn(Optional.empty());
        // Act
        // Assert
        NotFoundException thrown = assertThrows(
                NotFoundException.class,
                () -> productService.updateProductSeller(sellerId, wrongProductSellerId, new ProductRequestDto())
        );
        assertEquals(MessageError.PRODUCT_NOT_FOUND.getMessage(), thrown.getMessage());
    }

    @Test
    @DisplayName("Product: Update product")
    public void UpdateProductSeller_Ok() {
        // Arrange
        Long sellerId = 1L;
        when(sellerRepository.existsById(sellerId)).thenReturn(true);

        String storageTypeName = Category.FS.toString();
        ProductRequestDto requestDto = ProductRequestDto.builder()
                .storageType(storageTypeName)
                .price(50.0)
                .description("NEW_PRODUCT_DESC")
                .build();

        Seller sellerInDb = Seller.builder()
                .id(sellerId)
                .name("SELLER_NAME")
                .description("SELLER_DESC")
                .build();
        Long productSellerId = 1L;
        StorageType storageTypeInDb = StorageType.builder()
                .name(storageTypeName)
                .build();
        Product productInDb = Product.builder()
                .storageType(storageTypeInDb)
                .description("PRODUCT_DESC")
                .build();
        ProductSeller productSellerInDb = ProductSeller.builder()
                .seller(sellerInDb)
                .product(productInDb)
                .price(BigDecimal.valueOf(30))
                .build();
        when(productSellerRepository.findById(productSellerId)).thenReturn(TestDataGenerator.getOptionalObject(productSellerInDb));

        ProductCreateResponseDto expectedDto = ProductCreateResponseDto
                .builder()
                .code(StatusCodeEnum.SUCCESSFUL.getId())
                .message(SuccessMessageEnum.PRODUCTS_UPDATED.getMessage("products"))
                .operation(OperationEnum.UPDATE.getId())
                .build();

        Product productToSave = Product.builder()
                .storageType(storageTypeInDb)
                .description(requestDto.getDescription())
                .build();
        ProductSeller productSellerToSave = ProductSeller.builder()
                .seller(sellerInDb)
                .product(productToSave)
                .price(BigDecimal.valueOf(requestDto.getPrice()))
                .build();
        // Act
        // Assert
        ProductCreateResponseDto responseDto = productService
                .updateProductSeller(sellerId, productSellerId, requestDto);
        verify(productSellerRepository, atLeast(1)).save(productSellerToSave);
        assertThat(responseDto).usingRecursiveComparison().isEqualTo(expectedDto);
    }
}
