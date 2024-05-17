package org.example.blog.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.blog.dto.BlogByIdDTO;
import org.example.blog.dto.BlogDTO;
import org.example.blog.entity.BlogEntity;
import org.example.blog.repository.IBlogRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogServiceImple implements IBlogService{

    @Autowired
    IBlogRespository blogRespository;

    static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public BlogByIdDTO saveBlog(BlogDTO blog) {

        BlogByIdDTO blogDTO = new BlogByIdDTO();
        BlogEntity blogEntity = objectMapper.convertValue(blog, BlogEntity.class);

        BlogEntity blogResp = blogRespository.saveBlog(blogEntity);

        blogDTO.setId(blogResp.getId());


        return blogDTO;
    }

    @Override
    public BlogDTO getBlogById(Long id) {
        BlogEntity blogEntity = blogRespository.blogById(id);

        return objectMapper.convertValue(blogEntity, BlogDTO.class);
    }

    @Override
    public List<BlogDTO> blogsAll() {
        List<BlogEntity> blogEntities = blogRespository.blogsAll();
        List<BlogDTO> blogDTOS = new ArrayList<>();

        blogEntities.stream().forEach(blogEntity -> {
            blogDTOS.add(objectMapper.convertValue(blogEntity, BlogDTO.class));
        });
        return blogDTOS;
    }
}
