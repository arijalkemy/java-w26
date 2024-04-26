package com.meli.be_java_hisp_w26_g09.repository;

import com.meli.be_java_hisp_w26_g09.entity.Category;

import java.util.Optional;

public interface ICategoryRepository {

    Optional<Category> findById(Integer id);

}
