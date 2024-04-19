package org.bootcamp.manejo_de_excepciones_p1_blog.service;


import org.bootcamp.manejo_de_excepciones_p1_blog.dto.BlogDTO;
import org.bootcamp.manejo_de_excepciones_p1_blog.dto.RequestBlogDTO;
import org.bootcamp.manejo_de_excepciones_p1_blog.dto.ResponseBlogDTO;

import java.util.List;

public interface IBlogService {
    public ResponseBlogDTO addBlog(RequestBlogDTO blog);
    public List<BlogDTO> getBlogs();
    public BlogDTO getBlog(Integer id);
}
