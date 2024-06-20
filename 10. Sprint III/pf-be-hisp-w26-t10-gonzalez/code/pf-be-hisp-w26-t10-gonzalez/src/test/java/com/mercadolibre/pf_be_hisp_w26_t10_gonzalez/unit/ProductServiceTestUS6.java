package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.unit;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.ProductDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.ProductUS6Dto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.ProductUS6Response;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Rol;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.repository.ICategoryRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.repository.IUserAccountRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.service.implementations.ProductServiceImpl;
import org.h2.engine.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTestUS6 {
    @Mock
    private IProductRepository productRepository;

    @Mock
    private IUserAccountRepository userAccountRepository;

    @Mock
    private ICategoryRepository categoryRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Actualizar producto existente correctamente")
    public void testUpdateProductsHappyPath() {
        // Given
        Integer productId = 1;
        Integer sellerId = 2;
        ProductUS6Dto productDto = new ProductUS6Dto("Updated Product", 15.0);
        UserAccount seller = new UserAccount();
        seller.setUserId(sellerId.longValue());
        seller.setUserRole(Rol.SELLER);
        Category category = new Category();
        category.setId(1);

        Product productToUpdate = new Product();
        productToUpdate.setId(productId);
        productToUpdate.setName("Original Product");
        productToUpdate.setPrice(10.0);
        productToUpdate.setSeller(seller);

        Optional<Product> optionalProduct = Optional.of(productToUpdate);

        // Mock repository methods
        when(userAccountRepository.findById(anyLong())).thenReturn(Optional.of(seller));
        when(productRepository.findById(productId)).thenReturn(optionalProduct);

        // Mock repository update method
        doNothing().when(productRepository).updateNameAndPrice(anyInt(), anyString(), anyDouble(), anyInt());

        // When
        ProductUS6Response response = productService.updateProducts(productDto, productId, sellerId);

        // Then
        assertNotNull(response);
        assertEquals(1000, response.getCode());
        assertEquals("Producto con el id: 1 asociado al vendedor 2", response.getMessage());
    }

    @Test
    @DisplayName("Actualizar producto - Producto no encontrado")
    public void testUpdateProductsProductNotFound() {
        UserAccount seller = new UserAccount();
        seller.setUserId(2L);
        seller.setUserRole(Rol.SELLER);

        Integer productId = 1;
        Integer sellerId = 2;
        ProductUS6Dto productDto = new ProductUS6Dto("Updated Product", 15.0);

        // Mock repository methods
        when(userAccountRepository.findById(anyLong())).thenReturn(Optional.of(seller));
        when(categoryRepository.findById(anyInt())).thenReturn(Optional.of(new Category()));
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        // When / Then
        assertThrows(NotFoundException.class, () -> productService.updateProducts(productDto, productId, sellerId));
    }

    @Test
    @DisplayName("Actualizar producto - Vendedor no encontrado")
    public void testUpdateProductsSellerNotFound() {
        // Given
        Integer productId = 1;
        Integer sellerId = 2;
        ProductUS6Dto productDto = new ProductUS6Dto("Updated Product", 15.0);

        // Mock repository methods
        when(userAccountRepository.findById(anyLong())).thenReturn(Optional.empty());

        // When / Then
        assertThrows(NotFoundException.class, () -> productService.updateProducts(productDto, productId, sellerId));
    }

    @Test
    @DisplayName("Actualizar producto - Usuario no vendedor")
    public void testUpdateProductsUserNotSeller() {
        Integer productId = 1;
        UserAccount seller = new UserAccount();
        seller.setUserId(1L);
        seller.setUserRole(Rol.BUYER);
        ProductUS6Dto productDto = new ProductUS6Dto("Updated Product", 15.0);

        // Mock repository methods
        when(userAccountRepository.findById(anyLong())).thenReturn(Optional.of(seller));

        // When / Then
        assertThrows(BadRequestException.class, () -> productService.updateProducts(productDto, productId, seller.getUserId().intValue()));
    }

    @Test
    @DisplayName("Insertar productos - Vendedor no encontrado")
    public void testInsertProductsSellerNotFound() {
        // Given
        Integer sellerId = 1;
        List<ProductUS6Dto> products = new ArrayList<>();
        products.add(new ProductUS6Dto("Product 1", 10.0));
        products.add(new ProductUS6Dto("Product 2", 15.0));

        // Mock repository methods
        when(userAccountRepository.findById(anyLong())).thenReturn(Optional.empty());

        // When / Then
        assertThrows(NotFoundException.class, () -> productService.insertProducts(products, sellerId));
    }

    @Test
    @DisplayName("Insertar productos - Usuario no vendedor")
    public void testInsertProductsUserNotFound() {
        UserAccount seller = new UserAccount();
        seller.setUserId(1L);
        seller.setUserRole(Rol.BUYER);

        List<ProductUS6Dto> products = new ArrayList<>();
        products.add(new ProductUS6Dto("Product 1", 10.0));
        products.add(new ProductUS6Dto("Product 2", 15.0));

        // Mock repository methods
        when(userAccountRepository.findById(anyLong())).thenReturn(Optional.of(seller));

        // When / Then
        assertThrows(BadRequestException.class, () -> productService.insertProducts(products, seller.getUserId().intValue()));
    }

    @Test
    @DisplayName("Buscar productos por rango de precio")
    public void testFindProductByPriceRangeHappyPath() {
        // Given
        Double lowPrice = 10.0;
        Double highPrice = 20.0;

        List<Product> products = new ArrayList<>();
        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(1L);
        products.add(Product.builder().id(1).seller(userAccount).name("Product 1").price(15.0).build());
        products.add(Product.builder().id(2).seller(userAccount).name("Product 2").price(18.0).build());

        // Mock repository method
        when(productRepository.findProductByPriceRange(anyDouble(), anyDouble())).thenReturn(products);

        // When
        List<ProductDto> result = productService.findProductByPriceRange(lowPrice, highPrice);

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getName());
        assertEquals(15.0, result.get(0).getPrice());
        assertEquals("Product 2", result.get(1).getName());
        assertEquals(18.0, result.get(1).getPrice());
    }

    @Test
    @DisplayName("Buscar productos por rango de precio - Precio negativo")
    public void testFindProductByPriceRangeNegativePrice() {
        // Given
        Double lowPrice = -10.0;
        Double highPrice = 20.0;

        // When / Then
        assertThrows(BadRequestException.class, () -> productService.findProductByPriceRange(lowPrice, highPrice));
    }

    @Test
    @DisplayName("Buscar productos por palabra clave")
    public void testFindByKeywordHappyPath() {
        // Given
        String keyword = "apple";
        UserAccount userAccount = new UserAccount();
        userAccount.setUserId(1L);
        List<Product> products = new ArrayList<>();
        products.add(Product.builder().id(1).seller(userAccount).name("Apple Juice").price(5.0).build());
        products.add(Product.builder().id(2).seller(userAccount).name("Green Apple").price(2.0).build());

        // Mock repository method
        when(productRepository.findProductsByKeyword(anyString())).thenReturn(products);

        // When
        List<ProductDto> result = productService.findByKeyword(keyword);

        // Then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Apple Juice", result.get(0).getName());
        assertEquals(5.0, result.get(0).getPrice());
        assertEquals("Green Apple", result.get(1).getName());
        assertEquals(2.0, result.get(1).getPrice());
    }

}
