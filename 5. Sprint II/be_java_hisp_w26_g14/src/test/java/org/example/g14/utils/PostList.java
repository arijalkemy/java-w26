package org.example.g14.utils;

import org.example.g14.model.Post;
import org.example.g14.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostList {
    public static List<Post> getPostResponse(){
        Post playStation = new Post(
                LocalDate.of(2024, 05, 05),
                22,
                1,
                new Product(1,
                        "play station",
                        "videojuego",
                        "PS", 
                        "negro",
                        ""),
                1
        );

        Post xboxSeries = new Post(
                LocalDate.of(2024, 05, 01),
                22,
                1,
                new Product(2,
                        "xbox",
                        "videojuego",
                        "PS",
                        "blanco",
                        ""),
                1
        );

        Post pcPost = new Post(
                LocalDate.of(2024, 05, 03),
                22,
                1,
                new Product(1,
                        "pc",
                        "videojuego",
                        "PS",
                        "blanco",
                        ""
                ),
                1
        );

        List<Post> posts = new ArrayList<>();
        posts.add(playStation);
        posts.add(xboxSeries);
        posts.add(pcPost);

        return posts;
    }
}
