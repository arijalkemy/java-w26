package org.example.exceptions_p1_yt_blog.repository;

import org.example.exceptions_p1_yt_blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {
    Map<Integer, Blog> blogEntries;

    public BlogRepositoryImpl() {
        blogEntries = new HashMap<>();
    }

    @Override
    public List<Blog> getAll() {
        return new ArrayList<>(this.blogEntries.values());
    }

    @Override
    public Blog findById(int id) {
        return this.blogEntries.get(id);
    }

    @Override
    public boolean save(Blog blogEntry) {
        if( this.blogEntries.containsKey(blogEntry.getId())) {
            return false;
        }
        this.blogEntries.put(blogEntry.getId(), blogEntry);
        return true;
    }
}
