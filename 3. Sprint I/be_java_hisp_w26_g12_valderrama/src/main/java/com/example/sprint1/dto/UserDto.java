package com.example.sprint1.dto;

import java.util.Set;

public class UserDto {
    private Integer id;
    private String user_name;
    private Set<Integer> followers;
    private Set<Integer> followed;
    private Set<Integer> posts;
    public Integer getCountFollowers(){
        return followers.size();
    }
    public Integer getCountFollowed(){
        return followed.size();
    }
}
