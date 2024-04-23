package com.ej1p1dia4spring.blog.service.implementations;

import com.ej1p1dia4spring.blog.dto.BlogDTO;
import com.ej1p1dia4spring.blog.entity.EntradaBlog;
import com.ej1p1dia4spring.blog.repository.IBlogRepository;
import com.ej1p1dia4spring.blog.service.IBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogImpl implements IBlog {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public String agregarEntradaBlog(BlogDTO blogDTO) {
        EntradaBlog entradaBlog = new EntradaBlog(blogDTO.getId(), blogDTO.getTitulo(), blogDTO.getNombreAutor(),
                blogDTO.getFechaPublicacion());
        blogRepository.agregarEntradaBlog(entradaBlog);
        return "ID: " + entradaBlog.getId();
    }

    @Override
    public BlogDTO buscarEntradaBlog(int id) {
        EntradaBlog entradaEncontrada = blogRepository.obtenerEntradaBlog(id);
        BlogDTO blogDTO = new BlogDTO(entradaEncontrada.getId(), entradaEncontrada.getTitulo(),
                entradaEncontrada.getNombreAutor(), entradaEncontrada.getFechaPublicacion());
        return blogDTO;
    }
}
