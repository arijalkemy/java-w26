package com.mercadolibre.fresh_market.service;

import com.mercadolibre.fresh_market.config.exception.BadRequestException;
import com.mercadolibre.fresh_market.config.exception.CategoryBadRequestException;
import com.mercadolibre.fresh_market.config.exception.ProductNotFoundException;
import com.mercadolibre.fresh_market.config.exception.ProductsNotFoundException;
import com.mercadolibre.fresh_market.dtos.product.ProductDetailDTO;
import com.mercadolibre.fresh_market.dtos.ProductStockDTO;
import com.mercadolibre.fresh_market.dtos.WarehouseProduct;
import com.mercadolibre.fresh_market.dtos.product.ProductReqDTO;
import com.mercadolibre.fresh_market.dtos.product.ProductResDTO;
import com.mercadolibre.fresh_market.exceptions.EntityNotFound;
import com.mercadolibre.fresh_market.model.*;
import com.mercadolibre.fresh_market.model.enums.Category;
import com.mercadolibre.fresh_market.repository.IBatchRepository;
import com.mercadolibre.fresh_market.repository.IProductRepository;
import com.mercadolibre.fresh_market.repository.ISectionRepository;
import com.mercadolibre.fresh_market.repository.IWarehouseRepository;
import com.mercadolibre.fresh_market.service.impl.ProductServiceImpl;
import com.mercadolibre.fresh_market.util.JsonUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class ProductServiceImplTest {

    @Mock
    private IProductRepository productRepository;

    @Mock
    private IWarehouseRepository warehouseRepository;

    @Mock
    private ISectionRepository sectionRepository;

    @Mock
    private IBatchRepository batchRepository;

    @Mock
    private IUserService userService;

    @InjectMocks
    @Spy
    private ProductServiceImpl productServiceImpl;

    private ProductReqDTO productReqDTO;
    private final Long validSellerId = 1L;
    private Long validProductId = 1L;
    private Product validProduct;
    private User validUser;
    private ProductDetailDTO productDetailDTO;

    @BeforeEach
    void setUp() throws IOException {
        // Load valid ProductReqDTO from JSON using JsonUtil
        productReqDTO = JsonUtil.readJsonFromFile("productReq.json", ProductReqDTO.class);

        // Create a valid User object for the seller
        validUser = JsonUtil.readJsonFromFile("user.json", User.class);
        productDetailDTO = JsonUtil.readJsonFromFile("productDetail.json", ProductDetailDTO.class);
        validProduct = JsonUtil.readJsonFromFile("valid_product.json", Product.class);
    }

    @Test
     void testGetProductStock() {
        // Arrange
        Long productId = 1L;
        Product product = new Product();
        product.setId(productId);

        Warehouse warehouse = new Warehouse();
        warehouse.setId(1L);

        Section section = new Section();
        section.setId(1L);
        section.setWarehouse(warehouse);

        Batch batch = new Batch();
        batch.setCurrentQuantity(10);
        batch.setSection(section);
        batch.setProduct(product);

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(warehouseRepository.findAll()).thenReturn(List.of(warehouse));
        when(sectionRepository.findByWarehouseId(warehouse.getId())).thenReturn(List.of(section));
        when(batchRepository.findByProductAndSection(product, section)).thenReturn(List.of(batch));

        // Act
        ProductStockDTO productStockDTO = productServiceImpl.getProductStock(productId);

        // Assert
        assertEquals(productId, productStockDTO.getProductId());
        assertEquals(Integer.valueOf(10), productStockDTO.getWarehouseProducts().get(0).getQuantity());
    }


    @Test
     void testConvertMapToProductStockDTO() {
        Long productId = 1L;
        Map<Long, Integer> stockPerWarehouse = new HashMap<>();
        stockPerWarehouse.put(1L, 10);
        stockPerWarehouse.put(2L, 0);
        stockPerWarehouse.put(3L, 20);

        ProductStockDTO result = productServiceImpl.convertMapToProductStockDTO(productId, stockPerWarehouse);

        assertEquals(productId, result.getProductId());
        List<WarehouseProduct> warehouseProducts = result.getWarehouseProducts();
        assertEquals(2, warehouseProducts.size());
        assertEquals(1L, warehouseProducts.get(0).getWarehouseId());
        assertEquals(10, warehouseProducts.get(0).getQuantity());
        assertEquals(3L, warehouseProducts.get(1).getWarehouseId());
        assertEquals(20, warehouseProducts.get(1).getQuantity());
    }

    @Test
     void testGetAllProducts(){
        // Arrange
        List<Product> products = generateProducts();

        List<ProductDetailDTO> productsExpected = generateProductDetailDTOs();

        when(productRepository.findAll()).thenReturn(products);

        // Act
        List<ProductDetailDTO> productsResponse = productServiceImpl.getAllProducts();

        // Assert
        assertEquals(productsExpected, productsResponse);
    }

    @Test
     void testGetAllProductsNotFoundError(){
        // Arrange
        List<Product> products = new ArrayList<>();

        when(productRepository.findAll()).thenReturn(products);

        // Act & Assert
        assertThrows(ProductsNotFoundException.class, () -> productServiceImpl.getAllProducts());
    }

    @Test
     void testGetAllProductsByCategory(){
        // Arrange
        String category = "FF";
        List<Product> products = generateProducts();
        List<ProductDetailDTO> productsExpected = generateProductDetailDTOs();

        when(batchRepository.findDistinctProductsByCategory(Category.valueOf(category))).thenReturn(products);

        // Act
        List<ProductDetailDTO> productsResponse = productServiceImpl.getAllProductsByCategory(category);

        // Assert
        assertEquals(productsExpected, productsResponse);
    }

    @Test
     void testGetAllProductsByCategoryNotFoundError(){
        // Arrange
        String category = "FF";
        List<Product> products = new ArrayList<>();

        when(batchRepository.findDistinctProductsByCategory(Category.valueOf(category))).thenReturn(products);

        // Act & Assert
        assertThrows(ProductsNotFoundException.class, () -> productServiceImpl.getAllProductsByCategory(category));
    }

    @Test
     void testGetAllProductsByCategoryBadRequestError(){
        // Arrange
        String category = "InvalidCategory";
        // Act & Assert
        assertThrows(CategoryBadRequestException.class, () -> productServiceImpl.getAllProductsByCategory(category));
    }

    private List<Product> generateProducts() {
        Product product1 = new Product();
        product1.setId(1L);
        product1.setPrice(100.0);
        product1.setDescription("Product 1");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setPrice(200.0);
        product2.setDescription("Product 2");

        return List.of(product1, product2);
    }

    private List<ProductDetailDTO> generateProductDetailDTOs() {
        ProductDetailDTO productDetailDTO1 = new ProductDetailDTO();
        productDetailDTO1.setId(1L);
        productDetailDTO1.setPrice(100.0);
        productDetailDTO1.setDescription("Product 1");

        ProductDetailDTO productDetailDTO2 = new ProductDetailDTO();
        productDetailDTO2.setId(2L);
        productDetailDTO2.setPrice(200.0);
        productDetailDTO2.setDescription("Product 2");

        return List.of(productDetailDTO1, productDetailDTO2);
    }

    @Test
    @DisplayName("Create products successfully")
    void testCreateProductsSuccess() {
        // Arrange
        List<ProductDetailDTO> productDetailDTOList = List.of(productDetailDTO, productDetailDTO);

        when(userService.validateUserSeller(validSellerId)).thenReturn(validUser);
        when(productRepository.saveAll(any())).thenReturn(getMockProducts(validUser));
        when(productRepository.existsByDescription(any())).thenReturn(true);

        // Act
        ProductResDTO result = productServiceImpl.createProducts(productReqDTO, validSellerId);

        // Assert
        assertNotNull(result);
        assertEquals(productDetailDTOList.size(), result.getOperation());
        assertEquals("Products created successfully.", result.getMessage());
        assertEquals(201, result.getCode());

        verify(productRepository, times(productDetailDTOList.size())).existsByDescription(any());
        verify(productRepository, times(1)).saveAll(any());
    }

    @Test
    @DisplayName("Products already exist")
    void testCreateProductsProductsExist() {
        // Arrange

        when(userService.validateUserSeller(validSellerId)).thenReturn(validUser);
        when(productServiceImpl.getProductsExists(productReqDTO)).thenReturn(List.of());

        // Act
        ProductResDTO result = productServiceImpl.createProducts(productReqDTO, validSellerId);

        // Assert
        assertNotNull(result);
        assertEquals("There are Products already exist.", result.getMessage());
        assertEquals(HttpStatus.OK.value(), result.getCode());

    }

    @Test
    @DisplayName("Seller validation fails")
    void testCreateProductsSellerValidationFails() {
        // Arrange
        when(userService.validateUserSeller(validSellerId)).thenThrow(new EntityNotFound("User not found"));

        // Act & Assert
        assertThrows(EntityNotFound.class, () -> productServiceImpl.createProducts(productReqDTO, validSellerId));
    }

    @Test
    @DisplayName("User validation fails")
    void testCreateProductsUserValidationFails() {
        // Arrange
        when(userService.validateUserSeller(validSellerId)).thenThrow(new EntityNotFound("User not found"));

        // Act & Assert
        EntityNotFound exception = assertThrows(EntityNotFound.class,
                () -> productServiceImpl.createProducts(productReqDTO, validSellerId));

        assertEquals("User not found", exception.getMessage());

        verify(productRepository, never()).existsByDescription(anyString());
        verify(productRepository, never()).saveAll(anyList());
    }

    @Test
    @DisplayName("Products create when exists already")
    void testCreateProducts_ProductsExists() {
        // Arrange
        productReqDTO.setProducts(List.of());

        // Act
        assertThrows(BadRequestException.class, () -> productServiceImpl.createProducts(productReqDTO, validSellerId));

    }

    @Test
    @DisplayName("Product updated successfully")
    void testUpdateProductSuccess() {
        when(userService.validateUserSeller(validSellerId)).thenReturn(validUser);
        when(productRepository.findById(validProductId)).thenReturn(Optional.of(validProduct));
        when(productRepository.save(any(Product.class))).thenReturn(validProduct);

        ProductResDTO result = productServiceImpl.updateProduct(productDetailDTO, validSellerId, validProductId);

        assertNotNull(result);
        assertEquals(1, result.getOperation());
        assertEquals("Product update successfully.", result.getMessage());
        assertEquals(HttpStatus.CREATED.value(), result.getCode());
    }

    @Test
    @DisplayName("Product update fails - null product details")
    void testUpdateProductNullDetails() {
        when(userService.validateUserSeller(validSellerId)).thenReturn(validUser);

        BadRequestException exception = assertThrows(BadRequestException.class,
                () -> productServiceImpl.updateProduct(null, validSellerId, validProductId));

        assertEquals("Without products to process.", exception.getMessage());

        verify(productRepository, never()).findById(anyLong());
        verify(productRepository, never()).save(any(Product.class));
    }

    @Test
    @DisplayName("Product update fails - product not found")
    void testUpdateProductProductNotFound() {
        when(userService.validateUserSeller(validSellerId)).thenReturn(validUser);
        when(productRepository.findById(validProductId)).thenReturn(Optional.empty());

        ProductNotFoundException exception = assertThrows(ProductNotFoundException.class,
                () -> productServiceImpl.updateProduct(productDetailDTO, validSellerId, validProductId));

        assertEquals("Product not found.", exception.getMessage());

        verify(productRepository, times(1)).findById(validProductId);
        verify(productRepository, never()).save(any(Product.class));
    }

    // Helper method to create mock products
    private List<Product> getMockProducts(User seller) {
        // Create mock products based on the count
        // This is just an example, adjust as per your actual product creation logic
        return List.of(
                new Product(1L, 100.0, "Product 1", seller),
                new Product(2L, 200.0, "Product 2", seller)
        );
    }

}
