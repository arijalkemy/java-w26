package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ResponseFollowDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ResponseFollowedByUserDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ResponseUserFollowersDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.Post;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.User;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.BadRequestException;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.UserMinimalData;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.exception.NotFoundException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IUserRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service.impl.UserServiceImpl;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.utils.CustomUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class UserServiceTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserServiceImpl userService;

    private User follower;
    private User userToFollow;
    private int notAUserID;

    @BeforeEach
    public void setup() {
        this.follower = new User(1, "Juan");
        this.userToFollow = new User(2, "Pedro");
        this.userToFollow.setPosts(List.of(1));
        this.notAUserID = 5;
    }

    @Test
    @DisplayName(value = "User to follow exists")
    public void userToFollowExistsTest() {
        ResponseFollowDTO expectedResponse = new ResponseFollowDTO(
                follower.getUserId(), "You are now following user " + userToFollow.getUserName()
        );

        when(userRepository.findById(follower.getUserId())).thenReturn(follower);
        when(userRepository.findById(userToFollow.getUserId())).thenReturn(userToFollow);

        ResponseFollowDTO response = userService.followUser(follower.getUserId(), userToFollow.getUserId());

        Assertions.assertEquals(expectedResponse, response);
    }

    @Test
    @DisplayName(value = "User to follow does not exist")
    public void userToFollowDoesNotExistTest() {
        when(userRepository.findById(follower.getUserId())).thenReturn(follower);
        when(userRepository.findById(notAUserID)).thenReturn(null);

        NotFoundException thrownException = Assertions.assertThrows(
                NotFoundException.class,
                () -> userService.followUser(follower.getUserId(), notAUserID),
                "Esperaba que se lance una excepción, pero no ocurrió."
        );
        String expectedExceptionMessage = "User to follow with id " + notAUserID + " does not exist.";
        Assertions.assertEquals(thrownException.getMessage(), expectedExceptionMessage);
    }


    @Test
    @DisplayName(value = "Follower list orders name_asc and name_desc exist")
    public void followerListOrderExists() {
        String orderAsc = "name_asc";
        String orderDesc = "name_desc";
        User vendor = CustomUtils.newMockedVendorWithMockedPosts();

        when(userRepository.findById(vendor.getUserId())).thenReturn(vendor);

        Assertions.assertDoesNotThrow(() -> userService.getOrderedFollowersList(vendor.getUserId(), orderAsc),
                String.valueOf(BadRequestException.class));
        Assertions.assertDoesNotThrow(() -> userService.getOrderedFollowersList(vendor.getUserId(), orderDesc),
                String.valueOf(BadRequestException.class));
    }

    @Test
    @DisplayName(value = "Follower list order does not exist")
    public void followerListOrderDoesNotExist() {
        String fakeOrder = "fake";
        User vendor = CustomUtils.newMockedVendorWithMockedPosts();

        when(userRepository.findById(vendor.getUserId())).thenReturn(vendor);

        BadRequestException thrownException = Assertions.assertThrows(
                BadRequestException.class,
                () -> userService.getOrderedFollowersList(vendor.getUserId(), fakeOrder)
        );
        String expectedExceptionMessage = "Order should be name_asc or name_desc.";
        Assertions.assertEquals(expectedExceptionMessage, thrownException.getMessage());
    }

    @Test
    @DisplayName("get followers list ordered by name asc")
    public void ascFollowerListOrderIsRight(){
        String orderAsc = "name_asc";
        ResponseUserFollowersDTO mockedResponseUserFollowersDTO = CustomUtils.newResponseUserFollowersDTO(orderAsc);

        Assertions.assertEquals(mockedResponseUserFollowersDTO, this.followersList(orderAsc));

    }
    @Test
    @DisplayName("get followers list ordered by name desc")
    public void descFollowerListOrderIsRight(){
        String orderDesc = "name_desc";
        ResponseUserFollowersDTO mockedResponseUserFollowersDTO = CustomUtils.newResponseUserFollowersDTO(orderDesc);

        Assertions.assertEquals(mockedResponseUserFollowersDTO, this.followersList(orderDesc));

    }

    private ResponseUserFollowersDTO followersList(String order){
        int userIdParam = 1;
        User vendor = CustomUtils.newMockedVendor();
        Mockito.when(userRepository.findById(userIdParam)).thenReturn(vendor);
        return userService.getOrderedFollowersList(userIdParam, order);
    }


    @Test
    @DisplayName("get followed list ordered by name asc")
    public void ascFollowedListOrderIsRight(){
        String orderAsc = "name_asc";
        ResponseFollowedByUserDTO mockedResponseUserFollowersDTO = CustomUtils.newResponseFollowedByUserDTO(orderAsc);

        Assertions.assertEquals(mockedResponseUserFollowersDTO, this.followedList(orderAsc));

    }
    @Test
    @DisplayName("get followed list ordered by name desc")
    public void descFollowedListOrderIsRight(){
        String orderDesc = "name_desc";
        ResponseFollowedByUserDTO mockedResponseUserFollowersDTO = CustomUtils.newResponseFollowedByUserDTO(orderDesc);

        Assertions.assertEquals(mockedResponseUserFollowersDTO, this.followedList(orderDesc));
    }

    private ResponseFollowedByUserDTO followedList(String order){
        int userIdParam = 16;
        User user = CustomUtils.newMockedUserTwo();
        Mockito.when(userRepository.findById(userIdParam)).thenReturn(user);
        return userService.getOrderedFollowedSellers(userIdParam, order);
    }

    @Test
    @DisplayName(value = "Followed sellers list orders name_asc and name_desc exist")
    public void followedSellersListOrderExists() {
        String orderAsc = "name_asc";
        String orderDesc = "name_desc";
        User user = CustomUtils.newMockedUser();

        when(userRepository.findById(user.getUserId())).thenReturn(user);

        Assertions.assertDoesNotThrow(() -> userService.getOrderedFollowedSellers(user.getUserId(), orderAsc),
                String.valueOf(BadRequestException.class));
        Assertions.assertDoesNotThrow(() -> userService.getOrderedFollowedSellers(user.getUserId(), orderDesc),
                String.valueOf(BadRequestException.class));
    }

    @Test
    @DisplayName(value = "Followed sellers list order does not exist")
    public void followedSellersListOrderDoesNotExist() {
        String fakeOrder = "fake";
        User user = CustomUtils.newMockedUser();

        when(userRepository.findById(user.getUserId())).thenReturn(user);

        BadRequestException thrownException = Assertions.assertThrows(
                BadRequestException.class,
                () -> userService.getOrderedFollowedSellers(user.getUserId(), fakeOrder)
        );
        String expectedExceptionMessage = "Order should be name_asc or name_desc.";
        Assertions.assertEquals(expectedExceptionMessage, thrownException.getMessage());
    }



    @Test
    @DisplayName(value = "User to unfollow exists")
    public void userToUnFollowExistsTest() {
        User userOne = CustomUtils.newMockedUser();
        User userTwoToUnfollow = CustomUtils.newMockedVendor();

        UserMinimalData userFollowedMinimal = userOne.getFollowed().get(0);
        UserMinimalData userFollowerMinimal = userTwoToUnfollow.getFollowers().get(0);

        when(userRepository.findById(userOne.getUserId())).thenReturn(userOne);
        when(userRepository.findById(userTwoToUnfollow.getUserId())).thenReturn(userTwoToUnfollow);

        when(userRepository.findFollowedById(userOne, userTwoToUnfollow.getUserId())).thenReturn(
                userFollowedMinimal);
        when(userRepository.findFollowerById(userTwoToUnfollow, userOne.getUserId())).thenReturn(
                userFollowerMinimal);

        Assertions.assertDoesNotThrow(
                () -> userService.unfollow(userOne.getUserId(), userTwoToUnfollow.getUserId()));
    }

    @Test
    @DisplayName(value = "User to unfollow does not exist")
    public void userToUnFollowDoesNotExistTest() {
        User userOne = CustomUtils.newMockedUser();
        User userTwoToUnfollow = CustomUtils.newMockedVendor();

        when(userRepository.findById(userOne.getUserId())).thenReturn(userOne);
        when(userRepository.findById(userTwoToUnfollow.getUserId())).thenReturn(null);

        assertThrows(NotFoundException.class, () -> userService.unfollow(userOne.getUserId(),userTwoToUnfollow.getUserId()));
    }

    @Test
    @DisplayName(value = "User follower count is correct")
    public void userFollowersCountIsCorrectTest() {
        User vendorWithFollowers = CustomUtils.newMockedVendor();

        when(userRepository.findById(vendorWithFollowers.getUserId())).thenReturn(vendorWithFollowers);

        Assertions.assertEquals(2, userService.getFollowersCount(vendorWithFollowers.getUserId()).getFollowersCount());
    }


    @Test
    @DisplayName(value = "User follower count decreased")
    public void userFollowersCountDecreased() {
        User userOne = CustomUtils.newMockedUser();
        User vendorWithFollowers = CustomUtils.newMockedVendor();

        when(userRepository.findById(userOne.getUserId())).thenReturn(userOne);
        when(userRepository.findById(vendorWithFollowers.getUserId())).thenReturn(vendorWithFollowers);

        int previousCount = userService.getFollowersCount(vendorWithFollowers.getUserId()).getFollowersCount();

        UserMinimalData userMinimal = userOne.getFollowed().get(0);
        UserMinimalData vendorMinimal = vendorWithFollowers.getFollowers().get(0);

        when(userRepository.findFollowedById(userOne, vendorWithFollowers.getUserId())).thenReturn(
                userMinimal);
        when(userRepository.findFollowerById(vendorWithFollowers, userOne.getUserId())).thenReturn(
                vendorMinimal);

        userService.unfollow(userOne.getUserId(), vendorWithFollowers.getUserId());

        Assertions.assertEquals( previousCount - 1, userService.getFollowersCount(vendorWithFollowers.getUserId()).getFollowersCount());
    }

    @Test
    @DisplayName(value = "User follower count increased")
    public void userFollowersCountIncreased() {
        User userOne = CustomUtils.newMockedUser();
        User vendorWithFollowers = CustomUtils.newMockedVendor();

        when(userRepository.findById(userOne.getUserId())).thenReturn(userOne);
        when(userRepository.findById(vendorWithFollowers.getUserId())).thenReturn(vendorWithFollowers);
        
        UserMinimalData userMinimal = userOne.getFollowed().get(0);
        UserMinimalData vendorMinimal = vendorWithFollowers.getFollowers().get(0);

        when(userRepository.findFollowedById(userOne, vendorWithFollowers.getUserId())).thenReturn(
                userMinimal);
        when(userRepository.findFollowerById(vendorWithFollowers, userOne.getUserId())).thenReturn(
                vendorMinimal);

        userService.unfollow(userOne.getUserId(), vendorWithFollowers.getUserId());

        int previousCount = userService.getFollowersCount(vendorWithFollowers.getUserId()).getFollowersCount();

        userService.followUser(userOne.getUserId(), vendorWithFollowers.getUserId());

        Assertions.assertEquals( previousCount + 1, userService.getFollowersCount(vendorWithFollowers.getUserId()).getFollowersCount());
    }


}
