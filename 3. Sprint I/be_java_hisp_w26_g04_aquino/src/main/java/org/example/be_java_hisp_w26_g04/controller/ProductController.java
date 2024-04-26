package org.example.be_java_hisp_w26_g04.controller;

import java.util.List;
import org.example.be_java_hisp_w26_g04.dto.PostRequestDTO;
import org.example.be_java_hisp_w26_g04.dto.PostResponseDTO;
import org.example.be_java_hisp_w26_g04.dto.PromoCountDTO;
import org.example.be_java_hisp_w26_g04.dto.PromoListDTO;
import org.example.be_java_hisp_w26_g04.service.seller.ISellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  ISellerService sellerService;

  @PostMapping({"/post", "/promo-post"})
  public ResponseEntity<?> createPost(@RequestBody PostRequestDTO post) {
    return ResponseEntity.ok().body(sellerService.createNewPost(post));
  }

  @GetMapping("/followed/{userId}/list")
  public ResponseEntity<List<PostResponseDTO>> getPostsFromFollower(
      @PathVariable int userId,
      @RequestParam(required = false, value = "order") String order
  ) {
    return ResponseEntity.ok().body(sellerService.sortGetPostFromFollower(userId, order));
  }

  @GetMapping("promo-post/count")
  public ResponseEntity<PromoCountDTO> getPromoPostCount(
      @RequestParam(value = "user_id") int userId
  ) {
    return ResponseEntity.ok().body(sellerService.getPromoPostCount(userId));
  }

  @GetMapping("promo-post/list")
  public ResponseEntity<PromoListDTO> getPromoPost(
      @RequestParam(value = "user_id") int userId
  ) {
    return ResponseEntity.ok().body(sellerService.getPromoPostList(userId));
  }


  @GetMapping
  public ResponseEntity<List<PostResponseDTO>> getPosts(
      @RequestParam(required = false, name = "price_order") String priceOrder,
      @RequestParam(required = false, name = "product_name") String productName,
      @RequestParam(required = false, name = "type") String type
  ) {
    return ResponseEntity.ok().body(sellerService.getPosts(priceOrder, productName, type));
  }
}
