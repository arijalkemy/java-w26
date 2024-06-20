package com.mercadolibre.pf_be_hisp_w26_t10_garcia.unit.modify_order.service;

import com.mercadolibre.pf_be_hisp_w26_t10_garcia.dtos.order.*;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.ShoppingCart;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.exceptions.BadRequestException;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.repository.IShoppingCartProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.repository.IShoppingCartRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.repository.IUserAccountRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_garcia.service.implementations.ShoppingCartServiceImpl;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ShoppingCartTest {

    @Mock
    IShoppingCartRepository shoppingCartRepository;

    @Mock
    IProductRepository productRepository;

    @Mock
    IUserAccountRepository userAccountRepository;

    @Mock
    IShoppingCartProductRepository shoppingCartProductRepository;

    @InjectMocks
    ShoppingCartServiceImpl shoppingCartService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Modify Purchase Order - Happy Path")
    public void testModifyPurchaseOrder_HappyPath() {
        // Mockear shopping cart existente
        ShoppingCart existingShoppingCart = new ShoppingCart();
        existingShoppingCart.setId(1);
        when(shoppingCartRepository.findById(1)).thenReturn(Optional.of(existingShoppingCart));

        // Mockear usuario existente
        UserAccount existingUser = new UserAccount();
        existingUser.setUserId(1L);
        existingShoppingCart.setUser(existingUser);
        when(userAccountRepository.findById(1L)).thenReturn(Optional.of(existingUser));

        // Mockear productos existentes
        List<PurchaseOrderProduct> productsFromDto = new ArrayList<>();
        productsFromDto.add(new PurchaseOrderProduct(1, 2));
        productsFromDto.add(new PurchaseOrderProduct(2, 3));

        List<Product> productsWithStock = new ArrayList<>();
        Category category = Category.builder().id(1).name("FF").build();
        productsWithStock.add(Product.builder().id(1).category(category).name("Product 1").price(10.0).build());
        productsWithStock.add(Product.builder().id(2).category(category).name("Product 1").price(15.0).build());

        when(productRepository.findById(1)).thenReturn(Optional.of(productsWithStock.get(0)));
        when(productRepository.findById(2)).thenReturn(Optional.of(productsWithStock.get(1)));

        PurchaseOrderRequestBodyDto requestBodyDto = new PurchaseOrderRequestBodyDto();
        PurchaseOrderRequestDto purchaseOrderRequestDto = new PurchaseOrderRequestDto();
        purchaseOrderRequestDto.setBuyer_id(1);
        purchaseOrderRequestDto.setProducts(productsFromDto);
        purchaseOrderRequestDto.setOrder_status(PurchaseOrderStatusDto.builder().status_code("shopping_cart").build());
        requestBodyDto.setPurchaseOrderRequestDto(purchaseOrderRequestDto);

        // Ejecutar el método bajo prueba
        PurchaseOrderResponseDto responseDto = shoppingCartService.modifyPurchaseOrder(1, requestBodyDto);

        // Verificar que la respuesta no sea nula y que el total sea correcto (2 * 10.0 + 3 * 15.0 = 65.0)
        assertNotNull(responseDto);
        assertEquals(65.0, responseDto.getTotal_price());

        // Verificar llamadas a métodos mockeados
        verify(shoppingCartRepository, times(1)).findById(1);
        verify(userAccountRepository, times(1)).findById(1L);
        // 2 para verificar que el producto exista y otras 2 para extraer el precio
        verify(productRepository, times(4)).findById(anyInt());
    }

    @Test
    @DisplayName("Modify Purchase Order - Invalid Purchase Order Status")
    public void testModifyPurchaseOrder_InvalidOrderStatus() {
        // Mockear shopping cart existente
        ShoppingCart existingShoppingCart = new ShoppingCart();
        existingShoppingCart.setId(1);
        when(shoppingCartRepository.findById(1)).thenReturn(Optional.of(existingShoppingCart));

        // Mockear usuario existente
        UserAccount existingUser = new UserAccount();
        existingUser.setUserId(1L);
        existingShoppingCart.setUser(existingUser);
        when(userAccountRepository.findById(1L)).thenReturn(Optional.of(existingUser));

        PurchaseOrderRequestBodyDto requestBodyDto = new PurchaseOrderRequestBodyDto();
        PurchaseOrderRequestDto purchaseOrderRequestDto = new PurchaseOrderRequestDto();
        purchaseOrderRequestDto.setBuyer_id(1);
        purchaseOrderRequestDto.setOrder_status(new PurchaseOrderStatusDto("pending")); // Estado incorrecto
        requestBodyDto.setPurchaseOrderRequestDto(purchaseOrderRequestDto);

        // Ejecutar el método bajo prueba y capturar la excepción BadRequestException
        BadRequestException exception = assertThrows(BadRequestException.class, () ->
                shoppingCartService.modifyPurchaseOrder(1, requestBodyDto));

        // Verificar el mensaje de la excepción
        assertEquals("The status of the purchase order must be 'shopping_cart'", exception.getMessage());

        // Verificar llamadas a métodos mockeados
        verify(shoppingCartRepository, times(1)).findById(anyInt());
        verify(userAccountRepository, times(1)).findById(anyLong());
        verify(productRepository, never()).findById(anyInt());
    }

    @Test
    @DisplayName("Modify Purchase Order - Buyer Not Found")
    public void testModifyPurchaseOrder_BuyerNotFound() {
        // Mockear shopping cart existente
        ShoppingCart existingShoppingCart = new ShoppingCart();
        existingShoppingCart.setId(1);
        when(shoppingCartRepository.findById(anyInt())).thenReturn(Optional.of(existingShoppingCart));

        // Mockear usuario no existente
        when(userAccountRepository.findById(anyLong())).thenReturn(Optional.empty());

        PurchaseOrderRequestBodyDto requestBodyDto = new PurchaseOrderRequestBodyDto();
        PurchaseOrderRequestDto purchaseOrderRequestDto = new PurchaseOrderRequestDto();
        purchaseOrderRequestDto.setBuyer_id(99);
        purchaseOrderRequestDto.setOrder_status(PurchaseOrderStatusDto.builder().status_code("shopping_cart").build());
        requestBodyDto.setPurchaseOrderRequestDto(purchaseOrderRequestDto);

        // Ejecutar el método bajo prueba y capturar la excepción NotFoundException
        NotFoundException exception = assertThrows(NotFoundException.class, () ->
                shoppingCartService.modifyPurchaseOrder(1, requestBodyDto));

        // Verificar el mensaje de la excepción
        assertEquals("The buyer with the id 99 does not exist", exception.getMessage());

        // Verificar llamadas a métodos mockeados
        verify(shoppingCartRepository, times(1)).findById(anyInt());
        verify(userAccountRepository, times(1)).findById(anyLong());
        verify(productRepository, never()).findById(anyInt());
    }

    @Test
    @DisplayName("Modify Purchase Order - Product Not Found")
    public void testModifyPurchaseOrder_ProductNotFound() {
        // Mockear shopping cart existente
        ShoppingCart existingShoppingCart = new ShoppingCart();
        existingShoppingCart.setId(1);
        when(shoppingCartRepository.findById(anyInt())).thenReturn(Optional.of(existingShoppingCart));

        // Mockear usuario existente
        UserAccount existingUser = new UserAccount();
        existingUser.setUserId(1L);
        existingShoppingCart.setUser(existingUser);
        when(userAccountRepository.findById(anyLong())).thenReturn(Optional.of(existingUser));

        // Mockear productos con al menos uno no encontrado
        List<PurchaseOrderProduct> productsFromDto = new ArrayList<>();
        productsFromDto.add(new PurchaseOrderProduct(1, 2)); // Producto existente
        productsFromDto.add(new PurchaseOrderProduct(3, 3)); // Producto no encontrado

        List<Product> productsWithStock = new ArrayList<>();
        Category category = Category.builder().id(1).name("FF").build();
        productsWithStock.add(Product.builder().id(1).category(category).name("Product 1").price(10.0).build());

        when(productRepository.findById(1)).thenReturn(Optional.of(productsWithStock.get(0)));
        when(productRepository.findById(3)).thenReturn(Optional.empty());

        // Mockear request para el body de entrada
        PurchaseOrderRequestBodyDto requestBodyDto = new PurchaseOrderRequestBodyDto();
        PurchaseOrderRequestDto purchaseOrderRequestDto = new PurchaseOrderRequestDto();
        purchaseOrderRequestDto.setBuyer_id(1);
        purchaseOrderRequestDto.setProducts(productsFromDto);
        purchaseOrderRequestDto.setOrder_status(PurchaseOrderStatusDto.builder().status_code("shopping_cart").build());
        requestBodyDto.setPurchaseOrderRequestDto(purchaseOrderRequestDto);

        // Ejecutar el método bajo prueba y capturar la excepción NotFoundException
        NotFoundException exception = assertThrows(NotFoundException.class, () ->
                shoppingCartService.modifyPurchaseOrder(1, requestBodyDto));

        // Verificar el mensaje de la excepción
        assertEquals("Product not found with the ID: 3", exception.getMessage());

        // Verificar llamadas a métodos mockeados
        verify(shoppingCartRepository, times(1)).findById(1);
        verify(userAccountRepository, times(1)).findById(anyLong());
        verify(productRepository, times(2)).findById(anyInt());
    }

    @Test
    @DisplayName("Modify Purchase Order - Invalid Product Quantity")
    public void testModifyPurchaseOrder_InvalidProductQuantity() {
        // Mockear shopping cart existente
        ShoppingCart existingShoppingCart = new ShoppingCart();
        existingShoppingCart.setId(1);
        when(shoppingCartRepository.findById(1)).thenReturn(Optional.of(existingShoppingCart));

        // Mockear usuario existente
        UserAccount existingUser = new UserAccount();
        existingUser.setUserId(1L);
        existingShoppingCart.setUser(existingUser);
        when(userAccountRepository.findById(anyLong())).thenReturn(Optional.of(existingUser));

        // Mockear productos con cantidad inválida (<= 0)
        List<PurchaseOrderProduct> productsFromDto = new ArrayList<>();
        productsFromDto.add(new PurchaseOrderProduct(1, 2)); // Producto válido
        productsFromDto.add(new PurchaseOrderProduct(2, 0)); // Cantidad inválida
        productsFromDto.add(new PurchaseOrderProduct(3, -1)); // Cantidad inválida

        Category category = Category.builder().id(1).name("FF").build();
        when(productRepository.findById(1)).thenReturn(Optional.of(Product.builder().id(1).category(category).name("Product 1").price(10.0).build()));
        when(productRepository.findById(2)).thenReturn(Optional.of(Product.builder().id(2).category(category).name("Product 2").price(15.0).build()));
        when(productRepository.findById(3)).thenReturn(Optional.of(Product.builder().id(3).category(category).name("Product 3").price(20.0).build()));

        // Mockear el response body de entrada
        PurchaseOrderRequestBodyDto requestBodyDto = new PurchaseOrderRequestBodyDto();
        PurchaseOrderRequestDto purchaseOrderRequestDto = new PurchaseOrderRequestDto();
        purchaseOrderRequestDto.setBuyer_id(1);
        purchaseOrderRequestDto.setProducts(productsFromDto);
        purchaseOrderRequestDto.setOrder_status(PurchaseOrderStatusDto.builder().status_code("shopping_cart").build());
        requestBodyDto.setPurchaseOrderRequestDto(purchaseOrderRequestDto);

        // Ejecutar el método bajo prueba y capturar la excepción BadRequestException
        BadRequestException exception = assertThrows(BadRequestException.class, () ->
                shoppingCartService.modifyPurchaseOrder(1, requestBodyDto));

        // Verificar el mensaje de la excepción
        assertEquals("The product with the ID: 0 must have at least 1 on quantity", exception.getMessage());

        // Verificar llamadas a métodos mockeados
        verify(shoppingCartRepository, times(1)).findById(1);
        verify(userAccountRepository, times(1)).findById(anyLong());
        verify(productRepository, times(3)).findById(anyInt());
    }
}
