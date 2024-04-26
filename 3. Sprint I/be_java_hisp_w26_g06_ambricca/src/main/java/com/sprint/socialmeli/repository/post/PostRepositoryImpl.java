package com.sprint.socialmeli.repository.post;

import com.sprint.socialmeli.entity.Post;
import com.sprint.socialmeli.entity.Promo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostRepositoryImpl implements IPostRepository{
    Map<Integer, List<Post>> postMap = new HashMap<>();
    List<Promo> promosList = new ArrayList<>();

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

    /**
     * @param sellerId seller id
     * @return the list of the Promos entities
     * Search by the seller id the list of posts, then filter the promos by the posts ids, if not found any promo returns a empty list
     */
    @Override
    public List<Promo> findPromosBySellerId(Integer sellerId) {
        List<Post> posts = findBySellerId(sellerId);
        return promosList.stream().filter(promo -> posts.stream().filter(post -> post.getId() == promo.getPostId()).findAny().orElse(null) != null).toList();
    }

    /**
     * @param promo Promo entity
     * Adds the new promo to the promoList
     */
    @Override
    public void savePromo(Promo promo) {
        promosList.add(promo);
    }

    /**
     *
     * @param sellerId seller id
     * @param postId post id
     * @return the post entity
     * Search by the seller id the list of posts, then the list by the post id, if not found returns null
     */
    @Override
    public Post findBySellerIdAndPostId(Integer sellerId, Integer postId) {
        return findBySellerId(sellerId).stream().filter(post -> post.getId() == postId).findFirst().orElse(null);
    }
}
