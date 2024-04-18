package com.blog.excercise.service.impl;

import com.blog.excercise.dto.BlogDTO;
import com.blog.excercise.entity.EntradaBlog;
import com.blog.excercise.excpetion.BadRequestException;
import com.blog.excercise.excpetion.ExceptionConfig;
import com.blog.excercise.excpetion.NotFoundException;
import com.blog.excercise.repository.BlogRepository;
import com.blog.excercise.service.BlogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Integer postNewBlog(BlogDTO inputBlogDTO){

        EntradaBlog blogEnRepositorio = blogRepository.getBlogsByUserId(inputBlogDTO.getId());
        if(blogEnRepositorio != null){
            throw new BadRequestException("El id ya existe en el sistema.");
        }

        EntradaBlog entradaBlog = objectMapper.convertValue(inputBlogDTO, EntradaBlog.class);

        return blogRepository.saveNewBlog(entradaBlog);
    }

    @Override
    public BlogDTO getBlogById(Integer id){
        EntradaBlog entradaBlogDTO = blogRepository.getBlogsByUserId(id);
        if(entradaBlogDTO == null){
            throw new NotFoundException("El id no existe en el sistema.");
        }

        BlogDTO blogDTO = objectMapper.convertValue(entradaBlogDTO, BlogDTO.class);
        return blogDTO;
    }

    @Override
    public List<BlogDTO> getAllBlogs(){
        List<EntradaBlog> entradaBlogs = blogRepository.getAllBlogs();
        if (entradaBlogs.isEmpty()){
            throw new NotFoundException("El repositorio esta vacio.");
        }
        List<BlogDTO> listaBlogDTO = entradaBlogs.stream()
                .filter(blog -> blog != null)
                .map(blog -> objectMapper.convertValue(blog, BlogDTO.class))
                .collect(Collectors.toList());

        return listaBlogDTO;
    }

}
