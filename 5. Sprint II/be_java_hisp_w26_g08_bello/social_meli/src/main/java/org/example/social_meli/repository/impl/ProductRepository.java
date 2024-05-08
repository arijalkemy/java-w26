package org.example.social_meli.repository.impl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.example.social_meli.model.Post;
import org.example.social_meli.repository.IProductRepository;
import org.example.social_meli.utils.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private final Mapper mapper;
    private List<Post> postList;

    public ProductRepository(Mapper mapper) throws IOException {
        this.loadDataBase();
        this.mapper = mapper;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        JavaTimeModule javaTimeModule = new JavaTimeModule();
//        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//        objectMapper.setDateFormat(formatter.getLocale());
//        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ISO_OFFSET_DATE));
//        objectMapper.registerModule(javaTimeModule);
        List<Post> posts ;
        file= ResourceUtils.getFile("classpath:posts.json");
        posts= objectMapper.readValue(file,new TypeReference<List<Post>>(){});
        postList = posts;
    }

    private void saveDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        file = ResourceUtils.getFile("classpath:posts.json");
        objectMapper.writeValue(file, postList);
    }

    @Override
    public Post savePost(Post post) {
        postList.add(post);
        try {
            saveDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return post;
    }

    @Override
    public Boolean existsPost(Integer postId) {
        return postList.stream().anyMatch(post -> post.getPost_id().equals(postId));
    }

    @Override
    public List<Post> getAllPosts() {
        return postList;
    }
}
