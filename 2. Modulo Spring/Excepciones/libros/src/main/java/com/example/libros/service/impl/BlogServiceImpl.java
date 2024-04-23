package com.example.libros.service.impl;

import com.example.libros.dto.BlogDTO;
import com.example.libros.model.EntradaBlog;
import com.example.libros.repository.BlogRepositoryImpl;
import com.example.libros.repository.IBlogRepository;
import com.example.libros.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    IBlogRepository iBlogRepository;


    public void crearBlog(BlogDTO blogDTO){
        iBlogRepository.crearBlog(new EntradaBlog(blogDTO.getId(), blogDTO.getTitulo(), blogDTO.getAutor(), blogDTO.getFecha()));
    }

    public List<BlogDTO> obtenerBlogs(){
        return iBlogRepository.obtenerBlogs().stream().map(x -> new BlogDTO(x.getId(),x.getTitulo(),x.getAutor(),x.getFecha())).collect(Collectors.toList());
    }

    public BlogDTO obtenerBlog(int id) {
        Optional<EntradaBlog> optionalEntradaBlog = iBlogRepository.obtenerBlog(id);
        if (optionalEntradaBlog.isPresent()) {
            EntradaBlog entradaBlog = optionalEntradaBlog.get();
            return new BlogDTO(entradaBlog.getId(), entradaBlog.getTitulo(), entradaBlog.getAutor(), entradaBlog.getFecha());
        } else {
            throw new IllegalArgumentException("No se encontró ninguna entrada de blog con el ID proporcionado: " + id);
        }
    }
}
