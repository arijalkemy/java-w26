package org.example.be_java_hisp_w26_g07.service.interfaces;

import org.example.be_java_hisp_w26_g07.dto.*;

import java.util.List;

public interface IProductService {
    List<PostDto> findProductByFollow(Integer userID, String order);
    PostDto createPost(PostRequestDto postRequestDto);
    PostDtoPromo createPostPromo(PostRequestDto postRequestDto);
    PostDtoPromoCount getPromoPostCount(Integer userID);

    List<PostDto> getPromoPostList(Integer userId, String order);
}
