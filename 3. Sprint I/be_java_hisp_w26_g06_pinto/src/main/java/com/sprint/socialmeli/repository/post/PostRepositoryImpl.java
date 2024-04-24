package com.sprint.socialmeli.repository.post;

import com.sprint.socialmeli.entity.Post;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepositoryImpl implements IPostRepository{
    Map<Integer, List<Post>> postMap = new HashMap<>();

    // INDIVIDUAL
    @Getter
    Map<Integer, Double> promoPostMap = new HashMap<>(); //

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
    public void saveDiscountByPostId(Integer postId, Double discount) {
        this.promoPostMap.put(postId,discount);
    }

}
