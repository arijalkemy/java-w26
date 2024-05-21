package com.bootcamp.JPAImplementation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalificationsOfStudentDTO {
    List<CalificationCourseDTO> calificationCourseDTOS;
    Double average;
}
