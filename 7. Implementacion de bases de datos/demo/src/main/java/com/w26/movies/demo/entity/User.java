package com.w26.movies.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    Integer id;

    String name;
    String email;
    String password;

    String remember_token;

    LocalDateTime created_at;
    LocalDateTime updated_at;

}
