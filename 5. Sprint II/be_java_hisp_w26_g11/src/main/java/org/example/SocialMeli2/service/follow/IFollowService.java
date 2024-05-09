package org.example.SocialMeli2.service.follow;

import org.example.SocialMeli2.dto.CountFollowersDTO;
import org.example.SocialMeli2.dto.SellerFollowerDto;
import org.example.SocialMeli2.dto.FollowedSellersDTO;

/**
 * Interfaz para el servicio de seguimiento entre usuarios.
 */
public interface IFollowService {

    /**
     * Permite a un usuario seguir a otro.
     *
     * @param userId El ID del usuario que quiere seguir a otro.
     * @param userIdToFollow El ID del usuario a seguir.
     */
    void userIdToFollow(int userId,int userIdToFollow);

    /**
     * Obtiene el conteo de seguidores de un usuario.
     *
     * @param sellerId El ID del usuario.
     * @return Un objeto CountFollowersDTO que contiene el conteo de seguidores.
     */
    CountFollowersDTO countFollowers(Integer sellerId);

    /**
     * Permite a un usuario dejar de seguir a otro.
     *
     * @param userId El ID del usuario que quiere dejar de seguir a otro.
     * @param userIdToUnfollow El ID del usuario a dejar de seguir.
     */
    void unfollowSeller(Integer userId, Integer userIdToUnfollow);

    /**
     * Obtiene la lista de seguidores de un usuario.
     *
     * @param userId El ID del usuario.
     * @param order El orden en el que se desea obtener la lista.
     * @return Un objeto SellerFollowerDto que contiene la lista de seguidores.
     */
    SellerFollowerDto getSellerFollowers(int userId, String order);

    /**
     * Obtiene la lista de usuarios seguidos por un usuario.
     *
     * @param userId El ID del usuario.
     * @param order El orden en el que se desea obtener la lista.
     * @return Un objeto FollowedSellersDTO que contiene la lista de usuarios seguidos.
     */
    FollowedSellersDTO getFollowedSellers(int userId, String order);
}
