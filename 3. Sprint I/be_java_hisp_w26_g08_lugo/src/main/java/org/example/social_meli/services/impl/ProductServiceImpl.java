package org.example.social_meli.services.impl;

import org.example.social_meli.dto.*;
import org.example.social_meli.exceptions.BadRequestException;
import org.example.social_meli.exceptions.ConflictException;
import org.example.social_meli.exceptions.NotFoundException;
import org.example.social_meli.model.FollowerList;
import org.example.social_meli.model.Post;
import org.example.social_meli.model.PromoPost;
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

    @Override
    public List<PostDTO> getAllPosts() {
        ModelMapper mapper = new ModelMapper();
        return productRepository.getAllPosts().stream().map(post -> mapper.map(post, PostDTO.class)).toList();
    }

    @Override
    public List<PromoPostDTO> getAllPromoPosts() {
        ModelMapper mapper = new ModelMapper();
        return productRepository.getAllPromoPosts().stream().map(post -> mapper.map(post, PromoPostDTO.class)).toList();
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
    public PromoPostDTO savePromoPost(PromoPostDTO promoPostDTO) {
        ModelMapper mapper = new ModelMapper();

        if (productRepository.existsPost(promoPostDTO.getPost_id())){
            throw new ConflictException("Ya existe un post con el id " + promoPostDTO.getPost_id());
        }
        if(!userRepository.existsSellerById(promoPostDTO.getUser_id())){
            throw new NotFoundException("No existe un usuario con el id " + promoPostDTO.getUser_id());
        }

        productRepository.savePromoPost(mapper.map(promoPostDTO, PromoPost.class));
        return promoPostDTO;
    }

    @Override
    public PromoPostResponseDTO countPromoPostBySeller(Integer id) {
        FollowerList seller = userRepository.findSellerById(id);
        return new PromoPostResponseDTO(
                seller.getUser().getUser_id(),
                seller.getUser().getUser_name(),
                (int) productRepository.getAllPromoPosts()
                        .stream()
                        .filter(p -> p.getUser_id().equals(id)).filter(PromoPost::isHas_promo).count()
        );
    }

    public PromoPostListDTO getPromoPostsBySeller(Integer id){
        FollowerList seller = userRepository.findSellerById(id);
        List<PromoPostDTO> promoPostDTOList = getAllPromoPosts();

        if(!promoPostDTOList.isEmpty()){
            promoPostDTOList = promoPostDTOList
                    .stream()
                    .filter(p -> p.getUser_id().equals(id)).filter(PromoPostDTO::isHas_promo).toList();
        }

        return new PromoPostListDTO(
                seller.getUser().getUser_id(),
                seller.getUser().getUser_name(),
                promoPostDTOList
        );
    }

    @Override
    public PromoPostListDTO getOrderedPromoPostsBySeller(Integer id, String orderBy) {
        PromoPostListDTO response = getPromoPostsBySeller(id);
        if (!orderBy.equals("product_name_asc") && !orderBy.equals("product_name_desc")){
            throw new BadRequestException("El parametro de ordenamiento no es valido");
        }

        return (orderBy.equals("product_name_asc"))?
                getOrderedPromoPostsBySellerAsc(response):
                getOrderedPromoPostsBySellerDesc(response);
    }

    public PromoPostListDTO getOrderedPromoPostsBySellerAsc(PromoPostListDTO promoPostListDTO){
        promoPostListDTO.setPosts(promoPostListDTO.getPosts()
                .stream()
                .sorted(Comparator.comparing(p -> p.getProduct().getProduct_name())).toList());
        return promoPostListDTO;
    }
    public PromoPostListDTO getOrderedPromoPostsBySellerDesc(PromoPostListDTO promoPostListDTO){
        promoPostListDTO.setPosts(promoPostListDTO.getPosts()
                .stream()
                .sorted(Comparator.comparing(p -> p.getProduct().getProduct_name(), Comparator.reverseOrder())).toList());
        return promoPostListDTO;
    }

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
