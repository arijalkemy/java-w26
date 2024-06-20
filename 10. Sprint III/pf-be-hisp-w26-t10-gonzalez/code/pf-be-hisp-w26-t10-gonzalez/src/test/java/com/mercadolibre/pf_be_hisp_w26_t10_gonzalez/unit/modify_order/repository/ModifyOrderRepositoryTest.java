package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.unit.modify_order.repository;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.ShoppingCart;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.ShoppingCartProduct;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.repository.IShoppingCartRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.unit.modify_order.utils.ShoppingCartTestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ModifyOrderRepositoryTest {

    @Mock
    IShoppingCartRepository shoppingCartRepository;

    @Test
    @DisplayName("It should return a Shopping Cart - Happy Path")
    public void TestShoppingRepository_ThenReturnAListOfOneProduct(){
        Optional<ShoppingCart> expectedShoppingCart = ShoppingCartTestUtils.getOrderById();
        when(shoppingCartRepository.findById(anyInt())).thenReturn(expectedShoppingCart);

        Optional<ShoppingCart> actualShoppingCart = shoppingCartRepository.findById(anyInt());

        Assertions.assertEquals(actualShoppingCart.get(), expectedShoppingCart.get());
    }

    @Test
    @DisplayName("Should return a non-existent Shopping Cart - Sad Path")
    public void TestShoppingRepository_GetShoppingCart_ThenReturnNonExistentShoppingCart(){
        when(shoppingCartRepository.findById(anyInt())).thenReturn(Optional.empty());

        Optional<ShoppingCart> actualShoppingCart = shoppingCartRepository.findById(anyInt());

        Assertions.assertFalse(actualShoppingCart.isPresent());
    }

}
