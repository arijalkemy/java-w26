package org.mercadolibre.NotNullTeam.service.impl;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.request.PostPromoRequestDto;
import org.mercadolibre.NotNullTeam.DTO.response.PostsByFollowedDTO;
import org.mercadolibre.NotNullTeam.DTO.response.SellerPromosCountResponse;
import org.mercadolibre.NotNullTeam.DTO.response.SellerPromosResponse;
import org.mercadolibre.NotNullTeam.exception.error.NotFoundException;
import org.mercadolibre.NotNullTeam.mapper.PostMapper;
import org.mercadolibre.NotNullTeam.mapper.ProductMapper;
import org.mercadolibre.NotNullTeam.mapper.SellerMapper;
import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Post;
import org.mercadolibre.NotNullTeam.model.Product;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.repository.IBuyerRepository;
import org.mercadolibre.NotNullTeam.repository.IPostRepository;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.mercadolibre.NotNullTeam.service.IPostService;
import org.mercadolibre.NotNullTeam.service.ISellerServiceInternal;
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
    final ISellerServiceInternal iSellerServiceInternal;


    @Override
    public Long createPost(PostDTO postDTO) {
        return iPostRepository.createPost(PostMapper.postDtoToPost(postDTO,
                findSellerById(postDTO.getUser_id())));
    }

    private Seller findSellerById(Long id) {
        return iSellerRepository.findById(id).orElseThrow(() -> new NotFoundException("Seller"));
    }

    private Buyer findBuyerById(Long id) {
        return iBuyerRepository.findById(id).orElseThrow(() -> new NotFoundException("Buyer"));
    }

    @Override
    public PostsByFollowedDTO getPostsByWeeksAgo(Long userId, String order) {
        Buyer buyer = findBuyerById(userId);
        final int WEEKS = 2;

        List<Post> posts = buyer
                .getFollowedList()
                .stream()
                .flatMap(post -> iPostRepository
                        .getPostsByWeeksAgo(WEEKS, post.getUser().getId())
                        .stream())
                .collect(Collectors.toList());

        if (order.equals("date_asc")) {
            posts.sort(Comparator.comparing(Post::getDate));
        }
        else {
            posts.sort(Comparator.comparing(Post::getDate).reversed());
        }

        return PostMapper.postToPostByFollowed(userId, posts);
    }

    @Override
    public Long newProductPromo(PostPromoRequestDto request) {
        Seller seller = iSellerServiceInternal.findById(request.getUser_id());
        Product product = ProductMapper.productDtoToProduct(request.getProduct());
        Post postEntity = PostMapper.postPromoRequestToPost(request, seller, product);
        return iPostRepository.createPost(postEntity);
    }

    @Override
    public SellerPromosCountResponse getCountPromosBySellerId(Long userId) {
        Seller seller = iSellerServiceInternal.findById(userId);
        int promosCount = iPostRepository.getPostsPromoBySellerId(userId).size();

        return SellerMapper.sellerToSellerPromosCountResponse(seller, promosCount);
    }

    @Override
    public SellerPromosResponse getPromosBySellerId(Long userId) {
        Seller seller = iSellerServiceInternal.findById(userId);
        List<Post> posts = iPostRepository.getPostsPromoBySellerId(userId);

        return SellerMapper.sellerToSellerPromosResponse(seller, posts);
    }
}
