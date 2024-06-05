package org.example.testjpahql.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.example.testjpahql.entity.Movie;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class ActorDTO implements Serializable {
    private String firstName;
    private String lastName;
    private BigDecimal rating;

}
