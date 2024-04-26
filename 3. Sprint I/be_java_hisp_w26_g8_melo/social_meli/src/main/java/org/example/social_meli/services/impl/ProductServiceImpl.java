package org.example.social_meli.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.social_meli.dto.*;
import org.example.social_meli.exceptions.BadRequestException;
import org.example.social_meli.exceptions.ConflictException;
import org.example.social_meli.exceptions.NotFoundException;
import org.example.social_meli.model.Post;
import org.example.social_meli.model.User;
import org.example.social_meli.repository.IProductRepository;
import org.example.social_meli.repository.IUserRepository;
import org.example.social_meli.services.IProductService;
import org.example.social_meli.services.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IUserService userServiceImpl;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<PostDTO> getAllPosts() {
        ModelMapper mapper = new ModelMapper();
        return productRepository.getAllPosts().stream().map(post -> mapper.map(post, PostDTO.class)).toList();
    }

    @Override
    public PostDTO savePost(PostDTO postDTO) {
        ModelMapper mapper = new ModelMapper();
        if (productRepository.existsPost(postDTO.getPost_id())) {
            throw new ConflictException("Ya existe un post con el id " + postDTO.getPost_id());
        }
        if (!userRepository.existsSellerById(postDTO.getUser_id())) {
            throw new NotFoundException("No existe un usuario con el id " + postDTO.getUser_id());
        }
        productRepository.savePost(mapper.map(postDTO, Post.class));
        return postDTO;
    }

    @Override
    public FollowedPostListDTO getSellersPostsFollowedByUser(Integer id) {
        UserResponseDTO followerList = userServiceImpl.getFollowedById(id);
        List<PostDTO> postDTOList = getAllPosts();
        FollowedPostListDTO followedPostListDTO = new FollowedPostListDTO();
        if(!followerList.getFollower().isEmpty()){
            postDTOList = followerList.getFollower().stream()
                    .flatMap(follower -> getAllPosts().stream()
                            .filter(post -> post.getUser_id().equals(follower.getUser_id())))
                    .toList();

        }

        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        twoWeeksAgo.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        postDTOList = postDTOList.stream()
                .filter(post -> post.getDate().isAfter(twoWeeksAgo)).toList();

        followedPostListDTO.setUser_id(id);
        followedPostListDTO.setPost(postDTOList);

        return followedPostListDTO;
    }

    @Override
    public FollowedPostListDTO getOrderedSellersPostsFollowedByUser(Integer id, String orderBy) {
        FollowedPostListDTO response = getSellersPostsFollowedByUser(id);
        if (!orderBy.equals("date_asc") && !orderBy.equals("date_desc"))
            throw new BadRequestException("El parametro de ordenamiento no es valido");
        return (orderBy.equals("date_asc")?
                getOrderedSellersPostsFollowedByUserAsc(response):
                getOrderedSellersPostsFollowedByUserDesc(response));
    }

    @Override
    public PromoPostDTO savePromoPost(PromoPostDTO post) {
        User user= userRepository.findById(post.getUser_id());
        if(!user.getIsSeller()){
            throw new BadRequestException("Solo los usuarios vendedores pueden realizar publicaciones");
        }
        Post postToSave = objectMapper.convertValue(post, Post.class);
        postToSave = productRepository.savePost(postToSave);

        return objectMapper.convertValue(postToSave,PromoPostDTO.class);
    }

    @Override
    public UserCountPromoPostDTO getPromoPostCountByUser(Integer id) {
        User user = userRepository.findById(id);
        if(user==null){
            throw new NotFoundException("El usuario no existe");
        }
        List<Post> postList = productRepository.findAllPostsByUserId(id);
        postList= postList.stream().filter(Post::getHas_promo).toList();
        UserCountPromoPostDTO response = new UserCountPromoPostDTO();
        response.setUser_id(user.getUser_id());
        response.setUser_name(user.getUser_name());
        response.setPromo_products_count(postList.size());
        return response;
    }

    @Override
    public UserPromoPostListDTO getPromoPostByUser(Integer userId) {
        UserPromoPostListDTO response=new UserPromoPostListDTO();
        User user = userRepository.findById(userId);
        response.setUser_id(user.getUser_id());
        response.setUser_name(user.getUser_name());
        List<Post> postList = productRepository.findAllPostsByUserId(userId);
        response.setPosts(postList.stream().map(post-> objectMapper.convertValue(post,PromoPostDTO.class)).toList());
        return response;
    }

    @Override
    public FollowedPromoPostDTO getFollowedPromoPostByUser(Integer userId) {
        UserResponseDTO followedList = userServiceImpl.getFollowedById(userId);
        List<Post> postList = productRepository.findAllPromoPost();
        FollowedPromoPostDTO response = new FollowedPromoPostDTO();
        response.setUser_id(userId);
        if(!followedList.getFollower().isEmpty()){
            response.setPosts(
                    postList.stream()
                            .map(post ->
                                    objectMapper.convertValue(post,PromoPostDTO.class))
                            .toList()
            );
        }
        return response;
    }

    private FollowedPostListDTO getOrderedSellersPostsFollowedByUserAsc(FollowedPostListDTO response){
        response.setPost(response.getPost()
                .stream()
                .sorted(Comparator.comparing(PostDTO::getDate))
                .toList());
        return response;
    }

    private FollowedPostListDTO getOrderedSellersPostsFollowedByUserDesc(FollowedPostListDTO response){
        response.setPost(response.getPost()
                .stream()
                .sorted(Comparator.comparing(PostDTO::getDate).reversed())
                .toList());
        return response;
    }
}
