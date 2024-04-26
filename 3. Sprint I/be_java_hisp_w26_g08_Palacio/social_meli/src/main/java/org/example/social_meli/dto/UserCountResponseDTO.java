package org.example.social_meli.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserCountResponseDTO {

    private Integer user_id;
    private String user_name;
    private Integer followers_count;

}
