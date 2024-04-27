package org.example.blog.repositories;

import org.example.blog.entities.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepository implements IBlogRepository {
    private final Map<Integer, Blog> blogs;

    public BlogRepository() {
        this.blogs = new HashMap<>();
    }

    @Override
    public Blog getBlogById(Integer id) {
        if (!this.blogs.containsKey(id)) {
            return null;
        }
        return this.blogs.get(id);
    }

    @Override
    public boolean saveBlog(Blog blog) {
        if (getBlogById(blog.getId()) != null) {
            return false;
        }
        this.blogs.put(blog.getId(), blog);
        return true;
    }

    @Override
    public List<Blog> getListBlog() {
        return new ArrayList<>(this.blogs.values());
    }
}
