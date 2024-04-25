package com.group03.sprint1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationDTO implements Serializable {
    private Integer user_id;
    private Integer post_id;
    private LocalDate date;
    private ProductDTO product;
    private Integer category;
    private Double price;
}
