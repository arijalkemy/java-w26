package com.example.sprint1.repository;

import com.example.sprint1.model.Post;
import com.example.sprint1.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements IPostRepository {

    // begin modify Leonardo
    // A static list that stores all posts loaded from the JSON file or added dynamically. ArrayList.
    private static List<Post> listOfPosts = new ArrayList<>();

    /**
     * Constructor that loads the database of posts from a JSON file when an instance of the repository is created.
     * @throws IOException If there is an error reading the file, an IOException is thrown.
     */

    public PostRepositoryImpl() throws IOException {
        loadDatabase();
    }

    /**
     * Loads posts from a JSON file into the listOfPosts list.
     * converts the JSON data into Post objects and adds them to the listOfPosts list.
     * @throws IOException If the JSON file cannot be read or the data cannot be parsed, an IOException is thrown.
     */
    private void loadDatabase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        // Added
        file = ResourceUtils.getFile("classpath:posts.json");
        List<Post> posts = objectMapper.readValue(file, new TypeReference<List<Post>>() {});
        listOfPosts.addAll(posts); // Adds loaded posts to the list of posts
    }

    /**
     * Saves a new post to the list or throws an exception if a post with the same ID already exists.
     * @param post - The Post object to be saved.
     * @return Post - The Post object that was saved.
     */
    @Override
    public Post save(Post post){
        // Checks if the ID already exists
        if (findById(post.getId()) != null){
            throw new IllegalArgumentException("Post with ID: " + post.getId() + " already exists");
        }
        listOfPosts.add(post); // Adds the post to the list
        return post;
    }
    // finished modify Leonardo

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(listOfPosts);
    }

    // begin modify Leonardo
    /**
     * Finds a post by its unique ID in the list of posts.
     * @param id - The integer ID of the post to be retrieved.
     * @return Post - Returns the post with the specified ID or null if no such post exists.
     */
    @Override
    public Post findById(Integer id) {
        // Returns the post with the specified ID, or null if no such post exists
        return listOfPosts.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    // finished modify Leonardo

    /**
     * Returns all the recent posts
     * @param userId
     * @return
     */
    @Override
    public List<Post> getResentPost(Integer userId) {
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return listOfPosts.stream()
                .filter(post -> post.getUser_id().equals(userId))
                .filter(post -> LocalDate.parse(post.getDate(), formatter).isAfter(twoWeeksAgo))
                .collect(Collectors.toList());
    }

}

