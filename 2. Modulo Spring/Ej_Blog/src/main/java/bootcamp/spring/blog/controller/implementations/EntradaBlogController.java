package bootcamp.spring.blog.controller.implementations;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.spring.blog.controller.interfaces.IEntradaBlogController;
import bootcamp.spring.blog.model.EntradaBlog;
import bootcamp.spring.blog.service.interfaces.IEntradaBlogService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blog")
public class EntradaBlogController implements IEntradaBlogController {
    private final IEntradaBlogService blogService;

    @Override
    public ResponseEntity<Integer> post(EntradaBlog entradaBlog) {
        return ResponseEntity.ok(blogService.save(entradaBlog));
    }

    @Override
    public ResponseEntity<EntradaBlog> getById(Integer id) {
        return ResponseEntity.ok(blogService.searchById(id));
    }

    @Override
    public ResponseEntity<List<EntradaBlog>> getAll() {
        List<EntradaBlog> entradasBlog = blogService.searchAll();
        if(entradasBlog.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(entradasBlog);
    }

}
