package com.jewelry.perls.repository;

import com.jewelry.perls.entity.Jewer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewerRepository extends JpaRepository<Jewer, Integer> {
}
