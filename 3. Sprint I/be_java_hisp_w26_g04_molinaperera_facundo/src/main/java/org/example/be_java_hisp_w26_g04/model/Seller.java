package org.example.be_java_hisp_w26_g04.model;

import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
    private int userId;
    private String userName;
    private List<Post> listPost;
    private List<Product> listProduct;
    private Set<Integer> followers = new HashSet<>();

    public boolean addFollower(Buyer buyer){
        return followers.add(buyer.getUserId());
    }
}
