package bootcamp.bd.clothes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bootcamp.bd.clothes.model.Clothe;

public interface ClotheRepository extends JpaRepository<Clothe,Integer>{
    
}
