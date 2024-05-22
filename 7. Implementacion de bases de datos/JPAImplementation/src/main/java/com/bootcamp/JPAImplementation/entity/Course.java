package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "teacherLeader_id")
    private Teacher leaderTeacher;

    @OneToMany(mappedBy = "course")
    private List<StudentCourse> studentCourses;

    @ManyToMany
    @JoinTable(
            name = "courses_mentors"
            , joinColumns = @JoinColumn(name = "course_id")
            , inverseJoinColumns = @JoinColumn(name = "mentor_id")
    )
    private Set<Mentor> mentors;
}
