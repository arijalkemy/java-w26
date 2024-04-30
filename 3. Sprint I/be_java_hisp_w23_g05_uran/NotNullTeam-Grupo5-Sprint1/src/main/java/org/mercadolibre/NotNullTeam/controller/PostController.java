package org.mercadolibre.NotNullTeam.controller;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.PromoPostDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PostCreatedDto;
import org.mercadolibre.NotNullTeam.DTO.response.ProductsPromoCountDTO;
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

    //US0010 Llevar a cabo la publicación de un nuevo producto en promoción (Desarrollo INDIVIDUAL)
    @PostMapping("/promo-post")
    public ResponseEntity<?> createPromoPost(@RequestBody PromoPostDTO promoPostDTO) {
        Long promoId = iPostService.createPromoPost(promoPostDTO);
        return new ResponseEntity<>(
                new PostCreatedDto(promoId,"Promo posted successfully", LocalDate.now()),
                HttpStatus.CREATED);
    }

    //US0011 Obtener la cantidad de productos en promoción de un determinado vendedor (Desarrollo INDIVIDUAL)
    @GetMapping("/promo-post/{userId}/list")
    public ResponseEntity<ProductsPromoCountDTO> getProductsPromoCount(@PathVariable Long userId){
        return ResponseEntity.ok(iPostService.getProductsPromoCount(userId));
    }

    //US0012 Obtener un listado de todos los productos en promoción de un determinado vendedor(Desarrollo INDIVIDUAL)
    @GetMapping("/promo-post/listBySeller/{userId}")
    public ResponseEntity<?> getListPromoProductsBySeller(@PathVariable Long userId){
        return new ResponseEntity<>(
                iPostService.getListPromoProducts(userId), HttpStatus.OK);
    }


}
