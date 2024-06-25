package com.mercadolibre.pf_be_hisp_w26_t07_torres.service;

import com.mercadolibre.pf_be_hisp_w26_t07_torres.dtos.buyers.BuyerResponseDto;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.entity.Buyer;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.exceptions.NotFoundException;
import com.mercadolibre.pf_be_hisp_w26_t07_torres.repository.IBuyerRepository;
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
public class BuyerServiceTest {
    @Mock
    private IBuyerRepository repository;

    @InjectMocks
    private BuyerServiceImpl service;

    @Test
    @DisplayName("Get buyer with by id")
    public void getBuyerWithById() {
        // Arrange
        Long id = 2L;
        Buyer buyer = new Buyer(id, "900000003", "Brayan", "El socio");
        BuyerResponseDto expected = new BuyerResponseDto(id, "900000003", "Brayan", "El socio");

        // Act
        when(repository.findById(id)).thenReturn(Optional.of(buyer));
        BuyerResponseDto actual = service.findById(id);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Get buyer with by id not found exception")
    public void getBuyerWithByIdNoExist() {
        // Arrange
        Long id = 10L;
        String exMessage = MessageError.BUYER_NOT_FOUND.getMessage();

        // Act
        when(repository.findById(id)).thenReturn(Optional.empty());
        NotFoundException actual = Assertions.assertThrows(NotFoundException.class, () -> service.findById(id));

        // Assert
        Assertions.assertEquals(exMessage, actual.getMessage());
    }
}
