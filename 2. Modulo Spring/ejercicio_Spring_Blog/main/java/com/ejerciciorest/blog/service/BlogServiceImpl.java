package com.ejerciciorest.blog.service;

import com.ejerciciorest.blog.dto.EntradaBlogDTO;
import com.ejerciciorest.blog.entities.EntradaBlog;
import com.ejerciciorest.blog.repositories.IRepositorioBlog;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service
public class BlogServiceImpl implements IBlogService{
    @Autowired
    private IRepositorioBlog repositorioBlog;

    @Override
    public Integer agregarBlog(EntradaBlog blog){
        for(Map.Entry<Integer, EntradaBlog> entrada : repositorioBlog.listaBlogs().entrySet()){
            if(entrada.getKey().equals(blog.getId())){
                throw new RuntimeException("Ya existe un blog con ese id.");
            }
        }
        Integer id = repositorioBlog.agregarBlog(blog);
        return id;
    }

    @Override
    public EntradaBlogDTO mostrarBlogId(Integer id) {
        EntradaBlog blog = repositorioBlog.blogPorID(id);
        if (blog == null){
            throw new RuntimeException("No existe un blog con ese id.");
        }
        EntradaBlogDTO blogDTO = new EntradaBlogDTO(blog.getId(), blog.getTitulo(), blog.getNombre(),
                blog.getFechaCreacion());

        return blogDTO;
    }

    @Override
    public List<EntradaBlogDTO> mostrarBlogs() {
        Map<Integer, EntradaBlog> blogs = repositorioBlog.listaBlogs();
        List<EntradaBlogDTO> blogsDTO = new ArrayList<>();

        for(Map.Entry<Integer, EntradaBlog> entrada : blogs.entrySet()){
            blogsDTO.add(new EntradaBlogDTO(entrada.getValue().getId(), entrada.getValue().getTitulo(),
                    entrada.getValue().getNombre(), entrada.getValue().getFechaCreacion()));
        }

        return blogsDTO;
    }
}
