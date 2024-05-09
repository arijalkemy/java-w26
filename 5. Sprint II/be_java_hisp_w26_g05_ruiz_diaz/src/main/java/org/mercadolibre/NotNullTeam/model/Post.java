package org.mercadolibre.NotNullTeam.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class Post {
    private static Long currentId = 0L;
    private Long id;
    private Seller seller;
    private LocalDate date;
    private Product product;
    private int category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;

    public static Long fetchId(){
        currentId++;
        return currentId;
    }

}
