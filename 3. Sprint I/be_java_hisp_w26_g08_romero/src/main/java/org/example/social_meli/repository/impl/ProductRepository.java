package org.example.social_meli.repository.impl;

import org.example.social_meli.model.Post;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import org.example.social_meli.repository.IProductRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    ObjectMapper objectMapper=new ObjectMapper();

    private List<Post> postList;

    public ProductRepository() throws IOException {
        this.loadDataBase();
    }

    private void loadDataBase() throws IOException {
        File file;
        List<Post> posts ;
        file= ResourceUtils.getFile("classpath:posts.json");
        posts= objectMapper.readValue(file,new TypeReference<List<Post>>(){});
        postList = posts;
    }

    private void saveDataBase() throws IOException {
        File file;
        file = ResourceUtils.getFile("classpath:posts.json");
        objectMapper.writeValue(file, postList);
    }

    @Override
    public void savePost(Post post) {
        postList.add(post);
        try {
            saveDataBase();
        } catch (IOException e) {
            System.out.println("Error: Archivo no encontrado");
        }
    }

    @Override
    public Boolean existsPost(Integer postId) {
        return postList.stream().anyMatch(post -> post.getPost_id().equals(postId));
    }

    @Override
    public List<Post> getAllPosts() {
        return postList;
    }

    @Override
    public Integer PromoPostCount(Integer userId) {
        return postList.stream()
                .filter(post -> post.getUser_id().equals(userId) && post.isHas_promo())
                .toList()
                .size();
    }

    @Override
    public List<Post> PromoPostList(Integer userId) {
        return postList.stream()
                .filter(post -> post.getUser_id().equals(userId) && post.isHas_promo())
                .toList();
    }
}
