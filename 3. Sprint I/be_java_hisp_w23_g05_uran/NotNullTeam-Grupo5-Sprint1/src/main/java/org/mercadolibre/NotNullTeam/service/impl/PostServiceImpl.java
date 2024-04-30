package org.mercadolibre.NotNullTeam.service.impl;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.PromoPostDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PostsByFollowedDTO;
import org.mercadolibre.NotNullTeam.DTO.response.ProductsPromoCountDTO;
import org.mercadolibre.NotNullTeam.exception.error.NotFoundException;
import org.mercadolibre.NotNullTeam.mapper.PostMapper;
import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Post;
import org.mercadolibre.NotNullTeam.model.PromoPost;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.repository.IBuyerRepository;
import org.mercadolibre.NotNullTeam.repository.IPostRepository;
import org.mercadolibre.NotNullTeam.repository.IPromoPostRepository;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.mercadolibre.NotNullTeam.service.IPostService;
import org.mercadolibre.NotNullTeam.DTO.response.PromoProductsBySellerResponeseDTO;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService {
    final IPostRepository iPostRepository;
    final ISellerRepository iSellerRepository;
    final IBuyerRepository iBuyerRepository;
    final IPromoPostRepository iPromoPostRepository;


    @Override
    public Long createPost(PostDTO postDTO) {
        return iPostRepository.createPost(PostMapper.postDtoToPost(postDTO, findSellerById(postDTO.getUser_id())));
    }

    private Seller findSellerById(Long id){
        return iSellerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Seller"));
    }

    private Buyer findBuyerById(Long id){
        return iBuyerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Buyer"));
    }

    @Override
    public PostsByFollowedDTO getPostsByWeeksAgo(Long userId, String order) {
        Buyer buyer = findBuyerById(userId);
        final int WEEKS = 2;

        List<Post> posts = buyer.getFollowedList()
                .stream()
                .flatMap(post -> iPostRepository.getPostsByWeeksAgo(WEEKS, post.getUser().getId()).stream())
                .collect(Collectors.toList());

        if(order.equals("date_asc")) {
            posts.sort(Comparator.comparing(Post::getDate));
        }else{
            posts.sort(Comparator.comparing(Post::getDate).reversed());
        }

        return PostMapper.postToPostByFollowed(userId, posts);
    }

    @Override
    public Long createPromoPost(PromoPostDTO promoPostDTO) {
        PromoPost promoPost = new PromoPost(promoPostDTO);
        return iPromoPostRepository.createPromoPost(promoPost);
    }

    @Override
    public ProductsPromoCountDTO getProductsPromoCount(Long userId) {
        Seller seller = iSellerRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Seller"));
        int productsPromoCount = seller.quantityOfPromoProducts();

        return new ProductsPromoCountDTO(seller.getUser().getId(),seller.getUser().getName(),productsPromoCount);
    }

    @Override
    public PromoProductsBySellerResponeseDTO getListPromoProducts(Long userId) {
        Seller seller = iSellerRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Seller"));

        PromoProductsBySellerResponeseDTO promoProducts = iPromoPostRepository.getPromoProductsBySeller(seller);

        return promoProducts;
    }
}
