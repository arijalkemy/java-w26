package com.sprint.socialmeli.repository.post;

import com.sprint.socialmeli.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepositoryImpl implements IPostRepository{
    Map<Integer, List<Post>> postMap = new HashMap<>();

    /**
     *
     * @param post Post entity
     * @param sellerId Seller id
     * Adds the new post to the postMap by the seller ID
     */
    @Override
    public void save(Post post, Integer sellerId) {
        List<Post> postList = findBySellerId(sellerId);
        postList.add(post);
        postMap.put(sellerId, postList);
    }

    /**
     *
     * @param sellerId seller id
     * @return the list of the posts entities
     * Search by the seller id the list of posts, if not found returns a empty list
     */
    @Override
    public List<Post> findBySellerId(Integer sellerId) {
        return postMap.getOrDefault(sellerId, new ArrayList<>());
    }

    @Override
    public List<Post> findPromoBySellerId(Integer sellerId) {
        List<Post> postList = findBySellerId(sellerId);
        return postList.stream().filter(Post::isHasPromo).toList();
    }

    @Override
    public Map<Integer, Long> getTotalByPromoPost() {
        Map<Integer, Long> result = new HashMap<>();
        for(Integer sellerId : postMap.keySet()) {
            result.put(sellerId, postMap.get(sellerId).stream().filter(Post::isHasPromo).count());
        }
        return result;
    }

}
