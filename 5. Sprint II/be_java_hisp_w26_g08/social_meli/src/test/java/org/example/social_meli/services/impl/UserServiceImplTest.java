package org.example.social_meli.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.social_meli.dto.UserDTO;

import org.example.social_meli.dto.UserCountResponseDTO;
import org.example.social_meli.dto.UserResponseDTO;
import org.example.social_meli.exceptions.BadRequestException;
import org.example.social_meli.exceptions.NotFoundException;
import org.example.social_meli.model.FollowerList;
import org.example.social_meli.model.User;
import org.example.social_meli.repository.IUserRepository;
import org.example.social_meli.services.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import java.util.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserServiceImplTest {

    @Mock
    private IUserRepository userRepository;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private IUserService iUserService;


    @InjectMocks
    private UserServiceImpl userService;

    User user = new User();
    User client;
    User seller;

    FollowerList clientFollowedList;
    FollowerList sellerFollowerList;
    FollowerList followerList = new FollowerList(user);

    UserResponseDTO userResponseDTO=new UserResponseDTO();

    Integer id;
    String orderBy;
    String userName;

    @BeforeEach()
    void setUp(){

        user.setUserId(1);
        user.setUserName("Test User");
        followerList.getFollower().add(new User());
        followerList.getFollower().add(new User());

        client = new User(1,"username1",false);

        clientFollowedList= new FollowerList(client,List.of(
                new User(2,"darth",true),
                new User(3,"Aseller",true),
                new User(4,"zorth",true),
                new User(12,"Darth Mouth",true)
        ));

        seller= new User(12,"Darth Mouth",true);

        sellerFollowerList=new FollowerList(seller, List.of(
                new User(1,"username1",false),
                new User(5,"Lisa",false),
                new User(3,"Mister X",false )
        ));

        when(userRepository.existsById(anyInt())).thenReturn(true);
        when(userRepository.existsSellerById(anyInt())).thenReturn(true);
        when(userRepository.existsClientById(anyInt())).thenReturn(true);

        when(userRepository.findClientById(1)).thenReturn(clientFollowedList);
        when(userRepository.findSellerById(12)).thenReturn(sellerFollowerList);

        when(objectMapper.convertValue(clientFollowedList.getFollower().get(0), UserDTO.class)).thenReturn(new UserDTO(2,"darth"));
        when(objectMapper.convertValue(clientFollowedList.getFollower().get(1), UserDTO.class)).thenReturn(new UserDTO(3,"Aseller"));
        when(objectMapper.convertValue(clientFollowedList.getFollower().get(2), UserDTO.class)).thenReturn(new UserDTO(4,"zorth"));
        when(objectMapper.convertValue(clientFollowedList.getFollower().get(3), UserDTO.class)).thenReturn(new UserDTO(12,"Darth Mouth"));

        when(objectMapper.convertValue(sellerFollowerList.getFollower().get(0), UserDTO.class)).thenReturn(new UserDTO(1,"username1"));
        when(objectMapper.convertValue(sellerFollowerList.getFollower().get(1), UserDTO.class)).thenReturn(new UserDTO(5,"Lisa"));
        when(objectMapper.convertValue(sellerFollowerList.getFollower().get(2), UserDTO.class)).thenReturn(new UserDTO(3,"Mister X"));

    }
    @Test
    @DisplayName("Deberia dejar de seguir a un usuario")
    void unfollowUser() {
        //Arrange
        Integer userId = 1;
        Integer userIdToUnfollow = 2;

        User client = new User(userId, "cliente", false);
        User seller = new User(userIdToUnfollow, "vendedor", true);

        when(userRepository.findSellerById(any())).thenReturn(new FollowerList(seller));
        when(userRepository.findClientById(any())).thenReturn(new FollowerList(client));

        //Act
        UserResponseDTO returned = userService.unfollowUser(userId, userIdToUnfollow);

        //Assertions
        verify(userRepository, times(1)).findClientById(anyInt());
        verify(userRepository, times(1)).getClientIndex(any());
        verify(userRepository, times(1)).findSellerById(anyInt());
        verify(userRepository, times(1)).getSellerIndex(any());
        verify(userRepository, times(1)).updateClients(anyInt(), any());
        verify(userRepository, times(1)).updateSellers(anyInt(), any());

        assertEquals(0, returned.getFollower().size());
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion sino existe el vendedor")
    void unfollowUserWhenSellerNotFound() {
        //Arrange
        Integer userId = 12531;
        Integer userIdToUnfollow = 2;
        User client = new User(userId, "cliente", false);

        when(userRepository.findSellerById(any())).thenReturn(null);
        when(userRepository.findClientById(any())).thenReturn(new FollowerList(client));
        //Act - Assert
        assertThrows(NotFoundException.class, () -> userService.unfollowUser(userId, userIdToUnfollow));
    }
    @Test
    /*Verificar que el usuario a seguir exista. (US-0001).*/
    @DisplayName("El usuario no es vendedor")
    void usernotVendedor() {
        //Arrange

        Integer userIdValid=1;
        Integer userIdToFollow=2;
        User client = new User(userIdValid, "cliente",false);
        User seller = new User(userIdToFollow, "vendedor",false);
        when(userRepository.existsById(userIdValid)).thenReturn(true);
        when(userRepository.existsById(userIdToFollow)).thenReturn(true);
        when(userRepository.findById(userIdValid)).thenReturn(client);
        when(userRepository.findById(userIdToFollow)).thenReturn(seller);
        //Act - Assert
        assertThrows(
                BadRequestException.class,
                () -> userService.followUser(userIdValid, userIdToFollow),
                "No puede seguirlo, el usuario no es vendedor."
        );

        verify(userRepository, times(1)).existsById(userIdValid);
        verify(userRepository, times(1)).existsById(userIdToFollow);
        verify(userRepository, times(1)).findById(userIdValid);
        verify(userRepository, times(1)).findById(userIdToFollow);
    }

    @Test
    @DisplayName("Verificar que el usuario a seguir exista. (US-0001).")
    void existUser() {
        //Arrange
        Integer userIdValid=1;
        Integer userIdNotValid=2;
        when(userRepository.existsById(userIdValid)).thenReturn(true);
        when(userRepository.existsById(userIdNotValid)).thenReturn(false);
        //Act - Assertions
        Exception exception=assertThrows(BadRequestException.class,()->{
            userService.followUser(userIdValid, userIdNotValid);
        });

        assertEquals("Uno o ambos usuarios no existen", exception.getMessage());
        verify(userRepository, times(1)).existsById(userIdValid);
        verify(userRepository, times(1)).existsById(userIdNotValid);
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion sino existe el cliente")
    void unfollowUserWhenClientNotFound() {
        //Arrange
        Integer userId = 1;
        Integer userIdToUnfollow = 22123;

        when(userRepository.findClientById(any())).thenReturn(null);
        //Act - Assert
        assertThrows(NotFoundException.class, () -> userService.unfollowUser(userId, userIdToUnfollow));
    }

    @DisplayName("Test Count Followers")
    @Test
    void countFollowersTest() {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setUserName("Test User");

        FollowerList followerList = new FollowerList(user);
        followerList.getFollower().add(new User());
        followerList.getFollower().add(new User());

        when(userRepository.findSellerById(1)).thenReturn(followerList);
        //Act
        UserCountResponseDTO result = userService.countFollowers(1);
        //Assertions
        assertEquals(1, result.getUserId());
        assertEquals("Test User", result.getUserName());
        assertEquals(2, result.getFollowersCount());
    }

    @DisplayName("Test Empty Followers List")
    @Test
    void emptyFollowersListTest() {
        //Arrange
        User user = new User();
        user.setUserId(1);
        user.setUserName("Test User");

        FollowerList followerList = new FollowerList(user);

        when(userRepository.findSellerById(1)).thenReturn(followerList);
        //Act
        UserCountResponseDTO result = userService.countFollowers(1);
        //Assertions
        assertEquals(1, result.getUserId());
        assertEquals("Test User", result.getUserName());
        assertTrue(result.getFollowersCount() == 0);
    }

    @Test
    @DisplayName("Obtener la lista ordenada ascendentemente de seguidores de un usuario")
    void getAscOrderedFollowersById() {
        //Arrange
        id=2;
        orderBy="name_asc";
        userName="user2";
        userResponseDTO.setUserId(id);
        userResponseDTO.setUserName(userName);
        userResponseDTO.setFollower(List.of());
        FollowerList followerList = new FollowerList(new User(2, "user2", true),List.of());

        when(iUserService.getFollowers(anyInt())).thenReturn(userResponseDTO);
        when(userRepository.findSellerById(anyInt())).thenReturn(followerList);
        when(userRepository.existsSellerById(anyInt())).thenReturn(true);
        //Act
        UserResponseDTO returned = userService.getOrderedFollowersById(id, orderBy);
        //Asser
        assertEquals(userResponseDTO, returned);
    }

    @Test
    @DisplayName("Obtener la lista ordenada descendentemente de seguidores de un usuario")
    void getDescOrderedFollowersById() {
        //Arrange
        id=2;
        orderBy="name_desc";
        userName="user2";
        userResponseDTO.setUserId(id);
        userResponseDTO.setUserName(userName);
        userResponseDTO.setFollower(List.of());
        FollowerList followerList = new FollowerList(new User(2, "user2", true), List.of());

        when(iUserService.getFollowers(anyInt())).thenReturn(userResponseDTO);
        when(userRepository.findSellerById(anyInt())).thenReturn(followerList);
        when(userRepository.existsSellerById(anyInt())).thenReturn(true);
        //Act
        UserResponseDTO returned = userService.getOrderedFollowersById(id, orderBy);
        //Assert
        assertEquals(userResponseDTO, returned);
    }

    @Test
    @DisplayName("Obtener la lista ordenada ascendentemente de seguidos de un usuario")
    void getAscOrderedFollowedById() {
        //Arrange
        id=1;
        orderBy="name_asc";
        userName="user1";
        userResponseDTO.setUserId(id);
        userResponseDTO.setUserName(userName);
        userResponseDTO.setFollower(List.of());
        FollowerList followerList = new FollowerList(new User(1, "user1", false),List.of());

        when(iUserService.getFollowedById(anyInt())).thenReturn(userResponseDTO);
        when(userRepository.findClientById(anyInt())).thenReturn(followerList);
        when(userRepository.existsClientById(anyInt())).thenReturn(true);
        //Act
        UserResponseDTO returned = userService.getOrderedFollowedById(id, orderBy);
        //Assert
        assertEquals(userResponseDTO, returned);
    }

    @Test
    @DisplayName("Obtener la lista ordenada descendentemente de seguidos de un usuario")
    void getDescOrderedFollowedById() {
        //Arrange
        id=1;
        orderBy="name_desc";
        userName="user1";
        userResponseDTO.setUserId(id);
        userResponseDTO.setUserName(userName);
        userResponseDTO.setFollower(List.of());
        FollowerList followerList = new FollowerList(new User(1, "user1", false),List.of());

        when(iUserService.getFollowedById(anyInt())).thenReturn(userResponseDTO);
        when(userRepository.findClientById(anyInt())).thenReturn(followerList);
        when(userRepository.existsClientById(anyInt())).thenReturn(true);
        //Act
        UserResponseDTO returned = userService.getOrderedFollowedById(id, orderBy);
        //Assert
        assertEquals(userResponseDTO, returned);
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion si el orderBy no es valido al consultar seguidores")
    void getExceptionOrderedFollowersById() {
        //Arrange
        id=1;
        orderBy="qwerty";
        userName="user1";
        FollowerList followerList = new FollowerList(new User(1, "user1", false),List.of());

        when(userRepository.findSellerById(anyInt())).thenReturn(followerList);
        when(userRepository.existsSellerById(anyInt())).thenReturn(true);
        //Act - Assert
        assertThrows(BadRequestException.class, () -> userService.getOrderedFollowersById(id, orderBy));
    }

    @Test
    @DisplayName("Deberia lanzar una excepcion si el orderBy no es valido al consultar seguidos por un usuario")
    void getExceptionOrderedFollowedById() {
        //Arrange
        id=1;
        orderBy="qwerty";
        userName="user1";
        FollowerList followerList = new FollowerList(new User(1, "user1", false),List.of());

        when(userRepository.findClientById(anyInt())).thenReturn(followerList);
        when(userRepository.existsClientById(anyInt())).thenReturn(true);
        //Act - Assert
        assertThrows(BadRequestException.class, () -> userService.getOrderedFollowedById(id, orderBy));
    }
    @Test
    @DisplayName("Trae la lista de seguidos ordenados de forma ascendente")
    void getOrderedFollowedListAscTest(){
        //Arrange
        String order = "name_asc";
        UserResponseDTO expectedResult = UserResponseDTO.builder()
                .userId(1)
                .userName("username1")
                .follower(List.of(
                        new UserDTO(3,"Aseller"),
                        new UserDTO(12,"Darth Mouth"),
                        new UserDTO(2,"darth"),
                        new UserDTO(4,"zorth")
                )).build();
        //Act
        UserResponseDTO result = userService.getOrderedFollowedById(1,order);
        //Assert
        assertThat(result,samePropertyValuesAs(expectedResult));

    }

    @Test
    @DisplayName("Trae la lista de seguidos ordenados de forma descendente")
    void getOrderedFollowedListDescTest(){
        //Arrange
        UserResponseDTO expectedResult = UserResponseDTO.builder()
                .userId(1)
                .userName("username1")
                .follower(List.of(
                        new UserDTO(4,"zorth"),
                        new UserDTO(2,"darth"),
                        new UserDTO(12,"Darth Mouth"),
                        new UserDTO(3,"Aseller")
                )).build();
        String order = "name_desc";
        //Act
        UserResponseDTO result = userService.getOrderedFollowedById(1,order);
        //Assert
        assertThat(result,samePropertyValuesAs(expectedResult));
    }

    @Test
    @DisplayName("Trae la lista de seguidores ordenados de forma ascendente")
    void getOrderedFollowerListAscTest(){
        //Arrange
        String order = "name_asc";
        UserResponseDTO expectedResult = UserResponseDTO.builder()
                .userId(12)
                .userName("Darth Mouth")
                .follower(List.of(
                        new UserDTO(5,"Lisa"),
                        new UserDTO(3,"Mister X" ),
                        new UserDTO(1,"username1")
                )).build();
        //Act
        UserResponseDTO result = userService.getOrderedFollowersById(12,order);
        //Assert
        assertThat(result,samePropertyValuesAs(expectedResult));
    }

    @Test
    @DisplayName("Trae la lista de seguidores ordenados de forma descendente")
    void getOrderedFollowerListDescTest(){
        //Arrange
        String order = "name_desc";
        UserResponseDTO expectedResult = UserResponseDTO.builder()
                .userId(12)
                .userName("Darth Mouth")
                .follower(List.of(
                        new UserDTO(1,"username1"),
                        new UserDTO(3,"Mister X" ),
                        new UserDTO(5,"Lisa")
                )).build();
        //Act
        UserResponseDTO result = userService.getOrderedFollowersById(12,order);
        //Assert
        assertThat(result,samePropertyValuesAs(expectedResult));
    }


}