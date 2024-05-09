package org.mercadolibre.NotNullTeam.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mercadolibre.NotNullTeam.DTO.response.buyer.BuyerResponseDTO;
import org.mercadolibre.NotNullTeam.exception.error.InvalidParameterException;
import org.mercadolibre.NotNullTeam.exception.error.NotFoundException;
import org.mercadolibre.NotNullTeam.service.IBuyerService;
import org.mercadolibre.NotNullTeam.utils.GeneratorTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mercadolibre.NotNullTeam.util.TypeOrder.NAME_ASC;
import static org.mercadolibre.NotNullTeam.util.TypeOrder.NAME_DESC;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BuyerControllerTest {
    @Mock
    IBuyerService buyerService;

    @InjectMocks
    BuyerController buyerController;

    @Test
    @DisplayName("Buyer (UserId 1L) sigue a Seller (UserId 2L) y, se guarda correctamente")
    void followSellerSuccessfully() {
        buyerController.followSeller(1L, 2L);

        verify(buyerService, atLeastOnce()).followSeller(1L, 2L);
    }

    @Test
    @DisplayName("Buyer (UserId 1L) sigue a Seller (UserId 2L), el seller no existe y se lanza una excepcion")
    void followSellerThrowsSellerNotFound() {
        doThrow(NotFoundException.class).when(buyerService).followSeller(1L, 2L);

        assertThrows(NotFoundException.class,
                () -> buyerController.followSeller(1L, 2L));
    }

    @Test
    @DisplayName("Buyer (UserId 1L) deja de seguir a Seller (UserId 2L) y se guarda correctamente")
    void testUnfollowSellerSuccessfully() {
        buyerController.unfollowSeller(1L, 2L);

        verify(buyerService, atLeastOnce()).unfollowSeller(1L, 2L);
    }

    @Test
    @DisplayName("Buyer (UserId 1L) deja de seguir a Seller (UserId 2L), el seller no existe y lanza una excepcion")
    void unfollowSellerThrowsSellerNotFound() {
        doThrow(NotFoundException.class).when(buyerService).unfollowSeller(1L, 2L);

        assertThrows(NotFoundException.class,
                () -> buyerController.unfollowSeller(1L, 2L));
    }

    @Test
    @DisplayName("Se ejecuta correctamente el metodo getFollowedListOrdered pasandole como order: NAME_ASC")
    void getFollowedListOrderedNameAscSuccessfully() {
        getFollowedListOrderedOrder(NAME_ASC);
    }

    @Test
    @DisplayName("Se ejecuta correctamente el metodo getFollowedListOrdered pasandole como order: NAME_DESC")
    void getFollowedListOrderedNameDescSuccessfully() {
        getFollowedListOrderedOrder(NAME_DESC);
    }

    private void getFollowedListOrderedOrder(String order){
        BuyerResponseDTO buyerExpected = GeneratorTest.BuyerResponseDTO();
        when(buyerService.getFollowedListOrdered(1L, order)).thenReturn(buyerExpected);

        ResponseEntity<BuyerResponseDTO> response = buyerController.getFollowedListOrdered(1L, order);

        assertEquals(buyerExpected, response.getBody());
    }

    @Test
    @DisplayName("getFollowedListOrdered lanza un InvalidParameterException al recibir como parametro order: menor_mayor")
    void getFollowedListOrderedInvalidParameterException() {
        doThrow(InvalidParameterException.class).when(buyerService).getFollowedListOrdered(1L, "menor_mayor");

        assertThrows(InvalidParameterException.class,
                () -> buyerController.getFollowedListOrdered(1L, "menor_mayor"));
    }
}