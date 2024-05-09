package com.example.sprint1.service;

import com.example.sprint1.dto.FollowListDto;
import com.example.sprint1.exception.BadRequestException;
import com.example.sprint1.model.Post;
import com.example.sprint1.model.User;
import com.example.sprint1.repository.UserRepositoryImpl;
import com.example.sprint1.repository.PostRepositoryImpl;
import com.example.sprint1.repository.UserRepositoryTest;
import com.example.sprint1.dto.*;
import com.example.sprint1.exception.BadRequestException;
import com.example.sprint1.exception.NotFoundException;
import com.example.sprint1.model.User;
import com.example.sprint1.repository.UserRepositoryImpl;
import com.example.sprint1.util.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepositoryImpl userRepository;

    @InjectMocks
    UserServiceImpl userService;

    /**
     * Unit tests T-0003
     * Tests the ascending order and descending order of the method
     * getFollowerListToString, with order name_asc and name_desc
     */
    @Test
    @DisplayName("Verify that the alphabetical sort type exists")
    public void testGetFollowerListToString(){
        //Arrange
        List<User> mockFollowerList = Arrays.asList(
                new User(2, "Manuel", new HashSet<>(), new HashSet<>(), new HashSet<>()),
                new User(3, "Mau", new HashSet<>(), new HashSet<>(), new HashSet<>()),
                new User(4, "Joaquin",new HashSet<>(), new HashSet<>(), new HashSet<>())
        );

        when(userRepository.getUserById(1)).thenReturn(Optional.of(new User(1, "John",new HashSet<>(), new HashSet<>(), new HashSet<>())));
        when(userRepository.getFollowersById(1)).thenReturn(mockFollowerList);

        // Act
        FollowListDto resultAsc = userService.getFollowerList(1, "name_asc");
        FollowListDto resultDesc = userService.getFollowerList(1, "name_desc");

        // Assert
        //Ascending order
        assertEquals("Joaquin", resultAsc.getFollowed().get(0).getUser_name());
        assertEquals("Manuel", resultAsc.getFollowed().get(1).getUser_name());
        assertEquals("Mau", resultAsc.getFollowed().get(2).getUser_name());

        //Descending order
        assertEquals("Mau", resultDesc.getFollowed().get(0).getUser_name());
        assertEquals("Manuel", resultDesc.getFollowed().get(1).getUser_name());
        assertEquals("Joaquin", resultDesc.getFollowed().get(2).getUser_name());
    }

    /**
     * Unit test T-0003
     * Test that any other order throws a bad exception
     */
    @Test
    @DisplayName("Verify that the alphabetical sort type doesn't exist")
    public void testGetFollowerListToStringException() {
        List<User> mockFollowerList = Arrays.asList(
                new User(2, "Manuel", new HashSet<>(), new HashSet<>(), new HashSet<>()),
                new User(3, "Mau", new HashSet<>(), new HashSet<>(), new HashSet<>()),
                new User(4, "Joaquin",new HashSet<>(), new HashSet<>(), new HashSet<>())
        );

        when(userRepository.getUserById(1)).thenReturn(Optional.of(new User(1, "John",new HashSet<>(), new HashSet<>(), new HashSet<>())));
        when(userRepository.getFollowersById(1)).thenReturn(mockFollowerList);

        // Exception handling for invalid sort order
        assertThrows(BadRequestException.class, () -> userService.getFollowerList(1, "other_sort"));
    }

    /*
     * Unit tests T-0007
     * This test method checks the functionality of the getFollowerCount method in the UserService class.
     * The method is expected to return the count of followers for a specific user, along with the user's name and ID.
     *
     * @param users - The list of users to be used for the test
     */
    @ParameterizedTest
    @DisplayName("Test getFollowers")
    @MethodSource("com.example.sprint1.util.Utils#userProvider")
    public void testGetFollowers(List<User> users) {
        // arrange
        Mockito.when(userRepository.findAll()).thenReturn(users);
        // act
        CountFollowersUserDto expected = userService.getFollowerCount(3);
        // assert
        Assertions.assertEquals(2, expected.getCount());
        Assertions.assertEquals("user3", expected.getUserName());
        Assertions.assertEquals(3, expected.getUserId());
    }

    /**
     * Unit Test T-0007 - Test getFollowers method with bad path
     * This test method checks the functionality of the getFollowerCount method in the UserService class.
     * The method is expected to throw a NotFoundException when the user is not found.
     */
    @Test
    @DisplayName("Test getFollowers bad path")
    public void testGetFollowersBadPath() {
        // arrange
        Mockito.when(userRepository.findAll()).thenReturn(new ArrayList<>());
        // act
        Assertions.assertThrows(NotFoundException.class, () -> userService.getFollowerCount(3));
    }

    /*
     * Unit tests T-0002
     * Test unfollowUser for existing user and existing user to unfollow
     */
    @ParameterizedTest
    @DisplayName("Test unfollowUser for existing user and existing user to unfollow")
    @MethodSource("com.example.sprint1.util.Utils#userProvider")
    public void testUnfollowUForExistingUserAndExistingUserToFollow(List<User> users) {
        // arrange
        Integer userId = 3;
        Integer userIdToUnfollow = 4;

        User user = users.stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
        User userToUnfollow = users.stream().filter(u -> u.getId().equals(userIdToUnfollow)).findFirst().orElse(null);

        // act
        when(userRepository.getUserById(userId)).thenReturn(Optional.ofNullable(user));
        when(userRepository.getUserById(userIdToUnfollow)).thenReturn(Optional.ofNullable(userToUnfollow));
        if (!user.getFollowers().contains(userToUnfollow)) {
            user.addFollower(userToUnfollow.getId());
        }

        // assert
        userService.setUnfollow(userId, userIdToUnfollow);
        verify(userRepository, times(1)).updateUserFollowerDelete(user, userToUnfollow);
    }
    /*
     * Unit tests T-0002
     * Test unfollowUser for existing user and non-existing user to unfollow
     * Not found exception
     */
    @ParameterizedTest
    @DisplayName("Test unfollowUser for existing user and non-existing user to unfollow")
    @MethodSource("com.example.sprint1.util.Utils#userProvider")
    public void testUnfollowUserForExistingUserAndNonExistingUserToFollow(List<User> users) {
        // arrange
        Integer userId = 3;
        Integer userIdToUnfollow = 0;

        User user = users.stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
        User userToUnfollow = users.stream().filter(u -> u.getId().equals(userIdToUnfollow)).findFirst().orElse(null);

        // act
        when(userRepository.getUserById(userId)).thenReturn(Optional.ofNullable(user));
        when(userRepository.getUserById(userIdToUnfollow)).thenReturn(Optional.ofNullable(userToUnfollow));

        // assert
        NotFoundException exception = assertThrows(NotFoundException.class, () -> userService.setUnfollow(userId, userIdToUnfollow));
        assertEquals("User to unfollow not found: " + userIdToUnfollow, exception.getMessage());
        verify(userRepository, times(0)).updateUserFollowerDelete(user, userToUnfollow);
    }

    /*
     * Unit tests T-0002
     * Test unfollowUser for non-existing user and existing user to unfollow
     * Not found exception
     */
    @ParameterizedTest
    @DisplayName("Test unfollowUser for non-existing user and existing user to unfollow")
    @MethodSource("com.example.sprint1.util.Utils#userProvider")
    public void testUnfollowUserForNonExistingUserAndExistingUserToFollow(List<User> users) {
        // arrange
        Integer userId = 0;
        Integer userIdToUnfollow = 4;

        User user = users.stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
        User userToUnfollow = users.stream().filter(u -> u.getId().equals(userIdToUnfollow)).findFirst().orElse(null);

        // act
        when(userRepository.getUserById(userId)).thenReturn(Optional.ofNullable(user));

        // assert
        NotFoundException exception = assertThrows(NotFoundException.class, () -> userService.setUnfollow(userId, userIdToUnfollow));
        assertEquals("User not found: " + userId, exception.getMessage());
        verify(userRepository, times(0)).updateUserFollowerDelete(user, userToUnfollow);
    }

    /*
     * Unit tests T-0002
     * Test unfollowUser for existing user and existing user to unfollow but not followed
     * Bad request exception
     */
    @ParameterizedTest
    @DisplayName("Test unfollowUser for existing user and existing user to unfollow but not followed")
    @MethodSource("com.example.sprint1.util.Utils#userProvider")
    public void testUnfollowUserForExistingUserAndExistingUserToFollowButNotFollowed(List<User> users) {
        // arrange
        Integer userId = 3;
        Integer userIdToUnfollow = 1;

        User user = users.stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
        User userToUnfollow = users.stream().filter(u -> u.getId().equals(userIdToUnfollow)).findFirst().orElse(null);

        // act
        when(userRepository.getUserById(userId)).thenReturn(Optional.ofNullable(user));
        when(userRepository.getUserById(userIdToUnfollow)).thenReturn(Optional.ofNullable(userToUnfollow));
        if (user.getFollowers().contains(userToUnfollow)) {
            user.deleteFollower(userToUnfollow.getId());
        }

        // assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> userService.setUnfollow(userId, userIdToUnfollow));
        assertEquals("You are not following this user: " + userIdToUnfollow, exception.getMessage());
        verify(userRepository, times(0)).updateUserFollowerDelete(user, userToUnfollow);
    }

    /*
     * Unit tests T-0002
     * Test unfollowUser for the same user
     * Bad request exception
     */
    @ParameterizedTest
    @DisplayName("Test unfollowUser for the same user")
    @MethodSource("com.example.sprint1.util.Utils#userProvider")
    public void testUnfollowUserForTheSameUser(List<User> users) {
        // arrange
        Integer userId = 3;
        Integer userIdToUnfollow = 3;

        User user = users.stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
        User userToUnfollow = users.stream().filter(u -> u.getId().equals(userIdToUnfollow)).findFirst().orElse(null);
        // act

        // assert
        BadRequestException exception = assertThrows(BadRequestException.class, () -> userService.setUnfollow(userId, userIdToUnfollow));
        assertEquals("You cannot unfollow yourself.", exception.getMessage());
        verify(userRepository, times(0)).updateUserFollowerDelete(user, userToUnfollow);
    }
    /**
     * Parameterized test for ascending sort of followers.
     * This test verifies if the ascending sorting of followers is performed correctly.
     * A method source is used to provide different sets of input data.
     *
     * The @ParameterizedTest annotation indicates that this is a parameterized test.
     * The @DisplayName annotation provides a descriptive name for the test.
     * The @MethodSource annotation specifies the method that provides the test data for the parameterized test.
     *
     * @param testFollowDtos An object containing the input and expected output data for the test.
     */

    @ParameterizedTest
    @DisplayName("Test ascending sort of followers")
    @MethodSource("com.example.sprint1.util.Utils#ascendingFollowUserProvider")
    public void ascendingFollowerSort(TestFollowDto testFollowDtos){
        //Arrange
        List<User> inputUserDtoList = testFollowDtos.getInputFollow();
        FollowListDto outputFollowListDto = testFollowDtos.getExpectedOrderedFollow();
        FollowListDto actualresponseFollowListDto;
        User user = testFollowDtos.getUser();

        //Mocking
        when(userRepository.getUserById(user.getId())).thenReturn(Optional.of(user));
        when(userRepository.getFollowersById(user.getId())).thenReturn(inputUserDtoList);

        //Act
        actualresponseFollowListDto = userService.getFollowerList(user.getId(), "name_asc");

        //Assert
        Assertions.assertEquals(actualresponseFollowListDto, outputFollowListDto, "Non matching sorting");

    }

    /**
     * Parameterized test for descending sort of followers.
     * This test verifies if the descending sorting of followers is performed correctly.
     * A method source is used to provide different sets of input data.
     *
     * The @ParameterizedTest annotation indicates that this is a parameterized test.
     * The @DisplayName annotation provides a descriptive name for the test.
     * The @MethodSource annotation specifies the method that provides the test data for the parameterized test.
     *
     * @param testFollowDtos An object containing the input and expected output data for the test.
     */

    @ParameterizedTest
    @DisplayName("Test descending sort of followers")
    @MethodSource("com.example.sprint1.util.Utils#descendingFollowerUserProvider")
    public void descendingFollowerSort(TestFollowDto testFollowDtos){
        //Arrange
        List<User> inputUserDtoList = testFollowDtos.getInputFollow();
        FollowListDto outputFollowListDto = testFollowDtos.getExpectedOrderedFollow();
        FollowListDto actualresponseFollowListDto;
        User user = testFollowDtos.getUser();

        //Mocking
        when(userRepository.getUserById(user.getId())).thenReturn(Optional.of(user));
        when(userRepository.getFollowersById(user.getId())).thenReturn(inputUserDtoList);

        //Act
        actualresponseFollowListDto = userService.getFollowerList(user.getId(), "name_desc");

        //Assert
        Assertions.assertEquals(actualresponseFollowListDto, outputFollowListDto, "Non matching sorting");

    }

    /**
     * Parameterized test for descending sort of followed users.
     * This test verifies if the descending sorting of followed users is performed correctly.
     * A method source is used to provide different sets of input data.
     *
     * The @ParameterizedTest annotation indicates that this is a parameterized test.
     * The @DisplayName annotation provides a descriptive name for the test.
     * The @MethodSource annotation specifies the method that provides the test data for the parameterized test.
     *
     * @param testFollowDtos An object containing the input and expected output data for the test.
     */

    @ParameterizedTest
    @DisplayName("Test descending sort of followed")
    @MethodSource("com.example.sprint1.util.Utils#descendingFollowedUserProvider")
    public void descendingFollowedSort(TestFollowDto testFollowDtos){
        //Arrange
        List<User> inputUserDtoList = testFollowDtos.getInputFollow();
        FollowListDto outputFollowListDto = testFollowDtos.getExpectedOrderedFollow();
        FollowListDto actualresponseFollowListDto;
        User user = testFollowDtos.getUser();

        //Mocking
        when(userRepository.getUserById(user.getId())).thenReturn(Optional.of(user));
        when(userRepository.getFollowedById(user.getId())).thenReturn(inputUserDtoList);

        //Act
        actualresponseFollowListDto = userService.getFollowedList(user.getId(), "name_desc");

        //Assert
        Assertions.assertEquals(actualresponseFollowListDto, outputFollowListDto, "Non matching sorting");

    }

    /**
     * T-0001
     * Verify the successful addition of a follower when both users exist and are not already
     * following each other.
     */
    @ParameterizedTest
    @DisplayName("Test addFollower - Success when Both Users Exist and are Not Already Following Each Other")
    @MethodSource("com.example.sprint1.util.Utils#userProvider")
    public void testAddFollower_Success(List<User> users) {
        Integer userId = 1;
        Integer userToFollowId = 2;

        // Arrange
        User user = users.stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
        User userToFollow = users.stream().filter(u -> u.getId().equals(userToFollowId)).findFirst().orElse(null);

        // Mocking UserRepository to return the user objects
        Mockito.when(userRepository.findUserById(userId)).thenReturn(user);
        Mockito.when(userRepository.findUserById(userToFollowId)).thenReturn(userToFollow);

        // Behavior of updating followers
        Mockito.doAnswer(invocation -> {
            User u = invocation.getArgument(0);
            User uf = invocation.getArgument(1);
            u.getFollowed().add(uf.getId());
            uf.getFollowers().add(u.getId());
            return null;
        }).when(userRepository).updateUserFollower(Mockito.any(User.class), Mockito.any(User.class));

        // Act
        // Execute the add follower functionality
        userService.addFollower(userId, userToFollowId);

        // Assert
        // Assertions to verify the correct behavior
        assertTrue(user.getFollowed().contains(userToFollowId));
        assertTrue(userToFollow.getFollowers().contains(userId));
        Mockito.verify(userRepository).updateUserFollower(user, userToFollow);
    }

    /**
     * T-0001
     * Verify the behavior when the user attempting to follow does not exist.
     * This test ensures that a BadRequestException is thrown indicating that the user was not found.
     */
    @ParameterizedTest
    @DisplayName("Test addFollower - Fail if User Not Found")
    @MethodSource("com.example.sprint1.util.Utils#userProvider")
    public void testAddFollower_UserNotFound(List<User> users) {
        Integer userId = 10;  // User trying to follow another, does not exist
        Integer userToFollowId = 1;  // Existing user

        // Arrange
        User user = users.stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
        User userToFollow = users.stream().filter(u -> u.getId().equals(userToFollowId)).findFirst().orElse(null);
        // Find users
        Mockito.when(userRepository.findUserById(userId)).thenReturn(user);
        Mockito.when(userRepository.findUserById(userToFollowId)).thenReturn(userToFollow);

        // Act
        Exception exception = assertThrows(BadRequestException.class, () -> {
            userService.addFollower(userId, userToFollowId);
        });

        // Assert
        assertEquals("User not found", exception.getMessage());
        Mockito.verify(userRepository, Mockito.never()).updateUserFollower(any(User.class), any(User.class));
    }

    /**
     * T-0001
     * Verify that an error is thrown when a user attempts to follow themselves.
     * This test checks for a BadRequestException with a specific message indicating that
     * following oneself is not allowed.
     */
    @ParameterizedTest
    @DisplayName("Test addFollower - Fail if User Tries to Follow Themselves")
    @MethodSource("com.example.sprint1.util.Utils#userProvider")
    public void testAddFollower_UserFollowsThemselves(List<User> users) {
        Integer userId = 1;  // User attempting to follow themselves

        // Arrange
        User user = users.stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
        Mockito.when(userRepository.findUserById(userId)).thenReturn(user);

        // Act
        Exception exception = assertThrows(BadRequestException.class, () -> {
            userService.addFollower(userId, userId);
        });

        //Assert
        assertEquals("Can't follow yourself", exception.getMessage());
    }

    /**
     * T-0001
     * Verify the behavior when a user attempts to follow another user whom they already follow.
     * This test expects a BadRequestException to be thrown with a message indicating that the user is
     * already followed.
     */
    @ParameterizedTest
    @DisplayName("Test addFollower - Fail if User Already Follows the Other User")
    @MethodSource("com.example.sprint1.util.Utils#userProvider")
    public void testAddFollower_AlreadyFollowing(List<User> users) {
        Integer userId = 3;
        Integer userToFollowId = 4;

        // Arrange
        User user = users.stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
        User userToFollow = users.stream().filter(u -> u.getId().equals(userToFollowId)).findFirst().orElse(null);

        Mockito.when(userRepository.findUserById(userId)).thenReturn(user);
        Mockito.when(userRepository.findUserById(userToFollowId)).thenReturn(userToFollow);

        // Act
        Exception exception = assertThrows(BadRequestException.class, () -> {
            userService.addFollower(userId, userToFollowId);
        });
        // Assert
        assertEquals("User already followed", exception.getMessage());
    }

     /**
     * Parameterized test for ascending sort of followed users.
     * This test verifies if the ascending sorting of followed users is performed correctly.
     * A method source is used to provide different sets of input data.
     *
     * The @ParameterizedTest annotation indicates that this is a parameterized test.
     * The @DisplayName annotation provides a descriptive name for the test.
     * The @MethodSource annotation specifies the method that provides the test data for the parameterized test.
     *
     * @param testFollowDtos An object containing the input and expected output data for the test.
     */

    @ParameterizedTest
    @DisplayName("Test ascending sort of followed")
    @MethodSource("com.example.sprint1.util.Utils#ascendingFollowedUserProvider")
    public void ascendingFollowedSort(TestFollowDto testFollowDtos){
        //Arrange
        List<User> inputUserDtoList = testFollowDtos.getInputFollow();
        FollowListDto outputFollowListDto = testFollowDtos.getExpectedOrderedFollow();
        FollowListDto actualresponseFollowListDto;
        User user = testFollowDtos.getUser();

        //Mocking
        when(userRepository.getUserById(user.getId())).thenReturn(Optional.of(user));
        when(userRepository.getFollowedById(user.getId())).thenReturn(inputUserDtoList);

        //Act
        actualresponseFollowListDto = userService.getFollowedList(user.getId(), "name_asc");

        //Assert
        Assertions.assertEquals(actualresponseFollowListDto, outputFollowListDto, "Non matching sorting");

    }
}
