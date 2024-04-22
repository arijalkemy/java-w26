package meli.bootcamp.star_wars.controller;

import java.util.List;
import meli.bootcamp.star_wars.dto.EntradaBlogDto;
import meli.bootcamp.star_wars.service.IBlogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog")
public class BlogController {
  IBlogService blogService;

  public BlogController(IBlogService blogService) {
    this.blogService = blogService;
  }

  @GetMapping
  public ResponseEntity<List<EntradaBlogDto>> obtenerEntradasBlog() {
    List<EntradaBlogDto> entradas = blogService.obtenerEntradas();
    return ResponseEntity.ok().body(entradas);
  }

  @GetMapping("/{id}")
  public ResponseEntity<EntradaBlogDto> obtenerEntradaPorId(@PathVariable Long id) {
    return ResponseEntity.ok().body(blogService.obtenerEntradaPorId(id));
  }

  @PostMapping
  public ResponseEntity<EntradaBlogDto> crearEntradaBlog(@RequestBody EntradaBlogDto entradaBlog) {
    return ResponseEntity.ok().body(blogService.crearEntradaBlog(entradaBlog));
  }
}
