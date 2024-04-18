package com.spring.blog.service;

import com.spring.blog.dto.BlogEntryDTO;
import com.spring.blog.dto.BlogEntryResponseDTO;

import java.util.List;

public interface IBlogService {

    BlogEntryResponseDTO findBlogById(Integer id);

    List<BlogEntryResponseDTO> findAllBlogs();

    Integer createBlog(BlogEntryDTO blogEntry);

}
