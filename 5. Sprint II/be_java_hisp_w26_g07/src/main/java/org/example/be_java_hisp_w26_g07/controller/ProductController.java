package org.example.be_java_hisp_w26_g07.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.example.be_java_hisp_w26_g07.dto.products.PostDto;
import org.example.be_java_hisp_w26_g07.dto.products.PostRequestDto;
import org.example.be_java_hisp_w26_g07.service.interfaces.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/products")
public class ProductController {

    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    /**
     * US 0005
     * Controlador: Dar de alta una nueva publicación
     *
     * @param post PostRequestDto
     */
    @PostMapping("/post")
    public ResponseEntity<PostDto> addPost(@RequestBody @Valid PostRequestDto post) {
        return new ResponseEntity<>(productService.createPost(post), HttpStatus.OK);
    }

    /**
     * US 0006
     * Controlador: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las
     * últimas dos semanas (para esto tener en cuenta ordenamiento por fecha, publicaciones más recientes primero).
     *
     * @param userId PostRequestDto
     * @param order  Tipo de orden (opcional)
     */
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getLatestPost(
            @PathVariable @NotNull(message = "El id no puede ser nulo")
            @Positive(message = "El id debe ser mayor a 0") Integer userId,
            @RequestParam(required = false) String order
    ) {
        return new ResponseEntity<>(productService.findProductByFollow(userId, order), HttpStatus.OK);
    }


}
