package com.sinc_ejercicioblog.controlador;

import com.sinc_ejercicioblog.dto.EntradaBlogDTO;
import com.sinc_ejercicioblog.servicio.IEntradaBlogServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntradaBlogControlador {

    @Autowired
    private IEntradaBlogServicio iEntradaBlogServicio;

    @PostMapping(path = "/blog")
    public ResponseEntity<String> crearNuevaEntradaBlog(@RequestBody EntradaBlogDTO entradaBlogDTO){
        String mensaje = iEntradaBlogServicio.crearEntradaBlog(entradaBlogDTO);
        return ResponseEntity.ok().body(mensaje);
    }
    //pruebas: localhost:8080/blog
    /*
    {
        "idBlog":3,
        "titulo":"El blog de Marcos",
        "nombreAutor":"Marcos",
        "fechaPublicacion":"2022-12-06"
     }*/

    @GetMapping(path = "/blog/{id}")
    public ResponseEntity<EntradaBlogDTO> buscarBlogPorId(@PathVariable int id) {
        return new ResponseEntity<>(iEntradaBlogServicio.buscarEntradaBlogPorId(id), HttpStatus.OK);
    }
    //pruebas: localhost:8080/blog/3

    @GetMapping(path = "/blogs")
    public List<EntradaBlogDTO> obtenerTodosLosBlogs(){
        return iEntradaBlogServicio.buscarTodosLosBlogs();
    }
    //pruebas: localhost:8080/blogs
}
