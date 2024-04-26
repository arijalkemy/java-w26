package org.example.social_meli.services.impl;

import org.example.social_meli.dto.FollowListDTO;
import org.example.social_meli.dto.PostDTO;
import org.example.social_meli.dto.UserDTO;
import org.example.social_meli.dto.UserResponseDTO;
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
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductRepository productRepository;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IUserService userServiceImpl;

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
    public FollowListDTO getSellersPostsFollowedByUser(Integer id) {
        UserResponseDTO followerList = userServiceImpl.getFollowedById(id);
        List<PostDTO> postDTOList = getAllPosts();
        FollowListDTO followListDTO = new FollowListDTO();
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

        followListDTO.setUser_id(id);
        followListDTO.setPost(postDTOList);

        return followListDTO;
    }

    @Override
    public FollowListDTO getOrderedSellersPostsFollowedByUser(Integer id, String orderBy) {
        FollowListDTO response = getSellersPostsFollowedByUser(id);
        if (!orderBy.equals("date_asc") && !orderBy.equals("date_desc"))
            throw new BadRequestException("El parametro de ordenamiento no es valido");
        return (orderBy.equals("date_asc")?
                getOrderedSellersPostsFollowedByUserAsc(response):
                getOrderedSellersPostsFollowedByUserDesc(response));
    }

    @Override
    public UserDTO getPromoPostCount(Integer userId) {
        User user = findUserByIdOrThrow(userId);
        return new UserDTO(user.getUser_id(),
                user.getUser_name(),
                productRepository.PromoPostCount(userId));
    }

    @Override
    public List<PostDTO> getPromoPostList(Integer userId) {
        User user = findUserByIdOrThrow(userId);
        return mapPostsToPostDTOs(productRepository.PromoPostList(userId));
    }

    private List<PostDTO> mapPostsToPostDTOs(List<Post> posts) {
        ModelMapper mapper = new ModelMapper();
        return posts.stream()
                .map(post -> mapper.map(post, PostDTO.class))
                .collect(Collectors.toList());
    }

    private User findUserByIdOrThrow(Integer userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new NotFoundException("No existe un usuario con el id " + userId);
        }
        return user;
    }

    private FollowListDTO getOrderedSellersPostsFollowedByUserAsc(FollowListDTO response){
        response.setPost(response.getPost()
                .stream()
                .sorted(Comparator.comparing(PostDTO::getDate))
                .toList());
        return response;
    }

    private FollowListDTO getOrderedSellersPostsFollowedByUserDesc(FollowListDTO response){
        response.setPost(response.getPost()
                .stream()
                .sorted(Comparator.comparing(PostDTO::getDate).reversed())
                .toList());
        return response;
    }
}
