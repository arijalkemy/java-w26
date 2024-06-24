package com.mercadolibre.pf_be_hisp_w26_t6_martinez.entity;

import com.mercadolibre.pf_be_hisp_w26_t6_martinez.util.UserRoles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "hashedPassword")
    private String hashedPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRoles userRole;

}
