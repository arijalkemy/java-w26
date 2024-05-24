package com.bootcamp.course.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CourseDTO implements Serializable {

    private Long id;
    private String name;

    @JsonProperty("teacher_id")
    private Long teacherId;

    @JsonProperty("mentor_list")
    private List<MentorDTO> mentorList;

}
