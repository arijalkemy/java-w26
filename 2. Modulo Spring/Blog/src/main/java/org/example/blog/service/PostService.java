package org.example.blog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.blog.dto.PostDto;
import org.example.blog.dto.PostEntryDto;
import org.example.blog.entity.EntradaBlog;
import org.example.blog.exception.BadRequestException;
import org.example.blog.repository.IPostRepository;
import org.example.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostService implements IPostService {
    @Autowired
    IPostRepository postRepository;

    @Override
    public List<PostEntryDto> getAllPosts() {
        ObjectMapper mapper = new ObjectMapper();
        return postRepository.getAllPosts().stream()
                .map(v -> mapper.convertValue(v, PostEntryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostEntryDto getPostById(int id) {
        ObjectMapper mapper = new ObjectMapper();

        EntradaBlog post = postRepository.getPostById(id);

        if (post != null) {
            return mapper.convertValue(post, PostEntryDto.class);
        }
        throw new BadRequestException("Post not found");
    }

    @Override
    public String addNewPost(PostEntryDto entry) {
        return postRepository.addNewPost(entry);
    }
}
