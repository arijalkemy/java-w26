package bootcamp.bd.mini_series.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bootcamp.bd.mini_series.model.MiniSerie;

public interface IMiniserieReposity extends JpaRepository<MiniSerie,Long> {
    
}
