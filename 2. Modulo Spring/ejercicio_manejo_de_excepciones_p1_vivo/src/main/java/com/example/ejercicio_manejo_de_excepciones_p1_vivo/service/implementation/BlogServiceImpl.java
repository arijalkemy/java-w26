package com.example.ejercicio_manejo_de_excepciones_p1_vivo.service.implementation;

import com.example.ejercicio_manejo_de_excepciones_p1_vivo.dto.BlogDto;
import com.example.ejercicio_manejo_de_excepciones_p1_vivo.entity.EntradaBlog;
import com.example.ejercicio_manejo_de_excepciones_p1_vivo.exception.NotFoundException;
import com.example.ejercicio_manejo_de_excepciones_p1_vivo.exception.ResourceExistsException;
import com.example.ejercicio_manejo_de_excepciones_p1_vivo.repository.IBlogRepository;
import com.example.ejercicio_manejo_de_excepciones_p1_vivo.service.IBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements IBlogService {
    private final IBlogRepository blogRepository;

    @Override
    public List<BlogDto> searchAllBlogs() {
        List<EntradaBlog> entradasBlog = blogRepository.findAllBlogs();
        List<BlogDto> entradasBlogDto = new ArrayList<>();

        for(EntradaBlog entrada : entradasBlog) {
            entradasBlogDto.add(
                  new BlogDto(
                          entrada.getId(),
                          entrada.getTitulo(),
                          entrada.getNombreAutor(),
                          entrada.getFechaPublicacion()
                  )
            );
        }

        return entradasBlogDto;
    }

    @Override
    public BlogDto searchBlog(int id) {
        EntradaBlog blog = blogRepository.findBlogById(id);
        return new BlogDto(
            blog.getId(),
            blog.getTitulo(),
            blog.getNombreAutor(),
            blog.getFechaPublicacion()
        );
    }

    @Override
    public int createBlog(BlogDto blogDto) {
        if(blogRepository.blogExists(blogDto.getId())) {
            throw new ResourceExistsException("Blog", Integer.toString(blogDto.getId()));
        } else {
            EntradaBlog blog = new EntradaBlog(
                blogDto.getId(),
                blogDto.getTitulo(),
                blogDto.getNombreAutor(),
                blogDto.getFechaPublicacion()
            );
            return blogRepository.create(blog);
        }
    }
}
