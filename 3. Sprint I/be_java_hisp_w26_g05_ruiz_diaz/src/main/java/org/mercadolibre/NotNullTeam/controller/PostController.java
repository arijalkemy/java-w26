package org.mercadolibre.NotNullTeam.controller;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PostCreatedDto;
import org.mercadolibre.NotNullTeam.DTO.response.PostWithPromoResponseDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PromotionPostCountOfASellerResponseDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PromotionPostListOfASellerResponseDTO;
import org.mercadolibre.NotNullTeam.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class PostController {
    final IPostService iPostService;

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@RequestBody PostDTO postDTO) {
        Long postId = iPostService.createPost(postDTO);
        return new ResponseEntity<>(
                new PostCreatedDto(postId, "Post created successfully", LocalDate.now()), HttpStatus.CREATED);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getPostsByWeeksAgo(@PathVariable Long userId,
                                                @RequestParam(required = false, defaultValue = "date_desc") String order){
        return ResponseEntity.ok(iPostService.getPostsByWeeksAgo(userId, order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> createPostWithPromo(@RequestBody PostDTO postPromoRequestDTO) {
        PostWithPromoResponseDTO postWithPromoResponseDTO = iPostService.createPostWithPromo(postPromoRequestDTO);
        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentContextPath()
                                .path("/products/post/{id}")
                                .buildAndExpand(postWithPromoResponseDTO.getPost_id())
                                .toUri()
                ).body(
                        postWithPromoResponseDTO
                );
    }



    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromotionPostCountOfASeller(
            @RequestParam(required = true, name = "user_id") Long userId
    ){
        PromotionPostCountOfASellerResponseDTO response =  this.iPostService.getPromotionPostCountOfASeller(userId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getPromotionPostListOfASeller(
            @RequestParam(required = true, name = "user_id") Long userId
    ){
        PromotionPostListOfASellerResponseDTO response =  this.iPostService.getPromotionPostListOfASeller(userId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
