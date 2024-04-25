package org.mercadolibre.NotNullTeam.service.impl;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.response.PostsByFollowedDTO;
import org.mercadolibre.NotNullTeam.exception.error.NotFoundException;
import org.mercadolibre.NotNullTeam.mapper.PostMapper;
import org.mercadolibre.NotNullTeam.model.Buyer;
import org.mercadolibre.NotNullTeam.model.Post;
import org.mercadolibre.NotNullTeam.model.Seller;
import org.mercadolibre.NotNullTeam.repository.IBuyerRepository;
import org.mercadolibre.NotNullTeam.repository.IPostRepository;
import org.mercadolibre.NotNullTeam.repository.ISellerRepository;
import org.mercadolibre.NotNullTeam.service.IPostService;
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
}
