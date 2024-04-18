package com.example._09_practicaexcepcionesteoria.service;

import com.example._09_practicaexcepcionesteoria.dto.BlogPostDTO;
import com.example._09_practicaexcepcionesteoria.entity.BlogPost;
import com.example._09_practicaexcepcionesteoria.exceptions.BadRequestException;
import com.example._09_practicaexcepcionesteoria.exceptions.NotFoundException;
import com.example._09_practicaexcepcionesteoria.mapper.MapperBlog;
import com.example._09_practicaexcepcionesteoria.repository.IBlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogPostService implements IBlogPostService {
    @Autowired
    IBlogPostRepository iBlogPostRepository;

    private MapperBlog mapperBlog = new MapperBlog();

    @Override
    public List<BlogPostDTO> getAll() {
        List<BlogPost> blogPosts = iBlogPostRepository.getAll();
        List<BlogPostDTO> blogPostDTOS = new ArrayList<>();

        for (BlogPost blogPost : blogPosts){
            blogPostDTOS.add(mapperBlog.transferToDTO(blogPost));
        }

        return blogPostDTOS;
    }

    @Override
    public BlogPostDTO findById(int id) {
        BlogPost blogPost = iBlogPostRepository.findById(id);

        if(blogPost == null)
            throw new NotFoundException("No se encontro el blog con el id " + id);

        return mapperBlog.transferToDTO(blogPost);
    }

    @Override
    public int add(BlogPostDTO blogPostDTO) {
        BlogPost blog = mapperBlog.transferToEntity(blogPostDTO);

        if(getAll().stream().filter(b -> b.getIdBlog() == blog.getIdBlog()).count() > 0)
            throw new BadRequestException("El post del id " + blogPostDTO.getIdBlog() + " ya existe");

        return iBlogPostRepository.add(blog);
    }
}
