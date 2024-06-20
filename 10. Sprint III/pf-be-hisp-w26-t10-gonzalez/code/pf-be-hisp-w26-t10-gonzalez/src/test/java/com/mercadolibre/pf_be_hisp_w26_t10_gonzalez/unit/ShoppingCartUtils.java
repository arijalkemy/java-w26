package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.unit;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.ProductsGeneralDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Batch;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Product;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShoppingCartUtils {
    public static Product getProductOne(){
//        return new Product(
//                1,
//                null,
//                "Pizza de Peperoni",
//                8.99,
//                null,
//                null
//        );
//
        return Product.builder().id(1).category(null).name("Pizza de Pepperoni").price(8.99).seller(null).build();
    }
    public static Product getProductTwo(){
//        return new Product(
//                3,
//                null,
//                "Lechuga Iceberg",
//                1.99,
//                null,
//                null
//        );
        return Product.builder().id(3).category(null).name("Lechuga Iceberg").price(1.99).seller(null).build();
    }

    public static Batch getBatchOne(){
        return new Batch(
                1,
                getProductOne(),
                null,
                null,
                12345,
                -18.0,
                -20.0,
                100,
                100,
                LocalDate.of(2024,6,12),
                LocalTime.of(8,0),
                LocalDate.of(2024,7,12)
        );
    }
}
