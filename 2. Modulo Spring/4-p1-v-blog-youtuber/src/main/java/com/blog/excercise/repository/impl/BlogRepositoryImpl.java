package com.blog.excercise.repository.impl;

import com.blog.excercise.dto.BlogDTO;
import com.blog.excercise.entity.EntradaBlog;
import com.blog.excercise.repository.BlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository {

    private List<EntradaBlog> blogRepositoryList;

    public BlogRepositoryImpl(){
        this.blogRepositoryList = new ArrayList<>();
    }

    @Override
    public Integer saveNewBlog(EntradaBlog entradaBlog){
        blogRepositoryList.add(entradaBlog);
        return entradaBlog.getId();
    }

    @Override
    public EntradaBlog getBlogsByUserId(Integer userId){
        return blogRepositoryList.stream()
                .filter(blog -> blog.getId().equals(userId)).findFirst().orElse(null);
    }

    @Override
    public List<EntradaBlog> getAllBlogs(){
        return blogRepositoryList;
    }

}
