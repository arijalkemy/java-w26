package com.example.moviesexample.repository;

import com.example.moviesexample.entity.Migrations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MigrationsRepository extends JpaRepository<Migrations, String>, JpaSpecificationExecutor<Migrations> {

}
