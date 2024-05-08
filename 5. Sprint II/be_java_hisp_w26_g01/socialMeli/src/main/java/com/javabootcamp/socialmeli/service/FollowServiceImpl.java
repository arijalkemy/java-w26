package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.response.ResponseDto;
import com.javabootcamp.socialmeli.dto.response.UserDto;
import com.javabootcamp.socialmeli.enums.OrderType;
import com.javabootcamp.socialmeli.exception.EntityNotFoundException;
import com.javabootcamp.socialmeli.exception.ResourceAlreadyExistsException;
import com.javabootcamp.socialmeli.model.Follow;
import com.javabootcamp.socialmeli.model.User;
import com.javabootcamp.socialmeli.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;

    @Override
    public void addFollow(User follower, User followed) {
        //TO-DO verificar que el usuario existe
        followRepository.findByFollowerIdAndFollowedId(follower.getId(), followed.getId())
                .ifPresent(v -> {
                    throw new ResourceAlreadyExistsException("Follow already exists");
                });
        followRepository.add(new Follow(follower, followed, LocalDate.now()));
    }

    @Override
    public List<UserDto> searchFollowersByUser(int idUser) {
        //TO-DO verificar que el usuario que dejamos de seguir exista
        List<User> listFollowers = followRepository.findFollowersById(idUser);
        return listFollowers
                .stream()
                .map(follower -> {
                    UserDto userDto = new UserDto();
                    userDto.setId(follower.getId());
                    userDto.setUsername(follower.getUsername());
                    return userDto;
                })
                .toList();
    }

    @Override
    public List<User> searchFollowedByUser(Integer userId) {
        return followRepository.findFollowedsById(userId);
    }

    @Override
    public ResponseDto deleteFollow(Integer followerId, Integer followedId) {
        Follow follow = followRepository
                .findByFollowerIdAndFollowedId(followerId, followedId)
                .orElseThrow(() -> new EntityNotFoundException("Follow does not found"));
        followRepository.delete(follow);
        return new ResponseDto("User: " + followerId + " successfully stopped following: " + followedId);
    }

    @Override
    public int countFollowers(User user) {
        //TO-DO verificar que la cantidad de seguidores es la correcta
        Integer userId = user.getId();
        return followRepository.countFollowersById(userId);
    }

    @Override
    public List<UserDto> searchFollowersByUserAndOrderDesc(Integer userId) {
        return followRepository
            .searchFollowersByUserAndOrderDesc(userId)
            .stream()
            .map(follower -> {
                UserDto followerDto = new UserDto();
                followerDto.setId(follower.getId());
                followerDto.setUsername(follower.getUsername());
                return followerDto;
            })
            .toList();
    }

    @Override
    public List<User> searchFollowedByUserOrder(Integer idUser, OrderType order) {
        //TO-DO Verificar correcto ordenamiento

        if(order.equals(OrderType.name_asc)){
            return followRepository.findFollowedsByIdAsc(idUser);
        }

        return followRepository.findFollowedsByIdDesc(idUser);
    }

    @Override
    public List<UserDto> searchFollowersByUserAndOrderAsc(Integer userId) {
        //TO-DO Verificar correcto ordenamiento
        return followRepository
            .searchFollowersByUserAndOrderAsc(userId)
            .stream()
            .map(follower -> {
                UserDto followerDto = new UserDto();
                followerDto.setId(follower.getId());
                followerDto.setUsername(follower.getUsername());
                return followerDto;
            })
            .toList();
    }


}
