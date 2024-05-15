package com.javabootcamp.socialmeli.unit.service;

import com.javabootcamp.socialmeli.dto.response.ResponseDto;
import com.javabootcamp.socialmeli.dto.response.UserDto;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.exception.EntityNotFoundException;
import com.javabootcamp.socialmeli.exception.IllegalActionException;
import com.javabootcamp.socialmeli.exception.ResourceAlreadyExistsException;
import com.javabootcamp.socialmeli.model.Follow;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.FollowRepository;
import com.javabootcamp.socialmeli.service.FollowService;
import com.javabootcamp.socialmeli.service.FollowServiceImpl;
import com.javabootcamp.socialmeli.utils.DtoMapper;
import com.javabootcamp.socialmeli.utils.UserBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class FollowServiceTest {
    @Mock
    private FollowRepository followRepository;

    @InjectMocks
    private FollowServiceImpl followService;

    @Test
    @DisplayName("T-0011 -> Si el seguimiento existe debera arrojar ResourceAlreadyExistsException")
    void whenAddAlreadyExistingFollow() {
        //arrange
        User follower = UserBuilder.userClient(1);
        User followed = UserBuilder.userSeller(2);
        Mockito.when(followRepository.findByFollowerIdAndFollowedId(1, 2))
                .thenReturn(Optional.of(new Follow()));

        //act assert
        Assertions.assertThrows(
                ResourceAlreadyExistsException.class,
                () -> followService.addFollow(follower, followed)
        );

    }

    @Test
    @DisplayName("T-0012 -> Search followers by id devuelve una lista mapeada de dtos")
    void whenSearchFollowersByUser() {
        //arrange
        int userId = 4;
        List<User> mockedUsers = UserBuilder.userClientList();
        List<UserDto> expectedUsers = UserBuilder.userClientDtoList();
        Mockito.when(followRepository.findFollowersById(userId)).thenReturn(mockedUsers);

        //act
        List<UserDto> actualUsers = followService.searchFollowersByUser(userId);

        //assert
        Assertions.assertIterableEquals(expectedUsers, actualUsers);
    }

    @Test
    @DisplayName("T-0013 -> Search followers by id devuelve una lista identica a la que devuelve el repo")
    void whenSearchFollowedByUser() {
        //arrange
        int userId = 4;
        List<User> mockedUsers = UserBuilder.userClientList();
        Mockito.when(followRepository.findFollowedsById(userId)).thenReturn(mockedUsers);

        //act
        List<User> actualUsers = followService.searchFollowedByUser(userId);

        //assert
        Mockito.verify(followRepository, Mockito.atLeast(1)).findFollowedsById(userId);
        Assertions.assertIterableEquals(mockedUsers, actualUsers);
    }

    @Test
    @DisplayName("T-0014 -> Delete follow devuelve un mensaje exitoso")
    void whenDeleteFollow() {
        //arrange
        int followerId = 1;
        int followedId = 2;
        Follow mockedFollow = new Follow();

        ResponseDto expectedResponse = new ResponseDto("User: " + followerId
                + " successfully stopped following: " + followedId);
        Mockito.when(followRepository.findByFollowerIdAndFollowedId(followerId, followedId))
                .thenReturn(Optional.of(mockedFollow));

        //act
        ResponseDto actualResponse = followService.deleteFollow(followerId, followedId);

        //assert
        Mockito.verify(followRepository, Mockito.atLeast(1))
                .findByFollowerIdAndFollowedId(followerId, followedId);
        Mockito.verify(followRepository, Mockito.atLeast(1)).delete(mockedFollow);
        Assertions.assertEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("T-0015 -> Verifica que el follow exista en deleteFollow y arroja exception")
    void whenDeleteNonExistingFollow() {
        //arrange
        int followerId = 1;
        int followedId = 2;
        Mockito.when(followRepository.findByFollowerIdAndFollowedId(followerId, followedId))
                .thenReturn(Optional.empty());

        //act assert
        Assertions.assertThrows(EntityNotFoundException.class, () -> followService.deleteFollow(followerId, followedId));
    }

    @Test
    @DisplayName("T-0016 -> countFollowers llama a repository con id del usuario")
    void countFollowersCallsRepository() {
        //arrange
        int userId = 1;
        int followerCount = 5;
        User user = UserBuilder.userSeller(userId);
        Mockito.when(followRepository.countFollowersById(userId)).thenReturn(followerCount);

        //act
        int response = followService.countFollowers(user);

        //assert
        Mockito.verify(followRepository, Mockito.atLeast(1)).countFollowersById(userId);
        Assertions.assertEquals(followerCount, response);

    }

    @Test
    @DisplayName("T-0017 -> searchFollowersOrderAsc llama al repositiory y mapea a dto correctamente")
    void searchFollowersOrderAscMapsCorrectly() {
        //arrange
        int userId = 1;
        List<User> mockedUsers = UserBuilder.userClientList();
        List<UserDto> expectedResponse = UserBuilder.userClientDtoList();
        Mockito.when(followRepository.searchFollowersByUserAndOrderAsc(userId)).thenReturn(mockedUsers);

        //act
        List<UserDto> actualResponse = followService.searchFollowersByUserAndOrderAsc(userId);

        //assert
        Mockito.verify(followRepository, Mockito.atLeast(1))
                .searchFollowersByUserAndOrderAsc(userId);
        Assertions.assertIterableEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("T-0018 -> searchFollowersOrderDesc llama al repositiory y mapea a dto correctamente")
    void searchFollowersOrderDescMapsCorrectly() {
        //arrange
        int userId = 1;
        List<User> mockedUsers = UserBuilder.userClientList();
        List<UserDto> expectedResponse = UserBuilder.userClientDtoList();
        Mockito.when(followRepository.searchFollowersByUserAndOrderDesc(userId)).thenReturn(mockedUsers);

        //act
        List<UserDto> actualResponse = followService.searchFollowersByUserAndOrderDesc(userId);

        //assert
        Mockito.verify(followRepository, Mockito.atLeast(1))
                .searchFollowersByUserAndOrderDesc(userId);
        Assertions.assertIterableEquals(expectedResponse, actualResponse);
    }

    @Test
    @DisplayName("T-0019 -> searchFollowedOrder llama al metodo ascendente del repo segun corresponde")
    void searchFollowedCallsTheAscMethod() {
        //arrange
        OrderType orderType = OrderType.name_asc;
        int userId = 1;
        List<User> mockUsers = UserBuilder.userClientList();
        Mockito.when(followRepository.findFollowedsByIdAsc(userId)).thenReturn(mockUsers);

        //act
        List<User> response = followService.searchFollowedByUserOrder(userId, orderType);
        Mockito.verify(followRepository, Mockito.atLeast(1))
                .findFollowedsByIdAsc(userId);
        //assert
        Assertions.assertIterableEquals(mockUsers, response);

    }

    @Test
    @DisplayName("T-0020 -> searchFollowedOrder llama al metodo descentente del repo segun corresponde")
    void searchFollowedCallsTheDescMethod() {
        //arrange
        OrderType orderType = OrderType.name_desc;
        int userId = 1;
        List<User> mockUsers = UserBuilder.userClientList();
        Mockito.when(followRepository.findFollowedsByIdDesc(userId)).thenReturn(mockUsers);

        //act
        List<User> response = followService.searchFollowedByUserOrder(userId, orderType);
        Mockito.verify(followRepository, Mockito.atLeast(1))
                .findFollowedsByIdDesc(userId);
        //assert
        Assertions.assertIterableEquals(mockUsers, response);
    }
}
