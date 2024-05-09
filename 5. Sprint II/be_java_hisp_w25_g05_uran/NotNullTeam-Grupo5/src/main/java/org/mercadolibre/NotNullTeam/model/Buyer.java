package org.mercadolibre.NotNullTeam.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Buyer {
    private User user;
    private List<Seller> followedList = new ArrayList<>();

    public void addNewFollowed(Seller seller) {
        followedList.add(seller);
    }

    public void removeFollowed(Seller seller) {
        followedList.remove(seller);
    }

    public String getUsername(){
        return user.getName();
    }
}
