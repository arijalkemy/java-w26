package com.example.blog.service;

import com.example.blog.dto.BlogDTO;
import com.example.blog.exceptions.BlogIdAlreadyExistsException;
import com.example.blog.repository.BlogRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

@Service
@Data
@AllArgsConstructor
public class BlogService implements IBlogService{
@Autowired

    private BlogRepository blogRepository;

    @Override
    public String newBlog(BlogDTO blogDTO) {
        if (blogDTO == null || blogDTO.getId() <= 0) {
            return "ID de entrada de blog no valido";
        }
        if(!blogRepository.entryExist(blogDTO.getId())){
            blogRepository.saveBlog(blogDTO);
            return "Entrada de blog creada con el ID " + blogDTO.getId();
        } else{
            throw new BlogIdAlreadyExistsException("Ya existe una entrada con el id " + blogDTO.getId());
        }
    }

    @Override
    public String findBlog(Integer id) {
        return blogRepository.findBlog(id);
    }

    @Override
    public Map<Integer, BlogDTO> getAll() {
        return blogRepository.getAll();
    }


}
