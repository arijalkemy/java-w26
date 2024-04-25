package com.sprint.socialmeli.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostDTO implements Serializable {
    private final List<Integer> user_id;
    private final String date; //Entra como dd/MM/yyyy
    private final ProductDTO product;
    private final Integer category;
    private final Double price;
}
