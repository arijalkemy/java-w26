package com.mercadolibre.pf_be_hisp_w26_t01_ditta.service;

import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.Warehouse;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.repository.ICategoryRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.interfaces.ICategoryServiceInternal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryServiceInternal {

    private final ICategoryRepository categoryRepository;

    @Override
    public Category findCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ApiException("Not Found",
                        "No se encontró una categoria con id: " + categoryId,
                        404));
    }

}
