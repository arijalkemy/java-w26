package com.bootcamp.course.service;

import com.bootcamp.course.dto.StudentDTO;

public interface IStudentService extends IGenericService<StudentDTO> {

    StudentDTO updatePartial(Long id, String identification, String name, String lastName);

    StudentDTO findAverageStudent(Long studentId);

}
