package com.meli.blog_vivo.repository;

import com.meli.blog_vivo.entity.Blog;

import java.util.List;

public interface IBlogRepository {
    public Integer createBlog(Blog blog);
    public Blog findOne(Integer id);
    public List<Blog> findAll();
}
