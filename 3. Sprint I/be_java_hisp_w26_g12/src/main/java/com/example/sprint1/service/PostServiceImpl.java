package com.example.sprint1.service;

import com.example.sprint1.dto.PostDto;
import com.example.sprint1.exception.AlreadyInUseException;
import com.example.sprint1.model.Post;
import com.example.sprint1.model.User;
import com.example.sprint1.repository.IPostRepository;
import com.example.sprint1.dto.PostForListDto;
import com.example.sprint1.exception.BadRequestException;
import com.example.sprint1.exception.NotFoundException;
import com.example.sprint1.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService {

    private static List<Post> posts = new ArrayList<>();

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserService userService;

    /**
     * This method should be called when a new post submission is received. It handles validation,
     * conversion, and storage of the post data.
     * Adds a new post to the system after validating and converting the provided PostDto.
     * It checks for the existence of the post ID in the repository before saving to avoid duplicates.
     * @param postDto - The DTO containing all necessary data to create a post.
     * @return PostDto - Returns the PostDto after the post has been successfully added to the repository.
     * @throws IllegalArgumentException - If the postDto validation fails or if a post with the same ID already exists.
     */
    @Override
    public PostDto addPost(PostDto postDto) {
        validatePostDto(postDto); // Validates the necessary fields in the postDto
        Post post = convertDtoToEntity(postDto); // Converts postDto to a Post entity
        if (postRepository.findById(post.getId()) != null) {
            throw new AlreadyInUseException("A post with this ID already exists.");
        }
        postRepository.save(post); // Saves the post to the repository
        userService.addPostToUser(postDto.getUser_id(),postDto.getId()); // Adds the post to the user's list of posts
        return postDto; // Returns the PostDto, could be enhanced with more data if needed
    }


    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(int id) {
        return null;
    }

    /**
     * This method is used internally by the addPost method to ensure all required data is valid
     * before proceeding with post creation.
     * @param postDto - The PostDto object containing the data to validate.
     * @throws IllegalArgumentException - If any validation fails.
     */
    private void validatePostDto(PostDto postDto) {
        if (postDto.getUser_id() == null || postDto.getProduct() == null) {
            throw new IllegalArgumentException("User ID and Product must not be null");
        }
        if (postDto.getPrice() < 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        try {
            LocalDate.parse(postDto.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (Exception e) {
            throw new IllegalArgumentException("Date format is invalid, should be 'dd-MM-yyyy'");
        }
    }

    /**
     * This method is used internally by the addPost method to convert the DTO received from the API
     * into the entity model for the database.
     * Converts a PostDto to a Post entity. This includes mapping all necessary fields from the DTO to the entity.
     * @param postDto - The PostDto to be converted.
     * @return Post - The Post entity ready to be saved to the repository.
     */
    private Post convertDtoToEntity(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setUser_id(postDto.getUser_id());
        System.out.println("ID: " + postDto.getId() + ", Tipo de dato: " + postDto.getId().getClass());
        System.out.println("User ID: " + postDto.getUser_id() + ", Tipo de dato: " + postDto.getUser_id().getClass());
        post.setDate(postDto.getDate());
        System.out.println("Fecha: " + postDto.getDate() + ", Tipo de dato: " + postDto.getDate().getClass());
        post.setCategory(postDto.getCategory());
        System.out.println("Categoría: " + postDto.getCategory() + ", Tipo de dato: " + postDto.getCategory().getClass());
        post.setPrice(postDto.getPrice());
        System.out.println("Precio: " + postDto.getPrice() + ", Tipo de dato: " + postDto.getPrice().getClass());
        post.setProduct(postDto.getProduct());
        System.out.println("Producto: " + postDto.getProduct() + ", Tipo de dato: " + postDto.getProduct().getClass());
        post.setHas_promo(false);  // Promociones y descuentos se manejan por separado
        System.out.println("Tiene promoción: " + post.isHas_promo() + ", Tipo de dato: " + Boolean.TYPE);
        post.setDiscount(0.0);
        return post;
    }


    // Method to obtain the list of followed posts of a user, sorted by date. REQ. US0006, US0009
    @Override
    public List<PostForListDto> followedList(Integer userId, String order) {
        // Validations:
        // If the obtained list is empty (No existing user or No pub)
        // Check the value of the 'order' parameter.

        Optional<User> user = userRepository.getUserById(userId);
        if(user.isEmpty()){
            throw new NotFoundException("No se encontró al usuario");
        }
        Set<Integer> followedList = user.get().getFollowed();

        if(followedList.size()==0){
            throw new NotFoundException("Sin publicaciones recientes");
        }
        List<Post> sortedList = new ArrayList<>();
        for(Integer i: followedList){
            List<Post> followerdPosts = postRepository.getResentPost(i);
            sortedList.addAll(followerdPosts);
        }
        // Retrieve the list of recent posts (Last two weeks) from the repository for the given user.

        List<Post> orderList;
        ObjectMapper mapper = new ObjectMapper();
        //Auxiliary to give the format necessary to sort functions
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


        if (order == null || order.trim().isEmpty() || order.equals("date_desc")) {
            // If 'order' is null, empty, or "date_desc", sort the list by date in descending order.
             orderList = sortedList.stream()
                    .sorted(Comparator.comparing(post -> LocalDate.parse(((Post) post).getDate(),formatter)).reversed())
                    .toList();
        } else if (order.equals("date_asc")) {
             orderList = sortedList.stream()
                    .sorted(Comparator.comparing(post -> LocalDate.parse(post.getDate(),formatter))).toList();
        } else {
            // If 'order' is neither "date_desc" nor "date_asc", it's an invalid value.
            throw new BadRequestException("Invalid sorting order: " + order);
        }
        return orderList.stream().map(post -> mapper.convertValue(post, PostForListDto.class)).collect(Collectors.toList());
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
