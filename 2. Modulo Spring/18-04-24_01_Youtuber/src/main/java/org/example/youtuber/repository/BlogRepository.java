package org.example.youtuber.repository;

import org.example.youtuber.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BlogRepository {

    private final Map<Integer, Blog> blogStorage = new HashMap<>();

    public Blog save(Blog blog) {
        blogStorage.put(blog.getId(), blog);
        return blog;
    }

    public Blog findById(Integer id) {
        return blogStorage.get(id);
    }

    public List<Blog> findAll() {
        return blogStorage.values().stream().collect(Collectors.toList());
    }

    public boolean existsById(Integer id) {
        return blogStorage.containsKey(id);
    }
}
