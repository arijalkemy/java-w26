package org.meli.ejercicio6_p3_d1_estudiante.service.Iservice;

import org.meli.ejercicio6_p3_d1_estudiante.dto.StudentRequestDTO;
import org.meli.ejercicio6_p3_d1_estudiante.dto.StudentResponseDTO;
import org.meli.ejercicio6_p3_d1_estudiante.dto.StudentToUpdateRequestDTO;

import java.util.List;

public interface IStudentService {
    StudentResponseDTO save(StudentRequestDTO studentRequestDTO);
    List<StudentResponseDTO> findAll();
    StudentResponseDTO findById(Long id);
    void delete(Long id);
    void udpate(Long id, String identification, String name, String lastName);
    void udpate(StudentToUpdateRequestDTO studentToUpdateRequestDTO);

}
