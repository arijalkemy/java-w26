package com.mercadolibre.pf_be_hisp_w26_t07_torres.service;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.sellers.SellerResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.Seller;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.repository.ISellerRepository;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.util.enums.MessageError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SellerServiceTest {
    @Mock
    private ISellerRepository repository;

    @InjectMocks
    private SellerServiceImpl service;

    @Test
    @DisplayName("get seller by id")
    public void getSellerById() {
        // Arrange
        Long id = 2L;
        Seller seller = new Seller(id, "Fries", "papas");
        SellerResponseDto expected = new SellerResponseDto(id, "Fries", "papas");

        // Act
        when(repository.findById(id)).thenReturn(Optional.of(seller));
        SellerResponseDto actual = service.findById(id);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("get seller by id not found exception")
    public void getSellerByIdEmpty() {
        // Arrange
        Long id = 2L;
        String exMessage = MessageError.SELLER_NOT_FOUND.getMessage();

        // Act
        when(repository.findById(id)).thenReturn(Optional.empty());
        NotFoundException actual = Assertions.assertThrows(NotFoundException.class, () -> service.findById(id));

        // Assert
        Assertions.assertEquals(exMessage, actual.getMessage());
    }
}
