package org.example.blog.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.blog.dto.BlogDTO;
import org.example.blog.exceptions.AllReadyExistException;
import org.example.blog.exceptions.NonContentException;
import org.example.blog.exceptions.NotFoundException;
import org.example.blog.model.BlogEntry;
import org.example.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    IBlogRepository blogRepository;


    ObjectMapper mapper = new ObjectMapper();

    public BlogServiceImpl() {
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public Integer addBlogPost(BlogDTO blog) {

        if(blogRepository.exist(blog.getId())){
            throw new AllReadyExistException("El blog con id:"+ blog.getId()+ " ya existe");
        }
        return blogRepository.add(mapper.convertValue(blog, BlogEntry.class));
    }

    @Override
    public List<BlogDTO> findAllBlogEntries() {
        List<BlogEntry> entries = blogRepository.findAll();
        if(entries.isEmpty())
            throw new NonContentException("No se encontraron entradas para el blog");
        return entries.stream().map(x->mapper.convertValue(x, BlogDTO.class)).toList();
    }

    @Override
    public BlogDTO findById(Integer id) {
        if (!blogRepository.exist(id)){
            throw new NotFoundException("El blog con el id: "+id+" no existe");
        }
        return mapper.convertValue(blogRepository.findById(id),BlogDTO.class);
    }
}
