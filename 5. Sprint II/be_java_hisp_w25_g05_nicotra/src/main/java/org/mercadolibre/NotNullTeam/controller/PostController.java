package org.mercadolibre.NotNullTeam.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.post.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.response.post.PostCreatedDto;
import org.mercadolibre.NotNullTeam.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class PostController {
    final IPostService iPostService;

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDTO postDTO) {
        Long postId = iPostService.createPost(postDTO);
        return new ResponseEntity<>(
                new PostCreatedDto(postId, "Post created successfully", LocalDate.now()), HttpStatus.CREATED);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getPostsByWeeksAgo(
            @PathVariable @Valid @Positive(message = "El id  debe ser mayor a cero.") Long userId,
            @RequestParam(required = false, defaultValue = "date_desc") String order){
        return ResponseEntity.ok(iPostService.getPostsByWeeksAgo(userId, order));
    }
}
