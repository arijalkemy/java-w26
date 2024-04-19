package org.bootcamp.manejo_de_excepciones_p1_blog.repository;

import org.bootcamp.manejo_de_excepciones_p1_blog.entity.Blog;

import java.util.List;
import java.util.Map;

public interface IBlogRepository {
    public Integer createNewBlog(Integer idBlog, Blog blog);
    public Map<Integer, Blog> getAllBlogs();
    public Blog getBlogById(Integer id);
}
