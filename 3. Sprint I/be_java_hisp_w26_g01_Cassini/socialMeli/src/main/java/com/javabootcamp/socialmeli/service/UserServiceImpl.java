package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.FollowersCountDto;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.enums.UserType;
import com.javabootcamp.socialmeli.exception.IllegalActionException;
import com.javabootcamp.socialmeli.dto.FollowedSellersDto;
import com.javabootcamp.socialmeli.dto.UserDto;
import com.javabootcamp.socialmeli.dto.SellerWithFollowersDTO;
import com.javabootcamp.socialmeli.dto.ResponseDto;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.UserRepository;
import com.javabootcamp.socialmeli.exception.EntityNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final FollowService followService;

    @Override
    public List<UserDto> getAllUsers() {
        ObjectMapper mapper = new ObjectMapper();
        return userRepository
                .getAllUsers()
                .stream()
                .map(u -> mapper.convertValue(u, UserDto.class))
                .toList();

    }

    @Override
    public SellerWithFollowersDTO searchFollowersById(Integer userId) {
        User user = searchUserById(userId);

        SellerWithFollowersDTO sellerWithFollowersDTO = new SellerWithFollowersDTO();

        List<UserDto> followersDto = followService.searchFollowersByUser(userId);

        sellerWithFollowersDTO.setUserId(user.getId());
        sellerWithFollowersDTO.setUserName(user.getUsername());
        sellerWithFollowersDTO.setFollowers(followersDto);

        return sellerWithFollowersDTO;
    }



    @Override
    public SellerWithFollowersDTO searchFollowersById(Integer userId, OrderType order){

        if(order.equals(OrderType.date_desc) || order.equals(OrderType.date_asc)){
            throw new IllegalActionException("Invalid order type.");
        }

        User user = searchUserById(userId);
        SellerWithFollowersDTO sellerWithFollowersDTO = new SellerWithFollowersDTO();
        List<UserDto> followersDto;

        if(order.equals(OrderType.name_asc)){
            followersDto = followService.searchFollowersByUserAndOrderAsc(userId);
        }
        else{
            followersDto = followService.searchFollowersByUserAndOrderDesc(userId);
        }

        sellerWithFollowersDTO.setUserId(user.getId());
        sellerWithFollowersDTO.setUserName(user.getUsername());
        sellerWithFollowersDTO.setFollowers(followersDto);

        return sellerWithFollowersDTO;
    }

    @Override
    public FollowedSellersDto searchFollowedById(Integer userId) {
        List<User> userList = followService.searchFollowedByUser(userId);
        if (userList.isEmpty()) { // verifico si el usuario sigue a alguien
            throw new EntityNotFoundException("There are no followed users");
        }

        List<UserDto> userDtos = userList.stream()
                .map(u -> new UserDto(
                        u.getId(),
                        u.getUsername()
                ))
                .toList();

        return new FollowedSellersDto(userId,
                searchUserById(userId).getUsername(),
                userDtos);
    }
    @Override
    public FollowedSellersDto searchFollowedById(Integer userId, OrderType order) {

        if(order.equals(OrderType.date_asc) || order.equals(OrderType.date_desc)){
            throw new IllegalActionException("Invalid order type.");
        }

        List<User> userList = followService.searchFollowedByUserOrder(userId,order);
        if (userList.isEmpty()) { // verifico si el usuario sigue a alguien
            throw new EntityNotFoundException("There are no followed users.");
        }

        List<UserDto> userDtos = userList.stream()
                .map(u -> new UserDto(
                        u.getId(),
                        u.getUsername()
                ))
                .toList();

        return new FollowedSellersDto(userId,
                searchUserById(userId).getUsername(),
                userDtos);
    }

    @Override
    public FollowersCountDto countFollowersById(Integer userId) {
        User userToCount = searchUserById(userId);
        return new FollowersCountDto(userToCount.getId(),userToCount.getUsername(),followService.countFollowers(userToCount));
    }

    @Override
    public ResponseDto addFollower(Integer followerdId, Integer followedId) {
        User follower = userRepository.findById(followerdId)
                .orElseThrow(() -> new EntityNotFoundException("Follower not found"));
        if (follower.getUserType() == UserType.SELLER) {
            throw new IllegalActionException("Seller cannot follow");
        }
        User followed = userRepository.findById(followedId)
                .orElseThrow(() -> new EntityNotFoundException("Followed not found"));
        if (followed.getUserType() == UserType.CLIENT) {
            throw new IllegalActionException("Cannot follow a client");
        }
        followService.addFollow(follower, followed);
        return new ResponseDto("Follower added succesfully");
    }

    @Override
    public ResponseDto deleteFollower(Integer followerId, Integer followedId) {
        return followService.deleteFollow(followerId, followedId);
    }

    @Override
    public User searchUserById(Integer id) {
        return userRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User does not exist."));
    }

    @Override
    public List<Integer> getListSellerId(Integer userId) {
        // valido que exista usuario
        User user = searchUserById(userId);
        // retorno una lista solo con los id's
        return searchFollowedById(user.getId()).getFollowed().stream().map(UserDto::getId).toList();
    }
}
