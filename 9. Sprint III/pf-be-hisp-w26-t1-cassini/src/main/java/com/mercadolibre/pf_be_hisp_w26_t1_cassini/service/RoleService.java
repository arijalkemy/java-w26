package com.mercadolibre.pf_be_hisp_w26_t1_cassini.service;

import com.mercadolibre.pf_be_hisp_w26_t1_cassini.entity.Role;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.exceptions.ApiException;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.repository.IRoleRepository;
import com.mercadolibre.pf_be_hisp_w26_t1_cassini.service.interfaces.IRoleServiceInternal;
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
