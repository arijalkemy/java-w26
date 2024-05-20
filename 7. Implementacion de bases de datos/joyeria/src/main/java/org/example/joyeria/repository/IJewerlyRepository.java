package org.example.joyeria.repository;

import jakarta.transaction.Transactional;
import org.example.joyeria.model.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IJewerlyRepository extends JpaRepository<Jewel, Long> {

    @Query(nativeQuery = true, value = "SELECT j.* FROM jewel j WHERE j.sell = ?1")
    Optional<List<Jewel>> findJewelsSell(Boolean seller);
}
