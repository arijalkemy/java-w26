package com.meli.be_java_hisp_w26_g10.service;

import com.api.socialmeli.dto.SellersCountFollowersDto;
import com.api.socialmeli.entity.Buyer;
import com.api.socialmeli.entity.Seller;
import com.api.socialmeli.exception.NotFoundException;
import com.api.socialmeli.repository.IBuyerRepository;
import com.api.socialmeli.repository.ISellerRepository;
import com.api.socialmeli.repository.impl.BuyerRepositoryImpl;
import com.api.socialmeli.repository.impl.SellerRepositoryImpl;
import com.api.socialmeli.service.impl.SellerServiceImpl;
import com.meli.be_java_hisp_w26_g10.util.TestGeneratorUtil;
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

import com.api.socialmeli.dto.FollowedBySellerDto;
import com.api.socialmeli.dto.UserDto;
import com.api.socialmeli.exception.BadRequestException;
import com.api.socialmeli.utils.UserDtoShort;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
public class SellerServiceTest {
    @Mock
    BuyerRepositoryImpl buyerRepository;

    @Mock
    SellerRepositoryImpl sellerRepository;

    @InjectMocks
    SellerServiceImpl sellerService;

    @Test
    @DisplayName("Testeando un correcto escenario para contar seguidores")
    public void followerCounterOk(){

        List<Buyer> buyers = TestGeneratorUtil.createBuyerEnvironment();
        List<Seller> sellers = TestGeneratorUtil.createSellerEnvironment();

        when(buyerRepository.getAll()).thenReturn(buyers);
        when(sellerRepository.getAll()).thenReturn(sellers);

        SellersCountFollowersDto result = sellerService.getCountOfSellerFollowers(1);

        Assertions.assertEquals(2,result.getFollowers_count());
    }
    @Test
    @DisplayName("Testeando el conteo de seguidores sobre un Seller sin seguidores")
    public void followerCounterNotFound(){

        List<Seller> sellers = new ArrayList<>();
        when(sellerRepository.getAll()).thenReturn(sellers);

        Assertions.assertThrows(NotFoundException.class,() -> sellerService.getCountOfSellerFollowers(0));
    }

    @Test
    @DisplayName("Deberia de retornar la lista de seguidores ordenado de manera ascendente por nombre")
    public void correctAlphabeticOrderOfFollowwerASC(){

        // arrange
        String order = "name_asc";
        Seller seller = new Seller(1, "Meli");
        List<Buyer> buyers = TestGeneratorUtil.generateBuyerList();

        /* Creacion de followers y followers ordenados  */
        List<UserDto> followers = TestGeneratorUtil.generateUserDtoList();
        List<UserDto> sortedUsers = UserDtoShort.sortList(followers, order);

        /* Creacion de la salida del servicio */
        FollowedBySellerDto expectedFollowedBySellerDto = new FollowedBySellerDto(
                seller.getUser_id(),
                seller.getUser_name(),
                followers
        );

        // act
        when(sellerRepository.getById(anyInt())).thenReturn(seller);
        when(buyerRepository.getAll()).thenReturn(buyers);
        MockedStatic<UserDtoShort> userDtoShort = mockStatic(UserDtoShort.class);
        userDtoShort.when(() -> UserDtoShort.sortList(any(List.class), anyString())).thenReturn(sortedUsers);
        FollowedBySellerDto actualFollowedBySellerDto = sellerService.getFollowersOfSeller(1, order);

        // assert
        assertFalse(actualFollowedBySellerDto.getFollowers().isEmpty());
        assertEquals(sortedUsers, actualFollowedBySellerDto.getFollowers());

        userDtoShort.close();
    }

    @Test
    @DisplayName("Deberia de retornar la lista de seguidores ordenado de manera descendente por nombre")
    public void correctAlphabeticOrderOfFollowwerDESC(){
        // arrange
        String order = "name_desc";
        Seller seller = new Seller(1, "Meli");
        List<Buyer> buyers = TestGeneratorUtil.generateBuyerList();

        /* Creacion de followers y followers ordenados  */
        List<UserDto> followers = TestGeneratorUtil.generateUserDtoList();
        List<UserDto> sortedUsers = UserDtoShort.sortList(followers, order);

        /* Creacion de la salida del servicio */
        FollowedBySellerDto expectedFollowedBySellerDto = new FollowedBySellerDto(
                seller.getUser_id(),
                seller.getUser_name(),
                followers
        );

        // act
        when(sellerRepository.getById(anyInt())).thenReturn(seller);
        when(buyerRepository.getAll()).thenReturn(buyers);
        MockedStatic<UserDtoShort> userDtoShort = mockStatic(UserDtoShort.class);
        userDtoShort.when(() -> UserDtoShort.sortList(any(List.class), anyString())).thenReturn(sortedUsers);
        FollowedBySellerDto actualFollowedBySellerDto = sellerService.getFollowersOfSeller(1, order);

        // assert
        assertFalse(actualFollowedBySellerDto.getFollowers().isEmpty());
        assertEquals(sortedUsers, actualFollowedBySellerDto.getFollowers());

        userDtoShort.close();
    }

    @Test
    @DisplayName("Deberia de retornar una excepcion con mensaje ordenamiento no existente")
    public void incorrectAlphabeticOrderFollower(){
        // arrange
        String order = "name_desc";
        Seller seller = new Seller(1, "Meli");
        assertThrows(BadRequestException.class,
                () -> sellerService.getFollowersOfSeller(seller.getUser_id(), "any order")
        );
    }
}
