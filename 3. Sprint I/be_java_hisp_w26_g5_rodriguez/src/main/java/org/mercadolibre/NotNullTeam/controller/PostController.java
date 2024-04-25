package org.mercadolibre.NotNullTeam.controller;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.PostPromoRequestDto;
import org.mercadolibre.NotNullTeam.DTO.response.PostCreatedDto;
import org.mercadolibre.NotNullTeam.DTO.response.SellerPromosCountResponse;
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
        iPostService.createPost(postDTO);
        return new ResponseEntity<>(new PostCreatedDto("Post created successfully",
                LocalDate.now()), HttpStatus.CREATED);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getPostsBySellerTwoWeeksAgo(@PathVariable Long userId,
                                                         @RequestParam(required = false, defaultValue = "date_desc") String order) {
        return ResponseEntity.ok(iPostService.getPostsBySellerTwoWeeksAgo(userId, order));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> newProductPromo(@RequestBody PostPromoRequestDto request) {
        iPostService.newProductPromo(request);
        return new ResponseEntity<>(new PostCreatedDto("Post created successfully",
                LocalDate.now()), HttpStatus.CREATED);
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SellerPromosCountResponse> getCountPromosBySellerId(@RequestParam(
            "user_id") Long userId ) {
        return ResponseEntity.ok(iPostService.getCountPromosBySellerId(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<?> getPromosBySellerId(@RequestParam("user_id") Long userId ){
        return ResponseEntity.ok(iPostService.getPromosBySellerId(userId));
    }
}
