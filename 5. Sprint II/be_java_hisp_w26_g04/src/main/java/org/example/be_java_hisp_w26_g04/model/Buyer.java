package org.example.be_java_hisp_w26_g04.model;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Buyer  {
    private int userId;
    private String userName;
    private Set<Integer> sellersFollowing = new HashSet<>();

    public boolean addFollow(Seller seller){
        return sellersFollowing.add(seller.getUserId());
    }
}
