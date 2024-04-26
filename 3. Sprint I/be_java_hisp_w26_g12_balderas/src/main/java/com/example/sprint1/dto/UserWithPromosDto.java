package com.example.sprint1.dto;

import com.example.sprint1.model.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithPromosDto {

    private Integer user_id;
    private String user_name;
    private List<Post> posts;
}
