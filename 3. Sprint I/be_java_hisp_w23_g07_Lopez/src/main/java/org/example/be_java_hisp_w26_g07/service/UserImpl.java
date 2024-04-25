package org.example.be_java_hisp_w26_g07.service;

import org.example.be_java_hisp_w26_g07.dto.*;
import org.example.be_java_hisp_w26_g07.entity.User;
import org.example.be_java_hisp_w26_g07.exception.BadRequestException;
import org.example.be_java_hisp_w26_g07.exception.NotAcceptable;
import org.example.be_java_hisp_w26_g07.exception.NotFoundException;
import org.example.be_java_hisp_w26_g07.repository.interfaces.IUserRepository;
import org.example.be_java_hisp_w26_g07.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserImpl implements IUserService {
    private final IUserRepository iUserRepository;

    public UserImpl(@Autowired IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    /**
     * funcion usada para que un usuario pueda seguir a un vendedor
     *
     * @param userId   usuario
     * @param sellerId vendedor a seguir
     */
    @Override
    public Boolean userFollowSeller(Integer userId, Integer sellerId) {
        User seller = iUserRepository.findById(sellerId);
        User follower = iUserRepository.findById(userId);
        if (userId.equals(sellerId)) {
            throw new BadRequestException("El id del usuario no puede ser igual al vendedor");
        }
        if (seller == null || follower == null) {
            throw new BadRequestException("El usuario o vendedor no existe");
        }
        if (!seller.getIsSeller()) {
            throw new BadRequestException("El usuario a seguir con el id " + sellerId + " no es vendedor");
        }
        if (iUserRepository.userFollowSeller(userId, sellerId)) {
            return false;
        }
        iUserRepository.addFollowerById(userId, sellerId);
        return true;
    }

    @Override
    public FollowedResponseDto findFollowedUsers(Integer id, String order) {
        User user = iUserRepository.findById(id);
        Stream<UserInfoFollowsDto> userInfoFollowsDtos = user.getFollowedIds().stream()
                .map(followedId -> iUserRepository.findById(followedId))
                .map(followedUser -> new UserInfoFollowsDto(followedUser.getId(), followedUser.getName()));
        List<UserInfoFollowsDto> list;
        if (order.equals("name_desc")) {
            list = userInfoFollowsDtos.sorted(Comparator.comparing(UserInfoFollowsDto::getName).reversed())
                    .collect(Collectors.toList());

        } else {
            list = userInfoFollowsDtos.sorted(Comparator.comparing(UserInfoFollowsDto::getName))
                    .collect(Collectors.toList());
        }


        return new FollowedResponseDto(id, user.getName(), list);

    }

    @Override
    public FollowersResponseDto findFollowersByOrder(Integer userId, String order) {
        User seller = iUserRepository.findById(userId);

        if (seller == null) throw new NotFoundException("Vendedor no encontrado");
        if (!seller.getIsSeller()) throw new BadRequestException("El usuario no es un vendedor");

        FollowersResponseDto followersResponseDto = new FollowersResponseDto();

        List<UserInfoFollowsDto> userInfoFollowsDto = getUserInfoFollowers(seller.getFollowedIds());
        getUserInfoFollowsDtoByOrder(userInfoFollowsDto, order);
        followersResponseDto.setFollowers(userInfoFollowsDto);
        followersResponseDto.setId(seller.getId());
        followersResponseDto.setName(seller.getName());

        return followersResponseDto;
    }

    @Override
    public CountFollowersResponseDto getNumberOfSellersFollowed(String userId) {
        if (!userId.matches("\\d+")) {
            throw new BadRequestException("El valor ingresado no es numérico");
        }
        User user = iUserRepository.findById(Integer.parseInt(userId));
        if (user == null) {
            throw new NotFoundException("Usuario no encontrado");
        }
        if (!user.getIsSeller()) {
            throw new NotAcceptable("Existe el usuario pero no es vendedor");
        }
        return new CountFollowersResponseDto(user.getId(), user.getName(), user.getFollowerIds().size());
    }

    private void getUserInfoFollowsDtoByOrder(List<UserInfoFollowsDto> userInfoFollowsDto,
                                              String order) {
        if (order == null) return;

        switch (order) {
            case "name_asc":
                userInfoFollowsDto.sort(Comparator.comparing(UserInfoFollowsDto::getName));
                break;
            case "name_desc":
                userInfoFollowsDto.sort(Comparator.comparing(UserInfoFollowsDto::getName).reversed());
                break;
            default:
        }

    }

    private List<UserInfoFollowsDto> getUserInfoFollowers(List<Integer> usersId) {
        List<UserInfoFollowsDto> followers = new ArrayList<>();
        for (Integer userIdToFind : usersId) {
            User follower = iUserRepository.findById(userIdToFind);
            UserInfoFollowsDto userInfoFollowsDto = new UserInfoFollowsDto(follower.getId(), follower.getName());
            followers.add(userInfoFollowsDto);
        }
        return followers;
    }

    @Override
    public SuccessResponseDto unfollow(Integer userId, Integer userIdToUnfollow) {
        User foundUser = iUserRepository.findById(userId);
        if (foundUser == null) {
            throw new NotFoundException("El usuario no fue encontrado");
        }
        boolean followDeleted = iUserRepository.unfollow(foundUser, userIdToUnfollow);
        if (!followDeleted) {
            throw new BadRequestException("No se encontró el usuario para dejar de seguir");
        }
        return new SuccessResponseDto("Se ha dejado de seguir al usuario");
    }
}
