package com.meli.be_java_hisp_w26_g09.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.be_java_hisp_w26_g09.entity.Post;
import com.meli.be_java_hisp_w26_g09.repository.IPostRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.*;

@Repository
public class PostRepositoryImpl implements IPostRepository {
    List<Post> listOfPost;
    Integer counter;

    public PostRepositoryImpl() {
        this.listOfPost = new ArrayList<>();
        loadDataBase();
        counter = Objects.requireNonNull(listOfPost.stream()
                        .max(Comparator.comparing(Post::getId)).orElse(null)).getId();
    }

    private void loadDataBase() {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());



        try {
            file = ResourceUtils.getFile("classpath:posts_generated.json");
            Post[] posts = objectMapper.readValue(file, Post[].class);
            listOfPost.addAll(Arrays.stream(posts).toList());
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void createPost(Post post) {
        counter++;
        post.setId(counter);
        listOfPost.add(post);
        System.out.println(listOfPost);
    }

    @Override
    public List<Post> findAll() {
        return listOfPost;
    }

    @Override
    public List<Post> filterBySeller(Integer idSeller, boolean hasPromo) {

        if (hasPromo)
            return this.listOfPost.stream().filter(post -> post.getUserId().equals(idSeller) && post.getHasPromo()).toList();

        return this.listOfPost.stream().filter(post -> post.getUserId().equals(idSeller)).toList();
    }

}
