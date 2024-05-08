package com.meli.be_java_hisp_w26_g09.service.impl;

import com.meli.be_java_hisp_w26_g09.dto.ResponseDTO;
import com.meli.be_java_hisp_w26_g09.dto.UserDTO;
import com.meli.be_java_hisp_w26_g09.entity.Role;
import com.meli.be_java_hisp_w26_g09.entity.User;
import com.meli.be_java_hisp_w26_g09.exception.BadRequestException;
import com.meli.be_java_hisp_w26_g09.exception.NotContentFollowedException;
import com.meli.be_java_hisp_w26_g09.exception.NotFoundException;
import com.meli.be_java_hisp_w26_g09.util.mapper.UserMapper;
import com.meli.be_java_hisp_w26_g09.repository.IUserRepository;
import com.meli.be_java_hisp_w26_g09.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Comparator;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final String NAME_ASC = "name_asc";
    private final String NAME_DESC = "name_desc";

    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO getFollowedById(Integer id) {

        Optional<User> userFollowed = userRepository.findById(id);

        if (userFollowed.isEmpty())
            throw new NotFoundException("No information was found about those followed.");

        if (userFollowed.get().getRole() != null
                && userFollowed.get().getRole().getIdRole().equals(Role.ID_SELLER))
            throw new NotContentFollowedException("The seller does not have the option to follow");

        return userMapper.userFollowedToUserDTO(userFollowed.get());
    }

    @Override
    public UserDTO getFollowersById(Integer id) {
        Optional<User> userFollowers = userRepository.findById(id);
        if (userFollowers.isEmpty())
            throw new NotFoundException("No information was found about those followed.");

        if (userFollowers.get().getRole() != null && userFollowers.get().getRole().getIdRole().equals(Role.ID_CUSTOMER))
            throw new NotContentFollowedException("The customers don't have an option for followers");

        List<User> users = userRepository.findAll();

        List<User> followers = users.stream()
                .filter(user -> user.getFollowed() != null && user.getFollowed().stream().map(User::getUserId).
                        anyMatch(userId -> userId.equals(userFollowers.get().getUserId()))).toList();

        return userMapper.userFollowersToUserDTO(userFollowers.get(), followers);
    }

    @Override
    public UserDTO getFollowersCount(Integer id) {
        UserDTO user = getFollowersById(id);
        user.setFollowersCount(user.getFollowers().size());
        user.setFollowers(null);
        return user;
    }


    public UserDTO getFollowersByIdOrdered(Integer id, String order) {
        UserDTO userFollowerDTO = getFollowersById(id);
        if (!(NAME_ASC.equalsIgnoreCase(order) || NAME_DESC.equalsIgnoreCase(order))) {
            throw new BadRequestException("Invalid order parameter. Valid values are 'name_asc' or 'name_desc'.");
        }
        if (NAME_ASC.equalsIgnoreCase(order)) {
            userFollowerDTO.setFollowers(userFollowerDTO.getFollowers()
                    .stream()
                    .sorted(Comparator.comparing(UserDTO::getUserName))
                    .toList());
        } else if (NAME_DESC.equalsIgnoreCase(order)) {
            userFollowerDTO.setFollowers(userFollowerDTO.getFollowers()
                    .stream()
                    .sorted(Comparator.comparing(UserDTO::getUserName).reversed())
                    .toList());
        }
        return userFollowerDTO;
    }

    @Override
    public UserDTO getFollowedByIdOrdered(Integer id, String order) {
        UserDTO userDTO = getFollowedById(id);

        if (!(NAME_ASC.equalsIgnoreCase(order) || NAME_DESC.equalsIgnoreCase(order))) {
            throw new BadRequestException("Invalid order parameter. Valid values are 'name_asc' or 'name_desc'.");
        }
        if (NAME_ASC.equalsIgnoreCase(order)) {
            userDTO.setFollowed(userDTO.getFollowed()
                    .stream()
                    .sorted(Comparator.comparing(UserDTO::getUserName))
                    .toList());
        } else if (NAME_DESC.equalsIgnoreCase(order)) {
            userDTO.setFollowed(userDTO.getFollowed()
                    .stream()
                    .sorted(Comparator.comparing(UserDTO::getUserName).reversed())
                    .toList());
        }
        return userDTO;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserDTO)
                .toList();
    }

    @Override
    public ResponseDTO unfollowUser(int userId, int userIdToUnfollow) {
        Optional<User> userWhoUnfollowOptional = userRepository.findById(userId);
        if (userWhoUnfollowOptional.isEmpty()) throw new NotFoundException("User not found");
        if (userWhoUnfollowOptional.get().getRole() == null || userWhoUnfollowOptional.get().getRole().getIdRole().equals(Role.ID_SELLER))
            throw new BadRequestException("The seller can't unfollow to a seller");
        if(userWhoUnfollowOptional.get().getFollowed() == null || userWhoUnfollowOptional.get().getFollowed().isEmpty())
            throw new BadRequestException("The user does not have any followers");
        Optional<User> userToUnfollowOptional = userWhoUnfollowOptional.get().getFollowed().stream()
                .filter(user -> user.getUserId() == userIdToUnfollow)
                .findFirst();
        if (userToUnfollowOptional.isEmpty()) throw new NotFoundException("User not found in followers list");
        userRepository.unfollowUser(userWhoUnfollowOptional.get(), userToUnfollowOptional.get());
        return new ResponseDTO("Unfollow successfull");
    }

    public ResponseDTO follow(Integer userId, Integer userIdToFollow) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isEmpty())
            throw new NotFoundException("The user with id " + userId + " was not found.");

        User customer = userOptional.get();
        userOptional = userRepository.findById(userIdToFollow);

        if (userOptional.isEmpty())
            throw new NotFoundException("The user with id " + userIdToFollow + " was not found.");

        User seller = userOptional.get();

        if (!customer.getRole().getIdRole().equals(Role.ID_CUSTOMER) || !seller.getRole().getIdRole().equals(Role.ID_SELLER))
            throw new BadRequestException("Some submitted user does not comply with the role restrictions.");

        for (User userIterarion : customer.getFollowed()) {
            if (userIterarion.getUserId().equals(userIdToFollow))
                throw new BadRequestException("The user already follow to this customer.");
        }

        userRepository.addFollowed(customer, seller);

        return new ResponseDTO("The user with id " + userId + " is follow to " + userIdToFollow);
    }
}
