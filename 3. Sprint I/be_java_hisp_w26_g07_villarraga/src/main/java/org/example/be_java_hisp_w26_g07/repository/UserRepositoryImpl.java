package org.example.be_java_hisp_w26_g07.repository;

import org.example.be_java_hisp_w26_g07.entity.Post;
import org.example.be_java_hisp_w26_g07.entity.User;
import org.example.be_java_hisp_w26_g07.repository.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    private final List<User> users;

    public UserRepositoryImpl(@Qualifier("getUsers") List<User> users) {
        this.users = users;
    }

    @Override
    public User findById(Integer id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    /**
     * validacion de si un usuario ya sigue un vendedor
     *
     * @param id           identificador del usuario
     * @param userToFollow identificador del vendedor
     */
    @Override
    public Boolean userFollowSeller(Integer id, Integer userToFollow) {
        User user = findById(id);
        return user.getFollowerIds().contains(userToFollow);
    }

    /**
     * funcion usada para que un usuario pueda seguir un vendedor
     *
     * @param id           identificador del usuario
     * @param userToFollow identificador del vendedor
     */
    @Override
    public Boolean addFollowerById(Integer id, Integer userToFollow) {
        User user = findById(id);
        User seller = findById(userToFollow);
        List<Integer> newFollows = new ArrayList<>(user.getFollowerIds());
        newFollows.add(userToFollow);
        user.setFollowerIds(newFollows);

        List<Integer> sellerFollowed = new ArrayList<>(seller.getFollowedIds());
        sellerFollowed.add(id);
        seller.setFollowedIds(sellerFollowed);
        return true;
    }

    @Override
    public List<Post> findProductByFollow(User user) {
        List<Post> posts = new ArrayList<>();
        List<Post> postsRecently = new ArrayList<>();
        for (Integer userFollower : user.getFollowerIds()) {
            postsRecently = findById(userFollower).getPosts().stream()
                    .filter(post -> post.getDate().isAfter(LocalDate.now().minusDays(14)))
                    .toList();
            posts.addAll(postsRecently);
        }

        return posts;
    }

    @Override
    public boolean unfollow(User user, User sellerUser) {
        int userInd = users.indexOf(user);
        int sellerInd = users.indexOf(sellerUser);

        // Copy of the user's follows
        List<Integer> oldFollows = new ArrayList<>(user.getFollowerIds());
        boolean followRemoved = oldFollows.remove(Integer.valueOf(sellerUser.getId()));

        // Copy of the seller's followers
        List<Integer> oldFollowers = new ArrayList<>(sellerUser.getFollowedIds());
        boolean followerRemoved = oldFollowers.remove(Integer.valueOf(user.getId()));

        if (followRemoved && followerRemoved) {
            // Update the follows of the user
            user.setFollowerIds(oldFollows);
            users.set(userInd, user);
            // Update the followers of the seller
            sellerUser.setFollowedIds(oldFollowers);
            users.set(sellerInd, sellerUser);
        }

        // Update the followers of the seller
        return followRemoved && followerRemoved;
    }
}
