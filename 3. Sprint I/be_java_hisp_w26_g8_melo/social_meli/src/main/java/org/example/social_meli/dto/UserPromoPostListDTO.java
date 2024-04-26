package org.example.social_meli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPromoPostListDTO {
    private Integer user_id;
    private String user_name;
    private List<PromoPostDTO> posts;
}
