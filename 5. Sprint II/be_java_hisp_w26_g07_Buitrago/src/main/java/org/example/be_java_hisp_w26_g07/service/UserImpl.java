package org.example.be_java_hisp_w26_g07.service;

import org.example.be_java_hisp_w26_g07.dto.SuccessResponseDto;
import org.example.be_java_hisp_w26_g07.dto.users.CountFollowersResponseDto;
import org.example.be_java_hisp_w26_g07.dto.users.FollowedResponseDto;
import org.example.be_java_hisp_w26_g07.dto.users.FollowersResponseDto;
import org.example.be_java_hisp_w26_g07.dto.users.UserInfoFollowsDto;
import org.example.be_java_hisp_w26_g07.entity.User;
import org.example.be_java_hisp_w26_g07.exception.BadRequestException;
import org.example.be_java_hisp_w26_g07.exception.NotAcceptable;
import org.example.be_java_hisp_w26_g07.exception.NotFoundException;
import org.example.be_java_hisp_w26_g07.repository.interfaces.IUserRepository;
import org.example.be_java_hisp_w26_g07.service.interfaces.IUserService;
import org.example.be_java_hisp_w26_g07.utils.UserMessageError;
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

    /**
     * US 0001
     * Servicio: funcion usada para que un usuario pueda seguir a un vendedor
     *
     * @param userId   usuario
     * @param sellerId vendedor a seguir
     */
    @Override
    public Boolean userFollowSeller(Integer userId, Integer sellerId) {
        User seller = iUserRepository.findById(sellerId);
        User follower = iUserRepository.findById(userId);
        if (userId.equals(sellerId))
            throw new BadRequestException(UserMessageError.ID_CLIENT_SELLER_IS_EQUALS.getMessage());
        if (seller == null) throw new BadRequestException(UserMessageError.SELLER_NOT_FOUND.getMessage(sellerId));
        if (follower == null) throw new BadRequestException(UserMessageError.USER_NOT_FOUND.getMessage(userId));
        if (!seller.getIsSeller()) throw new BadRequestException(UserMessageError.CLIENT_IS_NOT_SELLER.getMessage());
        if (iUserRepository.userFollowSeller(userId, sellerId)) return false;
        iUserRepository.addFollowerById(userId, sellerId);
        return true;
    }

    /**
     * US 0002
     * Servicio: Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
     *
     * @param userId usuario
     */
    @Override
    public CountFollowersResponseDto getNumberOfSellersFollowed(Integer userId) {
        User user = iUserRepository.findById(userId);
        if (user == null) throw new NotFoundException(UserMessageError.USER_NOT_FOUND.getMessage(userId));
        if (!user.getIsSeller()) throw new NotAcceptable(UserMessageError.CLIENT_IS_NOT_SELLER.getMessage());
        return new CountFollowersResponseDto(user.getId(), user.getName(), user.getFollowerIds().size());
    }

    /**
     * US 0003
     * Servicio: Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?)
     *
     * @param userId usuario
     * @param order  tipo de orden (opcional)
     */
    @Override
    public FollowersResponseDto findFollowersByOrder(Integer userId, String order) {
        User seller = iUserRepository.findById(userId);
        if (!UserUtils.orderValidation(order)) throw new NotFoundException(UserMessageError.LIST_CLIENTE_ORDER.getMessage(userId));
        if (seller == null) throw new NotFoundException(UserMessageError.SELLER_NOT_FOUND.getMessage(userId));
        if (!seller.getIsSeller()) throw new BadRequestException(UserMessageError.CLIENT_IS_NOT_SELLER.getMessage());
        List<UserInfoFollowsDto> userInfoFollowsDto = getUserInfoFollowers(seller.getFollowerIds());
        return new FollowersResponseDto(seller.getId(), seller.getName(), UserUtils.getUserInfoFollowsDtoByOrder(userInfoFollowsDto, order));
    }

    /**
     * US 0004
     * Controlador: Obtener  un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?)
     *
     * @param id    usuario
     * @param order tipo de orden (opcional)
     */
    @Override
    public FollowedResponseDto findFollowedUsers(Integer id, String order) {
        User user = iUserRepository.findById(id);
        if (user == null) throw new NotFoundException(UserMessageError.SELLER_NOT_FOUND.getMessage(id));
        List<UserInfoFollowsDto> userInfoFollowsDtos = user.getFollowedIds().stream().map(followedId -> {
            User current = iUserRepository.findById(followedId);
            return new UserInfoFollowsDto(current.getId(), current.getName());
        }).toList();
        return new FollowedResponseDto(id, user.getName(), UserUtils.getUserInfoFollowsDtoByOrder(userInfoFollowsDtos, order));
    }

    /**
     * US 0007
     * servicio: Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
     *
     * @param userId           usuario
     * @param userIdToUnfollow vendedor para dejar de seguir
     */
    @Override
    public SuccessResponseDto unfollow(Integer userId, Integer userIdToUnfollow) {
        User followerUser = iUserRepository.findById(userId);
        User sellerUser = iUserRepository.findById(userIdToUnfollow);
        if (followerUser == null) throw new BadRequestException(UserMessageError.USER_NOT_FOUND.getMessage(userId));
        if (sellerUser == null)
            throw new BadRequestException(UserMessageError.SELLER_NOT_FOUND.getMessage(userIdToUnfollow));
        boolean followDeleted = iUserRepository.unfollow(followerUser, sellerUser);
        if (!followDeleted) {
            throw new BadRequestException("No se pudo completar la acción");
        }
        return new SuccessResponseDto("Se ha dejado de seguir al usuario");
    }


    private List<UserInfoFollowsDto> getUserInfoFollowers(List<Integer> usersId) {
        List<UserInfoFollowsDto> followers = new ArrayList<>();
        for (Integer userIdToFind : usersId) {
            User follower = iUserRepository.findById(userIdToFind);
            followers.add(new UserInfoFollowsDto(follower.getId(), follower.getName()));
        }
        return followers;
    }
}
