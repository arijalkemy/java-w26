package com.api.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellersCountFollowersDto {
    private int user_id;
    private String user_name;
    private int followers_count;
}
