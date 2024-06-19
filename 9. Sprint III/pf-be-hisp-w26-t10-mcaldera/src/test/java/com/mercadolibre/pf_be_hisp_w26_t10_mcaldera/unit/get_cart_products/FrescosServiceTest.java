package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.unit.get_cart_products;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.ProductDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.ShoppingCartProduct;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.repository.IShoppingCartProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.service.implementations.FrescosServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FrescosServiceTest {
    @Mock
    IShoppingCartProductRepository shoppingCartProductRepository;
    @InjectMocks
    FrescosServiceImpl frescosService;
    @Test
    @DisplayName("US-002-Issue-06 get shopping cart products")
    public void getShoppingCartProducts(){
        // Arrange
        Integer idOrder = 1;
        List<ShoppingCartProduct> products = new ArrayList<>();
        ShoppingCartProduct cartProduct = new ShoppingCartProduct();
        cartProduct.setId(1);
        cartProduct.setProduct(new Product(1,null,"Pizza de Pepperoni",8.99,null,null));
        products.add(cartProduct);
        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(new ProductDto(
                cartProduct.getProduct().getName(),
                cartProduct.getProduct().getPrice()));
        when(shoppingCartProductRepository.findDistinctByShoppingCartId(idOrder)).thenReturn(products);

        // Act
        List<ProductDto> response = frescosService.getProductsFromShoppingCart(idOrder).stream().toList();

        // Assert
        verify(shoppingCartProductRepository, atLeastOnce()).findDistinctByShoppingCartId(idOrder);
        assertEquals(productDtos.size(), response.size());
        assertEquals(productDtos.get(0).getName(), response.get(0).getName());
    }
}
