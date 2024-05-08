package org.example.social_meli.services.impl;

import org.example.social_meli.exceptions.BadRequestException;
import org.example.social_meli.model.FollowerList;
import org.example.social_meli.model.User;
import org.example.social_meli.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.social_meli.dto.UserDTO;
import org.example.social_meli.dto.UserResponseDTO;
import org.example.social_meli.exceptions.NotFoundException;
import org.example.social_meli.dto.UserCountResponseDTO;
import org.example.social_meli.services.IProductService;
import org.example.social_meli.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    private IProductService productService;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public UserResponseDTO getFollowedById(Integer userId) {
        if (!userRepository.existsClientById(userId)) {
            throw new NotFoundException("No existe el usuario " + userId);
        }
        ObjectMapper mapper = new ObjectMapper();
        User user = userRepository.findById(userId);
        FollowerList followerList = userRepository.findClientByUser(user);

        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setUser_id(followerList.getUser().getUser_id());
        responseDTO.setUser_name(followerList.getUser().getUser_name());
        responseDTO.setFollower(followerList.getFollower()
                .stream().map(follower ->
                        mapper.convertValue(follower, UserDTO.class))
                .toList());
        return responseDTO;
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
            throw new BadRequestException("El parametro de ordenamiento no es valido");
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

    @Override
    public void followUser(Integer user_id, Integer user_id_to_follow) {

        if (!userRepository.existsById(user_id) || !userRepository.existsById(user_id_to_follow)) {
            throw new BadRequestException("Uno o ambos usuarios no existen", "USER_NOT_FOUND", "El usuario o el vendedor no existen en la base de datos");
        } else {
            User user = userRepository.findById(user_id);
            User userToFollow = userRepository.findById(user_id_to_follow);
            if (user_id.equals(user_id_to_follow)) {
                throw new BadRequestException("No puedes seguirte a ti mismo");
            }
            if (!userToFollow.getIsSeller()) {
                throw new BadRequestException("No puede seguirlo, el usuario no es vendedor.");
            }
            if (user.getIsSeller() && userToFollow.getIsSeller()) {
                throw new BadRequestException("El vendedor no puede seguir a otro vendedor");
            }
            if (user.getIsSeller()) {
                throw new BadRequestException("El usuario es vendedor y no puede seguir.");
            }
            FollowerList seller = userRepository.findSellerByUser(userToFollow);
            if (seller == null) {
                seller = new FollowerList(userToFollow);
            }
            FollowerList client = userRepository.findClientByUser(user);
            if (client == null) {
                client = new FollowerList(user);
            }
            if(!client.getFollower().contains(userToFollow)){
                client.getFollower().add(userToFollow);
            }
            if (!seller.getFollower().contains(user)){
                seller.getFollower().add(user);
            }
            userRepository.saveSeller(seller);
            userRepository.saveClient(client);
        }
    }

    @Override
    public UserCountResponseDTO countFollowers(Integer id) {
        return new UserCountResponseDTO(
                userRepository.getAllSellers().stream().filter(user -> user.getUser().getUser_id().
                        equals(id)).findFirst().get().getUser().getUser_id(),
                userRepository.getAllSellers().stream().filter(user -> user.getUser().getUser_id().
                        equals(id)).findFirst().get().getUser().getUser_name(),
                userRepository.countFollowers(id)
        );
    }

    @Override
    public UserResponseDTO getFollowers(Integer userId) {
        if (!userRepository.existsSellerById(userId)) {
            throw new NotFoundException("El usuario " + userId+" no es vendedor");
        }
        FollowerList followerList = userRepository.getFollowerByUserId(userId);
        if (followerList == null) {
            throw new NotFoundException("No tiene seguidores");
        }
        List<UserDTO> followers = followerList.getFollower().stream()
                .map(user -> objectMapper.convertValue(user, UserDTO.class))
                .collect(Collectors.toList());

        return new UserResponseDTO(userId, userRepository.getUsernameById(userId), followers);

    }

    @Override
    public UserResponseDTO unfollowUser(Integer userId, Integer userIdToUnfollow) {
        ObjectMapper mapper = new ObjectMapper();
        FollowerList client = userRepository.findClientById(userId);
        Integer indexClient = userRepository.getClientIndex(client);
        FollowerList seller = userRepository.findSellerById(userIdToUnfollow);
        Integer indexSeller =  userRepository.getSellerIndex(seller);
        List<User> followers = seller.getFollower();
        followers.removeIf(follower -> follower.getUser_id().equals(userId));
        seller.setFollower(followers);
        List<User> followeds = client.getFollower();
        followeds.removeIf(followed -> followed.getUser_id().equals(userIdToUnfollow));
        client.setFollower(followeds);
        userRepository.updateClients(indexClient,client);
        userRepository.updateSellers(indexSeller,seller);
        UserResponseDTO response = new UserResponseDTO();
        response.setUser_id(client.getUser().getUser_id());
        response.setUser_name(client.getUser().getUser_name());
        response.setFollower(client.getFollower()
                .stream().map(follow->
                        mapper.convertValue(follow, UserDTO.class))
                .toList());
        return response;
    }
}
