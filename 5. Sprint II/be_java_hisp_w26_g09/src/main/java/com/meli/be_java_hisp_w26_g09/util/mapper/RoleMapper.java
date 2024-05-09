package com.meli.be_java_hisp_w26_g09.util.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.be_java_hisp_w26_g09.dto.RoleDTO;
import com.meli.be_java_hisp_w26_g09.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public RoleDTO roleToRoleDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO(role.getIdRole(), role.getNameRole());
        return roleDTO;
    }

    public Role roleDTOToRole(RoleDTO roleDTO) {
        if (roleDTO == null)
            return new Role();

        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.convertValue(roleDTO, Role.class);
    }

}
