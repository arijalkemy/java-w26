package org.mercadolibre.NotNullTeam.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mercadolibre.NotNullTeam.DTO.response.buyer.BuyerResponseDTO;
import org.mercadolibre.NotNullTeam.exception.error.InvalidParameterException;
import org.mercadolibre.NotNullTeam.exception.error.NotFoundException;
import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.model.User;
import org.mercadolibre.NotNullTeam.service.IBuyerService;
import org.mercadolibre.NotNullTeam.service.ISellerService;
import org.mercadolibre.NotNullTeam.util.TypeOrder;
import org.mercadolibre.NotNullTeam.utils.GeneratorTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mercadolibre.NotNullTeam.util.TypeOrder.NAME_ASC;
import static org.mercadolibre.NotNullTeam.util.TypeOrder.NAME_DESC;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuyerControllerTest {
    @Mock
    IBuyerService buyerService;

    @InjectMocks
    BuyerController buyerController;

    @Test
    @DisplayName("Un buyer x sigue a un seller y, se guarda correctamente")
    void followSellerSuccessfully() {
        buyerController.followSeller(1L, 2L);

        verify(buyerService, atLeastOnce()).followSeller(1L, 2L);
    }

    @Test
    @DisplayName("Un buyer x sigue a un seller y, el seller no existe y se lanza una excepcion")
    void followSellerThrowsSellerNotFound() {
        doThrow(NotFoundException.class).when(buyerService).followSeller(1L, 2L);

        assertThrows(NotFoundException.class,
                () -> buyerController.followSeller(1L, 2L));
    }

    @Test
    @DisplayName("Un buyer x deja de seguir a un seller y, se guarda correctamente")
    void testUnfollowSellerSuccessfully() {
        buyerController.unfollowSeller(1L, 2L);

        verify(buyerService, atLeastOnce()).unfollowSeller(1L, 2L);
    }

    @Test
    @DisplayName("Un buyer x deja de seguir a un seller y, el seller no existe y lanza una excepcion")
    void unfollowSellerThrowsSellerNotFound() {
        doThrow(NotFoundException.class).when(buyerService).unfollowSeller(1L, 2L);

        assertThrows(NotFoundException.class,
                () -> buyerController.unfollowSeller(1L, 2L));
    }


    @Test
    @DisplayName("Obtener lista de seguidos de un buyer x ordenada por nombre de forma ascendente")
    void getFollowedListOrderedNameAscSuccessfully() {
        BuyerResponseDTO buyerResponse = GeneratorTest.BuyerResponseDTO();
        when(buyerService.getFollowedListOrdered(1L, NAME_ASC)).thenReturn(buyerResponse);

        ResponseEntity<BuyerResponseDTO> response = buyerController.getFollowedListOrdered(1L, NAME_ASC);

        assertEquals(buyerResponse, response.getBody());
    }


    @Test
    @DisplayName("Obtener lista de seguidos de un buyer x con un parametro invalido de ordenamiento y lanza una " +
            "excepcion")
    void getFollowedListOrderedInvalidParameterException() {
        doThrow(InvalidParameterException.class).when(buyerService).getFollowedListOrdered(1L, "menor_mayor");

        assertThrows(InvalidParameterException.class,
                () -> buyerController.getFollowedListOrdered(1L, "menor_mayor"));
    }
}