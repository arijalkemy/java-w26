package com.meli.be_java_hisp_w26_g09.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.be_java_hisp_w26_g09.entity.Post;
import com.meli.be_java_hisp_w26_g09.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PostRepositoryImplTest {

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private PostRepositoryImpl postRepository;

    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.initMocks(this);
        postRepository = new PostRepositoryImpl();

        objectMapper.registerModule(new JavaTimeModule());
        File file = ResourceUtils.getFile("classpath:posts_generated.json");
        List<Post> posts = new ArrayList<>();
        when(objectMapper.readValue(file, new TypeReference<List<Post>>() {})).thenReturn(posts);
    }

    @Test
    @DisplayName("Test createPost")
    void testCreatePost() {
        Post post = new Post();
        post.setUserId(1);
        post.setDate(LocalDate.now());
        post.setProduct(new Product());
        post.setCategory(1);
        post.setPrice(10.0);
        post.setHasPromo(false);
        post.setDiscount(0.0);

        postRepository.createPost(post);

        List<Post> allPosts = postRepository.findAll();
        assertEquals(22, allPosts.size());
        assertEquals(1, allPosts.get(0).getId());
    }

}