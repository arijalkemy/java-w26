package com.example.movies_db.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private BigDecimal rating;
}
