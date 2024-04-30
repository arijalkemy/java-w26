package org.mercadolibre.NotNullTeam.repository.impl;

import org.mercadolibre.NotNullTeam.model.Post;
import org.mercadolibre.NotNullTeam.repository.IPostRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepositoryImpl implements IPostRepository {
    Map<Long, List<Post>> posts = new HashMap<>();

    @Override
    public void createPost(Post post) {
        if (!posts.containsKey(post.getSeller().getUser().getId())) {
            posts.put(post
                    .getSeller()
                    .getUser()
                    .getId(), new ArrayList<>(List.of(post)));
        }else{
            posts.get(post
                    .getSeller()
                    .getUser()
                    .getId()).add(post);
        }
    }

    @Override
    public List<Post> getPostsBySellerIdTwoWeeksAgo(Long sellerId){
        return posts.containsKey(sellerId) ? posts.get(sellerId).stream()
                .filter(post -> ChronoUnit.WEEKS.between(post.getDate(), LocalDate.now()) <= 2)
                .toList() : new ArrayList<>();
    }
}
