package com.bootcamp.JPAImplementation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalificationCourseDTO {
    Long courseId;
    Double calification1;
    Double calification2;
}
