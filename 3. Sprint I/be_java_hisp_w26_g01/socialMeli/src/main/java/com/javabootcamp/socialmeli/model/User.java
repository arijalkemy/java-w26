package com.javabootcamp.socialmeli.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.javabootcamp.socialmeli.enums.UserType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private UserType userType;
}
