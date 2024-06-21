package com.mercadolibre.project_be_java_hisp_w26_team5.unit;

import com.mercadolibre.project_be_java_hisp_w26_team5.dto.response.ProductDetailResponseDto;
import com.mercadolibre.project_be_java_hisp_w26_team5.enums.TypeProduct;
import com.mercadolibre.project_be_java_hisp_w26_team5.mapper.ProductMapper;
import com.mercadolibre.project_be_java_hisp_w26_team5.model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductMapperTest {

    static Product apple;
    static Product banana;

    @BeforeAll
    static void setUp() {
        apple = Product
                .builder()
                .id(1)
                .name("Apple")
                .description("Apple description")
                .type(TypeProduct.FS)
                .creationDate(Instant.now())
                .build();
        banana = Product
                .builder()
                .id(2)
                .name("Banana")
                .description("Banana description")
                .type(TypeProduct.FS)
                .creationDate(Instant.now())
                .build();
    }


    @Test
    @DisplayName("Test toProductDetailResponseDto with product apple success")
    void testToProductDetailResponseDtoSuccess() {
        //arrange
        Product product = apple;

        //expected
        ProductDetailResponseDto expected = ProductMapper.toProductDetailResponseDto(product);

        //assert
        assertEquals(expected.getId(), 1);
        assertEquals(expected.getName(), "Apple");
        assertEquals(expected.getDescription(), "Apple description");
        assertEquals(expected.getType(), TypeProduct.FS);
    }


    @Test
    @DisplayName("Test toProductDetailResponseDtoList with list response [apple,banana] success")
    void testToProductDetailResponseDtoListSuccess() {
        //arrange
        List<Product> products = List.of(apple, banana);

        //expected
        List<ProductDetailResponseDto> expected = ProductMapper.toProductDetailResponseDtoList(
                products);

        //assert
        assertEquals(expected.size(), 2);
        assertEquals(expected
                .get(0)
                .getId(), 1);
        assertEquals(expected
                .get(0)
                .getName(), "Apple");
        assertEquals(expected
                .get(0)
                .getDescription(), "Apple description");
        assertEquals(expected
                .get(0)
                .getType(), TypeProduct.FS);

        assertEquals(expected
                .get(1)
                .getId(), 2);
        assertEquals(expected
                .get(1)
                .getName(), "Banana");
        assertEquals(expected
                .get(1)
                .getDescription(), "Banana description");
        assertEquals(expected
                .get(1)
                .getType(), TypeProduct.FS);
    }


}
