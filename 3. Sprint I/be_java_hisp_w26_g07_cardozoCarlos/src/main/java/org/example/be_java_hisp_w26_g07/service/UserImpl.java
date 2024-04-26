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
        if (user == null) throw new NotFoundException("El usuario no existe");
        List<UserInfoFollowsDto> userInfoFollowsDtos = user.getFollowedIds().stream()
                .map(followedId -> {
                    User currentUser = iUserRepository.findById(followedId);
                    return new UserInfoFollowsDto(currentUser.getId(), currentUser.getName());
                }).toList();
        return new FollowedResponseDto(id, user.getName(), getUserInfoFollowsDtoByOrder(userInfoFollowsDtos, order));
    }

    @Override
    public FollowersResponseDto findFollowersByOrder(Integer userId, String order) {
        User seller = iUserRepository.findById(userId);

        if (seller == null) throw new NotFoundException("Vendedor no encontrado");
        if (!seller.getIsSeller()) throw new BadRequestException("El usuario no es un vendedor");


        List<UserInfoFollowsDto> userInfoFollowsDto = getUserInfoFollowers(seller.getFollowerIds());
        userInfoFollowsDto = getUserInfoFollowsDtoByOrder(userInfoFollowsDto, order);


        return new FollowersResponseDto(seller.getId(), seller.getName(),
                userInfoFollowsDto);
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

    private List<UserInfoFollowsDto> getUserInfoFollowsDtoByOrder(List<UserInfoFollowsDto> userInfoFollowsDto,
                                              String order) {
        if (order == null) return userInfoFollowsDto;

        return switch (order) {
            case "name_asc" ->
                    userInfoFollowsDto.stream().sorted(Comparator.comparing(UserInfoFollowsDto::getName)).toList();
            case "name_desc" ->
                    userInfoFollowsDto.stream().sorted(Comparator.comparing(UserInfoFollowsDto::getName).reversed())
                            .toList();
            default -> userInfoFollowsDto;
        };

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

    @Override
    public List<UserDistanceResponeDto> findUsersByKm(Integer userId, Integer distance) {
        List<User> userList = iUserRepository.findAll();
        User user = iUserRepository.findById(userId);
        if(user == null) throw new NotFoundException("Usuario no encontrado");
        List<UserDistanceResponeDto> userDistanceResponeDtoList = new ArrayList<>();
        userList = userList.stream().filter(u-> calculateDistanceKm(u.getLocation().getLatitud(),
                u.getLocation().getLongitud(), user.getLocation().getLatitud(), user.getLocation().getLongitud())
                <= distance && u.getId() != userId && u.getIsSeller()).toList();
        userDistanceResponeDtoList = userList.stream().map(u-> {
            return new UserDistanceResponeDto(u.getId(),u.getName(), String.format("%.2f",calculateDistanceKm(u.getLocation().getLatitud(),
                    u.getLocation().getLongitud(), user.getLocation().getLatitud(), user.getLocation().getLongitud())),u.getPosts());
        }).toList();
        if(userDistanceResponeDtoList.isEmpty()) throw new NotFoundException("No se encontraron usuarios cercanos");
        return userDistanceResponeDtoList;
    }

    private double haversine(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }

    private double calculateDistanceKm(double startLat, double startLong, double endLat, double endLong) {
        final int EARTH_RADIUS = 6371;
        double disLat = Math.toRadians((endLat - startLat));
        double disLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat = Math.toRadians(endLat);

        double a = haversine(disLat) + Math.cos(startLat) * Math.cos(endLat) * haversine(disLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
}
