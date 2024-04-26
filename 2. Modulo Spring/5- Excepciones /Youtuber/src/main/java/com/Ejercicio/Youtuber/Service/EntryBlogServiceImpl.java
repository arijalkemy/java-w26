package com.Ejercicio.Youtuber.Service;

import com.Ejercicio.Youtuber.Entity.EntryBlog;
import com.Ejercicio.Youtuber.Repository.IEntryBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntryBlogServiceImpl implements IEntryBlogService{

    @Autowired
    IEntryBlogRepository repository;

    @Override
    public Integer saveEntryBlog(EntryBlog entryBlog) {
        if (repository.exist(entryBlog.getId())){
            throw  new RuntimeException("Id existente");
        }
        return repository.saveEntryBlog(entryBlog);
    }
}
