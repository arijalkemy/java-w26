package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.impl;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.User;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.entity.UserMinimalData;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.repository.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private List<User> listUser;

    public UserRepositoryImpl() {
        this.listUser = new ArrayList<>();
        initializeUsers();
    }

    private void initializeUsers() {
        User aliceMorrison = new User(1, "Alice Morrison");
        User bobSmith = new User(2, "Bob Smith");
        User charlyGarcia = new User(3, "Charlie Garcia");
        User daisyJohnson = new User(4, "Daisy Johnson");
        User edwardWilson = new User(5, "Edward Wilson");
        User fionaCampbell = new User(6, "Fiona Campbell");
        User goergeMiller = new User(7, "George Miller");
        User hannahScott = new User(8, "Hannah Scott");
        User ianPeterson = new User(9, "Ian Peterson");
        User juliaEvans = new User(10, "Julia Evans");
        User kevinBrown = new User(11, "Kevin Brown");
        User lauraWhite = new User(12, "Laura White");
        User mikeDavis = new User(13, "Mike Davis");
        User noraBaker = new User(14, "Nora Baker");
        User oscarLee = new User(15, "Oscar Lee");


        UserMinimalData minimalBobSmith = new UserMinimalData(2, "Bob Smith");
        UserMinimalData minimalOscarLee = new UserMinimalData(15, "Oscar Lee");
        UserMinimalData minimalAliceMorrison = new UserMinimalData(1, "Alice Morrison");
        UserMinimalData minimalCharlyGarcia = new UserMinimalData(3, "Charlie Garcia");


        aliceMorrison.setFollowed(new ArrayList<>(List.of(minimalBobSmith)));
        aliceMorrison.setFollowers(new ArrayList<>( List.of(minimalOscarLee, minimalBobSmith)));
        aliceMorrison.setPosts(new ArrayList<>(List.of(1)));
        bobSmith.setFollowed(new ArrayList<>(List.of(minimalCharlyGarcia, minimalAliceMorrison)));
        bobSmith.setFollowers(new ArrayList<>( List.of(minimalOscarLee, minimalAliceMorrison)));
        bobSmith.setPosts(new ArrayList<>(List.of(2)));
        oscarLee.setFollowed(new ArrayList<>(List.of(minimalBobSmith, minimalAliceMorrison)));
        oscarLee.setFollowers(new ArrayList<> (List.of(minimalCharlyGarcia)));
        oscarLee.setPosts(new ArrayList<>(List.of(3)));
        charlyGarcia.setFollowed(new ArrayList<> (List.of(minimalOscarLee)));
        charlyGarcia.setFollowers(new ArrayList<>( List.of(minimalAliceMorrison, minimalBobSmith)));
        charlyGarcia.setPosts(new ArrayList<>(List.of(4)));

        listUser.add(aliceMorrison);
        listUser.add(bobSmith);
        listUser.add(charlyGarcia);
        listUser.add(daisyJohnson);
        listUser.add(edwardWilson);
        listUser.add(fionaCampbell);
        listUser.add(goergeMiller);
        listUser.add(hannahScott);
        listUser.add(ianPeterson);
        listUser.add(juliaEvans);
        listUser.add(kevinBrown);
        listUser.add(lauraWhite);
        listUser.add(mikeDavis);
        listUser.add(noraBaker);
        listUser.add(oscarLee);
    }

    @Override
    public List<User> getAll() {
        return listUser;
    }

    @Override
    public User findById(int id) {
        return listUser.stream().filter(user -> user.getUserId() == id).findFirst().orElse(null);
    }

    @Override
    public UserMinimalData findFollowedById(User user, int idFollowed) {
        return user.getFollowed().stream().filter(x->x.getUserId() == idFollowed).findFirst().orElse(null);
    }

    @Override
    public UserMinimalData findFollowerById(User user, int idFollowed) {
        return user.getFollowers().stream().filter(x->x.getUserId() == idFollowed).findFirst().orElse(null);
    }

    @Override
    public void unfollowed(User user, UserMinimalData followed) {
        user.getFollowed().remove(followed);
    }

    @Override
    public void deleteFollower(User user, UserMinimalData followed) {
        user.getFollowers().remove(followed);
    }
}
