package com.example.sprint1.service;

import com.example.sprint1.dto.PostDto;
import com.example.sprint1.dto.PostForListDto;
import com.example.sprint1.dto.PostPromoDto;
import com.example.sprint1.dto.PromoCountResponseDto;
import com.example.sprint1.model.Post;
import java.util.List;

public interface IPostService {
    PostDto addPost(PostDto postDto) throws IllegalArgumentException;

    List<Post> findAll();

    Post findById(int id);

    List<PostForListDto> followedList(Integer userId, String order);

    PostPromoDto postPromo(PostPromoDto postPromoDto);

    PromoCountResponseDto quantityPromo(Integer user_id);

}
