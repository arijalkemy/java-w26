package bootcamp.sprint.grupo02.sprintI.controller;

import bootcamp.sprint.grupo02.sprintI.dto.response.MessageResponseDTO;
import bootcamp.sprint.grupo02.sprintI.dto.response.PostListByBuyerResponseDTO;
import bootcamp.sprint.grupo02.sprintI.service.PostService;
import org.springframework.web.bind.annotation.*;
import bootcamp.sprint.grupo02.sprintI.dto.request.PostDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Validated
public class ProductController {

    private final PostService postService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListByBuyerResponseDTO> getPostByUser(@Positive(message = "El Id debe ser mayor a cero") @PathVariable int userId,
                                                                    @RequestParam String order){
        return ResponseEntity.ok(postService.findPostsByBuyer(userId, order));
    }

    @PostMapping("/post")
    public ResponseEntity<MessageResponseDTO> createPost(@Valid @RequestBody PostDTO dto){
        return ResponseEntity.status(HttpStatus.OK).body(postService.createPost(dto));
    }
}
