package org.implementaciondb.ejercicio5_movies_hql.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "password_resets")
public class PasswordReset {

    @Id
    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "token", length = 255)
    private String token;

    @Column(name = "created_at")
    private LocalDate createdAt;
}
