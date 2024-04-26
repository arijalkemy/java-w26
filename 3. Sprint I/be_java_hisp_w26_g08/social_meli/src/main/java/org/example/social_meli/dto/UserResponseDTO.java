package org.example.social_meli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private Integer user_id;
    private String user_name;
    private List<UserDTO> follower;
}
