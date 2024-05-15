package org.example.g14.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.g14.model.Post;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository{
    private final List<Post> listOfPosts;

    public PostRepository() throws IOException {
        //load list
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        List<Post> posts;

        file = ResourceUtils.getFile("classpath:PostsDB.json");
        posts = objectMapper.readValue(file, new TypeReference<>() {
        });

        listOfPosts = posts;
    }

    @Override
    public List<Post> findAllByUser(int idUser) {
        return listOfPosts.stream()
                .filter(post -> post.getIdUser() == idUser)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Post post) {
        post.setId(getMaxId() + 1);
        listOfPosts.add(post);
    }

    private int getMaxId(){
        return listOfPosts.stream().mapToInt(Post::getId).max().orElse(0);
    }
}
