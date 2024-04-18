package com.example.multicapatemplate.repository.impl;

import com.example.multicapatemplate.model.BlogEntry;
import com.example.multicapatemplate.repository.IBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {
    Map<Integer, BlogEntry> blogEntries;

    public BlogRepositoryImpl() {
        this.blogEntries = new HashMap<>();
    }

    @Override
    public List<BlogEntry> getAll() {

        return new ArrayList<>(this.blogEntries.values());
    }

    @Override
    public BlogEntry findById(int id) {
        return this.blogEntries.get(id);
    }

    @Override
    public boolean save(BlogEntry blogEntry) {
        if( this.blogEntries.containsKey(blogEntry.getId())) {
            return false;
        }
        this.blogEntries.put(blogEntry.getId(), blogEntry);
        return true;
    }
}
