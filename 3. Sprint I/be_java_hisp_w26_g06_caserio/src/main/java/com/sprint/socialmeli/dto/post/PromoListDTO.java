package com.sprint.socialmeli.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public class PromoListDTO implements Serializable {
    final private Integer user_id;
    final private String user_name;
    final private List<PromoResponseDTO> posts;
}