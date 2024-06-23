package com.mercadolibre.pf_be_hisp_w26_t01_arguello.service;

import com.mercadolibre.pf_be_hisp_w26_t01_arguello.entity.Role;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.repository.IRoleRepository;
import com.mercadolibre.pf_be_hisp_w26_t01_arguello.service.interfaces.IRoleServiceInternal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements IRoleServiceInternal {

    private final IRoleRepository roleRepository;

    @Override
    public Role searchById(int id) {
        return roleRepository.findById(id)
                .orElseThrow(()-> new ApiException("","No existe un rol con el id especificado.",404));
    }
}
