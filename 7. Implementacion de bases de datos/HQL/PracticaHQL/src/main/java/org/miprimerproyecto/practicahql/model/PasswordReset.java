package org.miprimerproyecto.practicahql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "password_resets")
@Data
public class PasswordReset implements Serializable {
    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "token")
    private String token;
    @Column(name = "created_at")
    private Date createdAt;
// Getters and setters
}
