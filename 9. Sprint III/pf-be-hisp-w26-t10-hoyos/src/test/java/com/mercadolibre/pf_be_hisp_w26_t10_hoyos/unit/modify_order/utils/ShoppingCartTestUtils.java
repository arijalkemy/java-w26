package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.unit.modify_order.utils;


import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.entity.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingCartTestUtils {
    public static UserAccount getUserAccountWithId1(){
        return UserAccount
                .builder()
                .userId(1L)
                .username("nhoyos")
                .password("123")
                .firstName("nicolas")
                .lastName("hoyos")
                .userRole(Rol.BUYER)
                .build();
    }
    public static List<Product> getListOfProducts(){
        return new ArrayList<Product>(
                List.of(
                        Product.builder()
                                .id(1)
                                .category(Category.builder().id(1).name("FF").build())
                                .name("Pizza de Pepperoni")
                                .price(8.99)
                                .build()
                )
        );
    }
    public static Optional<ShoppingCart> getOrderById(){
        UserAccount userAccount = getUserAccountWithId1();

        return Optional.ofNullable(
                ShoppingCart.builder()
                        .id(1)
                        .user(userAccount)
                        .orderDate(LocalDate.of(2024,6,13))
                        .orderState("shopping_cart")
                        .total(0.0)
                        .build()
        );
    }
}
