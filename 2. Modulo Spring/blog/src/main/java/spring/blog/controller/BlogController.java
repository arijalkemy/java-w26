package spring.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.blog.dto.BlogDto;
import spring.blog.entity.EntradaBlog;
import spring.blog.service.IBlogService;

@RestController
@RequestMapping("/")
public class BlogController {

    @Autowired
    IBlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<String> postNuevaEntrada(@RequestBody BlogDto entrada) {
        int blogId = blogService.guardarEntrada(entrada);
        return new ResponseEntity("Blog creado id: " + blogId, HttpStatus.CREATED);
    }

}
