package com.meli.be_java_hisp_w26_g09.util.mapper;

import com.meli.be_java_hisp_w26_g09.dto.RoleDTO;
import com.meli.be_java_hisp_w26_g09.entity.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleMapperTest {
    private RoleMapper roleMapper;

    @BeforeEach
    void setUp() {
        roleMapper = new RoleMapper();
    }

    @Test
    @DisplayName("Test roleToRoleDTO converts correctly")
    void roleToRoleDTO_ConvertsCorrectly() {
        Role role = new Role(1, "Customer");

        RoleDTO result = roleMapper.roleToRoleDTO(role);

        assertEquals(role.getIdRole(), result.getIdRole());
        assertEquals(role.getNameRole(), result.getNameRole());
    }

    @Test
    @DisplayName("Test roleDTOToRole converts correctly")
    void roleDTOToRole_ConvertsCorrectly() {
        RoleDTO roleDTO = new RoleDTO(2, "Seller");

        Role result = roleMapper.roleDTOToRole(roleDTO);

        assertEquals(roleDTO.getIdRole(), result.getIdRole());
        assertEquals(roleDTO.getNameRole(), result.getNameRole());
    }

    @Test
    @DisplayName("Test roleDTOToRole with null roleDTO returns empty role")
    void roleDTOToRole_WithNullRoleDTO_ReturnsEmptyRole() {
        Role result = roleMapper.roleDTOToRole(null);

        assertEquals(null, result.getIdRole());
        assertEquals(null, result.getNameRole());
    }
}