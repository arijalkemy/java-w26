package bootcamp.sprint.grupo02.sprintI.controller;

import bootcamp.sprint.grupo02.sprintI.dto.response.MessageResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostListByBuyerResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.SellerPromoResponseDTO;
import bootcamp.sprint.grupo02.sprintI.exception.BadRequestException;
import bootcamp.sprint.grupo02.sprintI.service.PostService;
import org.springframework.web.bind.annotation.*;
import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import bootcamp.sprint.grupo02.sprintI.service.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;
    private final PostService postService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListByBuyerResponseDTO> getPostByUser(@PathVariable int userId,
                                                                    @RequestParam String order){
        return ResponseEntity.ok(postService.findPostsByBuyer(userId, order));
    }

    @PostMapping("/post")
    public ResponseEntity<MessageResponseDTO> createPost(@RequestBody PostDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(postService.createPost(dto));
    }

    @PostMapping("/post-discount")
    public ResponseEntity<MessageResponseDTO> createPostWithDiscount(@RequestBody PostDTO dto){
        if(Objects.isNull(dto.getDiscount()) || Objects.isNull(dto.isHasPromo())) {
            throw new BadRequestException("Post should have a Discount And be Promo");
        }

        return ResponseEntity.status(HttpStatus.OK).body(postService.createPost(dto));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SellerPromoResponseDTO> countPromoPosts(@RequestParam(name = "user_id") int sellerId) {
        return ResponseEntity.ok(postService.countPromosBySeller(sellerId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<SellerPromoResponseDTO> getPromoPosts(@RequestParam(name = "user_id") int sellerId) {
        return ResponseEntity.ok(postService.searchPromosBySeller(sellerId));
    }
}
