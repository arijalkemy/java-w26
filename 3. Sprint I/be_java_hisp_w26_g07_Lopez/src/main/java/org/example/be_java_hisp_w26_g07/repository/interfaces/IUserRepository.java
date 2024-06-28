package org.example.be_java_hisp_w26_g07.repository.interfaces;

import org.example.be_java_hisp_w26_g07.entity.Post;
import org.example.be_java_hisp_w26_g07.entity.User;

import java.util.List;

public interface IUserRepository {
    List<User> findAll();

    User findById(Integer id);

    Boolean addFollowerById(Integer id, Integer userToFollow);

    Boolean userFollowSeller(Integer id, Integer userToFollow);

    boolean unfollow(User user, User sellerUser);

    List<Post> findProductByFollow(User user);



}
