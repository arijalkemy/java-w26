package com.sprint.socialmeli.repository.post;

import com.sprint.socialmeli.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PostRepositoryImpl implements IPostRepository{
    Map<Integer, List<Post>> postMap = new HashMap<>();

    @Override
    public void save(Post post, Integer sellerId) {
        List<Post> postList = findBySellerId(sellerId);
        postList.add(post);
        postMap.put(sellerId, postList);
    }

    @Override
    public List<Post> findBySellerId(Integer sellerId) {
        return postMap.getOrDefault(sellerId, new ArrayList<>());
    }

    // INDIVIDUAL
    @Override
    public List<Post> findPromoBySellerId(Integer sellerId) {
        return postMap.getOrDefault(sellerId, new ArrayList<>()).stream().filter(post -> post.isHas_promo()).toList();
    }

}
