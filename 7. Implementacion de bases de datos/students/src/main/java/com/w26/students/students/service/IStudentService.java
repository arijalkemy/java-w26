package com.w26.students.students.service;




import java.util.List;

import com.w26.students.students.dto.StudentCreation;
import com.w26.students.students.dto.StudentPatch;
import com.w26.students.students.models.Student;

public interface IStudentService {
    List<Student> getAll(int page);
    Student get(Long id);
    void create(StudentCreation studentToCreate);
    void delete(Long id);
    void update(Long id, StudentPatch studentToPatch);

}
