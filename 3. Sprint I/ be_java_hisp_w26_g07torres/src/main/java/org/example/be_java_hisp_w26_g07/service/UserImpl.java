package org.example.be_java_hisp_w26_g07.service;

import org.example.be_java_hisp_w26_g07.dto.*;
import org.example.be_java_hisp_w26_g07.entity.User;
import org.example.be_java_hisp_w26_g07.exception.BadRequestException;
import org.example.be_java_hisp_w26_g07.exception.NotAcceptable;
import org.example.be_java_hisp_w26_g07.exception.NotFoundException;
import org.example.be_java_hisp_w26_g07.repository.interfaces.IUserRepository;
import org.example.be_java_hisp_w26_g07.service.interfaces.IUserService;
import org.example.be_java_hisp_w26_g07.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserImpl implements IUserService {
    private final IUserRepository iUserRepository;

    public UserImpl(@Autowired IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    private List<UserInfoFollowsDto> getUserInfoFollowers(List<Integer> usersId) {
        List<UserInfoFollowsDto> followers = new ArrayList<>();
        for (Integer userIdToFind : usersId) {
            User follower = iUserRepository.findById(userIdToFind);
            followers.add(new UserInfoFollowsDto(follower.getId(), follower.getName()));
        }
        return followers;
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
        if (userId.equals(sellerId)) throw new BadRequestException("El id del usuario no puede ser igual al vendedor");
        if (seller == null || follower == null) throw new BadRequestException("El usuario o vendedor no existe");
        if (!seller.getIsSeller()) {
            throw new BadRequestException("El usuario a seguir con el id " + sellerId + " no es vendedor");
        }
        if (iUserRepository.userFollowSeller(userId, sellerId)) return false;
        iUserRepository.addFollowerById(userId, sellerId);
        return true;
    }

    @Override
    public FollowedResponseDto findFollowedUsers(Integer id, String order) {
        User user = iUserRepository.findById(id);
        if (user == null) throw new NotFoundException("Vendedor no encontrado");
        List<UserInfoFollowsDto> userInfoFollowsDtos = user.getFollowedIds()
                .stream()
                .map(followedId -> {
                    User current = iUserRepository.findById(followedId);
                    return new UserInfoFollowsDto(current.getId(), current.getName());
                }).toList();
        UserUtils.getUserInfoFollowsDtoByOrder(userInfoFollowsDtos, order);
        return new FollowedResponseDto(id, user.getName(), userInfoFollowsDtos);
    }

    @Override
    public FollowersResponseDto findFollowersByOrder(Integer userId, String order) {
        User seller = iUserRepository.findById(userId);
        if (seller == null) throw new NotFoundException("Vendedor no encontrado");
        if (!seller.getIsSeller()) throw new BadRequestException("El usuario no es un vendedor");
        List<UserInfoFollowsDto> userInfoFollowsDto = getUserInfoFollowers(seller.getFollowerIds());
        return new FollowersResponseDto(
                seller.getId(),
                seller.getName(),
                UserUtils.getUserInfoFollowsDtoByOrder(userInfoFollowsDto, order)
        );
    }

    @Override
    public CountFollowersResponseDto getNumberOfSellersFollowed(Integer userId) {
        User user = iUserRepository.findById(userId);
        if (user == null) throw new NotFoundException("Usuario no encontrado");
        if (!user.getIsSeller()) throw new NotAcceptable("Existe el usuario pero no es vendedor");
        return new CountFollowersResponseDto(user.getId(), user.getName(), user.getFollowerIds().size());
    }

    @Override
    public SuccessResponseDto unfollow(Integer userId, Integer userIdToUnfollow) {
        User followerUser = iUserRepository.findById(userId);
        User sellerUser = iUserRepository.findById(userIdToUnfollow);
        if (followerUser == null || sellerUser == null) {
            Integer idNotFound = followerUser == null ? userId : userIdToUnfollow;
            String errorMsg = String.format("El usuario con el id %s no fue encontrado", idNotFound);
            throw new NotFoundException(errorMsg);
        }
        boolean followDeleted = iUserRepository.unfollow(followerUser, sellerUser);
        if (!followDeleted) {
            throw new BadRequestException("No se pudo completar la acción");
        }
        return new SuccessResponseDto("Se ha dejado de seguir al usuario");
    }
}
