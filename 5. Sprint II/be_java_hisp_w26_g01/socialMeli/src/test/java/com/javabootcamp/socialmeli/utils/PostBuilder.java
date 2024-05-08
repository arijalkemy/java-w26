package com.javabootcamp.socialmeli.utils;

import com.javabootcamp.socialmeli.model.Post;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

public class PostBuilder {

    public static Post post(LocalDate fecha, Integer id){
        return new Post(
                UserBuilder.userSeller(2),
                id,
                fecha,
                ProductBuilder.product(),
                1,
                15.0,
                false,
                5.0
        );
    }
}
