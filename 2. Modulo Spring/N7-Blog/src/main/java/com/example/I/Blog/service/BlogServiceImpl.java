package com.example.I.Blog.service;

import com.example.I.Blog.dto.EntradaBlogDto;
import com.example.I.Blog.entity.EntradaBlog;
import com.example.I.Blog.exception.NotFoundException;
import com.example.I.Blog.repository.BlogRepositoryImpl;
import com.example.I.Blog.repository.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    IBlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepositoryImpl blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Long agregarEntrada(EntradaBlogDto entradaBlogDto) {
        List<EntradaBlog>  entradaBlogs = blogRepository.getEntradaBlogs();
        if(entradaBlogs.stream().anyMatch(e -> e.getId() == entradaBlogDto.getId())){
            throw new NotFoundException("YA EXISTE ENTRADA");
        }
        ObjectMapper mapper = new ObjectMapper();
        EntradaBlog entradaBlog = mapper.convertValue(entradaBlogDto, EntradaBlog.class);
        entradaBlogs.add(entradaBlog);
        return entradaBlog.getId();
    }

    public EntradaBlogDto obtenerEntrada(Long id) {
        List<EntradaBlog> entradaBlogs = blogRepository.getEntradaBlogs();
        if(entradaBlogs.stream().noneMatch(e -> e.getId() == id)){
            throw new NotFoundException("NO EXISTE ENTRADA");
        }
        EntradaBlog entradaBlog = entradaBlogs.stream().filter(e -> e.getId() == id).findFirst().get();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(entradaBlog, EntradaBlogDto.class);
    }

    public List<EntradaBlogDto> obtenerEntradas() {
        List<EntradaBlog> entradaBlogs = blogRepository.getEntradaBlogs();
        if(entradaBlogs.isEmpty()) {
            throw new NotFoundException("NO HAY ENTRADAS");
        }
        ObjectMapper mapper = new ObjectMapper();
        List<EntradaBlogDto> entradaBlogDtos = new ArrayList<>();
        entradaBlogs.forEach(v -> entradaBlogDtos.add(mapper.convertValue(v, EntradaBlogDto.class)));

        return entradaBlogDtos;
    }

}
