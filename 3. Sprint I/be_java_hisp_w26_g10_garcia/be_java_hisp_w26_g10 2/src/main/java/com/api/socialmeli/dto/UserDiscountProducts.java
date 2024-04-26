package com.api.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDiscountProducts {
    private Integer user_id;
    private String user_name;
    private List<CompletePostDto> posts;
}
