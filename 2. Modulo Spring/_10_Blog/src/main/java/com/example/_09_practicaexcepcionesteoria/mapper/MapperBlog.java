package com.example._09_practicaexcepcionesteoria.mapper;

import com.example._09_practicaexcepcionesteoria.dto.BlogPostDTO;
import com.example._09_practicaexcepcionesteoria.entity.BlogPost;

public class MapperBlog {

    public BlogPostDTO transferToDTO(BlogPost blogPost){
        BlogPostDTO blogPostDTO = new BlogPostDTO(
                blogPost.getIdBlog(),
                blogPost.getTitle(),
                blogPost.getAuthor(),
                blogPost.getPublicationDate()
        );

        return blogPostDTO;
    }

    public BlogPost transferToEntity(BlogPostDTO blogPostDTO){
        BlogPost blogPost = new BlogPost(
                blogPostDTO.getIdBlog(),
                blogPostDTO.getTitle(),
                blogPostDTO.getAuthor(),
                blogPostDTO.getPublicationDate()
        );

        return blogPost;
    }

}
