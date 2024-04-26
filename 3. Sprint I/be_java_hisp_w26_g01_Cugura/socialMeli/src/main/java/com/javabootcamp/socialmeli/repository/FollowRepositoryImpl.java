package com.javabootcamp.socialmeli.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.javabootcamp.socialmeli.model.Follow;
import com.javabootcamp.socialmeli.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class FollowRepositoryImpl implements FollowRepository {

    private List<Follow> followsList;

    public FollowRepositoryImpl() {
        this.followsList = new ArrayList<>();
    }

    @Override
    public void add(Follow follow) {
        followsList.add(follow);
    }

    public void delete(Follow follow){
        followsList.remove(follow);
    }

    @Override
    public List<User> findFollowersById(Integer id) {
        return followsList
                .stream()
                .filter(f -> f.getFollowed().getId().equals(id))
                .map(Follow::getFollower)
                .toList();
    }

    @Override
    public List<User> findFollowedsById(Integer id) {
        return followsList
                .stream()
                .filter(f -> f.getFollower().getId().equals(id))
                .map(Follow::getFollowed)
                .toList();
    }

    @Override
    public List<User> findFollowedsByIdAsc(Integer id) {
        return findFollowedsById(id).stream().sorted(Comparator.comparing(User::getUsername)).toList();
    }

    @Override
    public List<User> findFollowedsByIdDesc(Integer id) {
        return findFollowedsById(id).stream().sorted(Comparator.comparing(User::getUsername).reversed()).toList();
    }

    @Override
    public int countFollowersById(Integer id) {
        return (int) followsList
                .stream()
                .filter(f -> f.getFollowed().getId().equals(id))
                .count();
    }

    /**
     *
     * @param followerId Id de la persona que sigue un vendedor
     * @param followedId Id del vendedor seguido
     * @return Optional<Follow>
     */
    @Override
    public Optional<Follow> findByFollowerIdAndFollowedId(Integer followerId, Integer followedId){
        return followsList
            .stream()
            .filter(f -> f.getFollower().getId().equals(followerId) && f.getFollowed().getId().equals(followedId))
            .findFirst();
    }

    @Override
    public List<User> searchFollowersByUserAndOrderAsc(Integer id) {
        return findFollowersById(id)
            .stream()
            .sorted(Comparator.comparing(User::getUsername))
            .toList();
    }

    @Override
    public List<User> searchFollowersByUserAndOrderDesc(Integer id) {
        return findFollowersById(id)
            .stream()
            .sorted(Comparator.comparing(User::getUsername).reversed())
            .toList();
    }
}
