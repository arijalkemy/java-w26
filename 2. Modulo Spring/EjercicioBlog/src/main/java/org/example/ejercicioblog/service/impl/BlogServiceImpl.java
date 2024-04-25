package org.example.ejercicioblog.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ejercicioblog.dto.EntradaBlogDTO;
import org.example.ejercicioblog.dto.ExceptionDTO;
import org.example.ejercicioblog.entity.EntradaBlog;
import org.example.ejercicioblog.exception.NotFoundException;
import org.example.ejercicioblog.repository.IBlogRepository;
import org.example.ejercicioblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
     IBlogRepository blogRepository;
    @Override
    public ExceptionDTO addBlog(EntradaBlogDTO blog) {
        ObjectMapper objectMapper = new ObjectMapper();
        EntradaBlog entradaBlog = objectMapper.convertValue(blog, EntradaBlog.class);
        blogRepository.addBlog(entradaBlog);
        return new ExceptionDTO("Blog agregado exitosamente con el id: " + entradaBlog.getId());
    }

    @Override
    public List<EntradaBlogDTO> findAll() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<EntradaBlog> entradaBlogs= blogRepository.findAll();


        return entradaBlogs.stream()
                .map(entradaBlog -> objectMapper.convertValue(entradaBlog, EntradaBlogDTO.class))
                .toList();
    }

    @Override
    public EntradaBlogDTO findById(int id) {
        ObjectMapper objectMapper = new ObjectMapper();
        EntradaBlog entradaBlog = blogRepository.findById(id);
        if (entradaBlog != null) {
            return objectMapper.convertValue(entradaBlog, EntradaBlogDTO.class);
        }
        throw new NotFoundException("No se encontró el blog con el id: " + id);
    }
}
