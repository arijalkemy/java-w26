package com.meli.be_java_hisp_w26_g09.dto;

import com.meli.be_java_hisp_w26_g09.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class PromosBySellerDTO implements Serializable {
    private Integer userId;
    private String userName;
    private List<Post> posts;
}
