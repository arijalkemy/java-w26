package org.example.g14.service;

import org.example.g14.dto.CreatePostDto;
import org.example.g14.dto.PostDto;
import org.example.g14.dto.UserResumeDto;
import org.example.g14.dto.UserWithPromoPostsCountDto;

import java.util.List;

public interface IPostService {
    void add(CreatePostDto createPostDto);

    List<PostDto> getPostsFromFollowed(int userId, String order);

    void createPostWithPromo(CreatePostDto postWithPromo);

    UserWithPromoPostsCountDto getNumberOfPromoPost(int userId);
    UserResumeDto getResume(int userId);
}
