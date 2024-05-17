package meli.bootcamp.jpa_hibernate.service;

import lombok.RequiredArgsConstructor;
import meli.bootcamp.jpa_hibernate.repository.StudentRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;
}
