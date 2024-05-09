package org.example.SocialMeli2.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entidad para un Vendedor.
 * Esta entidad se utiliza para representar la información de un vendedor en el sistema.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"sellerId", "sellerName", "posts", "followers"})
public class Seller {
    /**
     * El ID del vendedor.
     */
    @JsonProperty("seller_id")
    private int sellerId;

    /**
     * El nombre del vendedor.
     */
    @JsonProperty("seller_name")
    private String sellerName;

    /**
     * La lista de posts del vendedor.
     * Cada post en la lista es representado como una entidad Post.
     */
    private List<Post> posts;

    /**
     * La lista de IDs de los seguidores del vendedor.
     */
    private List<Integer> followers;

    /**
     * Método para agregar un post a la lista de posts del vendedor.
     * @param post El post a agregar.
     */
    public void addPost(Post post){
        posts.add(post);
    }

    /**
     * Método para verificar si un producto ya existe en los posts del vendedor.
     * @param id El ID del producto a verificar.
     * @return Verdadero si el producto ya existe, falso en caso contrario.
     */
    public boolean productIdExists(int id){
        return posts.stream().anyMatch(post -> post.getProduct().getProductId() == id);
    }

    /**
     * Método para agregar un seguidor a la lista de seguidores del vendedor.
     * @param id El ID del seguidor a agregar.
     */
    public void addFollowers(int id){
        followers.add(id);
    }
}
