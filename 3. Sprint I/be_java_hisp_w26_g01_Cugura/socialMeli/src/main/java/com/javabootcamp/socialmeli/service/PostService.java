package com.javabootcamp.socialmeli.service;

import com.javabootcamp.socialmeli.dto.PostDto;
import com.javabootcamp.socialmeli.dto.PromoPostDto;
import com.javabootcamp.socialmeli.dto.SellerCountPromoDto;
import com.javabootcamp.socialmeli.dto.SellerWithPromoPostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findByTwoWeeksAgo(List<Integer> sellersId);
    void addPost(PostDto postDto);

    List<PostDto> findByTwoWeeksAgoOrderAsc(List<Integer> sellersId);

    List<PostDto> findByTwoWeeksAgoOrderDesc(List<Integer> sellersId);
    /**
     * Método que da tratamiento a la adición de una publicación en promoción
     * @param promoPostDto La publicación a ser cargada
     */
    void addPostWithPromo(PromoPostDto promoPostDto);
    /**
     * Método que da tratamiento a la búsqueda de la cantidad de publicaciones en promoción
     * de un vendedor a partir de su id
     * @param userId id del vendedor
     * @return  SellerPromoDto. Objeto que representa un objeto que contiene los datos básicos del vendedor
     * junto a la cantidad de publicaciones en promo asociadas
     */
    SellerCountPromoDto countPromoPostBySeller(Integer userId);
    SellerWithPromoPostDto searchAllPromoPostBySeller(Integer userId);
}
