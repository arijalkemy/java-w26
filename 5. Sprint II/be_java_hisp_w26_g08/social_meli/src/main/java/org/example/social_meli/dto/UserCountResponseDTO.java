package org.example.social_meli.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCountResponseDTO {

    private Integer userId;
    private String userName;
    private Integer followersCount;

}
