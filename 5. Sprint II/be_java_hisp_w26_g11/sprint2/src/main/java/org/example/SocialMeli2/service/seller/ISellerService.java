package org.example.SocialMeli2.service.seller;

import org.example.SocialMeli2.dto.RequestPostDTO;
import org.example.SocialMeli2.dto.ResponsePostDTO;
import org.example.SocialMeli2.entity.Post;
import org.example.SocialMeli2.entity.Seller;

import java.util.List;

/**
 * Interfaz para el servicio de vendedor.
 */
public interface ISellerService {

    /**
     * Agrega un nuevo post.
     *
     * @param postDTO El DTO del post a agregar.
     * @return El post agregado.
     */
    Post addPost(RequestPostDTO postDTO);

    /**
     * Obtiene una lista de todos los vendedores.
     *
     * @return Una lista de vendedores.
     */
    List<Seller> getSellers();

    /**
     * Obtiene los posts de los vendedores seguidos que tienen menos de dos semanas de antigüedad.
     *
     * @param userId El ID del usuario.
     * @param order El orden en el que se desea obtener los posts.
     * @return Un DTO con la respuesta de los posts.
     */
    ResponsePostDTO getPostsFromFollowingWithTwoWeeksOld(int userId, String order);
}
