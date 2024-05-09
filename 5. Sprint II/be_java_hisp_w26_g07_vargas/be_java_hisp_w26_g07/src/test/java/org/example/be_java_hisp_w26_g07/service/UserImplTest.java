package org.example.be_java_hisp_w26_g07.service;


import org.example.be_java_hisp_w26_g07.dto.SuccessResponseDto;
import org.example.be_java_hisp_w26_g07.dto.users.CountFollowersResponseDto;
import org.example.be_java_hisp_w26_g07.dto.users.FollowedResponseDto;
import org.example.be_java_hisp_w26_g07.dto.users.FollowersResponseDto;
import org.example.be_java_hisp_w26_g07.dto.users.UserInfoFollowsDto;
import org.example.be_java_hisp_w26_g07.entity.User;
import org.example.be_java_hisp_w26_g07.exception.BadRequestException;
import org.example.be_java_hisp_w26_g07.exception.NotAcceptable;
import org.example.be_java_hisp_w26_g07.exception.NotFoundException;
import org.example.be_java_hisp_w26_g07.repository.UserRepositoryImpl;
import org.example.be_java_hisp_w26_g07.utils.GeneratorDataTest;
import org.example.be_java_hisp_w26_g07.utils.UserMessageError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserImplTest {
    @Mock
    private UserRepositoryImpl userRepository;

    @InjectMocks
    private UserImpl userImpl;

    @Test
    @DisplayName("T-0001: userId y sellerId son iguales")
    void userFollowSellerSameIds() {
        // Given - Arrange
        // When - Act
        // Then - Assert
        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class,
                () -> userImpl.userFollowSeller(1, 1));
        Assertions.assertEquals(UserMessageError.ID_CLIENT_SELLER_IS_EQUALS.getMessage(), thrown.getMessage());
    }

    @Test
    @DisplayName("T-0001: El usuario vendedor no existe")
    void userFollowSellerSellerDoesNotExist() {
        // Given - Arrange
        // Caso cuando el usuario (vendedor) con id `userToFollow` no existe
        Mockito.when(userRepository.findById(111))
                .thenReturn(null);
        // When - Act
        // Then - Assert
        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class,
                () -> userImpl.userFollowSeller(1, 111));
        Assertions.assertEquals(UserMessageError.SELLER_NOT_FOUND.getMessage(111), thrown.getMessage());
    }

    @Test
    @DisplayName("T-0001: El usuario seguidor no existe")
    void userFollowSellerFollowerDoesNotExist() {
        // Given - Arrange
        // Caso en el que el usuario con id `id` no existe
        Mockito.when(userRepository.findById(222))
                .thenReturn(null);
        Mockito.when(userRepository.findById(1))
                .thenReturn(
                        GeneratorDataTest.getUserCustomId(1, false)
                );
        // When - Act
        // Then - Assert
        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class,
                () -> userImpl.userFollowSeller(222, 1));
        Assertions.assertEquals(UserMessageError.USER_NOT_FOUND.getMessage(222), thrown.getMessage());
    }

    @Test
    @DisplayName("T-0001: El usuario vendedor no es vendedor")
    void userFollowSellerIsNotSeller() {
        // Given - Arrange
        // Caso en el que el usuario con id `userToFollow` no es un vendedor
        Mockito.when(userRepository.findById(9))
                .thenReturn(
                        GeneratorDataTest.getUserCustomId(9, false)
                );
        Mockito.when(userRepository.findById(1))
                .thenReturn(
                        GeneratorDataTest.getUserCustomId(1, false)
                );
        // When - Act
        // Then - Assert
        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class,
                () -> userImpl.userFollowSeller(1, 9));
        Assertions.assertEquals(UserMessageError.CLIENT_IS_NOT_SELLER.getMessage(), thrown.getMessage());
    }

    @Test
    @DisplayName("T-0001: El usuario ya sigue al vendedor")
    void userFollowSellerAlreadyFollows() {
        // Given - Arrange
        // Caso en el que el usuario wid id `id` ya sigue al usuario con id `userToFollow`.
        Mockito.when(userRepository.userFollowSeller(5, 2))
                .thenReturn(true);
        Mockito.when(userRepository.findById(5))
                .thenReturn(
                        GeneratorDataTest.getUserCustomId(5, false)
                );
        Mockito.when(userRepository.findById(2))
                .thenReturn(
                        GeneratorDataTest.getUserCustomId(2, true)
                );
        // When - Act
        Boolean followAdded = userImpl.userFollowSeller(5, 2);
        // Then - Assert
        Assertions.assertFalse(followAdded);
    }

    @Test
    @DisplayName("T-0001: Caso exitoso añadir seguidor al vendedor")
    void userFollowSellerOk() {
        // Given - Arrange
        Mockito.when(userRepository.findById(9))
                .thenReturn(
                        GeneratorDataTest.getUserCustomId(9, false)
                );
        Mockito.when(userRepository.findById(1))
                .thenReturn(
                        GeneratorDataTest.getUserCustomId(1, true)
                );
        // When - Act
        boolean followAdded = userImpl.userFollowSeller(9, 1);
        // Then - Assert
        Assertions.assertTrue(followAdded);
    }

    @Test
    @DisplayName("T-0002: Unfollow user: successful")
    public void unfollowUserSuccessful() {
        // Arrange
        Integer clientId = 1;
        Integer sellerId = 2;
        List<User> users = GeneratorDataTest.usersById(clientId, sellerId);
        SuccessResponseDto expected = new SuccessResponseDto("Se ha dejado de seguir al usuario");

        // Act
        when(userRepository.unfollow(users.get(0), users.get(1))).thenReturn(true);
        initializeMockUserRepository(users);
        SuccessResponseDto actual = userImpl.unfollow(clientId, sellerId);

        // Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("T-0002: Unfollow user: failed (client not follow seller)")
    public void unfollowUserFailed() {
        // Arrange
        Integer clientId = 1;
        Integer sellerId = 5;
        List<User> users = GeneratorDataTest.usersById(clientId, sellerId);

        // Act
        when(userRepository.unfollow(users.get(0), users.get(1))).thenReturn(false);
        initializeMockUserRepository(users);
        Assertions.assertThrows(BadRequestException.class, () -> userImpl.unfollow(clientId, sellerId));
    }

    @Test
    @DisplayName("T-0002: Unfollow user: failed (user not found)")
    public void unfollowUserNotFound() {
        // Arrange
        Integer clientId = 100;
        Integer sellerId = 5;
        List<User> users = GeneratorDataTest.usersById(sellerId);

        // Act
        when(userRepository.findById(clientId)).thenReturn(null);
        initializeMockUserRepository(users);
        Assertions.assertThrows(BadRequestException.class, () -> userImpl.unfollow(clientId, sellerId));
    }

    @Test
    @DisplayName("T-0002: Unfollow user: failed (seller not found)")
    public void unfollowSellerNotFound() {
        // Arrange
        Integer clientId = 1;
        Integer sellerId = 500;
        List<User> users = GeneratorDataTest.usersById(clientId);

        // Act
        when(userRepository.findById(sellerId)).thenReturn(null);
        initializeMockUserRepository(users);
        Assertions.assertThrows(BadRequestException.class, () -> userImpl.unfollow(clientId, sellerId));
    }

    @Test
    @DisplayName("T-0003: Lista de seguidores para un posible id no asociado al sistema")
    void followersListBadPathId() {
        Integer id = Integer.MAX_VALUE;
        User users = null;
        String order = "name_desc";

        Mockito.when(userRepository.findById(id)).thenReturn(users);

        Assertions.assertThrows(NotFoundException.class, () -> {userImpl.findFollowersByOrder(id, order);});
    }

    @Test
    @DisplayName("T-0003: Lista de seguidores para un posible id no asociado a un vendedor")
    void followersListBadPathUser() {
        User users = GeneratorDataTest.findUsers().get(4);
        String order = null;

        Mockito.when(userRepository.findById(users.getId())).thenReturn(users);

        Assertions.assertThrows(BadRequestException.class,
                () -> {userImpl.findFollowersByOrder(users.getId(), order);});
    }

    @Test
    @DisplayName("T-0003: Validación de la existencia de la opción ascendente para el vendedor con id:1")
    void followersListOrderValidExistenceAsc() {
        String order = "name_asc";
        User user = GeneratorDataTest.findUsers().get(0);
        List<Integer> followersIdList = user.getFollowerIds();
        List<User> userFollows = Arrays.asList(
                GeneratorDataTest.findUsers().get(1),
                GeneratorDataTest.findUsers().get(2),
                GeneratorDataTest.findUsers().get(3)
        );

        Mockito.when(userRepository.findById(user.getId())).thenReturn(user);
        Mockito.when(userRepository.findById(userFollows.get(0).getId())).thenReturn(userFollows.get(0));
        Mockito.when(userRepository.findById(userFollows.get(1).getId())).thenReturn(userFollows.get(1));
        Mockito.when(userRepository.findById(userFollows.get(2).getId())).thenReturn(userFollows.get(2));

        FollowersResponseDto followedResponseDto = userImpl.findFollowersByOrder(user.getId(), order);

        Assertions.assertNotNull(followedResponseDto);
        Assertions.assertEquals(user.getName(), followedResponseDto.getName());
        Assertions.assertEquals(user.getId(), followedResponseDto.getId());
        Assertions.assertEquals(userFollows.size(), followedResponseDto.getFollowers().size());
    }

    @Test
    @DisplayName("T-0003: Validación de la existencia de la opción descendiente para el vendedor con id:1")
    void followersListOrderValidExistenceDes() {
        String order = "name_desc";
        User user = GeneratorDataTest.findUsers().get(0);
        List<Integer> followersIdList = user.getFollowerIds();
        List<User> userFollows = Arrays.asList(
                GeneratorDataTest.findUsers().get(1),
                GeneratorDataTest.findUsers().get(2),
                GeneratorDataTest.findUsers().get(3)
        );

        Mockito.when(userRepository.findById(user.getId())).thenReturn(user);
        Mockito.when(userRepository.findById(userFollows.get(0).getId())).thenReturn(userFollows.get(0));
        Mockito.when(userRepository.findById(userFollows.get(1).getId())).thenReturn(userFollows.get(1));
        Mockito.when(userRepository.findById(userFollows.get(2).getId())).thenReturn(userFollows.get(2));

        FollowersResponseDto followedResponseDto = userImpl.findFollowersByOrder(user.getId(), order);

        Assertions.assertNotNull(followedResponseDto);
        Assertions.assertEquals(user.getName(), followedResponseDto.getName());
        Assertions.assertEquals(user.getId(), followedResponseDto.getId());
        Assertions.assertEquals(userFollows.size(), followedResponseDto.getFollowers().size());
    }

    @Test
    @DisplayName("T-0003: Validación de la existencia de la " +
            "opción descendiente para el vendedor con id:1 cuando order es nulo")
    void followersListOrdernullValidExistenceDes() {
        String order = null;
        User user = GeneratorDataTest.findUsers().get(0);
        List<Integer> followersIdList = user.getFollowerIds();
        List<User> userFollows = Arrays.asList(
                GeneratorDataTest.findUsers().get(1),
                GeneratorDataTest.findUsers().get(2),
                GeneratorDataTest.findUsers().get(3)
        );

        Mockito.when(userRepository.findById(user.getId())).thenReturn(user);
        Mockito.when(userRepository.findById(userFollows.get(0).getId())).thenReturn(userFollows.get(0));
        Mockito.when(userRepository.findById(userFollows.get(1).getId())).thenReturn(userFollows.get(1));
        Mockito.when(userRepository.findById(userFollows.get(2).getId())).thenReturn(userFollows.get(2));

        FollowersResponseDto followedResponseDto = userImpl.findFollowersByOrder(user.getId(), order);

        Assertions.assertNotNull(followedResponseDto);
        Assertions.assertEquals(user.getName(), followedResponseDto.getName());
        Assertions.assertEquals(user.getId(), followedResponseDto.getId());
        Assertions.assertEquals(userFollows.size(), followedResponseDto.getFollowers().size());
    }

    @Test
    @DisplayName("T-0003: Validación de un vendedor sin seguidores 'Caso de borde' ")
    void notFollowersListOrderValidExistence() {
        String order = "name_desc";
        List<Integer> followersIdList = new ArrayList<>();
        User user = new User(Integer.MAX_VALUE, "Criss", null, followersIdList, null, true);

        Mockito.when(userRepository.findById(user.getId())).thenReturn(user);

        FollowersResponseDto followedResponseDto = userImpl.findFollowersByOrder(user.getId(), order);

        Assertions.assertNotNull(followedResponseDto);
        Assertions.assertEquals(user.getName(), followedResponseDto.getName());
        Assertions.assertEquals(user.getId(), followedResponseDto.getId());
        Assertions.assertEquals(0, followedResponseDto.getFollowers().size());
    }


    @Test
    @DisplayName("T-0004: Verificar el correcto ordenamiento ascendente por nombre")
    void findFollowedUsersAsc() {
        //Arrange
        Integer userId = 3;
        User user3 = GeneratorDataTest.findUsers().get(2);
        User user1 = GeneratorDataTest.findUsers().get(0);
        User user2 = GeneratorDataTest.findUsers().get(1);
        User user5 = GeneratorDataTest.findUsers().get(4);
        User user6 = GeneratorDataTest.findUsers().get(5);
        User user9 = GeneratorDataTest.findUsers().get(8);

        when(userRepository.findById(userId)).thenReturn(user3);

        when(userRepository.findById(1)).thenReturn(user1);
        when(userRepository.findById(2)).thenReturn(user2);
        when(userRepository.findById(5)).thenReturn(user5);
        when(userRepository.findById(6)).thenReturn(user6);
        when(userRepository.findById(9)).thenReturn(user9);
        FollowedResponseDto nameAsc = userImpl.findFollowedUsers(userId, "name_asc");
        List<UserInfoFollowsDto> ascFollowed = nameAsc.getFollowed();

        Assertions.assertEquals(5, ascFollowed.size());
        Assertions.assertEquals("Bryann", ascFollowed.get(0).getName());
        Assertions.assertEquals("Carlos", ascFollowed.get(1).getName());
        Assertions.assertEquals("Martin", ascFollowed.get(2).getName());
        Assertions.assertEquals("Monica", ascFollowed.get(3).getName());
        Assertions.assertEquals("Santiago", ascFollowed.get(4).getName());

    }

    @Test
    @DisplayName("T-0004: Verificar el correcto ordenamiento descendente por nombre")
    void findFollowedUsersDesc() {
        //Arrange
        Integer userId = 3;
        User user3 = GeneratorDataTest.findUsers().get(2);
        User user1 = GeneratorDataTest.findUsers().get(0);
        User user2 = GeneratorDataTest.findUsers().get(1);
        User user5 = GeneratorDataTest.findUsers().get(4);
        User user6 = GeneratorDataTest.findUsers().get(5);
        User user9 = GeneratorDataTest.findUsers().get(8);

        when(userRepository.findById(userId)).thenReturn(user3);

        when(userRepository.findById(1)).thenReturn(user1);
        when(userRepository.findById(2)).thenReturn(user2);
        when(userRepository.findById(5)).thenReturn(user5);
        when(userRepository.findById(6)).thenReturn(user6);
        when(userRepository.findById(9)).thenReturn(user9);
        FollowedResponseDto nameAsc = userImpl.findFollowedUsers(userId, "name_desc");
        List<UserInfoFollowsDto> ascFollowed = nameAsc.getFollowed();

        Assertions.assertEquals(5, ascFollowed.size());
        Assertions.assertEquals("Santiago", ascFollowed.get(0).getName());
        Assertions.assertEquals("Monica", ascFollowed.get(1).getName());
        Assertions.assertEquals("Martin", ascFollowed.get(2).getName());
        Assertions.assertEquals("Carlos", ascFollowed.get(3).getName());
        Assertions.assertEquals("Bryann", ascFollowed.get(4).getName());

    }

    @Test
    @DisplayName("T-0004: Envia la lista de los seguidos por un vendedor")
    void findFollowedUsers() {
        //Arrange
        Integer userId = 3;
        User user3 = GeneratorDataTest.findUsers().get(2);
        User user1 = GeneratorDataTest.findUsers().get(0);
        User user2 = GeneratorDataTest.findUsers().get(1);
        User user5 = GeneratorDataTest.findUsers().get(4);
        User user6 = GeneratorDataTest.findUsers().get(5);
        User user9 = GeneratorDataTest.findUsers().get(8);

        when(userRepository.findById(userId)).thenReturn(user3);

        when(userRepository.findById(1)).thenReturn(user1);
        when(userRepository.findById(2)).thenReturn(user2);
        when(userRepository.findById(5)).thenReturn(user5);
        when(userRepository.findById(6)).thenReturn(user6);
        when(userRepository.findById(9)).thenReturn(user9);
        FollowedResponseDto nameAsc = userImpl.findFollowedUsers(userId, null);
        List<UserInfoFollowsDto> ascFollowed = nameAsc.getFollowed();

        Assertions.assertEquals(5, ascFollowed.size());
        Assertions.assertEquals("Monica", ascFollowed.get(0).getName());
        Assertions.assertEquals("Santiago", ascFollowed.get(1).getName());
        Assertions.assertEquals("Bryann", ascFollowed.get(2).getName());
        Assertions.assertEquals("Carlos", ascFollowed.get(3).getName());
        Assertions.assertEquals("Martin", ascFollowed.get(4).getName());
    }

    @Test
    @DisplayName("T-0004: Envía la lista de los seguidos por un vendedor sin orden")
    void findFollowedUsersByAnyOrder() {
        //Arrange
        Integer userId = 3;
        User user3 = GeneratorDataTest.findUsers().get(2);
        User user1 = GeneratorDataTest.findUsers().get(0);
        User user2 = GeneratorDataTest.findUsers().get(1);
        User user5 = GeneratorDataTest.findUsers().get(4);
        User user6 = GeneratorDataTest.findUsers().get(5);
        User user9 = GeneratorDataTest.findUsers().get(8);

        when(userRepository.findById(userId)).thenReturn(user3);

        when(userRepository.findById(1)).thenReturn(user1);
        when(userRepository.findById(2)).thenReturn(user2);
        when(userRepository.findById(5)).thenReturn(user5);
        when(userRepository.findById(6)).thenReturn(user6);
        when(userRepository.findById(9)).thenReturn(user9);
        FollowedResponseDto nameAsc = userImpl.findFollowedUsers(userId, "invalid");
        List<UserInfoFollowsDto> ascFollowed = nameAsc.getFollowed();

        Assertions.assertEquals(5, ascFollowed.size());
        Assertions.assertEquals("Monica", ascFollowed.get(0).getName());
        Assertions.assertEquals("Santiago", ascFollowed.get(1).getName());
        Assertions.assertEquals("Bryann", ascFollowed.get(2).getName());
        Assertions.assertEquals("Carlos", ascFollowed.get(3).getName());
        Assertions.assertEquals("Martin", ascFollowed.get(4).getName());
    }

    @Test
    @DisplayName("T-0007: Verifica si el usuario no es vendedor retorna la excepción NotAcceptable")
    void getNumberOfSellersFollowedNotAcceptableTest() {
        //Arrange
        //Creación de usuario que no es vendedor, propiedad isseller false
        Integer userId = 1;
        User userMock = new User(userId, "Juan", List.of(), List.of(), List.of(), false);

        //Act and Assert
        when(userRepository.findById(userId)).thenReturn(userMock);
        assertThrows(NotAcceptable.class, () -> userImpl.getNumberOfSellersFollowed(userId));
    }

    @Test
    @DisplayName("T-0007: Verificar que la cantidad de seguidores de un determinado usuario sea correcta")
    void getNumberOfSellersFollowedTest() {
        //Arrange
        //Creación de usuario y id´s de seguidores que pertenecen al vendedor
        Integer userId = 1;
        User userMock = GeneratorDataTest.findUsers().get(0);

        CountFollowersResponseDto expected = new CountFollowersResponseDto(userId, userMock.getName(),
                userMock.getFollowerIds().size());

        //Act
        when(userRepository.findById(userId)).thenReturn(userMock);

        CountFollowersResponseDto output = userImpl.getNumberOfSellersFollowed(userId);

        //Assert
        assertEquals(expected, output);
    }

    @Test
    @DisplayName("T-0007: Verifica si el usuario no existe retorna la excepción NotFoundException")
    void getNumberOfSellersFollowedNotFoundExceptionTest() {
        //Arrange
        Integer userId = 1;

        //Act and Assert
        when(userRepository.findById(userId)).thenReturn(null);
        assertThrows(NotFoundException.class, () -> userImpl.getNumberOfSellersFollowed(userId));
    }

    @Test
     void findFollowedUsersWithUnexistinguserShouldThrowException(){
        when(userRepository.findById(1)).thenReturn(null);
        Assertions.assertThrows(NotFoundException.class, () -> userImpl.findFollowedUsers(1, null));

    }

    @Test
    @DisplayName("Test Opcional: Comprobación de seguimiento valido del usuario 2 al vendedor 4")
    public void userFollowSellerHappyPathTest() {
        // Arrange
        Integer userId = 2;
        Integer sellerId = 4;
        User follower = GeneratorDataTest.findUsers().get(1);
        User seller = GeneratorDataTest.findUsers().get(3);
        when(userRepository.findById(userId)).thenReturn(follower);
        when(userRepository.findById(sellerId)).thenReturn(seller);
        when(userRepository.userFollowSeller(userId, sellerId)).thenReturn(false);
        // Act
        Boolean result = userImpl.userFollowSeller(userId, sellerId);
        // Assert
        assertTrue(result);
    }

    @Test
    @DisplayName("Test Opcional: Comprobación de seguimiento no valido cuando el usuario es igual al vendedor")
    public void userFollowSellerWhenTheUserIsEqualsToSeller() {
        // Arrange
        Integer userId = 2;
        Integer sellerId = 2;
        User follower = GeneratorDataTest.findUsers().get(1);
        User seller = GeneratorDataTest.findUsers().get(1);
        when(userRepository.findById(userId)).thenReturn(follower);
        when(userRepository.findById(sellerId)).thenReturn(seller);
        // Act - Assert
        assertThrows(BadRequestException.class, () -> userImpl.userFollowSeller(userId, sellerId));
    }

    @Test
    @DisplayName("Test Opcional: Comprobación de seguimiento no valido cuando el usuario no existe")
    public void userFollowSellerWhenTheUserNotExist() {
        // Arrange
        Integer userId = 99;
        Integer sellerId = 2;
        User follower = null;
        User seller = GeneratorDataTest.findUsers().get(1);
        when(userRepository.findById(userId)).thenReturn(follower);
        when(userRepository.findById(sellerId)).thenReturn(seller);
        // Act - Assert
        assertThrows(BadRequestException.class, () -> userImpl.userFollowSeller(userId, sellerId));
    }

    @Test
    @DisplayName("Test Opcional: Comprobación de seguimiento no valido cuando el vendedor no existe")
    public void userFollowSellerWhenTheSellerNotExist() {
        // Arrange
        Integer userId = 2;
        Integer sellerId = 99;
        User follower = null;
        User seller = GeneratorDataTest.findUsers().get(1);
        when(userRepository.findById(userId)).thenReturn(follower);
        when(userRepository.findById(sellerId)).thenReturn(seller);
        // Act - Assert
        assertThrows(BadRequestException.class, () -> userImpl.userFollowSeller(userId, sellerId));
    }

    @Test
    @DisplayName("Test Opcional: Comprobación de seguimiento no valido cuando el id del " +
            "vendedor no correspondde a un vendedor")
    public void userFollowSellerWhenTheIdSellerIsNotSeller() {
        // Arrange
        Integer userId = 2;
        Integer sellerId = 99;
        User follower = null;
        User seller = GeneratorDataTest.findUsers().get(1);
        when(userRepository.findById(userId)).thenReturn(follower);
        when(userRepository.findById(sellerId)).thenReturn(seller);
        // Act - Assert
        assertThrows(BadRequestException.class, () -> userImpl.userFollowSeller(userId, sellerId));
    }

    @Test
    @DisplayName("Test Opcional: Comprobación de seguimiento cuando el usuario ya seguía al vendedor")
    public void userFollowSellerWhenTheUserAlreadyFollowToSeller() {
        // Arrange
        Integer userId = 2;
        Integer sellerId = 4;
        User follower = GeneratorDataTest.findUsers().get(1);
        User seller = GeneratorDataTest.findUsers().get(2);
        when(userRepository.findById(userId)).thenReturn(follower);
        when(userRepository.findById(sellerId)).thenReturn(seller);
        when(userRepository.userFollowSeller(userId, sellerId)).thenReturn(true);
        // Act
        Boolean result = userImpl.userFollowSeller(userId, sellerId);
        // Assert
        assertFalse(result);
    }

    public void initializeMockUserRepository(List<User> users) {
        for (User user : users) {
            when(userRepository.findById(user.getId())).thenReturn(user);
        }
    }
}
