package org.mercadolibre.NotNullTeam.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
    private User user;
    private List<Buyer> followersList = new ArrayList<>();

    public void addNewFollower(Buyer buyer) {
        followersList.add(buyer);
    }

    public int quantityOfFollowers() {
        return followersList.size();
    }

    public void removeFollower(Buyer buyer) {
        followersList.remove(buyer);
    }

    public String getUsername() {
        return getUser().getName();
    }
}
