package bootcamp.bd.joyeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bootcamp.bd.joyeria.model.Joya;

public interface JoyasRepository extends JpaRepository<Joya,Long> {
    
}
