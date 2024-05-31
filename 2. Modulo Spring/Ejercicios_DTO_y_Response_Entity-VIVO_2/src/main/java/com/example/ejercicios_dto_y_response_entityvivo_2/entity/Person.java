package com.example.ejercicios_dto_y_response_entityvivo_2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data @NoArgsConstructor @AllArgsConstructor
public class Person {
    private String name;
    private String lastName;
    private Long age;
}
