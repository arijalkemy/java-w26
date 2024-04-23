package org.bootcamp.blog.service;

import org.bootcamp.blog.dto.BlogDTO;

import java.util.List;

public interface IBlogService {
    String createBlog(BlogDTO blogDTO);
    BlogDTO getBlog(int id);
    List<BlogDTO> getBlogs();
}
