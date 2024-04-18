package com.spring.blog.repository;

import com.spring.blog.entity.BlogEntry;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Getter
@Repository
public class BlogsRepository {

    private HashMap<Integer, BlogEntry> blogRepository;

    public BlogsRepository() {
        this.blogRepository = new HashMap<>();
    }

}
