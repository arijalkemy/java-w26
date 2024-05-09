package org.example.SocialMeli2.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.example.SocialMeli2.entity.Post;
import org.example.SocialMeli2.entity.Seller;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

/**
 * Implementación del repositorio de vendedores.
 */
@Data
@Repository
public class SellerRepository implements ISellerRepository {
    private List<Seller> sellersList = new ArrayList<>();

    /**
     * Constructor que carga los vendedores desde un archivo JSON.
     *
     * @throws IOException si hay un error al leer el archivo.
     */
    public SellerRepository() throws IOException {
        loadSellers();
    }

    /**
     * Carga los vendedores desde un archivo JSON.
     *
     * @throws IOException si hay un error al leer el archivo.
     */
    private void loadSellers() throws IOException {
        File file = ResourceUtils.getFile("classpath:sellers.json");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        sellersList.addAll(objectMapper.readValue(file, new TypeReference<List<Seller>>() {
        }));
    }

    /**
     * Obtiene una lista de todos los vendedores.
     *
     * @return Una lista de vendedores.
     */
    @Override
    public List<Seller> getSellersList() {
        return sellersList;
    }

    /**
     * Verifica si existe un producto con el ID proporcionado.
     *
     * @param id El ID del producto.
     * @return Verdadero si el producto existe, falso en caso contrario.
     */
    @Override
    public boolean productIdExists(int id) {
        return sellersList.stream()
                .anyMatch(seller -> seller.productIdExists(id));
    }

    /**
     * Obtiene un vendedor por su ID.
     *
     * @param id El ID del vendedor.
     * @return El vendedor si se encuentra, o null si no se encuentra.
     */
    @Override
    public Seller getSellerById(int id) {
        return sellersList.stream().filter(v -> v.getSellerId() == id ).findFirst().orElse(null);
    }

    /**
     * Verifica si existe un post con el ID proporcionado.
     *
     * @param id El ID del post.
     * @return Verdadero si el post existe, falso en caso contrario.
     */
    @Override
    public boolean postIdExist(int id) {
        return sellersList.stream().anyMatch(seller -> seller.getPosts()
                .stream().anyMatch(post -> post.getPostId() == id));
    }

    /**
     * Permite a un usuario seguir a un vendedor.
     *
     * @param userId El ID del usuario que quiere seguir al vendedor.
     * @param userIdToFollow El ID del vendedor a seguir.
     * @return Verdadero si el usuario pudo seguir al vendedor, falso en caso contrario.
     */
    @Override
    public boolean userIdToFollowSeller(int userId, int userIdToFollow) {
        //se busca el id
        Seller seller = sellersList.stream().filter(value -> value.getSellerId() == userIdToFollow)
                .findFirst().orElse(null);

        //regresa true si se encuentra id
        if(seller == null) return true;

        //se agrega id
        seller.addFollowers(userId);

        return false;
    }

    /**
     * Encuentra los posts de los vendedores seguidos.
     *
     * @param sellers La lista de IDs de los vendedores.
     * @return Un mapa con los IDs de los vendedores y sus posts.
     */
    @Override
    public Map<Integer, List<Post>> findPostsByFollowing(List<Integer> sellers) {
        List<Seller> sellersMatch = new ArrayList<>();
        Map<Integer, List<Post>> postsMatch = new HashMap<>();

        // Obtenemos cada seller que el customer sigue
        for (Integer sellerId : sellers) {
            sellersMatch.add(getSellerById(sellerId));
        }

        // Agregamos a una lista todos los post que cumplen con las especificaciones
        for(Seller seller : sellersMatch) {
            postsMatch.put(
                    seller.getSellerId(),
                    findPostsWithTwoWeeksOld(seller.getPosts())
            );
        }

        return postsMatch;
    }

    /**
     * Filtra los posts que tienen menos de dos semanas de antigüedad.
     *
     * @param posts La lista de posts a filtrar.
     * @return Una lista de posts que tienen menos de dos semanas de antigüedad.
     */
    private List<Post> findPostsWithTwoWeeksOld(List<Post> posts) {
        // Obtener la fecha de hace dos semanas y la actual
        LocalDate twoWeeksBefore = LocalDate.now().minusWeeks(2);
        LocalDate currentDate = LocalDate.now();

        // Retorna todos los post del seller que hayan sido publicados en las
        // últimas dos semanas
        return posts.stream()
                .filter(post ->
                    (post.getDate().isAfter(twoWeeksBefore) ||
                    post.getDate().isEqual(twoWeeksBefore)) &&
                    (post.getDate().isBefore(currentDate) ||
                    post.getDate().isEqual(currentDate))
                )
                .toList();
    }

    /**
     * Obtiene una lista de vendedores que son seguidos por un usuario específico.
     *
     * @param id El ID del usuario.
     * @return Una lista de vendedores que son seguidos por el usuario.
     */
    @Override
    public List<Seller> getCustomersThatFollowsSellersById(int id) {
        return  sellersList.stream()
                .filter( v -> v.getFollowers().contains(id))
                .toList();
    }
}
