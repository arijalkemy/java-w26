package meli.bootcamp.blog.controller;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.blog.dto.PostDTO;
import meli.bootcamp.blog.dto.PostIdDTO;
import meli.bootcamp.blog.service.PostImpl;
import meli.bootcamp.blog.service.interfaces.IPost;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
@RequiredArgsConstructor
public class PostController {

    private final IPost post;

    @GetMapping
    public ResponseEntity<List<PostDTO>> getPosts() {
        return ResponseEntity.ok(post.getAllPosts());
    }

    @PostMapping("/post")
    public ResponseEntity<PostIdDTO> createPost(@RequestBody PostDTO postDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(post.savePost(postDTO));
    }

    @GetMapping(("/post/{id}"))
    public ResponseEntity<PostDTO> getPostById(@PathVariable Integer id) {
        return ResponseEntity.ok(post.getPostById(id));
    }
}
