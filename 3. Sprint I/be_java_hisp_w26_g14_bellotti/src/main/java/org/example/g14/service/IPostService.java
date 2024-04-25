package org.example.g14.service;

import org.example.g14.dto.CreatePostDto;
import org.example.g14.dto.PostDto;
import org.example.g14.dto.UserWithPostPromoCount;

import java.util.List;

public interface IPostService {
    void add(CreatePostDto createPostDto);
    void addWithPromo(CreatePostDto createPostDto);
    List<PostDto> getPostsFromFollowed(int userId, String order);
    UserWithPostPromoCount getCountOfPromo(int userId);
    PostDto putToPromo(int userId, int postId);

}
