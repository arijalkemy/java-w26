package org.example.qatesters.repository;

import org.example.qatesters.model.QATestersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQATestersRepository extends JpaRepository<QATestersModel, Long> {
}
