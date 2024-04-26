package com.sprint.socialmeli.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class ProductDTO implements Serializable {
    private final Integer product_id;
    private final String product_name;
    private final String type;
    private final String brand;
    private final String color;
    private final String notes;
}
