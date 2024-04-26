package com.sprint.socialmeli.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promo {
    private int id;
    private int postId;
    private int sellerId;
    private boolean hasPromo;
    private double discount;
}
