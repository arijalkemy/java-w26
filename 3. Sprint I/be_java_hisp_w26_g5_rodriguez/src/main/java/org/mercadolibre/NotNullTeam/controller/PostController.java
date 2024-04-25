package org.mercadolibre.NotNullTeam.controller;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.PostPromoRequestDto;
import org.mercadolibre.NotNullTeam.DTO.response.PostCreatedDto;
import org.mercadolibre.NotNullTeam.DTO.response.SellerPromosCountResponse;
import org.mercadolibre.NotNullTeam.DTO.response.SellerPromosResponse;
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
    public ResponseEntity<?> createPost(@RequestBody PostDTO postDTO) {
        Long postId = iPostService.createPost(postDTO);
        return new ResponseEntity<>(new PostCreatedDto(postId,
                "Post created successfully",
                LocalDate.now()), HttpStatus.CREATED);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getPostsByWeeksAgo(@PathVariable Long userId,
                                                @RequestParam(required = false, defaultValue = "date_desc") String order) {
        return ResponseEntity.ok(iPostService.getPostsByWeeksAgo(userId, order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> newPostProductPromo(@RequestBody PostPromoRequestDto request) {
        Long postId = iPostService.newProductPromo(request);
        return new ResponseEntity<>(new PostCreatedDto(postId,
                "Post created successfully",
                LocalDate.now()), HttpStatus.CREATED);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SellerPromosCountResponse> getCountPromosBySellerId(
            @RequestParam("user_id") Long userId) {
        SellerPromosCountResponse response = iPostService.getCountPromosBySellerId(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getPromosBySellerId(@RequestParam("user_id") Long userId) {
        SellerPromosResponse response = iPostService.getPromosBySellerId(userId);
        return ResponseEntity.ok(response);
    }
}
