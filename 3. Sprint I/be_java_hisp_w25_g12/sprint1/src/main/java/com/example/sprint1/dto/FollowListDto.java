package com.example.sprint1.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowListDto {
    Integer user_id;
    String user_name;
    List<FollowdUserDto> followed;
}
