package com.blog.excercise.service;

import com.blog.excercise.dto.BlogDTO;
import com.blog.excercise.entity.EntradaBlog;

import java.util.List;

public interface BlogService {

    Integer postNewBlog(BlogDTO inputBlogDTO);

    BlogDTO getBlogById(Integer id);

    List<BlogDTO> getAllBlogs();
}
