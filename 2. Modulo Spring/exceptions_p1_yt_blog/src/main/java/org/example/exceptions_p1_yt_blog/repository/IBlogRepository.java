package org.example.exceptions_p1_yt_blog.repository;

import org.example.exceptions_p1_yt_blog.entity.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> getAll();
    Blog findById(int id);
    boolean save(Blog blogEntry);
}
