package com.example.sprint1.service;

import com.example.sprint1.dto.PostDto;
import com.example.sprint1.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    IPostRepository postRepository;


    @Override
    public Object addPost(PostDto postDto) {
        return null;
    }

    @Override
    public Object followedList(Integer userId, String order) {
        return null;
    }

    @Override
    public Object followedList(Integer userId) {
        return null;
    }

    @Override
    public Object postPromo(PostDto postDto) {
        return null;
    }

    @Override
    public Object quantityPromo(Integer user_id) {
        return null;
    }

    @Override
    public Object getPromo(Integer user_id) {
        return null;
    }
}