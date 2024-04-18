package org.example._09blog.Repository.Impl;

import org.example._09blog.Model.Blog;
import org.example._09blog.Repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BlogRepository implements IRepository {

    private HashMap<Integer, Blog> blogs;

    public BlogRepository() {
        blogs = new HashMap<>();
    }

    @Override
    public Blog find(int id) {
        return blogs.get(id);
    }

    @Override
    public List<Blog> findAll() {
        return new ArrayList<>(blogs.values());
    }

    @Override
    public Blog save(Blog blog) {
        if (blogs.containsKey(blog.getId())) {
            return null;
        }
        blogs.put(blog.getId(), blog);
        return blog;
    }
}
