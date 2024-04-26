package com.meli.be_java_hisp_w26_g09.repository.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.entity.Category;
import com.meli.be_java_hisp_w26_g09.entity.Post;
import com.meli.be_java_hisp_w26_g09.repository.ICategoryRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class CategoryRepositoryImpl implements ICategoryRepository {

    private List<Category> categoryList;
    private Integer counter;

    public CategoryRepositoryImpl() throws IOException {
        loadDataBase();
        counter = Objects.requireNonNull(categoryList.stream()
                .max(Comparator.comparing(Category::getId)).orElse(null)).getId();
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        file = ResourceUtils.getFile("classpath:category_generated.json");
        categoryList = objectMapper.readValue(file, new TypeReference<>() {});;
    }


    @Override
    public Optional<Category> findById(Integer id) {
        if (id == null || id == 0)
            return Optional.empty();

        return categoryList.stream().filter(category -> category.getId().equals(id))
                .findFirst();
    }
}
