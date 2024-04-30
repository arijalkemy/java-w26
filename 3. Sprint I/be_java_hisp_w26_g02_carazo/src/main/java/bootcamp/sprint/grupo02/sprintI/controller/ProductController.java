package bootcamp.sprint.grupo02.sprintI.controller;

import bootcamp.sprint.grupo02.sprintI.dto.response.MessageResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostListByBuyerResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.SellerPromoResponseDTO;
import bootcamp.sprint.grupo02.sprintI.service.PostService;
import org.springframework.web.bind.annotation.*;
import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;
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

    @PostMapping("/promo-post")
    public ResponseEntity<MessageResponseDTO> createPostPromo(@RequestBody PostDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(postService.createPostPromo(dto));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<SellerPromoResponseDTO> getPromotionPostBySeller(@RequestParam int userId){
        return ResponseEntity.status(HttpStatus.OK).body(postService.findSellerPromoPostCount(userId));
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<SellerPromoResponseDTO> getListPromotionPostBySeller(@RequestParam int userId,
                                                                               @RequestParam String type){
        return ResponseEntity.ok(postService.findPromoPostsBySellerAndType(userId,type));
    }


}
