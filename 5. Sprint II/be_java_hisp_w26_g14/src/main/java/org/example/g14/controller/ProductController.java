package org.example.g14.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.example.g14.dto.request.PostCreateRequestDto;
import org.example.g14.dto.response.MessageResponseDto;
import org.example.g14.dto.response.PostResponseDto;
import org.example.g14.service.IPostService;
import org.example.g14.utils.ValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    IPostService postService;

    @PostMapping("/post")
    public ResponseEntity<MessageResponseDto> createPost(
        @RequestBody @Valid PostCreateRequestDto postCreateRequestDto
    ) {
        return ResponseEntity.ok(postService.add(postCreateRequestDto));
    }

    @GetMapping("/followed/{user_id}/list")
    public ResponseEntity<List<PostResponseDto>> getPostsFromFollowed(
        @PathVariable("user_id") @Positive(message = ValidationMessages.ID_POSITIVE) int userId,
        @RequestParam(required = false) String order
    ) {
        List<PostResponseDto> posts = postService.getPostsFromFollowed(userId, order);
        return ResponseEntity.ok(posts);
    }
}
