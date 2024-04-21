package org.example.blog.repository;

import org.example.blog.model.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements IBlogRepository{

    List<BlogEntry> blogEntries;

    public BlogRepository() {
        this.blogEntries = new ArrayList<>();
    }

    @Override
    public Integer add(BlogEntry newBlogEntry) {
        blogEntries.add(newBlogEntry);
        return newBlogEntry.getId();
    }

    @Override
    public BlogEntry findById(Integer id) {
        return blogEntries.stream().filter(x->x.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<BlogEntry> findAll() {
        return blogEntries;
    }
    @Override
    public Boolean exist(Integer id){
        return !blogEntries.stream().filter(x->x.getId().equals(id)).toList().isEmpty();
    }
}
