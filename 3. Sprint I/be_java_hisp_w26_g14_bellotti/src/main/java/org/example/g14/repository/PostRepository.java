package org.example.g14.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.g14.exception.NotFoundException;
import org.example.g14.model.Post;
import org.example.g14.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepository implements IPostRepository{
    private List<Post> listOfPosts;
    private static int postId;

    public PostRepository() throws IOException {
        //load list
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        List<Post> posts;

        file = ResourceUtils.getFile("classpath:PostsDB.json");
        posts = objectMapper.readValue(file, new TypeReference<List<Post>>() {
        });

        listOfPosts = posts;
        postId = posts.size();
    }

    @Override
    public List<Post> findAllByUser(int idUser) {
        return listOfPosts.stream()
                .filter(post -> post.getIdUser() == idUser)
                .collect(Collectors.toList());
    }

    @Override
    public void save(Post post) {
        if(post.getId()>0){
            for (int i = 0; i < listOfPosts.size(); ++i) {
                if (listOfPosts.get(i).getId() == post.getId()) {

                    listOfPosts.set(i, post);
                    break;
                }
            }
        }else{
            post.setId(postId);
            listOfPosts.add(post);
            postId++;
        }
    }
}
