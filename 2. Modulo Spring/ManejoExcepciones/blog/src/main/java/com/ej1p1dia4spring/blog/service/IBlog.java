package com.ej1p1dia4spring.blog.service;

import com.ej1p1dia4spring.blog.dto.BlogDTO;
import com.ej1p1dia4spring.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlog {
    String agregarEntradaBlog(BlogDTO blogDTO);
    BlogDTO buscarEntradaBlog(int id);
    List<BlogDTO> listarEntradas();
}
