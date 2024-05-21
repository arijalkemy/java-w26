package com.bootcamp.JPAImplementation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalificationsOfStudentDTO {
    @JsonProperty("courses_califications")
    List<CalificationCourseDTO> calificationCourses;
    Double average;
}
