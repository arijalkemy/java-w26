package bootcamp.bendezujonathan.blogs.controller.implementations;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.bendezujonathan.blogs.controller.interfaces.IBlogController;
import bootcamp.bendezujonathan.blogs.dto.request.EntradaDeBlogRequest;
import bootcamp.bendezujonathan.blogs.dto.response.EntradaDeBlogResponse;
import bootcamp.bendezujonathan.blogs.service.interfaces.IBlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BlogController implements IBlogController {

    private final IBlogService service;

    @Override
    public ResponseEntity<List<EntradaDeBlogResponse>> getAll() {
        List<EntradaDeBlogResponse> result = this.service.findAll();
        return ResponseEntity.ok(result);
    }

    @Override
    public ResponseEntity<EntradaDeBlogResponse> getById(int id) {
        return ResponseEntity.ok(this.service.searchById(id));
    }

    @Override
    public ResponseEntity<EntradaDeBlogResponse> postBlog(@Valid EntradaDeBlogRequest request) {
        return ResponseEntity.ok(this.service.create(request));
    }

}
