package com.meli.be_java_hisp_w26_g09.util.mapper;

import com.meli.be_java_hisp_w26_g09.dto.RoleDTO;
import com.meli.be_java_hisp_w26_g09.dto.UserDTO;
import com.meli.be_java_hisp_w26_g09.entity.Role;
import com.meli.be_java_hisp_w26_g09.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {
    private UserMapper userMapper;

    @BeforeEach
    void setUp() {
        userMapper = new UserMapper();
    }

    @Test
    @DisplayName("User to UserDto converts correctly")
    void userToUserDTO_ConvertsCorrectly() {
        User user = new User(1, "JohnDoe", new Role(), new ArrayList<>());

        UserDTO result = userMapper.userToUserDTO(user);

        assertEquals(user.getUserId(), result.getUserId());
        assertEquals(user.getUserName(), result.getUserName());
    }

    @Test
    @DisplayName("UserDTO to User converts correctly")
    void userDTOToUser_ConvertsCorrectly() {
        UserDTO userDTO = new UserDTO(1, "JohnDoe", new RoleDTO(), new ArrayList<>(), null, null);

        User result = userMapper.userDTOToUser(userDTO);

        assertEquals(userDTO.getUserId(), result.getUserId());
        assertEquals(userDTO.getUserName(), result.getUserName());
        assertNotNull(result.getFollowed());
        assertEquals(0, result.getFollowed().size());
    }

    @Test
    @DisplayName("List<User> to List<UserDTO> without followeds converts correctly")
    void listUserToListUserDTOwithoutFolloweds_ConvertsCorrectly() {
        List<User> users = new ArrayList<>();
        User user1 = new User(1, "JohnDoe", new Role(), new ArrayList<>());
        User user2 = new User(2, "JaneDoe", new Role(), new ArrayList<>());
        users.add(user1);
        users.add(user2);

        List<UserDTO> result = userMapper.listUserToListUserDTOwithoutFolloweds(users);

        assertEquals(users.size(), result.size());
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            UserDTO userDTO = result.get(i);
            assertEquals(user.getUserId(), userDTO.getUserId());
            assertEquals(user.getUserName(), userDTO.getUserName());
            assertNull(userDTO.getFollowed());
        }
    }

    @Test
    @DisplayName("UserList to UserDTOList converts correctly")
    void userListToUserDTOList_ConvertsCorrectly() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1, "JohnDoe", null, null));
        userList.add(new User(2, "AliceSmith", null, null));

        List<UserDTO> result = userMapper.userListToUserDTOList(userList);

        assertEquals(userList.size(), result.size());
        assertEquals(userList.get(0).getUserId(), result.get(0).getUserId());
        assertEquals(userList.get(0).getUserName(), result.get(0).getUserName());
        assertEquals(userList.get(1).getUserId(), result.get(1).getUserId());
        assertEquals(userList.get(1).getUserName(), result.get(1).getUserName());
    }

    @Test
    @DisplayName("User to UserDTO without followers converts correctly")
    void userFollowedToUserDTO_ConvertsCorrectly() {
        User user = new User(1, "JohnDoe", null, null);

        UserDTO result = userMapper.userFollowedToUserDTO(user);

        assertEquals(user.getUserId(), result.getUserId());
        assertEquals(user.getUserName(), result.getUserName());
        assertNull(result.getRole());
        assertTrue(result.getFollowed().isEmpty());
    }

    @Test
    @DisplayName("User to UserDTO with followers converts correctly")
    void userFollowersToUserDTO_ConvertsCorrectly() {
        User user = new User(1, "JohnDoe", new Role(Role.ID_SELLER, "Seller"), null);
        List<User> followers = new ArrayList<>();
        followers.add(new User(2, "AliceSmith", new Role(Role.ID_CUSTOMER, "Customer"), null));
        followers.add(new User(3, "BobJohnson", new Role(Role.ID_CUSTOMER, "Customer"), null));

        UserDTO result = userMapper.userFollowersToUserDTO(user, followers);

        assertEquals(user.getUserId(), result.getUserId());
        assertEquals(user.getUserName(), result.getUserName());
        assertNull(result.getRole());
        assertNull(result.getFollowed());
        assertEquals(followers.size(), result.getFollowers().size());
        assertEquals(followers.get(0).getUserId(), result.getFollowers().get(0).getUserId());
        assertEquals(followers.get(0).getUserName(), result.getFollowers().get(0).getUserName());
        assertEquals(followers.get(1).getUserId(), result.getFollowers().get(1).getUserId());
        assertEquals(followers.get(1).getUserName(), result.getFollowers().get(1).getUserName());
    }

    @Test
    @DisplayName("User to UserDTO with followers converts correctly")
    void userFollowersToUserDTO_ReturnsEmptyUserDTO_WhenUserIsNull() {
        User user = null;
        List<User> followers = new ArrayList<>();
        followers.add(new User(1, "AliceSmith", null, null));

        UserDTO result = userMapper.userFollowersToUserDTO(user, followers);

        assertNotNull(result);
        assertNull(result.getUserId());
        assertNull(result.getUserName());
        assertNull(result.getFollowers());
    }

    @Test
    @DisplayName("User to UserDTO with followers converts correctly")
    void userFollowersToUserDTO_ReturnsEmptyUserDTO_WhenUserIdIsNull() {
        User user = new User(null, "JohnDoe", null, null);
        List<User> followers = new ArrayList<>();
        followers.add(new User(1, "AliceSmith", null, null));

        UserDTO result = userMapper.userFollowersToUserDTO(user, followers);

        assertNotNull(result);
        assertNull(result.getUserId());
        assertNull(result.getUserName());
        assertNull(result.getFollowers());
    }

    @Test
    @DisplayName("User to UserDTO with followers converts correctly")
    void userFollowedToUserDTO_ReturnsEmptyUserDTO_WhenUserIsNull() {
        User user = null;

        UserDTO result = userMapper.userFollowedToUserDTO(user);

        assertNotNull(result);
        assertNull(result.getUserId());
        assertNull(result.getUserName());
        assertNull(result.getFollowed());
    }

    @Test
    @DisplayName("User to UserDTO with followers converts correctly")
    void userFollowedToUserDTO_ReturnsEmptyUserDTO_WhenUserIdIsNull() {
        User user = new User(null, "JohnDoe", null, null);

        UserDTO result = userMapper.userFollowedToUserDTO(user);

        assertNotNull(result);
        assertNull(result.getUserId());
        assertNull(result.getUserName());
        assertNull(result.getFollowed());
    }

    @Test
    @DisplayName("UserDTOList to UserList converts correctly")
    void userDTOListToUserList_ConvertsCorrectly() {
        List<UserDTO> userDTOList = new ArrayList<>();
        userDTOList.add(new UserDTO(1, "JohnDoe", null, null, null, null));
        userDTOList.add(new UserDTO(2, "AliceSmith", null, null, null, null));

        List<User> result = userMapper.userDTOListToUserList(userDTOList);

        assertNotNull(result);
        assertEquals(userDTOList.size(), result.size());
        assertEquals(userDTOList.get(0).getUserId(), result.get(0).getUserId());
        assertEquals(userDTOList.get(0).getUserName(), result.get(0).getUserName());
        assertEquals(userDTOList.get(1).getUserId(), result.get(1).getUserId());
        assertEquals(userDTOList.get(1).getUserName(), result.get(1).getUserName());
    }

    @Test
    @DisplayName("UserDTO to User converts correctly")
    void userDTOToUser_ReturnsEmptyUser_WhenUserDTOIsNull() {
        UserDTO userDTO = null;

        User result = userMapper.userDTOToUser(userDTO);

        assertNotNull(result);
        assertNull(result.getUserId());
        assertNull(result.getUserName());
        assertNull(result.getFollowed());
    }

    @Test
    @DisplayName("UserDTO to User converts correctly")
    void userDTOToUser_ReturnsEmptyUser_WhenUserIdIsNull() {
        UserDTO userDTO = new UserDTO(null, "JohnDoe", null, null, null, null);

        User result = userMapper.userDTOToUser(userDTO);

        assertNotNull(result);
        assertNull(result.getUserId());
        assertNull(result.getUserName());
        assertNull(result.getFollowed());
    }

    @Test
    @DisplayName("User to UserDTO converts correctly")
    void userToUserDTO_ReturnsEmptyUserDTO_WhenUserIsNull() {
        User user = null;

        UserDTO result = userMapper.userToUserDTO(user);

        assertNotNull(result);
        assertNull(result.getUserId());
        assertNull(result.getUserName());
        assertNull(result.getFollowed());
    }

    @Test
    @DisplayName("User to UserDTO converts correctly")
    void userToUserDTO_ReturnsEmptyUserDTO_WhenUserIdIsNull() {
        User user = new User(null, "JohnDoe", null, null);

        UserDTO result = userMapper.userToUserDTO(user);

        assertNotNull(result);
        assertNull(result.getUserId());
        assertNull(result.getUserName());
        assertNull(result.getFollowed());
    }

    @Test
    @DisplayName("User to UserDTO converts correctly")
    void userToUserDTO_ReturnsEmptyUserDTO_WhenFollowedIsNull() {
        User user = new User(1, "JohnDoe", null, null);

        UserDTO result = userMapper.userToUserDTO(user);

        assertNotNull(result);
        assertEquals(1, result.getUserId());
        assertEquals("JohnDoe", result.getUserName());
        assertTrue(result.getFollowed().isEmpty());
    }

    @Test
    @DisplayName("User to UserDTO converts correctly")
    void userToUserDTO_ReturnsEmptyUserDTO_WhenFollowedIsEmpty() {
        User user = new User(1, "JohnDoe", null, Collections.emptyList());

        UserDTO result = userMapper.userToUserDTO(user);

        assertNotNull(result);
        assertEquals(1, result.getUserId());
        assertEquals("JohnDoe", result.getUserName());
        assertEquals(null, result.getFollowed());
    }
}