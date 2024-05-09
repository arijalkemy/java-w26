package com.meli.be_java_hisp_w26_g09.util.mapper;

import com.meli.be_java_hisp_w26_g09.dto.RoleDTO;
import com.meli.be_java_hisp_w26_g09.entity.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public RoleDTO roleToRoleDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO(role.getIdRole(), role.getNameRole());
        return roleDTO;
    }
}
