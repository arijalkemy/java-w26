package org.example.be_java_hisp_w26_g07.service.interfaces;

import org.example.be_java_hisp_w26_g07.dto.PostDto;
import org.example.be_java_hisp_w26_g07.dto.PostRequestDto;
import org.example.be_java_hisp_w26_g07.dto.PromoPostCountDto;
import org.example.be_java_hisp_w26_g07.dto.PromoPostDto;

import java.util.List;

public interface IProductService {
    List<PostDto> findProductByFollow(Integer userID, String order);
    PostDto createPost(PostRequestDto postRequestDto);
    boolean createNewPromoPost(PromoPostDto promoPostDto);
    PromoPostCountDto getPromoPostCount(Integer userId);

}
