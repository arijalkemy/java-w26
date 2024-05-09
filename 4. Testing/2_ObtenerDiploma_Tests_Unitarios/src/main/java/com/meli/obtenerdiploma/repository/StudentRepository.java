package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.utils.CargadorDatos;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class StudentRepository implements IStudentRepository {

    @Value("${api.scope}")
    private String SCOPE;

    @Override
    public Set<StudentDTO> findAll() {
        return CargadorDatos.cargarDatosDeResourceJson("users.json", StudentDTO.class);
    }
}
