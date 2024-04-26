package org.example.be_java_hisp_w26_g07.service.interfaces;

import org.example.be_java_hisp_w26_g07.dto.*;

import java.util.List;

public interface IProductService {
    List<PostDto> findProductByFollow(Integer userID, String order);
    PostDto createPost(PostRequestDto postRequestDto);
    PostPromoResponseDto createPostWithPromo(PostPromoRequestDto postPromoRequestDto);
    PromoPostCountResponseDto getPromoCountByUser(Integer id);
    List<ProductResponseDto> findProductsWithDiscountByFollowers(Double discount, Integer userID);
    List<ProductResponseDto> findProductsWithDiscount(Double discount);
    List<ProductResponseDto> findProductsByNameProduct(String name);
    List<ProductResponseDto>  findProductsWithDiscountBySeller(Integer sellerId);
}
