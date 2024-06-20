package com.mercadolibre.fresh_market.service;

import com.mercadolibre.fresh_market.config.CategoryBadRequestException;
import com.mercadolibre.fresh_market.config.ProductsNotFoundException;
import com.mercadolibre.fresh_market.dtos.ProductDetailDTO;
import com.mercadolibre.fresh_market.dtos.ProductStockDTO;
import com.mercadolibre.fresh_market.dtos.WarehouseProduct;
import com.mercadolibre.fresh_market.model.Batch;
import com.mercadolibre.fresh_market.model.Product;
import com.mercadolibre.fresh_market.model.Section;
import com.mercadolibre.fresh_market.model.Warehouse;
import com.mercadolibre.fresh_market.model.enums.Category;
import com.mercadolibre.fresh_market.repository.IBatchRepository;
import com.mercadolibre.fresh_market.repository.IProductRepository;
import com.mercadolibre.fresh_market.repository.ISectionRepository;
import com.mercadolibre.fresh_market.repository.IWarehouseRepository;
import com.mercadolibre.fresh_market.service.impl.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {


    @Mock
    private IProductRepository productRepository;

    @Mock
    private IWarehouseRepository warehouseRepository;

    @Mock
    private ISectionRepository sectionRepository;

    @Mock
    private IBatchRepository batchRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testGetProductStock() {
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
        when(warehouseRepository.findAll()).thenReturn(Arrays.asList(warehouse));
        when(sectionRepository.findByWarehouseId(warehouse.getId())).thenReturn(Arrays.asList(section));
        when(batchRepository.findByProductAndSection(product, section)).thenReturn(Arrays.asList(batch));

        // Act
        ProductStockDTO productStockDTO = productService.getProductStock(productId);

        // Assert
        assertEquals(productId, productStockDTO.getProductId());
        assertEquals(Integer.valueOf(10), productStockDTO.getWarehouseProducts().get(0).getQuantity());
    }


    @Test
    public void testConvertMapToProductStockDTO() {
        Long productId = 1L;
        Map<Long, Integer> stockPerWarehouse = new HashMap<>();
        stockPerWarehouse.put(1L, 10);
        stockPerWarehouse.put(2L, 0);
        stockPerWarehouse.put(3L, 20);

        ProductStockDTO result = productService.convertMapToProductStockDTO(productId, stockPerWarehouse);

        assertEquals(productId, result.getProductId());
        List<WarehouseProduct> warehouseProducts = result.getWarehouseProducts();
        assertEquals(2, warehouseProducts.size());
        assertEquals(1L, warehouseProducts.get(0).getWarehouseId());
        assertEquals(10, warehouseProducts.get(0).getQuantity());
        assertEquals(3L, warehouseProducts.get(1).getWarehouseId());
        assertEquals(20, warehouseProducts.get(1).getQuantity());
    }

    @Test
    public void testGetAllProducts(){
        // Arrange
        List<Product> products = generateProducts();

        List<ProductDetailDTO> productsExpected = generateProductDetailDTOs();

        when(productRepository.findAll()).thenReturn(products);

        // Act
        List<ProductDetailDTO> productsResponse = productService.getAllProducts();

        // Assert
        assertEquals(productsExpected, productsResponse);
    }

    @Test
    public void testGetAllProductsNotFoundError(){
        // Arrange
        List<Product> products = new ArrayList<>();

        when(productRepository.findAll()).thenReturn(products);

        // Act & Assert
        assertThrows(ProductsNotFoundException.class, () -> productService.getAllProducts());
    }

    @Test
    public void testGetAllProductsByCategory(){
        // Arrange
        String category = "FF";
        List<Product> products = generateProducts();
        List<ProductDetailDTO> productsExpected = generateProductDetailDTOs();

        when(batchRepository.findDistinctProductsByCategory(Category.valueOf(category))).thenReturn(products);

        // Act
        List<ProductDetailDTO> productsResponse = productService.getAllProductsByCategory(category);

        // Assert
        assertEquals(productsExpected, productsResponse);
    }

    @Test
    public void testGetAllProductsByCategoryNotFoundError(){
        // Arrange
        String category = "FF";
        List<Product> products = new ArrayList<>();

        when(batchRepository.findDistinctProductsByCategory(Category.valueOf(category))).thenReturn(products);

        // Act & Assert
        assertThrows(ProductsNotFoundException.class, () -> productService.getAllProductsByCategory(category));
    }

    @Test
    public void testGetAllProductsByCategoryBadRequestError(){
        // Arrange
        String category = "InvalidCategory";
        // Act & Assert
        assertThrows(CategoryBadRequestException.class, () -> productService.getAllProductsByCategory(category));
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

        return Arrays.asList(product1, product2);
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

        return Arrays.asList(productDetailDTO1, productDetailDTO2);
    }
}
