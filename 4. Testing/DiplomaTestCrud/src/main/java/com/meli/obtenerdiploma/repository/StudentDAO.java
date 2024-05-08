package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentAllreadyExistException;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class StudentDAO implements IStudentDAO, IStudentUtilDAO {

    private final IStudentRepository studentRepository;

//    @Value("${uri}")
//    private String URI;
    private Set<StudentDTO> students = new HashSet<>();

//    public StudentDAO() {
//        Properties properties = new Properties();
//        studentRepository = new StudentRepository();
//        try {
//            properties.load(new ClassPathResource("application-dev.properties").getInputStream());
//            this.URI = properties.getProperty("uri");
//            this.loadData();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public Long save(StudentDTO stu) {
        if (existsById(stu.getId())) throw new StudentAllreadyExistException(stu.getId());

        students.add(stu);
        this.saveData();
        return stu.getId();
    }

    @Override
    public boolean delete(Long id) {
        if (!existsById(id)) return false;
        else {
            StudentDTO student = findById(id);
            return students.remove(student);
        }
    }

    @Override
    public boolean deleteAll() {
        students.clear();
        return studentRepository.deleteAll(students);
    }

    @Override
    public boolean existsById(Long id) {
        return students.stream().anyMatch(student -> student.getId().equals(id));
    }

    @Override
    public StudentDTO findById(Long id) {
        return students
                .stream()
                .filter(stu -> stu.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PostConstruct
    private void loadData() {
        //        Set<StudentDTO> loadedData = new HashSet<>();
        //
        //        ObjectMapper objectMapper = new ObjectMapper();
        //        File file;
        //        try {
        //            file = ResourceUtils.getFile(URI);
        //            loadedData = objectMapper.readValue(file, new TypeReference<>() {});
        //        } catch (FileNotFoundException e) {
        //            e.printStackTrace();
        //            System.out.println("Failed while initializing DB, check your resources files");
        //        } catch (IOException e) {
        //            e.printStackTrace();
        //            System.out.println("Failed while initializing DB, check your JSON formatting.");
        //        }
        this.students = studentRepository.findAll();
    }

    private void saveData() {
        studentRepository.saveData(students);
    }


}
