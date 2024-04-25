package bootcamp.sprint.grupo02.sprintI.controller;

import bootcamp.sprint.grupo02.sprintI.dto.request.PostPromoDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.*;
import bootcamp.sprint.grupo02.sprintI.service.PostService;
import org.springframework.web.bind.annotation.*;
import bootcamp.sprint.grupo02.sprintI.dto.request.PostRequestDTO;
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
    public ResponseEntity<MessageResponseDTO> createPost(@RequestBody PostRequestDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(postService.addPost(dto));
    }
    @PostMapping("/promo-post")
    public ResponseEntity<MessageResponseDTO> createPostPromo(@RequestBody PostPromoDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(postService.addPostPromo(dto));
    }

    @GetMapping("/promo-post/count/{userId}")
    public ResponseEntity<PromoQuantityResponseDTO> getPostByUser(@PathVariable int userId){
        return ResponseEntity.ok(postService.calculatePostPromoBySeller(userId));
    }

    @GetMapping("/promo-post/count/list/{userId}")
    public ResponseEntity<PromoListBySeller> getAllPromoBySeller(@PathVariable int userId){
        return ResponseEntity.ok(postService.findAllPromoBySeller(userId));
    }
    @PutMapping("/promo-post/delete/{postId}")
    public ResponseEntity<PostPromoResponseDTO> updatePromo(@PathVariable int postId){
        return ResponseEntity.ok(postService.removePromo(postId));
    }
}
