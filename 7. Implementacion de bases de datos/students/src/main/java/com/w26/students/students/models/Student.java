package com.w26.students.students.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@Entity
@Table(name = "Student")
@JsonIgnoreProperties({"hibernateLazyInitializer"}) //Esta propiedad se agrega debido a que un endpoint retorna esta entidad, pero no logra serializar el hibernateLazyInitilizer -> Entity
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String dni;

    private String name;
    
    @Column(name = "last_name")
    private String lastName;


}
