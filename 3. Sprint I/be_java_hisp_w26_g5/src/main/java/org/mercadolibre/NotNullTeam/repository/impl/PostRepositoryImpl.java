package org.mercadolibre.NotNullTeam.repository.impl;

import org.mercadolibre.NotNullTeam.model.Post;
import org.mercadolibre.NotNullTeam.repository.IPostRepository;
import org.springframework.stereotype.Repository;
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
    public List<Post> getPostsByWeeksAgo(int weeks, Long sellerId){
        return posts.containsKey(sellerId) ? posts.get(sellerId).stream()
                .filter(post -> ChronoUnit.WEEKS.between(post.getDate(), LocalDate.now()) <= weeks)
                .toList() : new ArrayList<>();
    }
}
