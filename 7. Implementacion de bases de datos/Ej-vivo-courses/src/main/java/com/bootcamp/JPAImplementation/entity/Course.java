package com.bootcamp.JPAImplementation.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToMany
    @JoinTable(
            name = "course_mentor", joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "mentor_id")
    )
    private List<Teacher> mentors;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<StudentCourseCalification> studentCourseCalifications;

    public Course(
            String name,
            Teacher teacher,
            List<Teacher> mentors,
            List<StudentCourseCalification> studentCourseCalifications
    ) {
        this.name = name;
        this.teacher = teacher;
        this.mentors = mentors;
        this.studentCourseCalifications = studentCourseCalifications;
    }
}
