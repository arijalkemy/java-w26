package com.meli.be_java_hisp_w26_g09.dto;

import com.meli.be_java_hisp_w26_g09.entity.Role;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoleDTOTest {
    @Test
    @DisplayName("Test constructor with parameters")
    void testConstructor() {
        Integer idRole = 1;
        String nameRole = "Test Role";

        RoleDTO dto = new RoleDTO(idRole, nameRole);

        assertEquals(idRole, dto.getIdRole());
        assertEquals(nameRole, dto.getNameRole());
    }

    @Test
    @DisplayName("Test no-args constructor")
    void testNoArgsConstructor() {
        RoleDTO dto = new RoleDTO();

        assertEquals(null, dto.getIdRole());
        assertEquals(null, dto.getNameRole());
    }

    @Test
    @DisplayName("Test setter")
    void testSetter() {
        RoleDTO dto = new RoleDTO();
        Integer idRole = 2;
        String nameRole = "New Role";

        dto.setIdRole(idRole);
        dto.setNameRole(nameRole);

        assertEquals(idRole, dto.getIdRole());
        assertEquals(nameRole, dto.getNameRole());
    }

    @Test
    @DisplayName("Test equals")
    void hashCode_ReturnsDifferentValue_ForDifferentRoles() {
        Role role1 = new Role(1, "Customer");
        Role role2 = new Role(2, "Seller");

        int hashCode1 = role1.hashCode();
        int hashCode2 = role2.hashCode();

        assertEquals(false, hashCode1 == hashCode2);
    }
}