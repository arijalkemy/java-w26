package org.example.social_meli.dto;

import lombok.*;


@Getter
@AllArgsConstructor

public class UserCountResponseDTO {

    private Integer userId;
    private String userName;
    private Integer followersCount;

}
