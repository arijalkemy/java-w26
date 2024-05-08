package org.mercadolibre.NotNullTeam.service.impl;

import lombok.RequiredArgsConstructor;
import org.mercadolibre.NotNullTeam.DTO.request.post.PostDTO;
import org.mercadolibre.NotNullTeam.DTO.response.post.PostsByFollowedDTO;
import org.mercadolibre.NotNullTeam.exception.error.InvalidParameterException;
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

import static org.mercadolibre.NotNullTeam.util.TypeOrder.DATE_ASC;
import static org.mercadolibre.NotNullTeam.util.TypeOrder.DATE_DESC;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService {
    final IPostRepository iPostRepository;
    final ISellerRepository iSellerRepository;
    final IBuyerRepository iBuyerRepository;


    @Override
    public Long createPost(PostDTO postDTO) {
        return iPostRepository.createPost(PostMapper.postDtoToPost(postDTO,
                findSellerById(postDTO.getUserId())));
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

        List<Post> posts = getPostsOfAllFollowed(buyer, WEEKS);

        switch (order) {
            case DATE_ASC -> posts.sort(Comparator.comparing(Post::getDate));
            case DATE_DESC -> posts.sort(Comparator.comparing(Post::getDate).reversed());
            default -> throw new InvalidParameterException("order -> " + order);
        }


        return PostMapper.postToPostByFollowed(userId, posts);
    }

    private List<Post> getPostsOfAllFollowed(Buyer buyer, int WEEKS) {
        return buyer
                .getFollowedList()
                .stream()
                .flatMap(post -> iPostRepository
                        .getPostsByWeeksAgo(WEEKS, post.getUser().getId())
                        .stream())
                .collect(Collectors.toList());
    }
}
