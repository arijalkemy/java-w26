package com.example.moviesexample.repository;

import com.example.moviesexample.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsersRepository extends JpaRepository<Users, String>, JpaSpecificationExecutor<Users> {

}
