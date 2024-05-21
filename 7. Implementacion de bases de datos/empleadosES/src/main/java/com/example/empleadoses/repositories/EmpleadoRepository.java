package com.example.empleadoses.repositories;

import com.example.empleadoses.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
    List<Empleado> findAll();
}
