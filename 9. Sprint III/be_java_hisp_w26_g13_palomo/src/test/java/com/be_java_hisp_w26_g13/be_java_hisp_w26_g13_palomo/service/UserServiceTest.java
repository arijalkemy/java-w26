package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.service;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto.ResponseFollowDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto.ResponseFollowedByUserDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto.ResponseUserFollowersDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.entity.User;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.exception.BadRequestException;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.entity.UserMinimalData;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.exception.NotFoundException;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.repository.IUserRepository;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.service.impl.UserServiceImpl;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.utils.CustomUtils;
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
    @DisplayName(value = "Verify user to follow exist")
    public void userToFollowExist(){

        when(userRepository.findById(follower.getUserId())).thenReturn(follower);
        when(userRepository.findById(userToFollow.getUserId())).thenReturn(userToFollow);
        ResponseFollowDTO responseMock = new ResponseFollowDTO(follower.getUserId(),"You are now following user Pedro");

        ResponseFollowDTO response = userService.followUser(follower.getUserId(),userToFollow.getUserId());


        Assertions.assertEquals(response.getMessage(),responseMock.getMessage());

    }

    @Test
    @DisplayName(value = "User to follow does not exist")
    public void userTofollowDoesNotExist(){

        when(userRepository.findById(follower.getUserId())).thenReturn(follower);
        when(userRepository.findById(userToFollow.getUserId())).thenReturn(null);

        NotFoundException test = Assertions.assertThrows(NotFoundException.class,()->userService.followUser(
                follower.getUserId(),userToFollow.getUserId()));

        NotFoundException testMock = new NotFoundException("User to follow with id 2 does not exist.");
        Assertions.assertEquals(test.getMessage(),testMock.getMessage());
    }
    







}
