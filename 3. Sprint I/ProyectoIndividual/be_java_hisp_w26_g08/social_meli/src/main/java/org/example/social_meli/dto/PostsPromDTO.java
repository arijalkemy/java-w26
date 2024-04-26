package org.example.social_meli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostsPromDTO {
    Integer user_id;
    String user_name;
    List<PostDTO> posts;
}
