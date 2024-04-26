package org.mercadolibre.NotNullTeam.repository.impl;

import org.mercadolibre.NotNullTeam.model.Post;
import org.mercadolibre.NotNullTeam.repository.IPostRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements IPostRepository {
    Map<Long, List<Post>> posts = new HashMap<>();

    @Override
    public Long createPost(Post post) {
        Long sellerId = post
                .getSeller()
                .getUser()
                .getId();

        if (!posts.containsKey(sellerId)) {
            posts.put(sellerId, new ArrayList<>(List.of(post)));
        }else{
            posts.get(sellerId).add(post);
        }

        return post.getId();
    }

    @Override
    public List<Post> getPostsByWeeksAgo(int WEEKS, Long sellerId){
        return posts.containsKey(sellerId) ? posts.get(sellerId).stream()
                .filter(post -> ChronoUnit.WEEKS.between(post.getDate(), LocalDate.now()) <= WEEKS)
                .toList() : new ArrayList<>();
    }

    @Override
    public int getCantPromosSellersByUserId(Long sellerId) {
        return posts.containsKey(sellerId) ? posts.get(sellerId)
                .stream()
                .filter(post -> post.getHasPromo())
                .toList()
                .size()
                : 0;
    }

    @Override
    public List<Post> getTopWeekPromosByUserId(Long sellerId, int LIMIT, int WEEKS) {
        if(!posts.containsKey(sellerId))
            return new ArrayList<>();

        return posts.get(sellerId).stream()
                .filter(post -> ChronoUnit.WEEKS.between(post.getDate(), LocalDate.now()) <= WEEKS)
                .limit(LIMIT)
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> getPostBySellerId(Long sellerId, int category) {
        return posts.containsKey(sellerId) ? posts.get(sellerId)
                .stream()
                .filter(post -> post.getCategory() == category)
                .toList()
                : new ArrayList<>();
    }

    @Override
    public void deletePostById(Long sellerId, Long postId) {
        if(posts.containsKey(sellerId))
            posts.get(sellerId).removeIf(post -> post.getId() == postId);
    }

    @Override
    public List<Post> getPostsByProductName(Long sellerId, String productName) {
        return posts.containsKey(sellerId) ? posts.get(sellerId)
                .stream()
                .filter(post -> post.getProduct().getName().toLowerCase().contains(productName.toLowerCase()))
                .toList()
                : new ArrayList<>();
    }
}
