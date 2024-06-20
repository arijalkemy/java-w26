package com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.unit.util;

import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.dtos.ProductsGeneralDto;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t10_gonzalez.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

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
//        return List.of(
//                new Product(1,null,"Pizza de Pepperoni",
//                        8.99,null,null),
//                new Product(2,null,"Zumo de Naranja Natural",
//                        2.49,null,null),
//                new Product(3,null,"Lechuga Iceberg",
//                        1.99,null,null),
//                new Product(4,null,"Filete de Salmón",
//                        12.99,null,null)
//        );
        return List.of(
                Product.builder().id(1).category(null).name("Pizza de Pepperoni").price(8.99).seller(null).build(),
                Product.builder().id(2).category(null).name("Zumo de Naranja Natural").price(2.49).seller(null).build(),
                Product.builder().id(3).category(null).name("Lechuga Iceberg").price(1.99).seller(null).build(),
                Product.builder().id(4).category(null).name("Filete de Salmón").price(12.99).seller(null).build()
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
//        return List.of(
//                new Product(1,null,"Pizza de Pepperoni",8.99,null,null),
//                new Product(2,null,"Filete de Salmón",12.99,null,null),
//                new Product(3,null,"Helado de Chocolate",3.99,null,null),
//                new Product(4,null,"Pollo Congelado",7.99,null,null)
//        );
//
        return List.of(
                Product.builder().id(1).category(null).name("Pizza de Pepperoni").price(8.99).seller(null).build(),
                Product.builder().id(2).category(null).name("Filete de Salmón").price(12.99).seller(null).build(),
                Product.builder().id(3).category(null).name("Helado de Chocolate").price(3.99).seller(null).build(),
                Product.builder().id(4).category(null).name("Pollo Congelado").price(7.99).seller(null).build()
        );
    }
}
