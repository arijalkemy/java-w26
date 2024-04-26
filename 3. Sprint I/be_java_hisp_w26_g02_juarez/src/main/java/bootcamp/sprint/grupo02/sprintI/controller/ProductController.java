package bootcamp.sprint.grupo02.sprintI.controller;

import bootcamp.sprint.grupo02.sprintI.dto.request.PostPromoDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.MessageResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostListByBuyerResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostPromoResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.ProductPromoAmountBySellerDTO;
import bootcamp.sprint.grupo02.sprintI.service.PostService;
import bootcamp.sprint.grupo02.sprintI.service.SellerService;
import org.springframework.web.bind.annotation.*;
import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final PostService postService;
    private final SellerService sellerService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListByBuyerResponseDTO> getPostByUser(@PathVariable int userId,
                                                                    @RequestParam String order){
        return ResponseEntity.ok(postService.findPostsByBuyer(userId, order));
    }

    @PostMapping("/post")
    public ResponseEntity<MessageResponseDTO> createPost(@RequestBody PostDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(postService.createPost(dto));
    }
    @PostMapping("/post/promo-post")
    public ResponseEntity<MessageResponseDTO> createPostWithDiscount(@RequestBody PostPromoDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(postService.createPostWithDiscount(dto));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<ProductPromoAmountBySellerDTO> getAmountOfPromos(@RequestParam int user_id){
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.getProductInPromoAmount(user_id));
    }
    @GetMapping("/promo-post/list")
    public ResponseEntity<List<PostPromoResponseDTO>> getListOfPromosFromASeller(@RequestParam int user_id){
        return ResponseEntity.status(HttpStatus.OK).body(sellerService.getPromoPostOfASeller(user_id));
    }
}
