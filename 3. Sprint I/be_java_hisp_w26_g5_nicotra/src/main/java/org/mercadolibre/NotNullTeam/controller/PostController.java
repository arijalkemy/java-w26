package org.mercadolibre.NotNullTeam.controller;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.PostWithPromoDto;
import org.mercadolibre.NotNullTeam.DTO.response.PostCreatedDto;
import org.mercadolibre.NotNullTeam.DTO.response.PostPromoCountDto;
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
        return new ResponseEntity<>(
                new PostCreatedDto(postId, "Post created successfully", LocalDate.now()), HttpStatus.CREATED);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getPostsByWeeksAgo(@PathVariable Long userId,
                                                @RequestParam(required = false, defaultValue = "date_desc") String order){
        return ResponseEntity.ok(iPostService.getPostsByWeeksAgo(userId, order));
    }

    //EJERCICIO INDIVIDUAL 0010
    @PostMapping("/promo-post")
    public ResponseEntity<PostCreatedDto> createPostWithPromo(@RequestBody PostWithPromoDto postDto) {
        return new ResponseEntity<>(iPostService.createPostWithPromo(postDto), HttpStatus.CREATED);
    }

    //EJERCICIO INDIVIDUAL 0011
    @GetMapping("/promo-post/count")
    public ResponseEntity<PostPromoCountDto> getCountPostPromo(@RequestParam Long userId) {
        return ResponseEntity.ok(iPostService.getCountPostPromo(userId));
    }

    //EJERCICIO INDIVIDUAL 0012
    @GetMapping("/promo-post/most-discount/{sellerId}")
    public ResponseEntity<PostWithPromoDto> getMostDiscountBySellerId(@PathVariable Long sellerId){
        return ResponseEntity.ok(iPostService.getMostDiscountBySellerId(sellerId));
    }
}
