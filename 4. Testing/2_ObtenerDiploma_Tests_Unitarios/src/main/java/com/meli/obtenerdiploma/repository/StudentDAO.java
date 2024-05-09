package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.CargadorDatos;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

@Repository
public class StudentDAO implements IStudentDAO {

    private String SCOPE;

    private Set<StudentDTO> students;


    public StudentDAO() {
        Properties properties =  new Properties();

        try {
            properties.load(new ClassPathResource("application.properties").getInputStream());
            this.SCOPE = properties.getProperty("api.scope");
            this.loadData();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        this.students = CargadorDatos.cargarDatosDeResourceJson("users.json", StudentDTO.class);
    }

    private void saveData() {
        CargadorDatos.guardarStudentsEnResource(students, "users.json");
    }
}
