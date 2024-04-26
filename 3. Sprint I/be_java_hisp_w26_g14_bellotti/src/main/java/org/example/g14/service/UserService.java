package org.example.g14.service;

import org.example.g14.dto.*;
import org.example.g14.exception.BadRequestException;
import org.example.g14.exception.NotFoundException;
import org.example.g14.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.g14.exception.ConflictException;
import org.example.g14.repository.IPostRepository;
import org.example.g14.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{
    @Autowired
    IUserRepository userRepository;

    @Autowired
    IPostRepository postRepository;

    @Override
    public UserWithFollowersCountDto countFollowersBySeller(int id) {
        User user = getUserById(id);
        if(postRepository.findAllByUser(user.getId()).isEmpty()){
            throw new BadRequestException("El usuario con el ID:" + id + " no es un vendedor");
        }

        return new UserWithFollowersCountDto(
                user.getId(),
                user.getName(),
                (int) user.getIdFollowers().stream().count());
    }

    @Override
    public UserFollowDto follow(int userId, int userIdToFollow) {
        if(userId == userIdToFollow){
            throw new BadRequestException("No te podes seguir a vos mismo maquina");
        }

        Optional<User> userOptional = userRepository.getById(userId);
        Optional<User> userToFollowOptional = userRepository.getById(userIdToFollow);

        if (userOptional.isEmpty() || userToFollowOptional.isEmpty()) {
            throw new NotFoundException("No se encontró uno o ambos usuarios");
        }

        if(postRepository.findAllByUser(userIdToFollow).isEmpty()){
            throw new BadRequestException("El usuario con el ID: " + userIdToFollow + " no es un vendedor");
        }

        User user = userOptional.get();
        User userToFollow = userToFollowOptional.get();

        if(user.getIdFollows().contains(userIdToFollow)){
            throw new ConflictException("El usuario con id " + userId + " ya sigue al usuario con id " + userIdToFollow);
        }


        user.getIdFollows().add(userToFollow.getId());

        userRepository.save(user);
        return new UserFollowDto(user.getName(),user.getIdFollows(),userToFollow.getIdFollowers());
    }

    private enum NameOrder{
        NAME_ASC,
        NAME_DESC
    }

    @Override
    public UserFollowedDto getListOfFollowedSellers(int userId, String order) {

        NameOrder orderEnum = null;

        if(order != null ){
            try {
                orderEnum = NameOrder.valueOf(order.toUpperCase());
            }
            catch (IllegalArgumentException e){
                throw new BadRequestException("Parametro de ordenamiento invalido");
            }
        }

        User user = getUserById(userId);
        UserFollowedDto usersDto = new UserFollowedDto();

        usersDto.setUser_id(user.getId());
        usersDto.setUser_name(user.getName());

        List<UserDto> listFollowed = new ArrayList<>();
        for(int followed : user.getIdFollows()){
            User foundUser = getUserById(followed);
            UserDto followedUserDto = new UserDto();
            followedUserDto.setUser_name(foundUser.getName());
            followedUserDto.setUser_id(foundUser.getId());
            listFollowed.add(followedUserDto);
        }

        if(orderEnum == NameOrder.NAME_ASC)
            listFollowed.sort(Comparator.comparing(UserDto::getUser_name));
        else if (orderEnum == NameOrder.NAME_DESC)
            listFollowed.sort(Comparator.comparing(UserDto::getUser_name).reversed());

        usersDto.setFollowed(listFollowed);

        return usersDto;
    }

    @Override
    public UserFollowersDto getAllFolowers(int id, String order) {
        NameOrder orderEnum = null;

        if(order != null ){
            try {
                orderEnum = NameOrder.valueOf(order.toUpperCase());
            }
            catch (IllegalArgumentException e){
                throw new BadRequestException("Parametro de ordenamiento invalido");
            }
        }

        User user = getUserById(id);

        if(user.getIdFollowers().size() == 0)
            throw new BadRequestException("No es un vendedor");

        UserFollowersDto userFollowersDto = new UserFollowersDto(user.getId(),
                user.getName(),
                new ArrayList<>());
        List<UserDto> userDtos = new ArrayList<>();

        for (Integer idUser : user.getIdFollowers()) {
            UserDto userDto = transferToUserDto(getUserById(idUser));
            userDtos.add(userDto);
        }

        if(orderEnum == NameOrder.NAME_ASC)
            userDtos.sort(Comparator.comparing(UserDto::getUser_name));
        else if (orderEnum == NameOrder.NAME_DESC)
            userDtos.sort(Comparator.comparing(UserDto::getUser_name).reversed());

        userFollowersDto.setFollowers(userDtos);

        return userFollowersDto;
    }

    @Override
    public UserFollowDto unfollowSeller(int followerUserId, int sellerUserId) {

        User followerUser = getUserById(followerUserId);

        // Check if Seller User exists
        getUserById(sellerUserId);

        // 'Integer.valueof' is needed because List.remove has an overload por a plain int parameter
        // that treats that parameter as an index in the List, not as the Object we are trying to remove.
        boolean wasFollowing = followerUser.getIdFollows().remove(Integer.valueOf(sellerUserId));

        if (!wasFollowing)
            throw new ConflictException(
                "El Usuario con id=%d no sigue al Usuario con id=%d".formatted(followerUserId, sellerUserId)
            );

        userRepository.save(followerUser);

        return new UserFollowDto(
            followerUser.getName(),
            followerUser.getIdFollowers(),
            followerUser.getIdFollows()
        );
    }

    private UserDto transferToUserDto(User user){
        return new UserDto(user.getId(), user.getName());
    }

    private User getUserById(int id){
        Optional<User> user = userRepository.getById(id);
        if(user.isEmpty())
            throw new NotFoundException("No se encontro el usuario");
        return user.get();
    }


}
