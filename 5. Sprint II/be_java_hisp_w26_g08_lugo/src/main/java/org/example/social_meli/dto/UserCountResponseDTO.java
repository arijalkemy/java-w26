package org.example.social_meli.dto;

import lombok.*;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCountResponseDTO {

    private Integer user_id;
    private String user_name;
    private Integer followers_count;

}
