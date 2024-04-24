package com.sprint.socialmeli.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class PostDTO implements Serializable {
    @NonNull
    private final Integer user_id;
    @NonNull
    private final String date; //Entra como dd/MM/yyyy
    @NonNull
    private final ProductDTO product;
    @NonNull
    private final Integer category;
    @NonNull
    private final Double price;
}
