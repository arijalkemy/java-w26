package com.javabootcamp.blog.service;

import com.javabootcamp.blog.dto.EntradaBlogDto;
import com.javabootcamp.blog.exceptions.ResourceAlreadyExistException;
import com.javabootcamp.blog.exceptions.ResourceNotFoundException;
import com.javabootcamp.blog.model.EntradaBlog;
import com.javabootcamp.blog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Map;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;
    public void addEntryBlog(EntradaBlog entradaBlog){
        if(blogRepository.findById(entradaBlog.getId())){
            throw new ResourceAlreadyExistException("Entrada ya existe");
        }else {
            blogRepository.addEntryBlog(entradaBlog);
        }
    }

    public Map<Integer,EntradaBlog> getAllEntryBlog(){
        return blogRepository.getEntryBlogList();
    }


    public EntradaBlogDto getEntryBlogById(int id) throws ResourceNotFoundException{
        EntradaBlog entradaBlog = blogRepository.getEntryBlogById(id);
        if(entradaBlog!=null){
            return new EntradaBlogDto(entradaBlog.getTitle(),entradaBlog.getAuthorName(),entradaBlog.getPublishedDate());
        }
        else{
            throw new ResourceNotFoundException("Entrada no encontrada");
        }
    }


}
