package org.example.social_meli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.social_meli.model.Post;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoListDTO extends FollowListDTO{
    private String user_name;

    public PromoListDTO(Integer user_id, String user_name, List<PostDTO> promoPostListByUser) {
        super(user_id, promoPostListByUser);
        this.user_name = user_name;
    }
}
