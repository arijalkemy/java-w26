package org.bootcamp.manejo_de_excepciones_p1_blog.repository;

import org.bootcamp.manejo_de_excepciones_p1_blog.entity.Blog;
import org.bootcamp.manejo_de_excepciones_p1_blog.exception.ExistingResourceException;
import org.bootcamp.manejo_de_excepciones_p1_blog.exception.NonExistentResourceException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BlogRepository implements IBlogRepository {
    private Map<Integer, Blog> blogs = new HashMap<>();

    @Override
    public Integer createNewBlog(Integer idBlog, Blog blog) {
        blogs.put(idBlog, blog);
        return idBlog;
    }

    @Override
    public Map<Integer, Blog> getAllBlogs() {
        return blogs;
    }

    @Override
    public Blog getBlogById(Integer id) {
        return blogs.get(id);
    }
}
