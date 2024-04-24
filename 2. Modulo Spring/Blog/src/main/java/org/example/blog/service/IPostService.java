package org.example.blog.service;

import org.example.blog.dto.PostDto;
import org.example.blog.dto.PostEntryDto;

import java.util.List;

public interface IPostService {
    String addNewPost(PostEntryDto entry);
    List<PostEntryDto> getAllPosts();
    PostEntryDto getPostById(int id);
}
