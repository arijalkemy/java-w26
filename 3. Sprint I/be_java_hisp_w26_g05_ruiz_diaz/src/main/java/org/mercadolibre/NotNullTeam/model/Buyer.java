package org.mercadolibre.NotNullTeam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {
    private User user;
    private List<Seller> followedList = new ArrayList<>();
    private List<Post> favoritePosts = new ArrayList<>();

    public void addNewFollowed(Seller seller) {
        followedList.add(seller);
    }

    public void removeFollowed(Seller seller) {
        followedList.remove(seller);
    }

    public String getUsername(){
        return user.getName();
    }

    public void addFavoritePost(Post post) {
        favoritePosts.add(post);
    }

    public void removeFavoritePost(Post post) {
        favoritePosts.remove(post);
    }

}
