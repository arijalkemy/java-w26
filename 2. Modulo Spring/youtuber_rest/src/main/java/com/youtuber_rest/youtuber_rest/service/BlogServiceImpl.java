package com.youtuber_rest.youtuber_rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.youtuber_rest.youtuber_rest.exception.BlogException;
import com.youtuber_rest.youtuber_rest.model.BlogModel;
import com.youtuber_rest.youtuber_rest.repository.IBlogRepository;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    IBlogRepository blogRepository;
    
    @Override
    public List<BlogModel> getAllBlog() {
        return null;
    }

    @Override
    public Optional<BlogModel> getBlogById(Long id) {
        BlogModel blogReturned = blogRepository.getById(id);
        if(blogReturned == null) throw new BlogException("Blog not found", HttpStatus.NOT_FOUND);
        return Optional.ofNullable(blogReturned);
    }

    @Override
    public Boolean addBLog(BlogModel newBlog) {
        if(blogRepository.getById(newBlog.getId()) != null) {
            throw new BlogException("Id already in DB", HttpStatus.CONFLICT);
        }
        return blogRepository.addBlog(newBlog);
    }
}
