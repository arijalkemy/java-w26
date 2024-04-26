package com.meli.be_java_hisp_w26_g09.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostResponseDTO implements Serializable {

    private Integer userId;
    private String userName;
    private List<PostDTO> posts;

}
