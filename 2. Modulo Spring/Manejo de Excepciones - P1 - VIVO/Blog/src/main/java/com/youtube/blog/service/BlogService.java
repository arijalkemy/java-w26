package com.youtube.blog.service;

import com.youtube.blog.dto.BlogDTO;
import com.youtube.blog.entity.EntradaBlog;
import com.youtube.blog.exceptions.NotFoundException;
import com.youtube.blog.exceptions.RecordAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService{

    @Override
    public List<BlogDTO> getTodosLosBlogs() {
        return this.entradasBlog;
    }

    @Override
    public BlogDTO getBlogPorId(int id) {
        Optional<BlogDTO> blogOptional = this.entradasBlog.stream()
                .filter(blog -> blog.getId() == id)
                .findFirst();

        if (blogOptional.isPresent()) {
            return blogOptional.get();
        } else {
            throw new NotFoundException("El blog id no existe");
        }
    }

    @Override
    public ResponseEntity<String> guardarBlog(BlogDTO entradaBlog) {
        BlogDTO existeBlog = getBlogPorId(entradaBlog.getId());
        if (existeBlog != null) {
            throw new RecordAlreadyExistsException("El blog ya existe");
        }

        this.entradasBlog.add(entradaBlog);

        return ResponseEntity.ok("Blog añadido correctamente");
    }

}
