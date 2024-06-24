package com.mercadolibre.pf_be_hisp_w26_t01_ditta.unit.service;

import com.mercadolibre.pf_be_hisp_w26_t01_ditta.entity.Category;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.repository.ICategoryRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_ditta.service.CategoryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {
    @Mock
    ICategoryRepository categoryRepository;

    @InjectMocks
    CategoryServiceImpl categoryService;

    @Test
    void findCategoryById_Ok() {
        Category category = new Category(1, "Fresco", "Fresco");
        when(categoryRepository.findById(1)).thenReturn(Optional.of(category));

        Category obtainted = categoryService.findCategoryById(1);

        Assertions.assertEquals(category, obtainted);
    }

    @Test
    void findCategoryById_NotFound() {
        when(categoryRepository.findById(1)).thenReturn(Optional.empty());
        Assertions.assertThrows(ApiException.class, () -> categoryService.findCategoryById(1));
    }


}
