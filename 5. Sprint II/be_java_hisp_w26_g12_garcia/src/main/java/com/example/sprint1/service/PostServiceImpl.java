package com.example.sprint1.service;

import com.example.sprint1.dto.PostDto;
import com.example.sprint1.dto.ProductDto;
import com.example.sprint1.exception.AlreadyInUseException;
import com.example.sprint1.model.Post;
import com.example.sprint1.model.Product;
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
     * US 0005 - Adds a new post to the repository
     * @param postDto - The DTO containing all necessary data to create a post.
     * @return postDto - Returns the PostDto after the post has been successfully added to the repository.
     */
    @Override
    public PostDto addPost(PostDto postDto) {
        validatePostDto(postDto);
        Post post = convertDtoToEntity(postDto);
        if (postRepository.findById(post.getId()) != null) {
            throw new AlreadyInUseException("A post with this ID already exists.");
        }
        postRepository.save(post);
        return postDto;
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

        post.setProduct(convertProductDtoToEntity(postDto.getProduct()));
        System.out.println("Producto: " + postDto.getProduct() + ", Tipo de dato: " + postDto.getProduct().getClass());
        post.setHas_promo(false);  // Promociones y descuentos se manejan por separado
        System.out.println("Tiene promoción: " + post.isHas_promo() + ", Tipo de dato: " + Boolean.TYPE);
        post.setDiscount(0.0);
        return post;
    }

    private Product convertProductDtoToEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setProduct_name(productDto.getProduct_name());
        product.setType(productDto.getType());
        product.setBrand(productDto.getBrand());
        product.setColor(productDto.getColor());
        product.setNotes(productDto.getNotes());

        return product;
    }


    /**
     * Req. US0006 - US0009
     * This method is used to check which metod is called by the controller.
     * It calls the followedList method or selectIforderFollowedList to obtain the list of followed posts and then sorts if required it by date.
     * @param userId, order - The userId of the user and the order of the list.
     * @return List<PostForListDto> - The list of posts sorted by date.
     */
    @Override
    public List<PostForListDto> selectIfOrderFollowedList(Integer userId , String order){
        // Check the value of the 'order' parameter.
        if(order==null){
            return followedList(userId);
        }else if(order.equals("date_asc")||order.equals("date_desc")){
            return followedListSortedByDate(userId, order);
        }else{
            // If 'order' is neither "date_desc" nor "date_asc", it's an invalid value.
            throw new BadRequestException("Invalid sorting order: " + order);
        }
    }

    /**
     * Req. US0006
     * It calls the followedList method to obtain the list of followed posts.
     * @param userId, order - The userId of the user and the order of the list.
     * @return List<PostForListDto> - The list of posts sorted by date.
     */
    // Method to obtain the list of followed posts of a user, sorted by date. REQ. US0006

    public List<PostForListDto> followedList(Integer userId) {
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

        // Sort the list by date in descending order.
        orderList = sortedList.stream()
                .sorted(Comparator.comparing(post -> LocalDate.parse(((Post) post).getDate(),formatter)).reversed())
                .toList();

        return orderList.stream().map(post -> mapper.convertValue(post, PostForListDto.class)).collect(Collectors.toList());
    }

    /**
     * REQ. US0009
     * This method is used to sort the list of followed posts of a user by date.
     * It calls the followedList method to obtain the list of followed posts and then sorts it by date.
     * @param userId, order - The userId of the user and the order of the list.
     * @return List<PostForListDto> - The list of posts sorted by date.
     */
    public List<PostForListDto> followedListSortedByDate(Integer userId , String order) {
        // Call the followedList method to obtain the list of followed posts.
        List<PostForListDto> sortedList = followedList(userId);
        //Auxiliary to give the format necessary to sort functions
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        // Sort the list by date in the specified order.
        if(order.equals("date_asc")){
            // Sort the list by date in ascending order.
            return sortedList.stream()
                    .sorted(Comparator.comparing(post -> LocalDate.parse(post.getDate(),formatter))).toList();
        }else{
            // Sort the list by date in descending order.
            return followedList(userId);
        }
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
