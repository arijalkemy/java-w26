package org.meli.ejercicio6_p3_d1_estudiante.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course_student")
public class CourseStudent {
    @EmbeddedId
    private CourseStudentId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student", referencedColumnName = "id", insertable = false, updatable = false)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_course", referencedColumnName = "id_course", insertable = false, updatable = false)
    private Course course;

    @Column(name = "nota_1")
    private Double nota_1;

    @Column(name = "nota_2")
    private Double nota_2;

}
