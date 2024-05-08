package org.mercadolibre.NotNullTeam.service.impl;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mercadolibre.NotNullTeam.DTO.response.buyer.BuyerResponseWithNotSellerListDTO;
import org.mercadolibre.NotNullTeam.DTO.response.seller.SellerFollowersCountDto;
import org.mercadolibre.NotNullTeam.DTO.response.seller.SellerResponseDTO;
import org.mercadolibre.NotNullTeam.exception.error.NotFoundException;
import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.model.User;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.mercadolibre.NotNullTeam.util.TypeOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class SellerServiceImplTest {

    @InjectMocks
    private SellerServiceImpl sellerService;
    @Mock
    ISellerRepository sellerRepository;


    Seller seller;
    Buyer buyerA;
    Buyer buyerC;
    Buyer buyerB;
    Buyer buyerOne;
    Buyer buyerTwo;
    Seller sellerWithoutFollowers;
    Seller sellerWithFollowers;

    @BeforeEach
    public void setup() {
        buyerOne = Buyer.builder()
                .user(User.builder().id(100L).name("Seguidor Numero Uno").build())
                .followedList(new ArrayList<>())
                .build();

        buyerTwo = Buyer.builder()
                .user(User.builder().id(101L).name("Seguidor Numero Dos").build())
                .followedList(new ArrayList<>())
                .build();

        sellerWithoutFollowers = Seller.builder()
                .user(User.builder().id(102L).name("Lonely Seller").build())
                .followersList(new ArrayList<>())
                .build();

        sellerWithFollowers = Seller.builder()
                .user(User.builder().id(103L).name("Popular Seller").build())
                .followersList(new ArrayList<>())
                .build();

        seller = Seller.builder()
                .user(User.builder().id(1L).name("Vendedor Uno").build())
                .followersList(new ArrayList<>())
                .build();

        buyerA = Buyer.builder()
                .user(User.builder().id(2L).name("A").build())
                .followedList(new ArrayList<>())
                .build();

        buyerC = Buyer.builder()
                .user(User.builder().id(4L).name("C").build())
                .followedList(new ArrayList<>())
                .build();

        buyerB = Buyer.builder()
                .user(User.builder().id(5L).name("B").build())
                .followedList(new ArrayList<>())
                .build();

        sellerWithFollowers.addNewFollower(buyerOne);
        buyerOne.addNewFollowed(sellerWithFollowers);
        sellerWithFollowers.addNewFollower(buyerTwo);
        buyerTwo.addNewFollowed(sellerWithFollowers);
    }

    @Test
    @DisplayName("Obtener la cantidad de seguidores de un seller x, y da 0")
    public void getFollowersCountWithoutFollowers() {
        SellerFollowersCountDto expectedResult = SellerFollowersCountDto.builder()
                .user_id(sellerWithoutFollowers.getUser().getId())
                .user_name(sellerWithoutFollowers.getUsername())
                .followers_count(0)
                .build();

        when(sellerRepository.findById(sellerWithoutFollowers.getUser().getId())).thenReturn(
                Optional.of(sellerWithoutFollowers));

        SellerFollowersCountDto actualResult = sellerService.getFollowersCount(102L);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Obtener la cantidad de seguidores de un seller x, y da 2")
    public void getFollowersCountWithFollowers() {
        SellerFollowersCountDto expectedResult = SellerFollowersCountDto.builder()
                .user_id(sellerWithFollowers.getUser().getId())
                .user_name(sellerWithFollowers.getUsername())
                .followers_count(2)
                .build();

        when(sellerRepository.findById(sellerWithFollowers
                .getUser()
                .getId())).thenReturn(Optional.of(sellerWithFollowers));

        SellerFollowersCountDto actualResult = sellerService.getFollowersCount(103L);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Se intenta obtener la cantidad de seguidores de un seller que no existe y lanza error")
    public void getFollowersCountThrowsSellerNotFound() {
        when(sellerRepository.findById(120L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> sellerService.getFollowersCount(102L));
    }

    @Test
    @DisplayName("Obtener lista de seguidores ordenada de un seller x por nombre ascendente")
    void getListFollowersOrdered() {
        seller.setFollowersList(new ArrayList<>(Arrays.asList(buyerC, buyerB, buyerA)));

        List<BuyerResponseWithNotSellerListDTO> expectedFollowers =
                List.of(
                        BuyerResponseWithNotSellerListDTO.builder()
                                .id(buyerA.getUser().getId())
                                .name(buyerA.getUsername())
                                .build(),
                        BuyerResponseWithNotSellerListDTO.builder()
                                .id(buyerB.getUser().getId())
                                .name(buyerB.getUsername())
                                .build(),
                        BuyerResponseWithNotSellerListDTO.builder()
                                .id(buyerC.getUser().getId())
                                .name(buyerC.getUsername())
                                .build()
                );

        SellerResponseDTO expectedSeller = SellerResponseDTO.builder()
                .id(seller.getUser().getId())
                .name(seller.getUsername())
                .followers(expectedFollowers)
                .build();

        when(sellerRepository.findById(1L)).thenReturn(Optional.of(seller));

        SellerResponseDTO responseSeller = sellerService.getListFollowersOrdered(seller
                .getUser()
                .getId(), TypeOrder.NAME_ASC);

        assertEquals(expectedSeller, responseSeller);
    }

    @Test
    @DisplayName("Obtener lista de seguidores ordenada de un seller x por nombre descendente")
    void getListFollowersOrderedDesc() {
        seller.setFollowersList(new ArrayList<>(Arrays.asList(buyerA, buyerB, buyerC)));

        List<BuyerResponseWithNotSellerListDTO> expectedFollowers =
                List.of(
                        BuyerResponseWithNotSellerListDTO.builder()
                                .id(buyerC.getUser().getId())
                                .name(buyerC.getUsername())
                                .build(),
                        BuyerResponseWithNotSellerListDTO.builder()
                                .id(buyerB.getUser().getId())
                                .name(buyerB.getUsername())
                                .build(),
                        BuyerResponseWithNotSellerListDTO.builder()
                                .id(buyerA.getUser().getId())
                                .name(buyerA.getUsername())
                                .build()
                );

        SellerResponseDTO expectedSeller = SellerResponseDTO.builder()
                .id(seller.getUser().getId())
                .name(seller.getUsername())
                .followers(expectedFollowers)
                .build();

        when(sellerRepository.findById(1L)).thenReturn(Optional.of(seller));

        SellerResponseDTO responseSeller = sellerService.getListFollowersOrdered(seller
                .getUser()
                .getId(), TypeOrder.NAME_DESC);

        assertEquals(expectedSeller, responseSeller);
    }

    @Test
    @DisplayName("Obtener la lista de seguidores de un seller que no existe se espera una excepcion")
    void getFollowersListByUnknowUserThrowsException() {
        // Arrange
        when(sellerRepository.findById(1L)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class,
                () -> sellerService.getListFollowersOrdered(1L, TypeOrder.NAME_DESC));
    }
}