package com.mercadolibre.pf_be_hisp_w26_t10_hoyos.unit.individual;

import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.ProductDto;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.SellerProductRequestDto;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.dtos.SellerProductResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.entity.UserAccount;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.repository.IProductRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.repository.IUserAccountRepository;
import com.mercadolibre.pf_be_hisp_w26_t10_hoyos.service.implementations.ProductServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SellerIndividualTest {

    @Mock
    IProductRepository productRepository;
    @Mock
    IUserAccountRepository accountRepository;
    @InjectMocks
    ProductServiceImpl productService;



    @Test
    @DisplayName("US-6-Create Product by seller happy path")
    public void testCreateNewSellerProductHappyPath() {
        Long userId = 1L;
        SellerProductRequestDto requestDto = new SellerProductRequestDto();
        List<ProductDto> products = new ArrayList<>();
        products.add(new ProductDto("Cerdo", 50.0));
        products.add(new ProductDto("Cereza", 75.0));
        requestDto.setProducts(products);

        UserAccount mockUserAccount = new UserAccount();
        mockUserAccount.setUserId(userId);

        when(accountRepository.findByUserId(userId)).thenReturn(mockUserAccount);
        when(productRepository.saveAll(anyList())).thenReturn(mock(List.class));

        SellerProductResponseDto response = productService.createNewSellerProduct(userId, requestDto);

        assertNotNull(response);
        assertEquals(1, response.getOperation());

    }

    @Test
    public void testCreateNewSellerProduct_UserNotFound() {

        Long userId = -2L;
        UserAccount userNonExistant = new UserAccount();
        SellerProductRequestDto requestDto = new SellerProductRequestDto();
        List<ProductDto> products = new ArrayList<>();
        products.add(new ProductDto("Product A", 50.0));
        products.add(new ProductDto("Product B", 75.0));
        requestDto.setProducts(products);

        when(accountRepository.findByUserId(userId)).thenReturn(null);

        assertThrows(NotFoundException.class, () -> {
            productService.createNewSellerProduct(userId, requestDto);
        });
    }
}