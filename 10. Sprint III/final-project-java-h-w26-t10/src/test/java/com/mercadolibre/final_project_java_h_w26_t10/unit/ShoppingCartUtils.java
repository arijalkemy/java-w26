package com.mercadolibre.final_project_java_h_w26_t10.unit;

import com.mercadolibre.final_project_java_h_w26_t10.entity.Batch;
import com.mercadolibre.final_project_java_h_w26_t10.entity.Product;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShoppingCartUtils {
    public static Product getProductOne(){
        return new Product(
                1,
                null,
                "Pizza de Peperoni",
                8.99,
                null,
                null
        );
    }
    public static Product getProductTwo(){
        return new Product(
                3,
                null,
                "Lechuga Iceberg",
                1.99,
                null,
                null
        );
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
