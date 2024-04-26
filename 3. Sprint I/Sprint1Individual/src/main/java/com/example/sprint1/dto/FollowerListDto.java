package com.example.sprint1.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FollowerListDto {
    Integer user_id;
    String user_name;
    List<FollowerUsersDto> followers;
}
