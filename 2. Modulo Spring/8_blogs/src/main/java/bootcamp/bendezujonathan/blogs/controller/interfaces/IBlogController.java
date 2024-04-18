package bootcamp.bendezujonathan.blogs.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import bootcamp.bendezujonathan.blogs.dto.request.EntradaDeBlogRequest;
import bootcamp.bendezujonathan.blogs.dto.response.EntradaDeBlogResponse;
import jakarta.validation.Valid;

@RequestMapping("/blogs")
public interface IBlogController {
    

    @GetMapping
    public ResponseEntity<List<EntradaDeBlogResponse>> getAll();

    @GetMapping("/{id}")
    public ResponseEntity<EntradaDeBlogResponse> getById(@PathVariable int id);

    @PostMapping
    public ResponseEntity<EntradaDeBlogResponse> postBlog(@Valid @RequestBody EntradaDeBlogRequest request);

}
