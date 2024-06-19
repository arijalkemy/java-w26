package com.mercadolibre.pf_be_hisp_w26_t1_cugura.service;

import org.springframework.stereotype.Service;

import com.mercadolibre.pf_be_hisp_w26_t1_cugura.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.repository.ICategoryRepository;
import com.mercadolibre.pf_be_hisp_w26_t1_cugura.service.interfaces.ICategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService{
    
    private final ICategoryRepository categoryRepository;

    @Override
    public Category searchCategoryById(Integer id) {
        return categoryRepository.findById(id)
            .orElseThrow(() -> new ApiException("Not Found",
                                                    "No se encontró la categoria con id: " + id,
                                                    404));
    }
}
