package com.example.multicapatemplate.repository;

import com.example.multicapatemplate.model.BlogEntry;

import java.util.List;

public interface IBlogRepository {

    List<BlogEntry> getAll();

    BlogEntry findById(int id);

    boolean save(BlogEntry blogEntry);
}
