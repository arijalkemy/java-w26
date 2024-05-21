package com.bootcamp.JPAImplementation.service;

import com.bootcamp.JPAImplementation.dto.*;
import com.bootcamp.JPAImplementation.entity.Course;
import com.bootcamp.JPAImplementation.entity.Student;
import com.bootcamp.JPAImplementation.entity.StudentCourseCalification;
import com.bootcamp.JPAImplementation.exception.NotFoundException;
import com.bootcamp.JPAImplementation.repository.ICourseRepository;
import com.bootcamp.JPAImplementation.repository.IStudentCourseCalificationRepository;
import com.bootcamp.JPAImplementation.repository.IStudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class StudentService implements IStudentService {

    private final IStudentRepository studentRepository;
    private final IStudentCourseCalificationRepository studentCourseCalificationRepository;
    private final ICourseRepository courseRepository;
    private final ObjectMapper objectMapper;

    public StudentService(
            IStudentRepository studentRepository, ObjectMapper objectMapper,
            IStudentCourseCalificationRepository studentCourseCalificationRepository,
            ICourseRepository courseRepository
    ) {
        this.studentRepository = studentRepository;
        this.objectMapper = objectMapper;
        this.courseRepository = courseRepository;
        this.studentCourseCalificationRepository = studentCourseCalificationRepository;
    }

    private final String NOT_FOUND_MESSAGE = "No se encontró el alumno solicitado";

    @Override
    @Transactional
    public StudentResponseDTO save(StudentRequestDTO studentRequestDTO) {
        Student student = studentRepository.save(mapToEntity(studentRequestDTO));
        return mapToDTO(student);
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentResponseDTO> findAll() {
        return studentRepository
                .findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public StudentResponseDTO findById(Long id) {
        Student student = studentRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(NOT_FOUND_MESSAGE));
        return mapToDTO(student);
    }

    @Override
    @Transactional
    public void udpate(Long id, String identification, String name, String lastName) {
        Student student = objectMapper.convertValue(
                findById(id),
                Student.class
        );
        student.setIdentification(identification);
        student.setName(name);
        student.setLastName(lastName);

        //studentRepository.save(student);
        /*
        Student studentToUpdate = new Student(identification, name, lastName);
         studentToUpdate.setId(student.getId());
        studentRepository.save(studentToUpdate);*/
    }

    @Override
    @Transactional
    public void udpate(StudentToUpdateRequestDTO studentToUpdateRequestDTO) {
        findById(studentToUpdateRequestDTO.getId());
        studentRepository.save(mapToEntity(studentToUpdateRequestDTO));
    }

    @Override
    public CalificationsOfStudentDTO getCalifications(Long studentId) {
        System.out.println(studentId);

        Student student = studentRepository
                .findById(studentId)
                .orElse(null);


        if (student != null) {
            System.out.println("student is null");
            return null;
        }

        System.out.println(student);

        List<StudentCourseCalification> studentCourseCalifications = student.getStudentCourseCalifications();

        Double calificationTotal = studentCourseCalifications
                .stream()
                .mapToDouble(c -> c.getCalification1() + c.getCalification2())
                .sum();

        Double average = calificationTotal / (studentCourseCalifications.size() * 2);

        CalificationsOfStudentDTO response = new CalificationsOfStudentDTO();

        response.setAverage(average);
        response.setCalificationCourseDTOS(studentCourseCalifications
                .stream()
                .map(c -> new CalificationCourseDTO(
                        c
                                .getCourse()
                                .getId(),
                        c.getCalification1(),
                        c.getCalification2()
                ))
                .toList());

        return response;
    }

    @Override
    public void loadData() {

        // Crear estudiantes
        Student student1 = new Student(
                "123456789",
                "Alice",
                "Brown"
        );
        Student student2 = new Student(
                "987654321",
                "Bob",
                "Johnson"
        );

        // Guardar estudiantes en la base de datos
        studentRepository.save(student1);
        studentRepository.save(student2);

        // Obtener algunos cursos para asignar calificaciones
        Course mathematics = new Course(
                "Mathematics",
                null,
                List.of(),
                List.of()
        );

        Course physics = new Course(
                "physics",
                null,
                List.of(),
                List.of()
        );

        courseRepository.save(mathematics);
        courseRepository.save(physics);

        // Asignar calificaciones a los estudiantes
        StudentCourseCalification calification1 = new StudentCourseCalification(
                mathematics,
                student1,
                85.0,
                90.0
        );
        StudentCourseCalification calification2 = new StudentCourseCalification(
                mathematics,
                student2,
                78.0,
                82.0
        );
        StudentCourseCalification calification3 = new StudentCourseCalification(
                physics,
                student1,
                88.0,
                91.0
        );
        StudentCourseCalification calification4 = new StudentCourseCalification(
                physics,
                student2,
                84.0,
                89.0
        );

        // Guardar las calificaciones en la base de datos
        studentCourseCalificationRepository.save(calification1);
        studentCourseCalificationRepository.save(calification2);
        studentCourseCalificationRepository.save(calification3);
        studentCourseCalificationRepository.save(calification4);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        findById(id);
        studentRepository.deleteById(id);
    }

    private Student mapToEntity(StudentRequestDTO studentRequestDTO) {
        return objectMapper.convertValue(
                studentRequestDTO,
                Student.class
        );
    }

    private StudentResponseDTO mapToDTO(Student student) {
        return objectMapper.convertValue(
                student,
                StudentResponseDTO.class
        );
    }

    private Student mapToEntity(StudentToUpdateRequestDTO studentToUpdateRequestDTO) {
        return objectMapper.convertValue(
                studentToUpdateRequestDTO,
                Student.class
        );
    }


}
