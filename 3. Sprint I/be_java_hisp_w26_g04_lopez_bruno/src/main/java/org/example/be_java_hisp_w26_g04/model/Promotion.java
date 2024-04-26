package org.example.be_java_hisp_w26_g04.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Promotion {
    private int promotionId;
    private int userId;
    private int postId;
    private boolean hasPromo;
    private double discount;
}
