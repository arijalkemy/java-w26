package com.mercadolibre.project_java_w26_team13.unit.service;

import com.mercadolibre.project_java_w26_team13.dtos.ProductDto;
import com.mercadolibre.project_java_w26_team13.entity.Batch;
import com.mercadolibre.project_java_w26_team13.entity.Order;
import com.mercadolibre.project_java_w26_team13.entity.Product;
import com.mercadolibre.project_java_w26_team13.entity.Section;
import com.mercadolibre.project_java_w26_team13.exceptions.ApiException;
import com.mercadolibre.project_java_w26_team13.exceptions.ExceptionsFactory;
import com.mercadolibre.project_java_w26_team13.repository.IProductRepository;
import com.mercadolibre.project_java_w26_team13.repository.IBatchRepository;
import com.mercadolibre.project_java_w26_team13.service.ProductService;
import com.mercadolibre.project_java_w26_team13.util.JWTClaims;
import com.mercadolibre.project_java_w26_team13.util.Roles;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    JWTClaims jwtClaims;

    @Mock
    IProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Mock
    private IBatchRepository batchRepository;

    @Test
    @DisplayName("obtener una lista de productos")
    public void getProductListOK() {
        String authorizationHeader = "Bearer token";
        String role = Roles.BUYER.getRole();

        List<Product> productList = List.of(
                Product.builder().id(1L).name("Producto A").price(10.20).build(),
                Product.builder().id(2L).name("Producto B").price(25.00).build(),
                Product.builder().id(3L).name("Producto C").price(50.25).build()
        );

        List<ProductDto> expected = List.of(
                ProductDto.builder().id(1L).name("Producto A").price(10.20).build(),
                ProductDto.builder().id(2L).name("Producto B").price(25.00).build(),
                ProductDto.builder().id(3L).name("Producto C").price(50.25).build()
        );

        Mockito.when(productRepository.findAll()).thenReturn(productList);
        Mockito.doNothing().when(jwtClaims).validateHeader(authorizationHeader, role);
        List<ProductDto> got = productService.getProductList(authorizationHeader);

        Assertions.assertEquals(expected, got);

    }

    @Test
    public void getProductListNotFound() {
        String authorizationHeader = "Bearer token";
        String role = Roles.BUYER.getRole();
        List<Product> emptyList = new ArrayList<>();
        Mockito.when(productRepository.findAll()).thenReturn(emptyList);
        Mockito.doNothing().when(jwtClaims).validateHeader(authorizationHeader, role);
        Assertions.assertThrows(ApiException.class, () -> productService.getProductList(authorizationHeader));
    }

    @Test
    public void getProductListUnauthorized() {
        String authorizationHeader = "Bearer token";
        String role = Roles.REPRESENTANTE.getRole();
        lenient().doThrow(ExceptionsFactory.unauthorizedException("User is not authorized")).when(jwtClaims).validateHeader(authorizationHeader, role);
        Assertions.assertThrows(ApiException.class, () -> productService.getProductList(authorizationHeader));
    }

    @Test
    public void getProductListAuthorizationIsNull() {
        lenient().doThrow(ExceptionsFactory.unauthorizedException("Invalid or missing token")).when(jwtClaims).validateHeader(null, null);
        Assertions.assertThrows(ApiException.class, () -> productService.getProductList(null));
    }

    @Test
    @DisplayName("obtener una lista de productos por categoria")
    public void getProductListByCategoryOK() {
        String authorizationHeader = "Bearer token";
        String role = Roles.BUYER.getRole();
        String category = "FS";

        Section section = new Section();
        section.setName("Fresco");

        Order order = new Order();
        order.setSection(section);

        Product product1 = Product.builder().id(1L).name("Producto FS").price(15.20).build();
        Product product2 = Product.builder().id(2L).name("Producto FS2").price(30.00).build();

        Batch batch1 = new Batch();
        batch1.setProduct(product1);
        batch1.setOrder(order);

        Batch batch2 = new Batch();
        batch2.setProduct(product2);
        batch2.setOrder(order);

        List<Batch> batches = List.of(batch1, batch2);

        List<ProductDto> expected = List.of(
                ProductDto.builder().id(1L).name("Producto FS").price(15.20).build(),
                ProductDto.builder().id(2L).name("Producto FS2").price(30.00).build()
        );

        Mockito.doNothing().when(jwtClaims).validateHeader(authorizationHeader, role);
        Mockito.when(batchRepository.findAll()).thenReturn(batches);

        List<ProductDto> got = productService.getProductListByCategory(authorizationHeader, category);

        Assertions.assertEquals(expected, got);
    }

    @Test
    @DisplayName("obtener una lista de productos por categoria no encontrada")
    public void getProductListByCategoryNotFound() {
        String authorizationHeader = "Bearer token";
        String role = Roles.BUYER.getRole();
        String category = "FF";

        List<Batch> emptyBatches = new ArrayList<>();

        Mockito.doNothing().when(jwtClaims).validateHeader(authorizationHeader, role);
        Mockito.when(batchRepository.findAll()).thenReturn(emptyBatches);

        Assertions.assertThrows(ApiException.class, () -> productService.getProductListByCategory(authorizationHeader, category));
    }
}
