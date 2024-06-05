package com.meli.blog_vivo.service;

import com.meli.blog_vivo.dto.BlogDTO;
import com.meli.blog_vivo.entity.Blog;

import java.util.List;

public interface IBlogService {
    public Integer addBlog(BlogDTO blog);
    public BlogDTO searchOne(Integer id);
    public List<BlogDTO> searchAll();
}
