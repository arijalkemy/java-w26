package com.youtuber_rest.youtuber_rest.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youtuber_rest.youtuber_rest.model.BlogModel;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    private final Map<Long, BlogModel> blogDatabase;

    
    public BlogRepositoryImpl() {
        this.blogDatabase = new HashMap<>();
    }

    @Override
    public Boolean addBlog(BlogModel newBlog) {
        if(getById(newBlog.getId()) != null){
           return false;
        }
        blogDatabase.put(newBlog.getId(), newBlog);
        return true;
    }

    @Override
    public List<BlogModel> getAll() {
        return new ArrayList<>(this.blogDatabase.values());
    }


    @Override
    public BlogModel getById(Long id) { 
        if(blogDatabase.containsKey(id)|| blogDatabase.isEmpty()) {
            return null;
        }
        return blogDatabase.get(id);
    }
}
