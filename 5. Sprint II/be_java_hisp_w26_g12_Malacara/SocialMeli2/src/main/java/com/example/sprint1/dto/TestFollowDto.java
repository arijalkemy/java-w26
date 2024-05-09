package com.example.sprint1.dto;

import com.example.sprint1.model.User;
import lombok.Data;

import java.util.List;

@Data
public class TestFollowDto {

    User user;
    List<User> inputFollow;
    FollowListDto expectedOrderedFollow;
}
