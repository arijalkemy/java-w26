package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.GenerateStudentsTest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Profile("test")
@Repository
public class StudentTestDAO implements IStudentDAO {
    private Set<StudentDTO> students;

    public StudentTestDAO() {
        this.loadData();
    }

    @Override
    public void save(StudentDTO stu) {
        boolean removed = this.delete(stu.getId());

        if (!removed) stu.setId((this.students.size() + 1L));

        students.add(stu);

        this.saveData();
    }

    @Override
    public boolean delete(Long id) {
        boolean ret = false;

        try {
            StudentDTO found = this.findById(id);

            students.remove(found);
            ret  = true;
            this.saveData();

        } catch (StudentNotFoundException e) {}

        return ret;
    }

    public boolean exists(StudentDTO stu) {
        boolean ret = false;

        try {
            ret  = this.findById(stu.getId()) != null;
        }
        catch (StudentNotFoundException e) {}

        return ret;
    }

    @Override
    public StudentDTO findById(Long id) {
        return students.stream()
                .filter(stu -> stu.getId().equals(id))
                .findFirst().orElseThrow(() -> new StudentNotFoundException(id));
    }

    private void loadData() {
        this.students = GenerateStudentsTest.generateStudents();;
    }

    private void saveData() {
    }
}
