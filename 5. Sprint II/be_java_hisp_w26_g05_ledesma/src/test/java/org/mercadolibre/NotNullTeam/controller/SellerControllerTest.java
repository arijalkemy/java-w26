package org.mercadolibre.NotNullTeam.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mercadolibre.NotNullTeam.DTO.response.seller.SellerFollowersCountDto;
import org.mercadolibre.NotNullTeam.DTO.response.seller.SellerResponseDTO;
import org.mercadolibre.NotNullTeam.exception.error.NotFoundException;
import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.model.User;
import org.mercadolibre.NotNullTeam.service.IBuyerService;
import org.mercadolibre.NotNullTeam.service.ISellerService;
import org.mercadolibre.NotNullTeam.utils.GeneratorTest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mercadolibre.NotNullTeam.util.TypeOrder.NAME_ASC;
import static org.mercadolibre.NotNullTeam.util.TypeOrder.NAME_DESC;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SellerControllerTest {
    @Mock
    ISellerService sellerService;

    @InjectMocks
    SellerController sellerController;

    @Test
    @DisplayName("Obtenemos la cantidad de seguidores del Seller1 (UserId: 2L)")
    void testGetFollowersCount() {
        SellerFollowersCountDto expected = GeneratorTest.sellerFollowersCountDto();
        when(sellerService.getFollowersCount(2L)).thenReturn(expected);

        ResponseEntity<?> response = sellerController.getFollowersCount(2L);

        assertEquals(expected, response.getBody());
    }

    @Test
    @DisplayName("Intentamos obtener la lista de seguidores de un Seller no existente (UserId: 1L)")
    void followSellerThrowsSellerNotFound() {
        when(sellerService.getFollowersCount(1L)).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class,
                () -> sellerController.getFollowersCount(1L));
    }

    @Test
    @DisplayName("Obtenemos la lista de seguidores de un Seller existente (UserId: 2L)")
    void testGetListFollowers() {
        SellerResponseDTO expected = GeneratorTest.sellerResponseDTO();
        when(sellerService.getListFollowersOrdered(2L, NAME_ASC)).thenReturn(expected);

        ResponseEntity<?> response = sellerController.getListFollowers(2L, NAME_ASC);

        assertEquals(expected, response.getBody());
    }
}