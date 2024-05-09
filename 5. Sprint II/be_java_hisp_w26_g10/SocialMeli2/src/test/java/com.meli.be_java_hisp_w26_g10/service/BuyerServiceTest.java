package com.meli.be_java_hisp_w26_g10.service;

import com.api.socialmeli.entity.Buyer;
import com.api.socialmeli.entity.Seller;
import com.api.socialmeli.exception.BadRequestException;
import com.api.socialmeli.repository.impl.BuyerRepositoryImpl;
import com.api.socialmeli.service.impl.BuyerServiceImpl;
import com.api.socialmeli.service.impl.SellerServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;
import com.api.socialmeli.exception.NotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g10.util.TestGeneratorUtil;
import org.apache.commons.collections4.CollectionUtils;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class BuyerServiceTest {



    @Mock
    BuyerRepositoryImpl buyerRepository;
    @Mock
    SellerServiceImpl sellerService;

    @InjectMocks
    BuyerServiceImpl buyerService;

    @Test
    @DisplayName("T0001 - Seguir a un usuario exitosamente")
    public void followSuccessfullyAnUser(){
        //Act && Arrange
        Buyer buyer = new Buyer(15, "Nicolas", new ArrayList<>());
        Seller seller = new Seller(15, "Nike");
        Buyer finalBuyer = new Buyer(15, "Nicolas", List.of(seller));
        when(sellerService.getSellerById(seller.getUser_id())).thenReturn(seller);
        when(buyerRepository.getById(buyer.getUser_id())).thenReturn(buyer);
        when(buyerRepository.followUser(buyer,seller)).thenReturn(finalBuyer);
        Buyer buyerReturned = buyerService.followUser(buyer.getUser_id(),seller.getUser_id());
        //Assert
        Assertions.assertEquals(finalBuyer, buyerReturned);
    }

    @Test
    @DisplayName("T0001 - Seguir a un usuario el cual ya se seguia previamente")
    public void followUserTwice(){
        //Act && Arrange
        Seller seller = new Seller(15, "Nike");
        Buyer buyer = new Buyer(15, "Nicolas", List.of(seller));
        when(sellerService.getSellerById(seller.getUser_id())).thenReturn(seller);
        when(buyerRepository.getById(buyer.getUser_id())).thenReturn(buyer);
        //Assert
        Assertions.assertThrows(BadRequestException.class,
                () -> buyerService.followUser(buyer.getUser_id(),seller.getUser_id()));
    }

    @Test
    @DisplayName("T0002 - Realizar la accion de dejar de seguir a un vendedor de forma exitosa")
    public void unfollowUserGoodWay() {

        Integer followerId = 1;
        Integer unfollowId = 1;

        Buyer buyerExpected = TestGeneratorUtil.getSingleBuyer();

        when(buyerRepository.getById(followerId)).thenReturn(buyerExpected);

        buyerService.unfollowUser(followerId, unfollowId);

        verify(buyerRepository, times(2)).getById(followerId);

    }
    @Test
    @DisplayName("T0002 - Dejar de seguir a un vendedor mandando la excepcion NotFoundException")
    public void unfollowUserFirstSadPath() {
        Integer followerId = 1;
        Integer unfollowId = 2;


        when(buyerRepository.getById(followerId)).thenReturn(null);

        Assertions.assertThrows(NotFoundException.class, () -> buyerService.unfollowUser(followerId, unfollowId));

    }

    @Test
    @DisplayName("T0002 - Dejar de seguir a un vendedor mandando la excepcion NotFoundException con el mensaje : 'No sigues al vendedor'")
    public void unfollowUserSecondSadPath() {
        Integer followerId = 1;
        Integer unfollowId = 2;

        Buyer buyerExpected = TestGeneratorUtil.getSingleBuyer();

        when(buyerRepository.getById(followerId)).thenReturn(buyerExpected);

        Assertions.assertThrows(NotFoundException.class, () -> buyerService.unfollowUser(followerId, unfollowId));

    }

    @Test
    @DisplayName("T0004 - Obtener la lista de seguidos por usuario sin un ordenamiento definido de manera exitosa")
    public void GetFollowedListByUserSuccessful(){
        //Arrange
        ObjectMapper mapper = new ObjectMapper();
        Buyer buyer = TestGeneratorUtil.getBuyerById(1);
        when(buyerRepository.getById(1)).thenReturn(buyer);
        //Act
        Buyer buyerResult = mapper.convertValue(buyerService
                .GetFollowedListByUser(buyer.getUser_id(),null),Buyer.class);
        //Assert
        assertEquals(buyer,buyerResult);
    }

    @Test
    @DisplayName("T0004 - Obtener la lista de seguidos de un usuario que no existe")
    public void GetFollowedListByUserNotFound(){
        //Arrange
        when(buyerRepository.getById(anyInt())).thenReturn(null);
        //Act && Assert
        assertThrows(NotFoundException.class,
                () -> buyerService.GetFollowedListByUser(11, null)
        );
    }

    @Test
    @DisplayName("T0004 - Obtener la lista de seguidos de un usuario ordenada ascendentemente")
    public void GetFollowedListByUserOrderUpwardSuccessful(){
        //Arrange
        ObjectMapper mapper = new ObjectMapper();
        Buyer buyer = TestGeneratorUtil.getBuyerById(10);
        buyer.setFollowed(TestGeneratorUtil.OrderFollowedListByName("name_asc",buyer.getFollowed()));
        when(buyerRepository.getById(buyer.getUser_id())).thenReturn(buyer);
        //Act
        Buyer response = mapper.convertValue(buyerService
                .GetFollowedListByUser(buyer.getUser_id(),"name_asc"),Buyer.class);
        //Assert
        assertTrue(CollectionUtils.isEqualCollection(buyer.getFollowed(),response.getFollowed()));
    }

    @Test
    @DisplayName("T0004 - Obtener la lista de seguidos de un usuario ordenada descendentemente")
    public void GetFollowedListByUserOrderDownwardSuccessful(){
        //Arrange
        ObjectMapper mapper = new ObjectMapper();
        Buyer buyer = TestGeneratorUtil.getBuyerById(10);
        buyer.setFollowed(TestGeneratorUtil.OrderFollowedListByName("name_desc",buyer.getFollowed()));
        when(buyerRepository.getById(buyer.getUser_id())).thenReturn(buyer);
        //Act
        Buyer response = mapper.convertValue(buyerService
                .GetFollowedListByUser(buyer.getUser_id(),"name_desc"),Buyer.class);
        //Assert
        assertTrue(CollectionUtils.isEqualCollection(buyer.getFollowed(),response.getFollowed()));
    }

    @Test
    @DisplayName("T0004 - Obtener la lista de seguidos de un usuario con parametros de ordenamiento invalidos")
    public void GetFollowedListByUserOrderFailedParamsInvalid(){
        //Arrange
        Buyer buyer = TestGeneratorUtil.getBuyerById(10);
        when(buyerRepository.getById(buyer.getUser_id())).thenReturn(buyer);
        //Act && Assert
        assertThrows(BadRequestException.class,
                () -> buyerService.GetFollowedListByUser(buyer.getUser_id(), "any")
        );
    }

}
