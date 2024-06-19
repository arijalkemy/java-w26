package com.mercadolibre.final_project_java_hisp_w26_t1.unit.service;


import com.mercadolibre.final_project_java_hisp_w26_t1.entity.Role;
import com.mercadolibre.final_project_java_hisp_w26_t1.exceptions.ApiException;
import com.mercadolibre.final_project_java_hisp_w26_t1.repository.IRoleRepository;
import com.mercadolibre.final_project_java_hisp_w26_t1.service.RoleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private IRoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @Test
    void searchById_Ok(){

        Role r = new Role();
        r.setId(1);
        when(roleRepository.findById(anyInt())).thenReturn(Optional.of(r));

        Role result = roleService.searchById(1);

        Assertions.assertEquals(1,result.getId());
    }

    @Test
    void searchById_NotFound(){


        when(roleRepository.findById(anyInt())).thenReturn(Optional.empty());

        Assertions.assertThrows(ApiException.class, () -> roleService.searchById(1));
    }
}
