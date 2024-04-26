package org.example.be_java_hisp_w26_g07.service.interfaces;

import org.example.be_java_hisp_w26_g07.dto.CountPromoResponseDto;
import org.example.be_java_hisp_w26_g07.dto.PostDto;
import org.example.be_java_hisp_w26_g07.dto.PostRequestDto;
import org.example.be_java_hisp_w26_g07.dto.PromoRequestDto;

import java.util.List;

public interface IProductService {
    List<PostDto> findProductByFollow(Integer userID, String order);

    PostDto createPost(PostRequestDto postRequestDto);

    void createPromoPost(PromoRequestDto promoRequestDto);

    public CountPromoResponseDto getNumberOfPromotions(String userId);

    public List<PostDto> getPromotions(String userId);

    public List<PostDto> getPosts(String userId);

    public List<PostDto> getAllProducts();

    public List<PostDto> getProductsFilteredByColor(String color);

    public List<PostDto> getProductsFilteredByCategory(String category);

    public List<PostDto> getProductsWithAPriceLowerThan(String price);

    public List<PostDto> getProductsWithPricesBetween(String since, String to);

    public List<PostDto> getDiscountedProductsFrom(String discount);


}
