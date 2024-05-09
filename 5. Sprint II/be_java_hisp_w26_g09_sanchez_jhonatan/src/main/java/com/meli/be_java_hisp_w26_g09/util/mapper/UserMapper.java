package com.meli.be_java_hisp_w26_g09.util.mapper;

import com.meli.be_java_hisp_w26_g09.dto.UserDTO;
import com.meli.be_java_hisp_w26_g09.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserDTO userToUserDTO(User user) {

        if (user == null || user.getUserId() == null)
            return new UserDTO();

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(user.getUserName());
        userDTO.setFollowed(
                (user.getFollowed() != null
                        && user.getFollowed().isEmpty()) ? null :
                        this.userListToUserDTOList(user.getFollowed()));
        return userDTO;
    }



    public User userDTOToUser(UserDTO userDTO) {

        if (userDTO == null || userDTO.getUserId() == null)
            return new User();

        User user = new User();
        user.setUserId(userDTO.getUserId());
        user.setUserName(userDTO.getUserName());
        user.setFollowed(user.getFollowed() != null
                && (userDTO.getFollowed().isEmpty()) ? null :
                        userDTOListToUserList(userDTO.getFollowed()));

        return user;
    }

    public List<User> userDTOListToUserList(List<UserDTO> userDTOList) {
        if (userDTOList == null || userDTOList.isEmpty())
            return new ArrayList<>();

        return userDTOList.stream()
                .map(this::userDTOToUser)
                .toList();
    }

    public List<UserDTO> userListToUserDTOList(List<User> userList) {
        if (userList == null || userList.isEmpty())
            return new ArrayList<>();

        return userList.stream()
                .map(this::userToUserDTO)
                .toList();
    }

    public UserDTO userFollowedToUserDTO(User user) {
        if (user == null || user.getUserId() == null)
            return new UserDTO();

        UserDTO userDTO = userToUserDTO(user);
        if (userDTO.getFollowed() != null)
            userDTO.getFollowed().forEach(userDTO1 -> userDTO1.setRole(null));

        return userDTO;
    }

    public UserDTO userFollowersToUserDTO(User user, List<User> users) {
        if (user == null || user.getUserId() == null)
            return new UserDTO();

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserName(user.getUserName());
        userDTO.setFollowers(listUserToListUserDTOwithoutFolloweds(users));
        return userDTO;
    }

    public List<UserDTO> listUserToListUserDTOwithoutFolloweds(List<User> users){
        RoleMapper roleMapper = new RoleMapper();
        List<UserDTO> result = new ArrayList<>();
        for (User u: users){
            result.add(new UserDTO(u.getUserId(),
                    u.getUserName(),
                    roleMapper.roleToRoleDTO(u.getRole()),
                    null,
                    null,
                    null));
        }
        return result;
    }



}
