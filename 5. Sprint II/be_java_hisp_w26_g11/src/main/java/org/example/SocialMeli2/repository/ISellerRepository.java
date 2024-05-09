package org.example.SocialMeli2.repository;

import org.example.SocialMeli2.entity.Post;
import org.example.SocialMeli2.entity.Seller;

import java.util.List;
import java.util.Map;

/**
 * Interfaz para el repositorio de vendedores.
 */
public interface ISellerRepository {

    /**
     * Obtiene un vendedor por su ID.
     *
     * @param id El ID del vendedor.
     * @return El vendedor si se encuentra, o null si no se encuentra.
     */
    Seller getSellerById(int id);

    /**
     * Encuentra los posts de los vendedores seguidos.
     *
     * @param sellers La lista de IDs de los vendedores.
     * @return Un mapa con los IDs de los vendedores y sus posts.
     */
    Map<Integer, List<Post>> findPostsByFollowing(List<Integer> sellers);

    /**
     * Permite a un usuario seguir a un vendedor.
     *
     * @param userId El ID del usuario que quiere seguir al vendedor.
     * @param userIdToFollow El ID del vendedor a seguir.
     * @return Verdadero si el usuario pudo seguir al vendedor, falso en caso contrario.
     */
    boolean userIdToFollowSeller(int userId, int userIdToFollow);

    /**
     * Verifica si existe un producto con el ID proporcionado.
     *
     * @param id El ID del producto.
     * @return Verdadero si el producto existe, falso en caso contrario.
     */
    boolean productIdExists(int id);

    /**
     * Verifica si existe un post con el ID proporcionado.
     *
     * @param id El ID del post.
     * @return Verdadero si el post existe, falso en caso contrario.
     */
    boolean postIdExist(int id);

    /**
     * Obtiene una lista de todos los vendedores.
     *
     * @return Una lista de vendedores.
     */
    List<Seller> getSellersList();

    /**
     * Obtiene una lista de vendedores que son seguidos por un usuario específico.
     *
     * @param userId El ID del usuario.
     * @return Una lista de vendedores que son seguidos por el usuario.
     */
    List<Seller> getCustomersThatFollowsSellersById(int userId);
}
