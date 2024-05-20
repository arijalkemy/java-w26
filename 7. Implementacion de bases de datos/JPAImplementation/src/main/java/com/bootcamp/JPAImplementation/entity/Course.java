package com.bootcamp.JPAImplementation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacherOnCharge;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "course_mentors",
    joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "mentor_id"))
    private List<Mentor> mentors;
    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_courses",
    joinColumns = @JoinColumn(name = "course_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))*/
    @OneToMany(mappedBy = "course")
    private List<Student> students;

}
