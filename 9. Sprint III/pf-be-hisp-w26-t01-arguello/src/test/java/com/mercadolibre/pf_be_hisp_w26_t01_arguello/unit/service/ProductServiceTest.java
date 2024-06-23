package com.mercadolibre.pf_be_hisp_w26_t01_arguello.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.dtos.ProductResponseDTO;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.Product;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.enums.ProductCategory;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    IProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;

    @Test
    public void getAll_Ok() {
        List<Product> productList = List.of(new Product(1, "Banana", 200d,
                new Category(1, "Fresco", "Prod fresco")));
        when(productRepository.findAll()).thenReturn(productList);
        List<ProductResponseDTO> expected = List.of(new ProductResponseDTO("Banana", 200d, "Fresco"));

        List<ProductResponseDTO> obtained = productService.getAll();

        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void getAll_NotFound() {
        List<Product> productList = List.of();
        when(productRepository.findAll()).thenReturn(productList);

        Assertions.assertThrows(ApiException.class, () -> productService.getAll());
    }

    @Test
    public void getAllByCategory_Ok() {
        String categoryKey = "FS";
        String category = "Fresco";
        List<ProductResponseDTO> expected = List.of(new ProductResponseDTO("Banana", 200d, category));
        List<Product> productList = List.of(new Product(1, "Banana", 200d,
                new Category(1, category, "Prod fresco")));
        when(productRepository.findAllByCategoryName(category)).thenReturn(productList);
        List<ProductResponseDTO> obtained = productService.getAllByCategory(categoryKey);

        Assertions.assertEquals(expected, obtained);
    }

    @Test
    public void getAllByCategory_NotFound() {
        String category = "Fresco";
        String categoryKey = "FS";
        List<Product> productList = List.of();
        when(productRepository.findAllByCategoryName(category)).thenReturn(productList);

        Assertions.assertThrows(ApiException.class, () -> productService.getAllByCategory(categoryKey));
    }

    @Test
    public void findAllProductsInIds_Ok() {
        List<Integer> ids = List.of(1);
        List<Product> productsList =List.of(new Product(1, "Banana", 10.0, null ));
        when(productRepository.findAllByIds(ids)).thenReturn(productsList);

        List<Product> obtained = productService.findAllProductsInIds(ids);

        Assertions.assertEquals(productsList, obtained);
    }

    @Test
    public void findAllProductsInIds_NotFound() {
        List<Integer> ids = List.of(1);
        List<Product> productsList =List.of();
        when(productRepository.findAllByIds(ids)).thenReturn(productsList);

        Assertions.assertThrows(ApiException.class, () -> productService.findAllProductsInIds(ids));
    }

    @Test
    public void exists_Ok(){
        Integer id = 1;
        when(productService.exists(id)).thenReturn(true);
        Boolean obtained = productService.exists(id);

        Assertions.assertTrue(obtained);
    }

    @Test
    public void findById_Ok(){
        Integer id = 1;
        Product product = new Product(1, "Banana", 10.0, null);
        when(productRepository.findById(id)).thenReturn(Optional.of(product));

        Product obtained = productService.findById(id);

        Assertions.assertEquals(product, obtained);
    }
}
