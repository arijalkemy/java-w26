package com.meli.be_java_hisp_w26_g09.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.entity.Post;
import com.meli.be_java_hisp_w26_g09.repository.IPostRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Repository
public class PostRepositoryImpl implements IPostRepository {
    List<Post> listOfPost = new ArrayList<>();
    Integer counter;

    public PostRepositoryImpl() throws IOException {
        loadDataBase();
        counter = Objects.requireNonNull(listOfPost.stream()
                        .max(Comparator.comparing(Post::getId)).orElse(null)).getId();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Post> posts;

        file = ResourceUtils.getFile("classpath:posts_generated.json");
        posts = objectMapper.readValue(file, new TypeReference<>() {
        });
        listOfPost = posts;
    }

    @Override
    public void createPost(Post post) {
        counter++;
        post.setId(counter);
        listOfPost.add(post);
    }

    @Override
    public List<Post> findAll() {
        return listOfPost;
    }
}
