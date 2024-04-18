package bootcamp.spring.blog.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import bootcamp.spring.blog.model.EntradaBlog;

public interface IController<T>{
    @GetMapping
	ResponseEntity<List<T>> getAll();
    
    @PostMapping
	ResponseEntity<Integer> post(@RequestBody T obj);

    @GetMapping("/{id}")
    ResponseEntity<EntradaBlog> getById(@PathVariable Integer id);
}
