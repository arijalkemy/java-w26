package org.example.dto_p1_sports.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SportDTO implements Serializable {
    private String name;
    private String lastname;
    private String sportName;
}
