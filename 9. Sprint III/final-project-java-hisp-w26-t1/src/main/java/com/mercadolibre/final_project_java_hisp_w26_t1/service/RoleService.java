package com.mercadolibre.final_project_java_hisp_w26_t1.service;

import com.mercadolibre.final_project_java_hisp_w26_t1.entity.Role;
import com.mercadolibre.final_project_java_hisp_w26_t1.exceptions.ApiException;
import com.mercadolibre.final_project_java_hisp_w26_t1.repository.IRoleRepository;
import com.mercadolibre.final_project_java_hisp_w26_t1.service.interfaces.IRoleServiceInternal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService implements IRoleServiceInternal {

    private final IRoleRepository roleRepository;

    @Override
    public Role searchById(int id) {
        return roleRepository.findById(id)
                .orElseThrow(()-> new ApiException("","No existe un rol con el id especificado.",404));
    }
}
