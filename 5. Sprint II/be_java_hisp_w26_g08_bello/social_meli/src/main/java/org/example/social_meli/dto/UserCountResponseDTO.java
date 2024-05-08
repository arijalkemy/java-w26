package org.example.social_meli.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCountResponseDTO {

    private Integer user_id;
    private String user_name;
    private Integer followers_count;

}
