package com.example.sprint1.controller;

import com.example.sprint1.dto.PostDto;
import com.example.sprint1.model.Post;
import com.example.sprint1.service.IPostService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostControllerTest {
    @Mock
    IPostService postService;

    @InjectMocks
    PostController postController;

    @Test
    public void testGetPosts() {
        // arrange
        List<Post> posts = new ArrayList<>();
        ResponseEntity<List<Post>> expectedResponse = ResponseEntity.ok(posts);

        // act
        when(postService.findAll()).thenReturn(posts);

        // assert
        Assertions.assertEquals(expectedResponse, postController.getAllPosts());
    }

    @Test
    public void testPostWithPromo() {
        // arrange
        PostDto post = new PostDto();
        ResponseEntity<PostDto> expectedResponse = ResponseEntity.status(HttpStatus.CREATED).body(post);

        // act
        when(postService.postPromo(post)).thenReturn(post);

        // assert
        Assertions.assertEquals(expectedResponse, postController.postPromo(post));
    }

    @Test
    public void testPostWithPromoCount() {
        // arrange
        Integer count = 1;
        PostDto post = new PostDto();
        ResponseEntity<PostDto> expectedResponse = ResponseEntity.status(HttpStatus.OK).body(post);

        // act
        when(postService.quantityPromo(count)).thenReturn(post);

        // assert
        Assertions.assertEquals(expectedResponse, postController.quantityPromo(count));
    }

    @Test
    public void testGetPromo() {
        // arrange
        Integer count = 1;
        PostDto post = new PostDto();
        ResponseEntity<PostDto> expectedResponse = ResponseEntity.status(HttpStatus.OK).body(post);

        // act
        when(postService.getPromo(count)).thenReturn(post);

        // assert
        Assertions.assertEquals(expectedResponse, postController.getPromo(count));
    }

}
