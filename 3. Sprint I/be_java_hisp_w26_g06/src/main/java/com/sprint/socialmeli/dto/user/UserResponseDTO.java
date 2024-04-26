package com.sprint.socialmeli.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
@AllArgsConstructor
public class UserResponseDTO implements Serializable {
    private final Integer user_id;
    private final String user_name;
}
