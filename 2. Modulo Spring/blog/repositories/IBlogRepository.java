package org.example.blog.repositories;

import org.example.blog.entities.Blog;

import java.util.List;
import java.util.Map;

public interface IBlogRepository {
    boolean saveBlog(Blog blog);

    Blog getBlogById(Integer id);

    List<Blog> getListBlog();
}
