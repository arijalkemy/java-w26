package com.w26.movies.demo.entity;

import java.time.LocalDateTime;

import com.w26.movies.demo.entity.CompositeKey.PassWordResetId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "password_resets")
@IdClass(PassWordResetId.class)
public class PasswordReset {

    @Id
    private String email;

    @Id
    private String token;

    LocalDateTime created_at;
}
