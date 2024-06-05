package com.meli.blog_vivo.repository;

import com.meli.blog_vivo.entity.Blog;

import java.util.ArrayList;
import java.util.List;

public class BlogRepository implements IBlogRepository{

    public List<Blog> blogDB = new ArrayList<>();

    @Override
    public Integer createBlog(Blog blog) {
        blogDB.add(blog);
        return blog.getId();
    }

    @Override
    public Blog findOne(Integer id) {
        Blog result =  blogDB.stream().filter(b -> b.getId()==id).findFirst().orElse(null);
        return result;
    }

    @Override
    public List<Blog> findAll() {
        return blogDB;
    }
}
