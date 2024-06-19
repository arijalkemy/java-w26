package org.example.templatemvc.Repository.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course_student")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "first_note")
    private double firstNote;

    @Column(name = "second_note")
    private double secondNote;

}
