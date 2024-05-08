package org.example.social_meli.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.example.social_meli.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.example.social_meli.exceptions.BadRequestException;
import org.example.social_meli.exceptions.NotFoundException;

import org.example.social_meli.model.FollowerList;
import org.example.social_meli.model.User;

import org.example.social_meli.dto.UserDTO;
import org.example.social_meli.dto.UserResponseDTO;
import org.example.social_meli.dto.UserCountResponseDTO;

import org.example.social_meli.services.IUserService;

import java.util.Comparator;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void followUser(Integer user_id, Integer user_id_to_follow) {

        if (!userRepository.existsById(user_id) || !userRepository.existsById(user_id_to_follow)) {
            throw new BadRequestException("Uno o ambos usuarios no existen");
        }
        User user = userRepository.findById(user_id);
        User userToFollow = userRepository.findById(user_id_to_follow);
        if (user_id.equals(user_id_to_follow)) {
            throw new BadRequestException("No puedes seguirte a ti mismo");
        }
        if (!userToFollow.getIsSeller()) {
            throw new BadRequestException("No puede seguirlo, el usuario no es vendedor.");
        }
        if (user.getIsSeller()){
            throw new BadRequestException("El vendedor no puede seguir a otro vendedor");
        }
        FollowerList seller = userRepository.findSellerByUser(userToFollow) ==null?
                new FollowerList(userToFollow):
                userRepository.findSellerByUser(userToFollow);
        FollowerList client = userRepository.findClientByUser(user) == null ?
                new FollowerList(user):
                userRepository.findClientByUser(user);
        if(!client.getFollower().contains(userToFollow)){
            client.getFollower().add(userToFollow);
        }
        if (!seller.getFollower().contains(user)){
            seller.getFollower().add(user);
        }
        userRepository.saveSeller(seller);
        userRepository.saveClient(client);
    }

    @Override
    public UserCountResponseDTO countFollowers(Integer id) {
        FollowerList seller = userRepository.findSellerById(id);
        return new UserCountResponseDTO(
                seller.getUser().getUser_id(),
                seller.getUser().getUser_name(),
                seller.getFollower().size()
        );
    }

    @Override
    public UserResponseDTO getFollowers(Integer userId) {
        if (!userRepository.existsSellerById(userId)) {
            throw new NotFoundException("El usuario " + userId+" no es vendedor");
        }
        FollowerList followerList = userRepository.findSellerById(userId);
        if (followerList == null) {
            throw new NotFoundException("No tiene seguidores");
        }
        return  getUserResponseDTO(followerList);

    }

    @Override
    public UserResponseDTO getFollowedById(Integer userId) {
        if (!userRepository.existsClientById(userId)) {
            throw new NotFoundException("El usuario " + userId+" no es un comprador");
        }
        FollowerList followerList = userRepository.findClientById(userId);
        return getUserResponseDTO(followerList);
    }

    @Override
    public UserResponseDTO unfollowUser(Integer userId, Integer userIdToUnfollow) {
        FollowerList client = userRepository.findClientById(userId);
        Integer indexClient = userRepository.getClientIndex(client);

        if (client == null) {
            throw new NotFoundException("No existe el usuario " + userId);
        }

        FollowerList seller = userRepository.findSellerById(userIdToUnfollow);
        Integer indexSeller =  userRepository.getSellerIndex(seller);

        if (seller == null) {
            throw new NotFoundException("No existe el usuario " + userIdToUnfollow);
        }

        List<User> followers = seller.getFollower();
        List<User> followed = client.getFollower();

        followers.removeIf(follower -> follower.getUser_id().equals(userId));
        seller.setFollower(followers);

        followed.removeIf(f -> f.getUser_id().equals(userIdToUnfollow));
        client.setFollower(followed);

        userRepository.updateClients(indexClient,client);
        userRepository.updateSellers(indexSeller,seller);

        return getUserResponseDTO(client);
    }

    @Override
    public UserResponseDTO getOrderedFollowedById(Integer id, String orderBy) {
        UserResponseDTO response = getFollowedById(id);
        return orderFollowerList(response,orderBy);
    }

    @Override
    public UserResponseDTO getOrderedFollowersById(Integer id, String orderBy) {
        UserResponseDTO response = getFollowers(id);
        return orderFollowerList(response,orderBy);
    }

    private UserResponseDTO orderFollowerList(UserResponseDTO response, String orderBy){
        if (!orderBy.equals("name_asc") && !orderBy.equals("name_desc"))
            throw new BadRequestException("El parámetro de ordenamiento no es valido");
        return (orderBy.equals("name_asc")?
                orderFollowersAsc(response):
                orderFollowersDesc(response));
    }

    private UserResponseDTO orderFollowersAsc(UserResponseDTO user){
        user.setFollower(user.getFollower()
                .stream()
                .sorted(Comparator.comparing(UserDTO::getUser_name))
                .toList());
        return user;
    }

    private UserResponseDTO orderFollowersDesc(UserResponseDTO user){
        user.setFollower(user.getFollower().stream().sorted(Comparator.comparing(UserDTO::getUser_name).reversed()).toList());
        return user;
    }

    private UserResponseDTO getUserResponseDTO(FollowerList followerList) {
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setUser_id(followerList.getUser().getUser_id());
        responseDTO.setUser_name(followerList.getUser().getUser_name());
        responseDTO.setFollower(followerList.getFollower()
                .stream().map(follower ->
                        objectMapper.convertValue(follower, UserDTO.class))
                .toList());
        return responseDTO;
    }
}
