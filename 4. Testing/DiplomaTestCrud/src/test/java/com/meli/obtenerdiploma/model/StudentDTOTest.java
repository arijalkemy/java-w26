package com.meli.obtenerdiploma.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentDTOTest {

    List<SubjectDTO> subjects = List.of( new SubjectDTO( "Carlos", 5.0) );
    StudentDTO student = new StudentDTO( (long) 1,"jose","msg",1.0,subjects );


}