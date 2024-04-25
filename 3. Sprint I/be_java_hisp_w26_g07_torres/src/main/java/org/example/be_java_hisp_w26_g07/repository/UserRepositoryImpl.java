package org.example.be_java_hisp_w26_g07.repository;

import org.example.be_java_hisp_w26_g07.entity.*;
import org.example.be_java_hisp_w26_g07.repository.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    private final Map<Integer, User> userMap;
    private final List<Followers> followersList;
    private final Map<Integer, Category> categoryMap;
    private final Map<Integer, Post> postMap;
    private final Map<Integer, Product> productMap;

    public UserRepositoryImpl(
            @Qualifier("getInitialUsers") HashMap<Integer, User> users,
            @Qualifier("getInitialFollowers") ArrayList<Followers> followers,
            @Qualifier("getInitialCategories") HashMap<Integer, Category> categories,
            @Qualifier("getInitialPosts") HashMap<Integer, Post> posts,
            @Qualifier("getInitialProducts") HashMap<Integer, Product> products
    ) {
        userMap = users;
        followersList = followers;
        categoryMap = categories;
        productMap = products;
        postMap = posts;
    }

    @Override
    public User findById(Integer id) {
        if (!userMap.containsKey(id)) {
            return null;
        }
        return userMap.get(id);
    }

    /**
     * validacion de si un usuario ya sigue un vendedor
     *
     * @param userId   identificador del usuario
     * @param sellerId identificador del vendedor
     */
    @Override
    public Boolean userFollowSeller(Integer userId, Integer sellerId) {
        Followers foundFollower = followersList.stream()
                .filter(f -> f.getUserId().equals(userId) && f.getSellerId().equals(sellerId))
                .findAny()
                .orElse(null);

        return foundFollower != null;
    }

    /**
     * funcion usada para que un usuario pueda seguir un vendedor
     *
     * @param id           identificador del usuario
     * @param sellerId identificador del vendedor
     */
    @Override
    public Boolean addFollowerById(Integer id, Integer sellerId) {
        Followers newFollow = new Followers(id, sellerId);
        return followersList.add(newFollow);
    }

    @Override
    public List<Integer> followerIdBySellerId(Integer sellerId) {
        return followersList.stream()
                .filter(f -> f.getSellerId().equals(sellerId))
                .mapToInt(Followers::getUserId)
                .boxed().toList();
    }

    @Override
    public List<Integer> followedIdByUserId(Integer userId) {
        return followersList.stream()
                .filter(f -> f.getUserId().equals(userId))
                .mapToInt(Followers::getSellerId)
                .boxed().toList();
    }

    @Override
    public void addPost(Post newPost) {
        postMap.put(newPost.getId(), newPost);
    }

    @Override
    public List<Post> findProductByFollow(User user) {
        List<Post> posts = new ArrayList<>();
        List<Integer> sellerIdList = followersList.stream()
                .filter(f -> f.getUserId().equals(user.getId()))
                .mapToInt(Followers::getSellerId)
                .boxed().toList();
        List<Post> allPosts = postMap.values().stream().toList();
        List<Post> postsRecently;

        for (Integer sellerId : sellerIdList) {
            postsRecently = allPosts.stream()
                    .filter(post -> post.getDate().isAfter(LocalDate.now().minusDays(14)) &&
                            post.getUserId().equals(sellerId))
                    .toList();
            posts.addAll(postsRecently);
        }

        return posts;
    }

    @Override
    public boolean unfollow(User user, User sellerUser) {
        return followersList.remove(new Followers(user.getId(), sellerUser.getId()));
    }

    @Override
    public Product findProductById(Integer productId) {
        return productMap.get(productId);
    }

    @Override
    public void createProduct(Product newProduct) {
        productMap.put(newProduct.getId(), newProduct);
    }

    @Override
    public List<Post> getPromoPostsBySellerId(Integer userId) {
        return postMap.values().stream()
                .filter(p -> p.getUserId().equals(userId) &&
                        p.getHasPromo() != null && p.getHasPromo())
                .collect(Collectors.toList());
    }
}
