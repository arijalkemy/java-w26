package com.example.joyeria.repository;

import com.example.joyeria.model.Joyeria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface IJoyeriaRepositorio extends JpaRepository<Joyeria, Long> {
    List<Joyeria> findByVentaONoTrue();
}
