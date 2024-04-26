package com.javabootcamp.socialmeli.repository;

import java.util.List;

import com.javabootcamp.socialmeli.model.Post;

public interface PostRepository {
    /**
     * Método que permite guardar de forma volatil una publicacion
     * @param post publicacion a guardar
     */
    void add(Post post);
    List<Post> findByTwoWeeksAgo(List<Integer> sellersId);
    List<Post> findByTwoWeeksAgoOrderAsc(List<Integer> sellersId);
    List<Post> findByTwoWeeksAgoOrderDesc(List<Integer> sellersId);
    /**
     * Método que permite contar la cantidad de publicaciones en promo de un vendedor
     * @param userId Id del vendedor
     * @return Cantidad de publicaciones en promo de un vendedor
     */
    Integer countPromosByUser(Integer userId);
    List<Post> findPostWithPromoBySellerId(Integer userId);
}
