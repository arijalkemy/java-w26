package com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.unit.util;

import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.dtos.ProductsGeneralDto;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_mcaldera.repository.IProductRepository;

import java.util.List;

public class TestUtilGenerator {
    static IProductRepository productRepository;

    public static List<ProductsGeneralDto> getProductsDtoExpectedTest(){
        return List.of(
                new ProductsGeneralDto("Pizza de Pepperoni", 8.99),
                new ProductsGeneralDto("Zumo de Naranja Natural", 2.49),
                new ProductsGeneralDto("Lechuga Iceberg", 1.99),
                new ProductsGeneralDto("Filete de Salmón", 12.99)
        );
    }

    public static List<Product> getProductsExpectedTest(){
        return List.of(
                new Product(1,null,"Pizza de Pepperoni",
                        8.99,null,null),
                new Product(2,null,"Zumo de Naranja Natural",
                        2.49,null,null),
                new Product(3,null,"Lechuga Iceberg",
                        1.99,null,null),
                new Product(4,null,"Filete de Salmón",
                        12.99,null,null)
        );
    }

    public static List<ProductsGeneralDto> getProductsDtoByCategoryExpectedTest(){
        return List.of(
                new ProductsGeneralDto("Pizza de Pepperoni", 8.99),
                new ProductsGeneralDto("Filete de Salmón", 12.99),
                new ProductsGeneralDto("Helado de Chocolate", 3.99),
                new ProductsGeneralDto("Pollo Congelado", 7.99)
        );
    }

    public static List<Product> getProductsByCategoryExpectedTest(){
        return List.of(
                new Product(1,null,"Pizza de Pepperoni",
                        8.99,null,null),
                new Product(2,null,"Filete de Salmón",
                        12.99,null,null),
                new Product(3,null,"Helado de Chocolate",
                        3.99,null,null),
                new Product(4,null,"Pollo Congelado",
                        7.99,null,null)
        );
    }
}
