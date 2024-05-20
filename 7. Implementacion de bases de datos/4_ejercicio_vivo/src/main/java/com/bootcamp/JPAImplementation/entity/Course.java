package com.bootcamp.JPAImplementation.entity;

import java.util.Set;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;
    @Basic
    private String name;

    @ManyToOne
    @JoinColumn(name = "associate_id")
    private Teacher associate;

    @ManyToMany
    @JoinTable(
        name = "course_mentors",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private Set<Teacher> mentors;

    @OneToMany(mappedBy = "course")
    private Set<Cursado> cursantes;
    
}
