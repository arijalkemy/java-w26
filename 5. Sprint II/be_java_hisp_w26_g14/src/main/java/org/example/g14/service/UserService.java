package org.example.g14.service;

import org.example.g14.dto.response.UserFollowedResponseDto;
import org.example.g14.dto.response.UserFollowersCountResponseDto;
import org.example.g14.dto.response.UserFollowersResponseDto;
import org.example.g14.dto.response.UserResponseDto;
import org.example.g14.exception.*;
import org.example.g14.model.User;
import org.example.g14.repository.IPostRepository;
import org.example.g14.repository.IUserRepository;
import org.example.g14.utils.NameOrder;
import org.example.g14.utils.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserService implements IUserService, IUserServiceInternal {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IPostRepository postRepository;

    @Override
    public UserFollowersCountResponseDto countFollowersBySeller(int id) {
        User user = searchUserIfExists(id);
        if(postRepository.findAllByUser(user.getId()).isEmpty()){
            throw new NotSellerException(id);
        }

        return new UserFollowersCountResponseDto(
                user.getId(),
                user.getName(),
                user.getIdFollowers().size());
    }

    @Override
    public UserFollowedResponseDto follow(int userId, int userIdToFollow) {

        if(userId == userIdToFollow){
            throw new BadRequestException("Un usuario no se puede seguir a si mismo.");
        }

        User user = searchUserIfExists(userId);
        User userToFollow = searchUserIfExists(userIdToFollow);

        if(postRepository.findAllByUser(userIdToFollow).isEmpty()){
            throw new NotSellerException(userIdToFollow);
        }

        if(user.getIdFollows().contains(userIdToFollow)){
            throw new ConflictException("El usuario con id " + userId + " ya sigue al usuario con id " + userIdToFollow);
        }

        user.getIdFollows().add(userToFollow.getId());
        userToFollow.getIdFollowers().add(user.getId());

        userRepository.save(user);
        userRepository.save(userToFollow);

        return transferToUserFollowedDto(user);
    }

    @Override
    public UserFollowedResponseDto getListOfFollowedSellers(int userId, String order) {

        NameOrder orderEnum = null;

        if(order != null ){
            try {
                orderEnum = NameOrder.valueOf(order.toUpperCase());
            }
            catch (IllegalArgumentException e){
                throw new OrderInvalidException(order);
            }
        }

        User user = searchUserIfExists(userId);
        Stream<UserResponseDto> userResponseDtoStream = user.getIdFollows().stream()
                .map(this::searchUserIfExists)
                .map(UserMapper::transferToUserDto);

        if(orderEnum == NameOrder.NAME_ASC)
            userResponseDtoStream = userResponseDtoStream.sorted(Comparator.comparing(UserResponseDto::getUser_name));
        else if (orderEnum == NameOrder.NAME_DESC)
            userResponseDtoStream = userResponseDtoStream.sorted(Comparator.comparing(UserResponseDto::getUser_name).reversed());

        return new UserFollowedResponseDto(user.getId(),
                user.getName(),
                userResponseDtoStream.toList());
    }

    @Override
    public UserFollowersResponseDto getAllFolowers(int id, String order) {
        NameOrder orderEnum = null;

        if(order != null){
            try {
                orderEnum = NameOrder.valueOf(order.toUpperCase());
            }
            catch (IllegalArgumentException e){
                throw new OrderInvalidException(order);
            }
        }

        User user = searchUserIfExists(id);

        if (postRepository.findAllByUser(id).isEmpty())
            throw new NotSellerException(id);

        Stream<UserResponseDto> userResponseDtoStream = user.getIdFollowers().stream()
            .map(this::searchUserIfExists)
            .map(UserMapper::transferToUserDto);

        if(orderEnum == NameOrder.NAME_ASC)
            userResponseDtoStream = userResponseDtoStream.sorted(Comparator.comparing(UserResponseDto::getUser_name));
        else if (orderEnum == NameOrder.NAME_DESC)
            userResponseDtoStream = userResponseDtoStream.sorted(Comparator.comparing(UserResponseDto::getUser_name).reversed());

        return new UserFollowersResponseDto(user.getId(),
                user.getName(),
                userResponseDtoStream.toList());
    }

    @Override
    public UserFollowedResponseDto unfollowSeller(int followerUserId, int sellerUserId) {

        User followerUser = searchUserIfExists(followerUserId);

        // Check if Seller User exists
        User sellerUser = searchUserIfExists(sellerUserId);

        // 'Integer.valueof' is needed because List.remove has an overload por a plain int parameter
        // that treats that parameter as an index in the List, not as the Object we are trying to remove.
        boolean wasFollowing = followerUser.getIdFollows().remove(Integer.valueOf(sellerUserId));
        sellerUser.getIdFollowers().remove(Integer.valueOf(followerUserId));

        if (!wasFollowing)
            throw new ConflictException(
                "El Usuario con id=%d no sigue al Usuario con id=%d".formatted(followerUserId, sellerUserId)
            );

        userRepository.save(followerUser);
        userRepository.save(sellerUser);

        return transferToUserFollowedDto(followerUser);
    }

    private UserFollowedResponseDto transferToUserFollowedDto(User user) {

        List<UserResponseDto> followedUsers = user.getIdFollows().stream()
            .map(this::searchUserIfExists)
            .map(UserMapper::transferToUserDto)
            .toList();

        return new UserFollowedResponseDto(
            user.getId(),
            user.getName(),
            followedUsers
        );
    }

    public User searchUserIfExists(int id){
        Optional<User> user = userRepository.getById(id);
        if(user.isEmpty())
            throw new UserNotFoundException(id);
        return user.get();
    }
}
